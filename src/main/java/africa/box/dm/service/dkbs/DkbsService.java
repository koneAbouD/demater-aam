package africa.box.dm.service.dkbs;
import africa.box.dm.config.MyAppConfig;
import africa.box.dm.db.CompteDocumentDao;
import africa.box.dm.db.entities.CompteDocument;
import africa.box.dm.dto.DocumentDto;
import africa.box.dm.service.ExternalEndPointService;
import africa.box.dm.service.ModelMapper;
import africa.box.dm.service.StorageService;
import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.*;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service
public class DkbsService {

    @Autowired
    ExternalEndPointService externalEndPointService;

    private final StorageService storageService;

    final
    MyAppConfig appConfig;

//    final CompteDocumentDao dao;

    @Autowired
    CompteDocumentDao compteDocumentDao;


    @Bean
    public RestTemplate restTemplate3() {
//        return new RestTemplate(getClientHttpRequestFactory());
        return new RestTemplate();
    }

    public DkbsService(StorageService storageService, MyAppConfig appConfig) {
        this.storageService = storageService;
        this.appConfig = appConfig;

    }

//    public  String postDocForServer(String url,String businesskey) throws UnirestException {
//
//        Unirest.setTimeouts(0, 0);
//        HttpResponse<String> response = Unirest.post("https://boxbanking-mobile.westeurope.cloudapp.azure.com/index.php/api/upload/sign/files")
//                .header("Accept", "application/json")
//                .header("Content-Type", "application/json")
//                .field("file", new File(url))
//                .field("businesskey", businesskey)
//                .asString();
//
//        return response.getBody();
//    }

    public String signedDocumentVolo (String businessKey) throws UnirestException {

        try {

            String idVolo=businessKey+"_volo";

            System.out.println("debut signedDocumentVolo===");


            Unirest.setTimeouts(0, 0);
            HttpResponse<String> res = Unirest.post("http://www.dkbsolutions.com/Api_dkbsign4/v1/Testdkbsign")
                    .header("authorizations", "DH9QhgopYgZ0VyQNSVj1407RrlAolzMAeQYwVSYLNA==")
                    .header("Content-Type", "text/plain")
                    .body("{\n" +
                            "\"Key_Api\":\"test@dkbsign4\",\n" +
                            "\"Id_cl\":\""+idVolo+"\",\n" +
                            "\"signataire\":\"BOX BANKING\",\n" +
                            "\"Code_ctr\":\""+idVolo+"\",\n" +
                            "\"ctr\":\"https://boxbanking-mobile.westeurope.cloudapp.azure.com/index.php/api/read/sign/files/"+idVolo+"\",\n"+
                            "\"nom_ctr\":\""+idVolo+"\",\n" +
                            "\"posX\":140,\n" +
                            "\"posY\":280,\n" +
                            "\"page_sign\":2,\n" +
                            "\"initial\":\"\",\n" +
                            "\"qrcodeyes\":\"\"\n" +
                            "}")
                    .asString();

            return res.getBody();
        }
        catch(Exception exp) {
            System.out.println("exp.getMessage()============="+exp.getMessage());
            exp.printStackTrace();
        }


//        {
//            "Key_Api":"test@dkbsign4",
//                "Id_cl":"AA067_volo",
//                "signataire":"BOX BANKING",
//                "Code_ctr":"AA067_volo",
//                "ctr":"https://boxbanking-mobile.westeurope.cloudapp.azure.com/index.php/api/read/sign/files/AA067_volo",
//                "nom_ctr":"AA067_volo",
//                "posX":110,
//                "posY":230,
//                "page_sign":1,
//                "initial":"",
//                "qrcodeyes":"1"
//        }

        System.out.println("f ================= return null");

        return null;
    }

