package africa.box.dm.service;

import java.util.UUID;

public class BusinessKeyGenerator {
    public static String newKey() {
        return UUID.randomUUID().toString();
    }
}
