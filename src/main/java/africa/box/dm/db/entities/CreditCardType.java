package africa.box.dm.db.entities;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public enum CreditCardType {

    VISA_GOLD {
        @Override
        public boolean canHaveInsurance() {
            return true;
        }
    },
    VISA_CLASSIC {
        @Override
        public boolean canHaveInsurance() {
            return true;
        }
    },
    GIM_UEMOA {
        @Override
        public boolean canHaveInsurance() {
            return false;
        }
    };


    public abstract boolean canHaveInsurance();


}
