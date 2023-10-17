package africa.box.dm.controllers;

import africa.box.dm.consumer.banking.BankingBase;
import africa.box.dm.controllers.exceptions.GenericNotFoundExceoption;
import africa.box.dm.db.entities.Compte;
import africa.box.dm.service.CompteService;
import createcustomerproxy.ErrorResponseFlow_Exception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("/compte")
@CrossOrigin(value = "*", origins = "*")
public class BankingController {

    @Autowired
    private BankingBase bankingBase;
    @Autowired
    private CompteService compteService;
    @PostMapping(path = "/{businessKey}/create-customer")
    public ResponseEntity<Object> createCustomer(@PathVariable String businessKey) throws ErrorResponseFlow_Exception, createaccountproxy.ErrorResponseFlow_Exception {
        bankingBase.disableSSL();
        String customerCode = compteService.createCustomer(businessKey);

        Map<String, Object> response = new HashMap<>();
        response.put("customerCode", customerCode);
        return ResponseEntity.status(201).body(response);
    }

    /*@GetMapping(path = "/{businessKey}/load-customer")
    public ResponseEntity<Object> getCustomerDetails(
            @PathVariable String businessKey) throws gercustomerproxy.ErrorResponseFlow_Exception {
        Optional<Compte> mayBe = compteService.getCompte(businessKey);

        if (!mayBe.isPresent()) {
            throw new GenericNotFoundExceoption("Client Introuvable");
        }
        return ResponseEntity.status(200)
                .body(bankingBase
                        .getCustomerDetails(mayBe.get().getCustomercode())
                        .orElseThrow(()-> new GenericNotFoundExceoption("Client Introuvable"))
                );
    }*/
}
