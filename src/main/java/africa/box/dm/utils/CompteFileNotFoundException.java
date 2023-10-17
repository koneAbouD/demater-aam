package africa.box.dm.utils;

public class CompteFileNotFoundException extends RuntimeException {
    public CompteFileNotFoundException(){
        super("Document introuvable");
    }
}
