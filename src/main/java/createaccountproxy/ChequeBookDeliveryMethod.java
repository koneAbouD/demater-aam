
package createaccountproxy;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour chequeBookDeliveryMethod.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="chequeBookDeliveryMethod">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="B"/>
 *     &lt;enumeration value="C"/>
 *     &lt;enumeration value="R"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "chequeBookDeliveryMethod")
@XmlEnum
public enum ChequeBookDeliveryMethod {

    B,
    C,
    R;

    public String value() {
        return name();
    }

    public static ChequeBookDeliveryMethod fromValue(String v) {
        return valueOf(v);
    }

}
