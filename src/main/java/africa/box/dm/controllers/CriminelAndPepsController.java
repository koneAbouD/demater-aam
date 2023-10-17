package africa.box.dm.controllers;
import africa.box.dm.config.LogInfoConstante;
import africa.box.dm.controllers.exceptions.CompteNotException;
import africa.box.dm.db.entities.Compte;
import africa.box.dm.db.entities.CriminelAndPeps;
import africa.box.dm.db.entities.LogInfo;
import africa.box.dm.dto.PepsDTO;
import africa.box.dm.service.CompteService;
import africa.box.dm.service.CriminelAndPepsService;
import africa.box.dm.service.impl.PepsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/crimeAndPeps")
@CrossOrigin(value = "*", origins = "*")
public class CriminelAndPepsController {

    @Autowired(required=true)
    CompteService compteService;

    @Autowired
    PepsService pepsService;

    @Autowired(required=true)
    CriminelAndPepsService criminelAndPepsService;


    @PostMapping(path = "/informations_crimeAndPeps")
    @ResponseBody
    public CriminelAndPeps informationsCriminelAndPeps(@RequestBody CriminelAndPeps c) throws Exception {
        CriminelAndPeps crimAndPeps = criminelAndPepsService.saveCrimAndPepsInformation(c);

        System.out.println("c.getPepsAndCrimId()---- ====> "+c.getPepsAndCrimId());
        return crimAndPeps;
    }

    @PostMapping(path = "/search")
    public ResponseEntity<Object> processVerification(@RequestBody @Valid PepsDTO body, BindingResult br){
        if (br.hasErrors()){
            Map<String, Object> err = new HashMap<>();
            for (FieldError fe:br.getFieldErrors()){
                err.put(fe.getField(), fe.getDefaultMessage());
            }

            return ResponseEntity.status(400).body(err);
        }

        compteService.getCompte(body.getBusinessKey()).orElseThrow(()->{
           return new CompteNotException();
        });
        return ResponseEntity.status(200).body(
                pepsService.processVerfication(body.getBusinessKey(), body.getName(),  body.getBirthDay(), body.getCountryCode())
        );
    }

    @GetMapping(path = "/{businessKey}/results")
    public ResponseEntity<Map<String, Object>> getVerificationResult(@PathVariable String businessKey){
        return  ResponseEntity.status(200).body(pepsService.getVerificationResult(businessKey).orElse(new HashMap<>()));
    }



}
