
package createcustomerproxy;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour customerOrThirdPartyType.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="customerOrThirdPartyType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="C"/>
 *     &lt;enumeration value="T"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "customerOrThirdPartyType")
@XmlEnum
public enum CustomerOrThirdPartyType {

    C,
    T;

    public String value() {
        return name();
    }

    public static CustomerOrThirdPartyType fromValue(String v) {
        return valueOf(v);
    }

}
