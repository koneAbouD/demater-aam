package africa.box.dm.dto;

public class MyAppValidationMessageDto {
    private String type;
    private String message;
    private String path;
    private String[] arguments;
    private String code;

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setArguments(String[] arguments) {
        this.arguments = arguments;
    }

    public String[] getArguments() {
        return arguments;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
