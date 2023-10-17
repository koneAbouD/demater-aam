
package createcustomerproxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour shareholderCreateIdentifier complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="shareholderCreateIdentifier">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="customerCode" type="{http://soprabanking.com/amplitude}customerCode" minOccurs="0"/>
 *         &lt;element name="shareholderCode" type="{http://soprabanking.com/amplitude}shareholderCode"/>
 *         &lt;element name="shareholderType" type="{http://soprabanking.com/amplitude}customerOrThirdPartyType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "shareholderCreateIdentifier", propOrder = {
    "customerCode",
    "shareholderCode",
    "shareholderType"
})
public class ShareholderCreateIdentifier {

    protected String customerCode;
    @XmlElement(required = true)
    protected String shareholderCode;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected CustomerOrThirdPartyType shareholderType;

    /**
     * Obtient la valeur de la propriété customerCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerCode() {
        return customerCode;
    }

    /**
     * Définit la valeur de la propriété customerCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerCode(String value) {
        this.customerCode = value;
    }

    /**
     * Obtient la valeur de la propriété shareholderCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShareholderCode() {
        return shareholderCode;
    }

    /**
     * Définit la valeur de la propriété shareholderCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShareholderCode(String value) {
        this.shareholderCode = value;
    }

    /**
     * Obtient la valeur de la propriété shareholderType.
     * 
     * @return
     *     possible object is
     *     {@link CustomerOrThirdPartyType }
     *     
     */
    public CustomerOrThirdPartyType getShareholderType() {
        return shareholderType;
    }

    /**
     * Définit la valeur de la propriété shareholderType.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerOrThirdPartyType }
     *     
     */
    public void setShareholderType(CustomerOrThirdPartyType value) {
        this.shareholderType = value;
    }

}
