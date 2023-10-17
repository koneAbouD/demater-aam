package africa.box.dm.service.impl;

public class IDCardNotFountException extends RuntimeException {
    public IDCardNotFountException(){
        super("Carte d'identité manquante");
    }
}
