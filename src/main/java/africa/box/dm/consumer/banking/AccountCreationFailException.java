package africa.box.dm.consumer.banking;

import createcustomerproxy.ResponseStatusMessage;

import java.util.List;

public class AccountCreationFailException extends RuntimeException {
    public AccountCreationFailException(String message) {
        super(message);
    }
}
