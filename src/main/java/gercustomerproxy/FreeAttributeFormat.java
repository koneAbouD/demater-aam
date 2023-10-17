
package gercustomerproxy;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour freeAttributeFormat.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="freeAttributeFormat">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="A"/>
 *     &lt;enumeration value="D"/>
 *     &lt;enumeration value="M"/>
 *     &lt;enumeration value="T"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "freeAttributeFormat")
@XmlEnum
public enum FreeAttributeFormat {

    A,
    D,
    M,
    T;

    public String value() {
        return name();
    }

    public static FreeAttributeFormat fromValue(String v) {
        return valueOf(v);
    }

}
