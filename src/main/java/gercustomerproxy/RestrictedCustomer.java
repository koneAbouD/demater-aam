
package gercustomerproxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour restrictedCustomer complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="restrictedCustomer">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="customerNumber" type="{http://soprabanking.com/amplitude}charMax15" minOccurs="0"/>
 *         &lt;element name="displayedName" type="{http://soprabanking.com/amplitude}charMax67" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "restrictedCustomer", propOrder = {
    "customerNumber",
    "displayedName"
})
public class RestrictedCustomer {

    protected String customerNumber;
    protected String displayedName;

    /**
     * Obtient la valeur de la propri�t� customerNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerNumber() {
        return customerNumber;
    }

    /**
     * D�finit la valeur de la propri�t� customerNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerNumber(String value) {
        this.customerNumber = value;
    }

    /**
     * Obtient la valeur de la propri�t� displayedName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDisplayedName() {
        return displayedName;
    }

    /**
     * D�finit la valeur de la propri�t� displayedName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDisplayedName(String value) {
        this.displayedName = value;
    }

}
