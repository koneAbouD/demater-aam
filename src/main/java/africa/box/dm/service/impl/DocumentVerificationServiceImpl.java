package africa.box.dm.service.impl;

import africa.box.dm.config.BusinessConstants;
import africa.box.dm.config.DmnConstants;
import africa.box.dm.config.MyAppConfig;
import africa.box.dm.consumer.ocr.*;
import africa.box.dm.consumer.ocr.IdenfyConsumer;
import africa.box.dm.db.CompteDocumentDao;
import africa.box.dm.db.DocFileDao;
import africa.box.dm.db.domain.filestorage.DocFile;
import africa.box.dm.db.domain.filestorage.FileStorageNotFoundException;
import africa.box.dm.db.domain.filestorage.FileStorageType;
import africa.box.dm.db.entities.Compte;
import africa.box.dm.db.entities.CompteDocument;
import africa.box.dm.db.entities.DemandeurIDCardOCR;
import africa.box.dm.db.DemandeurIDCardOCRDao;
import africa.box.dm.service.contract.DocumentVerificationService;
import africa.box.dm.utils.DateFormatter;
import africa.box.dm.utils.FileUtil;
import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import okhttp3.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class DocumentVerificationServiceImpl implements DocumentVerificationService {
    private final static Logger  log  = LoggerFactory.getLogger(DocumentVerificationServiceImpl.class);
    private static final MediaType MEDIA_TYPE_JPG = MediaType.parse("image/jpeg");

    private IdenfyConsumer idenfyConsumer;
    private DemandeurIDCardOCRDao idCardOCRDao;
    private Gson gson;
    private RegularConsumer regularConsumer;
    private MyAppConfig appConfig;
    private CompteDocumentDao documentDao;
    private DocFileDao docFileDao;
    private FileUtil fileUtil;
    private Map<String, Object> Regulardata = new HashMap<>();

    public DocumentVerificationServiceImpl(IdenfyConsumer idenfyConsumer,
                                           DemandeurIDCardOCRDao idCardOCRDao,
                                           Gson gson, RegularConsumer regularConsumer,
                                           CompteDocumentDao documentDao, MyAppConfig appConfig,
                                           FileUtil fileUtil, DocFileDao docFileDao){
        this.idenfyConsumer = idenfyConsumer;
        this.idCardOCRDao = idCardOCRDao;
        this.gson =gson;
        this.regularConsumer = regularConsumer;
        this.documentDao = documentDao;
        this.appConfig = appConfig;
        this.fileUtil = fileUtil;
        this.docFileDao = docFileDao;
    }

    @Override
    public Object ocrFilePredication(MultipartFile file) throws IOException {
        OkHttpClient client = new OkHttpClient();

        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("file", file.getOriginalFilename(), RequestBody.create(MEDIA_TYPE_JPG, file.getResource().getFile()))
                .build();

        Request request = new Request.Builder()
                .url("https://app.nanonets.com/api/v2/OCR/Model/{{model_id}}/LabelFile/?async=true")
                .post(requestBody)
                .addHeader("Authorization", Credentials.basic("BhYqwZsLGH2WdXqrgJe16yehCfZ203nO", ""))
                .build();

        Response response = client.newCall(request).execute();
        return response;
    }

    /**
     * Methode qui verifies l'authenticité des document
     * @param dto
     * @return
     * @throws Exception
     */
    @Override
    public Map<String, Object> processDocumentVerification(IdenfyVerificationDTO dto) throws Exception {
        String clientId = UUID.randomUUID().toString();

        // Generate AuthToken && Scan reference
        Map<String,String> resToken = idenfyConsumer.generateToken(clientId);
        String authToken = resToken.get("authToken").toString();
        String scanRef = resToken.get("scanRef").toString();


        // Start Document process verification
        dto.setAuthToken(authToken);
        Map<String, Object> processVerifRes = idenfyConsumer.processVerification(dto);
        boolean processStatus = (Boolean) processVerifRes.get("success");
        if (!processStatus){
            Gson gson = new Gson();
            throw new IdenfyBadRequestException(gson.toJson(processVerifRes));
        }

        // Get Verification status
        String status = idenfyConsumer.getStatus(scanRef);

        // Get Verification Data

        Map<String, Object> data = idenfyConsumer.getFullStatus(scanRef);
        data.put("status", status);


        return data;
    }

    @Override
    public  Map<String, String> process(IdenfyVerificationDTO dto, Compte compte) throws Exception{
        String clientId = UUID.randomUUID().toString();
        // Generate AuthToken && Scan reference
        Map<String,String> resToken = idenfyConsumer.generateToken(clientId);
        String authToken = resToken.get("authToken").toString();
        String scanRef = resToken.get("scanRef").toString();

        // Get Images BAse64
        String BACK = dto.getImages().getBACK();
        String FRONT = dto.getImages().getFRONT();
        String FACE = dto.getImages().getFACE();
        dto.getImages().setBACK(getBase64(BACK));
        dto.getImages().setFACE(getBase64(FACE));
        dto.getImages().setFRONT(getBase64(FRONT));

        // Start Document process verification
        dto.setAuthToken(authToken);

        Map<String, Object> processVerifRes = idenfyConsumer.processVerification(dto);
        boolean processStatus = (Boolean) processVerifRes.get("success");
        if (!processStatus){
            Gson gson = new Gson();
            throw new IdenfyBadRequestException(gson.toJson(processVerifRes));
        }

        // Save OCR Data
        DemandeurIDCardOCR idCardOCR = new DemandeurIDCardOCR();
        idCardOCR.setFace(FACE.getBytes());
        idCardOCR.setIdCardFront(FRONT.getBytes());
        idCardOCR.setIdCardBack(BACK.getBytes());
        idCardOCR.setScanRef(scanRef);
        idCardOCR.setBusinessKey(compte.getBusinessKey());
        idCardOCR.setDocumentType(dto.getDocumentType());
        idCardOCR.setCountryCode(dto.getCountry());
        idCardOCRDao.save(idCardOCR);

        return resToken;
    }

    @Override
    public Map<String, String> generateIdenfyAuthToken() throws Exception{
        String clientId = UUID.randomUUID().toString();
        return idenfyConsumer.generateToken(clientId);
    }

    @Override
    public Optional<Map<String, Object>> getVerficationStatus(String businessKey) throws Exception{
        return  Optional.of(idCardOCRDao.findFirstByBusinessKey(businessKey))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(idCardOCR -> {
                    return idCardOCR.getOcrResult();
                } );

    }


    private String getBase64(String url){
        String data = url.split(",")[1];
        try{
            Base64.getDecoder().decode(data);
        }catch (Exception ex){
            throw  new RuntimeException("Image malformée en base64");
        }
        return data;
    }

    @Override
    public Map<String, Object> process(Compte compte){
        //List<String> list = new ArrayList<>();
        //String[] nameOfDocs = new String[]{"Pièce d'identité (Recto)", "Pièce d'identité (Verso)"};
        List<String> docNameList = new ArrayList<>();
        docNameList.add("Pièce d'identité (Recto)");
        if (!compte.getTypeDePiece().equalsIgnoreCase(DmnConstants.IDCardType.PASSEPORT)){
            docNameList.add("Pièce d'identité (Verso)");
        }

        List<String> listImages = docNameList.stream()
                .map(docName->{
                        CompteDocument doc = documentDao.findFirstByBusinessKeyAndName(compte.getBusinessKey(), docName)
                                .orElseThrow(()->{return  new RuntimeException(docName + " non trouvé");});
                        if (doc.getDocPath() == null) throw new RuntimeException(docName + " non Chargé");

                        return getDocumentBase64(doc, FileStorageType.DB);

                })
                .collect(Collectors.toList());

        //List<String> listImages = getDocument(businessKey);
        //if (listImages.size() == 0) throw new  IDCardNotFountException();

        String tag = UUID.randomUUID().toString();
        Map<String, Object> result = regularConsumer.process(listImages.toArray(new String[0]), tag);
        DemandeurIDCardOCR idCard ;
        Optional<DemandeurIDCardOCR> optionalIdCard = idCardOCRDao.findFirstByBusinessKey(compte.getBusinessKey());
        if (optionalIdCard.isPresent()){
            idCard = optionalIdCard.get();
        }
        else{
            idCard = new DemandeurIDCardOCR();
            idCard.setBusinessKey(compte.getBusinessKey());
        }


        findEntryByValue(result, "Surname", Regulardata);
        findEntryByValue(result, "Document Number", Regulardata);
        findEntryByValue(result, "Given Names", Regulardata);
        findEntryByValue(result, "Date of Birth", Regulardata);
        findEntryByValue(result, "Place of Birth", Regulardata);
        findEntryByValue(result, "Date of Expiry", Regulardata);
        findEntryByValue(result, "Date of Issue", Regulardata);
        findEntryByValue(result, "Place of Issue", Regulardata);
        findEntry(result,"result_type", Regulardata);
        findEntry(result,"Status", Regulardata);


        idCard.setOcrResult(Regulardata);
        idCard.setScanRef(tag);
        idCardOCRDao.save(idCard);
        return idCard.getOcrResult();

    }


    private List<String> getDocument(String businessKey){
        String[] nameOfDocs = new String[]{"Pièce d'identité (Recto)", "Pièce d'identité (Verso)"};

        List<String> listImages = new ArrayList<>();
        for (String nameOfDoc: nameOfDocs){
            CompteDocument doc = documentDao.findFirstByBusinessKeyAndName(businessKey, nameOfDoc)
                    .get();
            if (doc.getDocPath() != null){
                try{
                    byte[] bytes = fileUtil.getCompteFile(businessKey, doc.getDocPath(), doc.getCreatedAt());
                    listImages.add(Base64.getEncoder().encodeToString(bytes));
                }catch (Exception ex){

                }

            }

        }

        return listImages;

    }

    private String getDocumentBase64(CompteDocument doc, FileStorageType type) {
        if (FileStorageType.DB.equals(type)){
            return getDocumentBase64FromDatabase(doc);
        }else if (FileStorageType.FS.equals(type)) {
            return getDocumentBase64FromFileSystem(doc);
        }else {
            throw new FileStorageNotFoundException();
        }
    }

    private String getDocumentBase64FromFileSystem(CompteDocument doc){

        try{
            byte[] bytes = fileUtil.getCompteFile(doc.getBusinessKey(), doc.getDocPath(), doc.getCreatedAt());
            return Base64.getEncoder().encodeToString(bytes);
        }catch (Exception ex){
            throw new RuntimeException(ex.getMessage());
        }

    }


    private String getDocumentBase64FromDatabase(CompteDocument doc){
        try{
            DocFile docFile = docFileDao.findOneByDocIdAndFilename(doc.getIdentifiant(), doc.getDocPath())
                    .orElseThrow(()->{return new RuntimeException(doc.getName() + " introuvable");});

            return Base64.getEncoder().encodeToString(docFile.getContent());
        }catch (Exception ex){
            throw new RuntimeException(ex.getMessage());
        }

    }



    public void findEntry(Map<String, Object> map,
                          String key, Map<String, Object> data){
        Map.Entry<String, Object> entryFOund = null;
        for (Map.Entry<String, Object> entry: map.entrySet()){
            if (entry.getKey().equals(key)){
                entryFOund = entry;

                if(!data.containsKey(key))
                    data.put(key, entryFOund.getValue());
                break;
                //return data;
            }else{
                if (entry.getValue() instanceof  LinkedTreeMap) {

                    findEntry((LinkedTreeMap<String, Object>) entry.getValue(), key, data);
                    if (entryFOund != null)
                        break;
                }
                if (entry.getValue() instanceof HashMap){
                    findEntry((HashMap<String, Object>) entry.getValue(), key, data);
                    if (entryFOund != null)
                        break;

                }else if (entry.getValue() != null && entry.getValue().getClass().isArray()){
                    List<Map<String, Object>> list = Arrays.asList((HashMap[])entry.getValue());
                    for (Map<String, Object> item:list){
                        findEntry(item, key, data);
                        if (entryFOund != null)
                            break;
                    }
                }else if (entry.getValue() instanceof Collection){
                    List<Map<String, Object>> list = (ArrayList)entry.getValue();
                    for (Object item:list){

                        if (item instanceof HashMap){
                            findEntry((HashMap) item, key, data);
                            if (entryFOund != null)
                                break;
                        } else if (item instanceof LinkedTreeMap) {
                            findEntry((LinkedTreeMap) item, key, data);
                            if (entryFOund != null)
                                break;
                        }

                    }
                }
            }


        }
        //  System.out.println("END CALL");
        // return data;
    }




    public void  findEntryByValue(Map<String, Object> map,
                                  String key, Map<String, Object> data){
        Map.Entry<String, Object> entryFOund = null;
        Map<String, Object> parent = map;

        for (Map.Entry<String, Object> entry: map.entrySet()){
            if (entry.getValue() != null) {
                if ( entry.getValue().equals(key)){
                    entryFOund = entry;
                    if (!data.containsKey(key) || data.get(key) == null) {
                        data.put(key,  parent.get("Buf_Text"));
                    }

                    break;
                }else{

                    if (entry.getValue() instanceof LinkedTreeMap){
                        parent = (LinkedTreeMap)  entry.getValue();

                        findEntryByValue((LinkedTreeMap<String, Object>) entry.getValue(), key, data);

                    } else if (entry.getValue() instanceof HashMap) {
                        parent = (HashMap)  entry.getValue();

                        findEntryByValue((HashMap<String, Object>) entry.getValue(), key, data);
                    }
                    else if (entry.getValue() != null && entry.getValue().getClass().isArray()){
                        List<Map<String, Object>> list = Arrays.asList((HashMap[])entry.getValue());
                        for (Map<String, Object> item:list){
                            findEntryByValue(item, key, data);
                        }
                    }else if (entry.getValue() instanceof Collection){
                        List<Object> list = (ArrayList)entry.getValue();
                        for (Object item:list){
                            if (item instanceof HashMap) {
                                findEntryByValue((HashMap) item, key, data);
                            } else if (item instanceof LinkedTreeMap) {
                                findEntryByValue((LinkedTreeMap) item, key, data);
                            }

                        }

                    }
                }
            }


        }
        //System.out.println("END CALL");
        //return data;
    }
}
