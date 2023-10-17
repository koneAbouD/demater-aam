package africa.box.dm.controllers.exceptions;

public class CompteNotException extends RuntimeException{
    public CompteNotException(){
        super("Dossier introuvable");
    }
}
