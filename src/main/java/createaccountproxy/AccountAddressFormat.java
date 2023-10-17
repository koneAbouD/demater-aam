
package createaccountproxy;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour accountAddressFormat.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="accountAddressFormat">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;length value="2"/>
 *     &lt;enumeration value="BP"/>
 *     &lt;enumeration value="CA"/>
 *     &lt;enumeration value="CX"/>
 *     &lt;enumeration value="EM"/>
 *     &lt;enumeration value="GE"/>
 *     &lt;enumeration value="GU"/>
 *     &lt;enumeration value="SE"/>
 *     &lt;enumeration value="SP"/>
 *     &lt;enumeration value="TR"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "accountAddressFormat")
@XmlEnum
public enum AccountAddressFormat {

    BP,
    CA,
    CX,
    EM,
    GE,
    GU,
    SE,
    SP,
    TR;

    public String value() {
        return name();
    }

    public static AccountAddressFormat fromValue(String v) {
        return valueOf(v);
    }

}
