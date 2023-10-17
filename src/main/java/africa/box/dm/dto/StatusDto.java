package africa.box.dm.dto;

public class StatusDto {
    private Boolean error;
    private String message;

    public static StatusDto ofSuccess(String message) {
        StatusDto stat = new StatusDto();
        stat.setError(false);
        stat.setMessage(message);
        return stat;
    }
    public static StatusDto ofError(String message,Exception e) {
        StatusDto stat = new StatusDto();
        stat.setError(true);
        stat.setMessage(message+" "+e.getMessage());
        return stat;
    }
    public static StatusDto ofEchec(String message) {
        StatusDto stat = new StatusDto();
        stat.setError(true);
        stat.setMessage(message);
        return stat;
    }

    public StatusDto() {
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
