package africa.box.dm.service.ocerisation;
import africa.box.dm.config.BusinessConstants;
import africa.box.dm.db.CompteDocumentDao;
import africa.box.dm.db.entities.Compte;
import africa.box.dm.db.entities.CompteDocument;
import africa.box.dm.db.entities.DocumentStatus;
import africa.box.dm.dto.DocumentDto;
import africa.box.dm.service.CompteService;
import africa.box.dm.service.ModelMapper;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import net.minidev.json.parser.JSONParser;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.FileInputStream;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

import java.util.Optional;
import java.util.UUID;

import org.json.JSONArray;
import org.json.JSONObject;

@Service
public class RegulaService {
     String prenomDemandeur=null;
     String nomDemandeur=null;

    @Autowired(required=true)
    CompteService compteService;

    @Autowired
    CompteDocumentDao documentDao;



    public String getCniOcrData(String imageBase64,String businesskey, String identifiant){
        JSONObject myMetaDataJson = new JSONObject();
        Optional<CompteDocument> doc = documentDao.findById(identifiant);
        CompteDocument document=doc.get();




        String imageBase64_vrai = imageBase64.substring(1, imageBase64.length() - 1);
        System.out.println("imageBase64=========="+imageBase64);
        System.out.println("imageBase64_vrai=========="+imageBase64_vrai);
        try {
            String  upBasePath = System.getProperty("java.io.tmpdir");
            String fileName=upBasePath+"/stringtoolong_"+businesskey+".txt";

            FileWriter myWriter = new FileWriter(fileName);
            myWriter.write(imageBase64_vrai);

            myWriter.close();
            System.out.println("Successfully wrote to the file.");

            //**************************************
            if (myWriter != null) {
                FileInputStream fis = new FileInputStream(fileName);
                String stringTooLong = IOUtils.toString(fis, "UTF-8");
                System.out.println("stringTooLong=========="+stringTooLong);

                if (stringTooLong != null) {

                    Unirest.setTimeouts(0, 0);
                    HttpResponse<String> response = Unirest.post("http://104.40.182.52:8087/api/process")
                            .header("Content-Type", "application/json")
                            .body("{\"processParam\":{\"scenario\":\"FullProcess\",\"resultTypeOutput\":[],\"doublePageSpread\":true,\"log\":true},\"List\":[{\"ImageData\":{\"image\":\""+stringTooLong+"\"},\"light\":6,\"page_idx\":0}],\"systemInfo\":{}}")
                            .asString();
                    System.out.println("response.getBody 11========"+response.getBody());

                    JSONObject obj = new JSONObject(response.getBody());
                    JSONObject ContainerList = obj.getJSONObject("ContainerList");
                    System.out.println("ContainerList=====2222222222====>"+ContainerList);

                    JSONArray List = ContainerList.getJSONArray("List");
                    System.out.println("List=====2222222222====>"+List);

                    JSONObject object_2 = List.getJSONObject(2);
                    System.out.println("object_2+++++object_2++++++"+object_2);

                    JSONObject objText = object_2.getJSONObject("Text");
                    System.out.println("objText+++++objText++++++"+objText);

                    JSONArray fieldList = objText.getJSONArray("fieldList");
                    System.out.println("fieldList+++++fieldList++++++"+fieldList);



                    if (fieldList != null) {
                        fieldList.forEach( fiedlistObject -> {
                            Optional<Compte> compte = compteService.getCompte(businesskey);
                            Compte cmpt=null;
                            cmpt=compte.get();

                            System.out.println("fiedlistObject===========>"+fiedlistObject);

                            JSONObject objList = (JSONObject) fiedlistObject;
                            System.out.println("objList===========>"+objList);

                            String fieldName = objList.getString("fieldName");
                            String value = objList.getString("value");

                            System.out.println("fieldName===========>"+fieldName);
                            System.out.println("value===========>"+value);

                            if (fieldName.equals("Date of Expiry")) {
                                Date date1=null;
                                try {
                                    System.out.println("Date of Expiry==="+value);
//                                        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(value);
                                    date1=new SimpleDateFormat("yyyy-MM-dd").parse(value);
                                    System.out.println("date1==="+date1);

                                } catch (ParseException e) {
                                    try {
                                        date1=new SimpleDateFormat("yyyy/MM/dd").parse(value);
                                    } catch (ParseException parseException) {
                                        parseException.printStackTrace();
                                    }
                                    e.printStackTrace();
                                }
                                //difference entre physique et morale
                                myMetaDataJson.put("dateValidite",date1);

//                                if (cmpt.getTypeDemandeur().equals("physique")) {
//                                    cmpt.setDateExpirationPiece(date1);
//                                }
//                                if (cmpt.getTypeDemandeur().equals("morale")) {
//                                    myMetaDataJson.put("dateValidite",date1);
//                                }

                            }
                            if (fieldName.equals("Date of Issue")) {
                                Date date2=null;
                                try {
                                    System.out.println("Date of Issue==="+value);
//                                    Date date2=new SimpleDateFormat("dd/MM/yyyy").parse(value);
                                    date2=new SimpleDateFormat("yyyy-MM-dd").parse(value);
                                    System.out.println("date2==="+date2);
                                    System.out.println("end try===");
                                } catch (ParseException e) {
                                    try {
                                        date2=new SimpleDateFormat("yyyy-MM-dd").parse(value);
                                    } catch (ParseException parseException) {
                                        parseException.printStackTrace();
                                    }
                                    System.out.println("catch date2===");
                                    e.printStackTrace();
                                }
                                myMetaDataJson.put("dateCreation",date2);
                                //difference entre physique et morale

//                                if (cmpt.getTypeDemandeur().equals("physique")) {
//                                    cmpt.setDateCreationPiece(date2);
//                                }
//                                if (cmpt.getTypeDemandeur().equals("morale")) {
//                                    myMetaDataJson.put("dateCreation",date2);
//                                }

                            }
                            if (fieldName.equals("Document Number")) {
                                //difference entre physique et morale
                                myMetaDataJson.put("numeroPiece",value);
//                                if (cmpt.getTypeDemandeur().equals("physique")) {
//                                    cmpt.setNumeroDePiece(value);
//                                }
//                                if (cmpt.getTypeDemandeur().equals("morale")) {
//                                    myMetaDataJson.put("numeroPiece",value);
//                                }

                            }
                            if (fieldName.equals("Place of Birth")) {
                                //difference entre physique et morale
//                                if (cmpt.getLieuDeNaissance()==null) {
//                                    cmpt.setLieuDeNaissance(value);
//                                }
                            }
                            if (fieldName.equals("Date of Birth")) {
                                Date date3=null;
                                try {
                                    System.out.println("Date of Birth==="+value);
//                                    Date date3=new SimpleDateFormat("dd/MM/yyyy").parse(value);
                                    date3=new SimpleDateFormat("yyyy-MM-dd").parse(value);
                                    System.out.println("date3==="+date3);

                                } catch (ParseException e) {
                                    try {
                                        date3=new SimpleDateFormat("yyyy/MM/dd").parse(value);
                                    } catch (ParseException parseException) {
                                        parseException.printStackTrace();
                                    }
                                    e.printStackTrace();
                                }
                                myMetaDataJson.put("dateNaissance",date3);
                                //difference entre physique et morale

//                                if (cmpt.getTypeDemandeur().equals("physique")) {
//                                    cmpt.setDateDeNaissance(date3);
//                                }
//
//                                if (cmpt.getTypeDemandeur().equals("morale")) {
//                                    myMetaDataJson.put("dateNaissance",date3);
//                                }


                            }
                            if (fieldName.equals("Surname")) {
                                nomDemandeur=value;
//                                if (cmpt.getTypeDemandeur().equals("physique")) {
//                                    cmpt.setNomDemandeur(value);
//                                }
//                                if (cmpt.getTypeDemandeur().equals("morale")) {
//                                    prenomDemandeur=value;
//
//                                }

                            }

                            if (fieldName.equals("Sex")) {
//                                if (cmpt.getGenre()==null) {
//                                    if (value.equals("M")) {
//                                        cmpt.setGenre("Homme");
//                                    } else {
//                                        cmpt.setGenre("Femme");
//                                    }
//
//                                }

                            }
                            if (fieldName.equals("Given Names")) {
                                prenomDemandeur=value;
//                                if (cmpt.getTypeDemandeur().equals("physique")) {
//                                    cmpt.setPrenomDemandeur(value);
//                                }
//                                if (cmpt.getTypeDemandeur().equals("morale")) {
//
//
//                                }
                            }
                              myMetaDataJson.put("name",nomDemandeur+" "+prenomDemandeur);
//                                if (cmpt.getTypeDemandeur().equals("morale")) {
//                                    myMetaDataJson.put("name",nomDemandeur+" "+prenomDemandeur);
//
//
//                                }

//                            if (fieldName.equals("Given Names")) {
//                                cmpt.setPrenomDemandeur(value);
//                            }

                            document.setDocMeta(myMetaDataJson.toString());
                            documentDao.save(document);

//                            compteService.saveVerificationKyc(cmpt);
                        });

                    }
                    File file=new File(fileName);

                    if(file.exists())
                    {
                        file.deleteOnExit();
                        System.out.println("File deleted successfully");

                    }
                    else
                    {
                        System.out.println("file=================file==>"+file);
                        System.out.println("Failed to delete the file");
                    }
                    return response.getBody();

                }
            }

        } catch (Exception e){
            System.out.println("e*************"+e);
        }
        return null;
    }

}
