package africa.box.dm.controllers.exceptions;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(){
        super("Ressource introuvable");
    }
}
