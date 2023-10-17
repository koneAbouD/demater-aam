package africa.box.dm.controllers;

import africa.box.dm.consumer.ocr.IdenfyBadRequestException;
import africa.box.dm.consumer.ocr.IdenfyErrorExeption;
import africa.box.dm.controllers.exceptions.CompteNotException;
import com.google.gson.Gson;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExcepptionHandler {

    @ExceptionHandler({IdenfyErrorExeption.class, IdenfyBadRequestException.class})
    public ResponseEntity<Object> idenfyExceptionhandler(IdenfyErrorExeption ex){
        Map<String, Object> err = new HashMap<>();
        ex.printStackTrace();
        err.put("message", ex.getMessage());
        return ResponseEntity.status(400).body(err);
    }


    @ExceptionHandler({SocketException.class, SocketTimeoutException.class})
    public ResponseEntity<Map<String, Object>> sockerExceptionHandler(Exception ex){
        Map<String, Object> err = new HashMap<>();
        err.put("message", "Service temporairement indisponible");
        return ResponseEntity.status(400).body(err);
    }

    @ExceptionHandler({NullPointerException.class})
    public ResponseEntity<Map<String, Object>> nullPoninterExceptionHandler(Exception ex){
        Map<String, Object> err = new HashMap<>();
        err.put("message", "Impossible de traiter un object null");
        ex.printStackTrace();
        return ResponseEntity.status(400).body(err);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<Map<String, Object>> goblabExceptionHandler(Exception ex){
        Map<String, Object> err = new HashMap<>();
        err.put("message", "Some error happened on server side");
        err.put("error", ex.getLocalizedMessage());
        ex.printStackTrace();
        return ResponseEntity.status(400).body(err);
    }

    @ExceptionHandler({CompteNotException.class})
    public ResponseEntity<Map<String, Object>> EntityNoundException(Exception ex) {
        Map<String, Object> err = new HashMap<>();
        err.put("error", ex.getMessage());
        ex.printStackTrace();
        return ResponseEntity.status(400).body(err);
    }
}
