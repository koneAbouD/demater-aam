
package createaccountproxy;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour codeForInterestLadderPrinting.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="codeForInterestLadderPrinting">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="D"/>
 *     &lt;enumeration value="N"/>
 *     &lt;enumeration value="S"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "codeForInterestLadderPrinting")
@XmlEnum
public enum CodeForInterestLadderPrinting {

    D,
    N,
    S;

    public String value() {
        return name();
    }

    public static CodeForInterestLadderPrinting fromValue(String v) {
        return valueOf(v);
    }

}
