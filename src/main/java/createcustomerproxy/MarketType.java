
package createcustomerproxy;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour marketType.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="marketType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PB"/>
 *     &lt;enumeration value="PV"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "marketType")
@XmlEnum
public enum MarketType {

    PB,
    PV;

    public String value() {
        return name();
    }

    public static MarketType fromValue(String v) {
        return valueOf(v);
    }

}
