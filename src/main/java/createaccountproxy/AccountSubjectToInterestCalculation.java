
package createaccountproxy;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour accountSubjectToInterestCalculation.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="accountSubjectToInterestCalculation">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="N"/>
 *     &lt;enumeration value="O"/>
 *     &lt;enumeration value="R"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "accountSubjectToInterestCalculation")
@XmlEnum
public enum AccountSubjectToInterestCalculation {

    N,
    O,
    R;

    public String value() {
        return name();
    }

    public static AccountSubjectToInterestCalculation fromValue(String v) {
        return valueOf(v);
    }

}
