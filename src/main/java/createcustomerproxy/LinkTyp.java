
package createcustomerproxy;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour linkTyp.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="linkTyp">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ET"/>
 *     &lt;enumeration value="MI"/>
 *     &lt;enumeration value="OU"/>
 *     &lt;enumeration value="SP"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "linkTyp")
@XmlEnum
public enum LinkTyp {

    ET,
    MI,
    OU,
    SP;

    public String value() {
        return name();
    }

    public static LinkTyp fromValue(String v) {
        return valueOf(v);
    }

}
