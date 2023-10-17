package africa.box.dm.controllers;
import africa.box.dm.config.LogInfoConstante;
import africa.box.dm.config.PdfContratTemplate;
import africa.box.dm.dto.StatusDto;
import africa.box.dm.service.LogInfoService;
import africa.box.dm.service.MyAppException;
import africa.box.dm.service.dkbs.DkbsService;
import africa.box.dm.service.dkbs.ResponsePostSign;
import africa.box.dm.service.signature.SignatureService;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/signature")
@CrossOrigin(value = "*", origins = "*")
public class SignatureController {
    private static final Logger logger = LoggerFactory.getLogger(SignatureController.class);

    @Autowired(required = true)
    SignatureService signatureService;

    @Autowired
    LogInfoService logInfoService;

    @Autowired
    PdfContratTemplate pdfcontratTemplate;

    @Autowired
    DkbsService DkbsService;


//    @PostMapping("/dkbs/{businessKey}")
//    @ResponseBody
//    public ResponsePostSign dkbsEssai(@PathVariable("businessKey") String businessKey) {
//
//
//        try {
//            ResponsePostSign res=  DkbsService.signedDocumentVolo(businessKey);
////            DkbsService.signedDocumentCompte(businessKey);
//
//            //System.out.println("signature respEnt.body(file)=======>"+respEnt.body(file));
//            return res;
//        } catch(Exception e){
//        }
//
//        return  null;
//    }

    @PostMapping("/dkbs/{businessKey}")
    @ResponseBody
    public StatusDto dkbsEssai(@PathVariable("businessKey") String businessKey) {


        try {
            DkbsService.signedDocumentVolo(businessKey);
            DkbsService.signedDocumentCompte(businessKey);

            logInfoService.addLog(
                    LogInfoConstante.TRAITEMENT_DU_DOSSIER.ETAPE_SIGNATURE_CONTRAT.SIGNER_DKBS,
                    businessKey,
                    LogInfoConstante.TRAITEMENT_DU_DOSSIER.ETAPE_SIGNATURE_CONTRAT.ETAPE_VERIFICATION_SIGNATURE);

            System.out.println("signature  DkbsService.signedDocumentVolo(businessKey)=======>"+ DkbsService.signedDocumentVolo(businessKey));
            System.out.println("signature   DkbsService.signedDocumentCompte(businessKey);=======>"+  DkbsService.signedDocumentCompte(businessKey));
            return StatusDto.ofSuccess("Initialisation de vérification dkbs éffectué avec succès");


        } catch(Exception e){
        }

        return  null;
    }

    @GetMapping("/getDkbs/{businessKey}")
    @ResponseBody
    public StatusDto getDkbsEssai(@PathVariable("businessKey") String businessKey) {


        try {
            DkbsService.getSignedDocumentVolo(businessKey);
            DkbsService.getSignedDocumentCompte(businessKey);

            //System.out.println("signature respEnt.body(file)=======>"+respEnt.body(file));
            return StatusDto.ofSuccess("vérification dkbs effectué avec succès");
        } catch(Exception e){
        }
        return null;
    }

    @GetMapping("/getSignature/{businessKey}")
    @ResponseBody
    public ResponseEntity<Resource> getSignature(@PathVariable("businessKey") String businessKey) throws MyAppException {
        Resource file =  signatureService.getSignatureImage(businessKey);

        ResponseEntity.BodyBuilder respEnt = ResponseEntity.ok();

        respEnt.contentType(MediaType.IMAGE_PNG);

        System.out.println("signature file=======>"+file);
        System.out.println("signature respEnt=======>"+respEnt);

        try {

            //System.out.println("signature respEnt.body(file)=======>"+respEnt.body(file));
            return respEnt.body(file);

        } catch(Exception e){
            logger.error("Erreur de récupération du fichier, inexistant ou code inexistant");
        }
        throw new MyAppException("Erreur de récupération du fichier, inexistant ou code inexistant");
    }

    @PostMapping("/create/{businessKey}")
    @ResponseBody
    public String postSignature(@PathVariable("businessKey") String businessKey){
        String resultats = signatureService.createSignature(businessKey);

//        Resource file =  signatureService.createSignature(businessKey);
//
//        ResponseEntity.BodyBuilder respEnt = ResponseEntity.ok();
//
//        respEnt.contentType(MediaType.IMAGE_PNG);
//        respEnt.body(file);

        try {
//            JSONObject params = new JSONObject();
//            params.put(businessKey,respEnt.body(file));
//            params.put(businessKey,businessKey);
//            System.out.println("params======"+params);
//            Map<String, Object> fileUrl = new HashMap<>();
//            fileUrl.put(businessKey,respEnt.body(file));

            //System.out.println("signature respEnt.body(file)=======>"+respEnt.body(file));
            return null;


        } catch(Exception e){
            logger.error("Erreur de récupération du fichier, inexistant ou code inexistant");
        }
        throw new MyAppException("Erreur de récupération du fichier, inexistant ou code inexistant");

//        logInfoService.addLog(
//                    LogInfoConstante.TRAITEMENT_DU_DOSSIER.ETAPE_SIGNATURE_CONTRAT.SIGNER_CONTRAT,
//                    businessKey,
//                    LogInfoConstante.TRAITEMENT_DU_DOSSIER.ETAPE_SIGNATURE_CONTRAT.ETAPE_VERIFICATION_SIGNATURE);
//        return resultats;
    }
//




}
