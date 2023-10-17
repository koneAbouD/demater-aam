
package createcustomerproxy;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour customerInternationalOperationType.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="customerInternationalOperationType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="D"/>
 *     &lt;enumeration value="P"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "customerInternationalOperationType")
@XmlEnum
public enum CustomerInternationalOperationType {

    D,
    P;

    public String value() {
        return name();
    }

    public static CustomerInternationalOperationType fromValue(String v) {
        return valueOf(v);
    }

}
