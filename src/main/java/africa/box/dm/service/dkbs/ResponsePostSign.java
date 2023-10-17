package africa.box.dm.service.dkbs;

public class ResponsePostSign {

    private String code;
    private String message;
    private Integer signature_restant;

    public Integer getSignature_restant() {
        return signature_restant;
    }

    public void setSignature_restant(Integer signature_restant) {
        this.signature_restant = signature_restant;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResponsePostSign() {
    }

    public ResponsePostSign(String code, String message, Integer signature_restant) {
        this.code = code;
        this.message = message;
        this.signature_restant = signature_restant;
    }
}
