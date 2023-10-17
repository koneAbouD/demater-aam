package africa.box.dm.controllers;

import africa.box.dm.db.entities.CreditCardParameter;
import africa.box.dm.service.SystemParameterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;
import java.util.List;


@RestController
@RequestMapping(path = "/parameters")
public class SystemParameterController {
    private SystemParameterService systemParameterService;


    @PostMapping(path = "/credit-card")
    public ResponseEntity<Long> addCreditCard(@RequestBody CreditCardParameter body) {
        return ResponseEntity.status(201)
                .body(systemParameterService.addCreditCard(body));
    }


    @PostMapping(path = "/credit-card/update")
    public ResponseEntity<CreditCardParameter> updateCreditCard(@RequestBody CreditCardParameter body) {
        return ResponseEntity.status(201)
                .body(systemParameterService.update(body).orElseThrow(()->{
                    return new RuntimeException("Card de credit introubble");
                }));
    }

    @PostMapping(path = "/credit-card/{id}")
    public ResponseEntity<Void> deleteCreditCard(@PathVariable Long id) {
        systemParameterService.delete(id);
        return ResponseEntity.status(204)
                .body(null);
    }



    @GetMapping(path = "/credit-card")
    public List<CreditCardParameter> getAllCreditCard() {
        return systemParameterService.findAll();
    }
}
