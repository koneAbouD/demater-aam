package africa.box.dm.service;

import africa.box.dm.dto.MyAppValidationMessageDto;

import java.util.List;

public class MyAppException extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private List<MyAppValidationMessageDto> validationErrors;

    public MyAppException() {
    }

    public MyAppException(String message) {
        super(message);
    }

    public MyAppException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyAppException(Throwable cause) {
        super(cause);
    }

    public static MyAppException ofValidationErrors(List<MyAppValidationMessageDto> appMessages) {
        MyAppException expp = new MyAppException("Validation Error");
        expp.setValidationErrors(appMessages);
        return expp;
    }

    public void setValidationErrors(List<MyAppValidationMessageDto> validationErrors) {
        this.validationErrors = validationErrors;
    }

    public List<MyAppValidationMessageDto> getValidationErrors() {
        return validationErrors;
    }
}
