
package createcustomerproxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour customerInternationalOperationInformations complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="customerInternationalOperationInformations">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="customerInternationalOperationType" type="{http://soprabanking.com/amplitude}customerInternationalOperationType"/>
 *         &lt;element name="customerInternationalOperationCode" type="{http://soprabanking.com/amplitude}charMax3"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customerInternationalOperationInformations", propOrder = {
    "customerInternationalOperationType",
    "customerInternationalOperationCode"
})
public class CustomerInternationalOperationInformations {

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected CustomerInternationalOperationType customerInternationalOperationType;
    @XmlElement(required = true)
    protected String customerInternationalOperationCode;

    /**
     * Obtient la valeur de la propriété customerInternationalOperationType.
     * 
     * @return
     *     possible object is
     *     {@link CustomerInternationalOperationType }
     *     
     */
    public CustomerInternationalOperationType getCustomerInternationalOperationType() {
        return customerInternationalOperationType;
    }

    /**
     * Définit la valeur de la propriété customerInternationalOperationType.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerInternationalOperationType }
     *     
     */
    public void setCustomerInternationalOperationType(CustomerInternationalOperationType value) {
        this.customerInternationalOperationType = value;
    }

    /**
     * Obtient la valeur de la propriété customerInternationalOperationCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerInternationalOperationCode() {
        return customerInternationalOperationCode;
    }

    /**
     * Définit la valeur de la propriété customerInternationalOperationCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerInternationalOperationCode(String value) {
        this.customerInternationalOperationCode = value;
    }

}
