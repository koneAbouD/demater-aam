
package createcustomerproxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour customerLeaderInformations complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="customerLeaderInformations">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="leaderCode" type="{http://soprabanking.com/amplitude}leaderCode"/>
 *         &lt;element name="leaderType" type="{http://soprabanking.com/amplitude}customerOrThirdPartyType"/>
 *         &lt;element name="leaderPosition" type="{http://soprabanking.com/amplitude}charMax30" minOccurs="0"/>
 *         &lt;element name="typeOfCorporateExecutiveDuty" type="{http://soprabanking.com/amplitude}char3" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customerLeaderInformations", propOrder = {
    "leaderCode",
    "leaderType",
    "leaderPosition",
    "typeOfCorporateExecutiveDuty"
})
public class CustomerLeaderInformations {

    @XmlElement(required = true)
    protected String leaderCode;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected CustomerOrThirdPartyType leaderType;
    protected String leaderPosition;
    protected String typeOfCorporateExecutiveDuty;

    /**
     * Obtient la valeur de la propriété leaderCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLeaderCode() {
        return leaderCode;
    }

    /**
     * Définit la valeur de la propriété leaderCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLeaderCode(String value) {
        this.leaderCode = value;
    }

    /**
     * Obtient la valeur de la propriété leaderType.
     * 
     * @return
     *     possible object is
     *     {@link CustomerOrThirdPartyType }
     *     
     */
    public CustomerOrThirdPartyType getLeaderType() {
        return leaderType;
    }

    /**
     * Définit la valeur de la propriété leaderType.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerOrThirdPartyType }
     *     
     */
    public void setLeaderType(CustomerOrThirdPartyType value) {
        this.leaderType = value;
    }

    /**
     * Obtient la valeur de la propriété leaderPosition.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLeaderPosition() {
        return leaderPosition;
    }

    /**
     * Définit la valeur de la propriété leaderPosition.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLeaderPosition(String value) {
        this.leaderPosition = value;
    }

    /**
     * Obtient la valeur de la propriété typeOfCorporateExecutiveDuty.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypeOfCorporateExecutiveDuty() {
        return typeOfCorporateExecutiveDuty;
    }

    /**
     * Définit la valeur de la propriété typeOfCorporateExecutiveDuty.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeOfCorporateExecutiveDuty(String value) {
        this.typeOfCorporateExecutiveDuty = value;
    }

}
