package africa.box.dm.consumer.ocr;

public class RegulaLicenseNotFoundException extends RuntimeException {
    public RegulaLicenseNotFoundException(){
        super("Service temporairement indisponible");
    }
}
