package africa.box.dm.controllers.exceptions;

public class MalformedDateEception extends RuntimeException {
    public MalformedDateEception(String message){
        super(message);
    }
}
