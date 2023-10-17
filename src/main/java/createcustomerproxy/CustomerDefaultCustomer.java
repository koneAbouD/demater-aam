
package createcustomerproxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour customerDefaultCustomer complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="customerDefaultCustomer">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="retail" type="{http://soprabanking.com/amplitude}customerRetail" minOccurs="0"/>
 *         &lt;element name="nonRetail" type="{http://soprabanking.com/amplitude}customerNonRetail" minOccurs="0"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customerDefaultCustomer", propOrder = {
    "retail",
    "nonRetail"
})
public class CustomerDefaultCustomer {

    protected CustomerRetail retail;
    protected CustomerNonRetail nonRetail;

    /**
     * Obtient la valeur de la propri�t� retail.
     * 
     * @return
     *     possible object is
     *     {@link CustomerRetail }
     *     
     */
    public CustomerRetail getRetail() {
        return retail;
    }

    /**
     * D�finit la valeur de la propri�t� retail.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerRetail }
     *     
     */
    public void setRetail(CustomerRetail value) {
        this.retail = value;
    }

    /**
     * Obtient la valeur de la propri�t� nonRetail.
     * 
     * @return
     *     possible object is
     *     {@link CustomerNonRetail }
     *     
     */
    public CustomerNonRetail getNonRetail() {
        return nonRetail;
    }

    /**
     * D�finit la valeur de la propri�t� nonRetail.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerNonRetail }
     *     
     */
    public void setNonRetail(CustomerNonRetail value) {
        this.nonRetail = value;
    }

}
