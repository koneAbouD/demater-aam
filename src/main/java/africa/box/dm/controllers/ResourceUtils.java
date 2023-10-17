package africa.box.dm.controllers;

import africa.box.dm.controllers.exceptions.CompteNotException;
import africa.box.dm.controllers.exceptions.EntityNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import javax.swing.text.html.Option;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ResourceUtils {

    public static <T> ResponseEntity<T> wrapOrNotFound(Optional<T> mayBeResponse){
        return wrapOrNotFound(mayBeResponse, null);
    }

    public static <T> ResponseEntity<T> wrapOrNotFound(Optional<T> mayBeResponse, HttpHeaders headers){
        return ResponseEntity.ok().headers(headers).body(
                mayBeResponse.orElseThrow(()->new EntityNotFoundException())
        );
    }


    public static ResponseEntity<Map<String, Object>> checkFieldErrors(BindingResult br){
        if (br.hasErrors()){
            System.out.println("###########");
            Map<String, Object> err = new HashMap<>();
            for (FieldError fe:br.getFieldErrors()){
                err.put(fe.getField(), fe.getDefaultMessage());
            }

            return ResponseEntity.status(400).body(err);
        }
        return null;
    }
}
