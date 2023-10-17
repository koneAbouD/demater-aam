
package createaccountproxy;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour accountAddressType.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="accountAddressType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;minLength value="1"/>
 *     &lt;maxLength value="2"/>
 *     &lt;enumeration value="C"/>
 *     &lt;enumeration value="CH"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "accountAddressType")
@XmlEnum
public enum AccountAddressType {

    C,
    CH;

    public String value() {
        return name();
    }

    public static AccountAddressType fromValue(String v) {
        return valueOf(v);
    }

}
