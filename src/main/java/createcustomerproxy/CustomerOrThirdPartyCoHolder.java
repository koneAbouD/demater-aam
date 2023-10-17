
package createcustomerproxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour customerOrThirdPartyCoHolder complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="customerOrThirdPartyCoHolder">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="coHolderType" type="{http://soprabanking.com/amplitude}customerOrThirdPartyType"/>
 *         &lt;element name="jointCustomerCode" type="{http://soprabanking.com/amplitude}customerCode"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customerOrThirdPartyCoHolder", propOrder = {
    "coHolderType",
    "jointCustomerCode"
})
public class CustomerOrThirdPartyCoHolder {

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected CustomerOrThirdPartyType coHolderType;
    @XmlElement(required = true)
    protected String jointCustomerCode;

    /**
     * Obtient la valeur de la propriété coHolderType.
     * 
     * @return
     *     possible object is
     *     {@link CustomerOrThirdPartyType }
     *     
     */
    public CustomerOrThirdPartyType getCoHolderType() {
        return coHolderType;
    }

    /**
     * Définit la valeur de la propriété coHolderType.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerOrThirdPartyType }
     *     
     */
    public void setCoHolderType(CustomerOrThirdPartyType value) {
        this.coHolderType = value;
    }

    /**
     * Obtient la valeur de la propriété jointCustomerCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJointCustomerCode() {
        return jointCustomerCode;
    }

    /**
     * Définit la valeur de la propriété jointCustomerCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJointCustomerCode(String value) {
        this.jointCustomerCode = value;
    }

}
