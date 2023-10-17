package africa.box.dm.utils;

public class UnSupportedContratException extends RuntimeException {

    public UnSupportedContratException(){
        super("Type de contrat non supporté");
    }
}
