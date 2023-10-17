
package createaccountproxy;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour accountExistingAddressToBeUsed.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="accountExistingAddressToBeUsed">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="C"/>
 *     &lt;enumeration value="CC"/>
 *     &lt;enumeration value="D"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "accountExistingAddressToBeUsed")
@XmlEnum
public enum AccountExistingAddressToBeUsed {

    C,
    CC,
    D;

    public String value() {
        return name();
    }

    public static AccountExistingAddressToBeUsed fromValue(String v) {
        return valueOf(v);
    }

}
