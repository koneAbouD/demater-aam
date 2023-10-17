package africa.box.dm.controllers;

import africa.box.dm.consumer.ocr.IdenfyVerificationDTO;
import africa.box.dm.controllers.exceptions.CompteNotException;
import africa.box.dm.db.entities.Compte;
import africa.box.dm.service.CompteService;
import africa.box.dm.service.contract.DocumentVerificationService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "/docs-verification")
@CrossOrigin("*")
@AllArgsConstructor
public class DocumentVerificationResource {
    private DocumentVerificationService documentVerificationService;
    private CompteService compteService;
    private  final static Logger log = LoggerFactory.getLogger(DocumentVerificationResource.class);


    @PostMapping(path = "/process-old/{businessKey}")
    public ResponseEntity<Object> processVerification(@RequestBody @Valid IdenfyVerificationDTO body, BindingResult br,
                                                      @PathVariable String businessKey) throws Exception {
        if (br.hasErrors()){
            Map<String, Object> err = new HashMap<>();

            for(FieldError fe:br.getFieldErrors()){
                err.put(fe.getField(), fe.getDefaultMessage());
            }

            return ResponseEntity.status(400).body(err);
        }
        System.out.println(body.getCountry());
//        try{
//            Base64.getDecoder().decode(body.getImages().getBACK());
//            Base64.getDecoder().decode(body.getImages().getBACK());
//            Base64.getDecoder().decode(body.getImages().getBACK());
//        }catch (IllegalArgumentException ex){
//            Map<String, Object> err = new HashMap<>();
//            err.put("message","Image malformée en base64");
//            return ResponseEntity.status(400).body(err);
//        }
        Optional<Compte> compte = compteService.getCompte(businessKey);

        if (!compte.isPresent()) throw new CompteNotException();

        return ResponseEntity.status(200).body(documentVerificationService.process(body, compte.get()));
        //return ResponseEntity.status(200).body(body);
    }

    @PostMapping(path = "/token")
    public ResponseEntity<Map<String, String>> getAuthToken() throws  Exception{
        return ResponseEntity.status(201).body(documentVerificationService.generateIdenfyAuthToken());
    }

    @GetMapping(path = "/full-status/{businessKey}")
    public ResponseEntity<Map<String, Object>> getFullStatus(@PathVariable String businessKey) throws  Exception{
        return ResponseEntity.status(200)
                .contentType(MediaType.APPLICATION_JSON)
                .body(documentVerificationService.getVerficationStatus(businessKey).orElse(new HashMap<>()));
    }

    @PostMapping(path = "/process/{businessKey}")
    public ResponseEntity<Map<String, Object>> process(@PathVariable String businessKey){
        log.info("Start Verif Controller ...");
            Optional<Compte> compte = compteService.getCompte(businessKey);

            if (!compte.isPresent()) throw new CompteNotException();
           // return ResponseEntity.status(201).body(documentVerificationService.process(businessKey));
            return ResponseEntity.status(201).body(documentVerificationService.process(compte.get()));

    }
}
