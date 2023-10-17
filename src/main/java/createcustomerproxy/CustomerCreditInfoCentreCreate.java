
package createcustomerproxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour customerCreditInfoCentreCreate complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="customerCreditInfoCentreCreate">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="customerRelationshipRisk" type="{http://soprabanking.com/amplitude}customerRelationshipRiskLevelCode" minOccurs="0"/>
 *         &lt;element name="creditInfoCentreRegistrationNumber" type="{http://soprabanking.com/amplitude}charMax20" minOccurs="0"/>
 *         &lt;element name="creditInfoCentreCodeToDeclare" type="{http://soprabanking.com/amplitude}creditInfoCentreCodeToDeclare" minOccurs="0"/>
 *         &lt;element name="creditInfoCentreKey" type="{http://soprabanking.com/amplitude}char1" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customerCreditInfoCentreCreate", propOrder = {
    "customerRelationshipRisk",
    "creditInfoCentreRegistrationNumber",
    "creditInfoCentreCodeToDeclare",
    "creditInfoCentreKey"
})
public class CustomerCreditInfoCentreCreate {

    protected String customerRelationshipRisk;
    protected String creditInfoCentreRegistrationNumber;
    protected String creditInfoCentreCodeToDeclare;
    protected String creditInfoCentreKey;

    /**
     * Obtient la valeur de la propri�t� customerRelationshipRisk.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerRelationshipRisk() {
        return customerRelationshipRisk;
    }

    /**
     * D�finit la valeur de la propri�t� customerRelationshipRisk.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerRelationshipRisk(String value) {
        this.customerRelationshipRisk = value;
    }

    /**
     * Obtient la valeur de la propri�t� creditInfoCentreRegistrationNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreditInfoCentreRegistrationNumber() {
        return creditInfoCentreRegistrationNumber;
    }

    /**
     * D�finit la valeur de la propri�t� creditInfoCentreRegistrationNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreditInfoCentreRegistrationNumber(String value) {
        this.creditInfoCentreRegistrationNumber = value;
    }

    /**
     * Obtient la valeur de la propri�t� creditInfoCentreCodeToDeclare.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreditInfoCentreCodeToDeclare() {
        return creditInfoCentreCodeToDeclare;
    }

    /**
     * D�finit la valeur de la propri�t� creditInfoCentreCodeToDeclare.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreditInfoCentreCodeToDeclare(String value) {
        this.creditInfoCentreCodeToDeclare = value;
    }

    /**
     * Obtient la valeur de la propri�t� creditInfoCentreKey.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreditInfoCentreKey() {
        return creditInfoCentreKey;
    }

    /**
     * D�finit la valeur de la propri�t� creditInfoCentreKey.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreditInfoCentreKey(String value) {
        this.creditInfoCentreKey = value;
    }

}