    public String signedDocumentCompte (String businessKey) throws UnirestException {

        String idCmpt=businessKey+"_compte";
        System.out.println("debut signedDocumentCompte===");
        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.post("http://www.dkbsolutions.com/Api_dkbsign4/v1/Testdkbsign")
                .header("authorizations", "DH9QhgopYgZ0VyQNSVj1407RrlAolzMAeQYwVSYLNA==")
                .header("Content-Type", "text/plain")
                .body("{\n" +
                        "\"Key_Api\":\"test@dkbsign4\",\n" +
                        "\"Id_cl\":\""+idCmpt+"\",\n" +
                        "\"signataire\":\"BOX BANKING\",\n" +
                        "\"Code_ctr\":\""+idCmpt+"\",\n" +
                        "\"ctr\":\"https://boxbanking-mobile.westeurope.cloudapp.azure.com/index.php/api/read/sign/files/"+idCmpt+"\",\n"+
                        "\"nom_ctr\":\""+idCmpt+"\",\n" +
                        "\"posX\":140,\n" +
                        "\"posY\":280,\n" +
                        "\"page_sign\":2,\n" +
                        "\"initial\":\"\",\n" +
                        "\"qrcodeyes\":\"\"\n" +
                        "}")
                .asString();

//        Gson resData = new Gson();
//        ResponsePostSign responsePostSign = resData.fromJson(response.getBody(), ResponsePostSign.class);


//        System.out.println("signedDocumentCompte responsePostSign==="+responsePostSign);
        System.out.println("fin signedDocumentCompte response.getBody()==="+response.getBody());
        return response.getBody();
    }




//    public String getSignedDocumentVolo (String businesskey) throws UnirestException {
//        System.out.println("debut getsigneddocVolo");
//        String idVolo=businesskey+"_volo";
//        Unirest.setTimeouts(0, 0);
//        HttpResponse<String> response = Unirest.get("http://www.dkbsolutions.com/Api_dkbsign4/v1/getTestdocsign/"+idVolo)
//                .header("authorizations", "DH9QhgopYgZ0VyQNSVj1407RrlAolzMAeQYwVSYLNA==")
//                .asString();
//

//
//        //response
//
////        {
////            "code": 807,
////                "transac": [
////            {
////                "Id_cl": "AA0002",
////                    "Code_ctr": "AA0002_CONFIRMATION",
////                    "ctr": "http://www.dkbsolutions.com/Api_dkbsign4/include/DOCSIGN_TEST/contrat-AA0002_CONFIRMATION.pdf",
////                    "sign_trans": "SexPnmRP9arnoY28qDh5SwacosB9iRjYqmAwWOkCTJe3cTF7tHSVvWEdozA0B9cTMGrVQV7pbJkqEpurIIty2U+UfdtrD3o9fie0BXngjrw4JaqBrgE+WklZZcAH7OZLbnd/Yl1jVCNS2JbNTES15j1qkNeJV/hHYt5GBVtEnHbw=="
////            }
////    ]
////        }
//
//
////        response.getBody();
////        Gson g = new Gson();
////        Compte compte = g.fromJson(response.getBody(), Compte.class);
////        compte.getBusinessKey();
//
//
//        // stockage du nouveau document
//// Optional<CompteDocument> compteDocumentOptional = this.dao.findById(fileId);
////        CompteDocument doc= compteDocumentOptional.get();
////        DocumentDto documentDto ;
////        documentDto = ModelMapper.convertCompteDocumentToDocumentDto(doc);
////
////
////        File newFileApresSignature = new File(String.valueOf(Paths.get(newFileNameFormat)));
////        FileItem fileItem = new DiskFileItem("mainFile2", "MediaType.APPLICATION_PDF", false, newFileApresSignature.getName(), (int) newFileApresSignature.length(), newFileApresSignature.getParentFile());
////
////        try {
////            InputStream input = new FileInputStream(newFileApresSignature);
////            OutputStream os = fileItem.getOutputStream();
////            IOUtils.copy(input, os);
////        } catch (IOException ex) {
////            ex.printStackTrace();
////        }
////
////        MultipartFile multipartFile = new CommonsMultipartFile(fileItem);
////
////        storageService.store(businessKey, multipartFile, doc.getIdentifiant(), documentDto);
////
//        String caract = "ï»¿";
//        String responseTest = "{\"code\":807,\"transac\":[{\"Id_cl\":\"AA069_volo\",\"Code_ctr\":\"AA069_volo\",\"ctr\":\"http:\\/\\/www.dkbsolutions.com\\/Api_dkbsign4\\/include\\/DOCSIGN_TEST\\/AA069_volo.pdf\",\"sign_trans\":\"zjOz\\/QqHit8EwivfIsuDmwsJG7VB5BZzC6Ti9sRDBAk04+yEn3GvYzTUh8YjYL7EDIMnbhUu6X0J9siYXLKNqU3fqQPLZ7rPhstusTPllNE7VpmJ2T5vtMzBv8XLX76e8bcXEZaNI6kktqQUDchxrV18uFe6XXvpo4ln90LRtGzw==\"}]}\n";
//        System.out.println("fin response.getBody()==="+response.getBody());
//        String newResponse= response.getBody().replace(caract,"X");
//        ObjectMapper oMapper = new ObjectMapper();
//        System.out.println(newResponse.substring(0,10));
//        System.out.println(newResponse.substring(10,newResponse.length()));
//        String test=newResponse.substring(0,10)+newResponse.substring(10,newResponse.length());
//        try {
//            Map<String, Object> map = oMapper.readValue(test, Map.class);
//            System.out.println(" map.get()++++++++++++"+ map.get("code"));
//            List<TransacObjet> transacobj = (List<TransacObjet>) map.get("transac");
//
//            System.out.println(" transacobj++++++++++++"+ transacobj);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
////
////        JSONParser validationparser = new JSONParser(JSONParser.MODE_JSON_SIMPLE);
////
////        try {
////            JSONObject jsonObject = (JSONObject) validationparser.parse(newResponse);
////            System.out.println(jsonObject);
////            System.out.println(jsonObject.get("code"));
////            System.out.println(jsonObject.get("transac"));
////        } catch (ParseException e) {
////            e.printStackTrace();
////        }
//
////        System.out.println("fin response.getBody()==="+newResponse);
//
////                Gson resData = new Gson();
////        ResponseGetSign responseGetSign = resData.fromJson(newResponse, ResponseGetSign.class);
////        System.out.println("responseGetSign 111++++==="+responseGetSign);
//
//                return response.getBody();
//
////        Compte compte = g.fromJson(response.getBody(), Compte.class);
//    }

