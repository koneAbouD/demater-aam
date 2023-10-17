
package gercustomerproxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour customerEmailAddress complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="customerEmailAddress">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="customer" type="{http://soprabanking.com/amplitude}restrictedCustomer" minOccurs="0"/>
 *         &lt;element name="mailType" type="{http://soprabanking.com/amplitude}mailType" minOccurs="0"/>
 *         &lt;element name="email" type="{http://soprabanking.com/amplitude}charMax50"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customerEmailAddress", propOrder = {
    "customer",
    "mailType",
    "email"
})
public class CustomerEmailAddress {

    protected RestrictedCustomer customer;
    protected MailType mailType;
    @XmlElement(required = true)
    protected String email;

    /**
     * Obtient la valeur de la propri�t� customer.
     * 
     * @return
     *     possible object is
     *     {@link RestrictedCustomer }
     *     
     */
    public RestrictedCustomer getCustomer() {
        return customer;
    }

    /**
     * D�finit la valeur de la propri�t� customer.
     * 
     * @param value
     *     allowed object is
     *     {@link RestrictedCustomer }
     *     
     */
    public void setCustomer(RestrictedCustomer value) {
        this.customer = value;
    }

    /**
     * Obtient la valeur de la propri�t� mailType.
     * 
     * @return
     *     possible object is
     *     {@link MailType }
     *     
     */
    public MailType getMailType() {
        return mailType;
    }

    /**
     * D�finit la valeur de la propri�t� mailType.
     * 
     * @param value
     *     allowed object is
     *     {@link MailType }
     *     
     */
    public void setMailType(MailType value) {
        this.mailType = value;
    }

    /**
     * Obtient la valeur de la propri�t� email.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * D�finit la valeur de la propri�t� email.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

}