    public String getSignedDocumentVolo (String businesskey) throws UnirestException {

        System.out.println("debut getsigneddocVolo");
        String idVolo=businesskey+"_volo";

        try {
            Unirest.setTimeouts(0, 0);
            HttpResponse<String> response = Unirest.get("https://boxbanking-mobile.westeurope.cloudapp.azure.com/index.php/api/read/doc/signed/"+idVolo)
                    .asString();


            System.out.println("response.getBody()+++++++++"+response.getBody());
            Gson resData = new Gson();
            ResponseGetSign responseGetSign = resData.fromJson(response.getBody(), ResponseGetSign.class);



            System.out.println("responseGetSign+++++++++"+responseGetSign);
            //        // stockage du nouveau docume
            if (responseGetSign != null) {

                List<CompteDocument> voloDoc = compteDocumentDao.findByBusinessKeyAndName(businesskey,"Contrat VOLO");
//            Optional<CompteDocument> compteDocumentOptional = compteDocumentDao.findById(fileId);
                CompteDocument doc= voloDoc.get(0);

//                DocumentDto documentDto ;
//                documentDto = ModelMapper.convertCompteDocumentToDocumentDto(doc);


                return getDkbsFileSigned(responseGetSign.getData().getCtr(),doc);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    public String getSignedDocumentCompte (String businessKey) throws UnirestException {
        System.out.println("debut getSignedDocumentCompte");

        String idCmpt=businessKey+"_compte";

        try {
            Unirest.setTimeouts(0, 0);
            HttpResponse<String> response = Unirest.get("https://boxbanking-mobile.westeurope.cloudapp.azure.com/index.php/api/read/doc/signed/"+idCmpt)
                    .asString();


            System.out.println("response.getBody()+++++++++"+response.getBody());
            Gson resData = new Gson();
            ResponseGetSign resp = resData.fromJson(response.getBody(), ResponseGetSign.class);



            System.out.println("responseGetSign+++++++++"+resp);

            //        // stockage du nouveau docume

            if (resp != null) {
                List<CompteDocument> cmptDoc = compteDocumentDao.findByBusinessKeyAndName(businessKey,"Contrat ouverture de compte");
                CompteDocument doc= cmptDoc.get(0);

                return getDkbsFileSigned(resp.getData().getCtr(),doc);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Async
    public String getDkbsFileSigned (String urlFileUploaded, CompteDocument d){
        System.out.println("urlFileUploaded+++++++++++"+urlFileUploaded);
//        String urlFileUploaded = externalEndPointConfig.getGet_file_uploaded_url()+"/"+externalBusinessKey+"/"+d.getDocCode();
        MultipartFile file = restTemplate3().execute(urlFileUploaded, HttpMethod.GET, null, clientHttpResponse -> {
            File ret = File.createTempFile("download", "tmp");
            FileOutputStream fichier=new FileOutputStream(ret);
            StreamUtils.copy(clientHttpResponse.getBody(), fichier);
            System.out.println(clientHttpResponse.getHeaders().getContentType());

            FileItem fileItem = new DiskFileItem("mainFile", ""+clientHttpResponse.getHeaders().getContentType(), false, ret.getName(), (int) ret.length(), ret.getParentFile());

            try {
                InputStream input = new FileInputStream(ret);
                OutputStream os = fileItem.getOutputStream();
                IOUtils.copy(input, os);
                // Or faster..
                // IOUtils.copy(new FileInputStream(file), fileItem.getOutputStream());
            } catch (IOException ex) {
                // do something.
            }

            MultipartFile multipartFile = new CommonsMultipartFile(fileItem);
            // CommonsMultipartFile multipartFile = new CommonsMultipartFile(fileItem);

            fichier.close();
            return multipartFile;
        });

        DocumentDto dto = storageService.store(d.getBusinessKey(),file,d.getIdentifiant(), ModelMapper.convertCompteDocumentToDocumentDto(d));

        return dto.getDocPath();
    }

}
