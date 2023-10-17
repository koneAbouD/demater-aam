
package createcustomerproxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour customerJointAccountInformations complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="customerJointAccountInformations">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="coHolderInformations" type="{http://soprabanking.com/amplitude}customerCoHolderInformations"/>
 *         &lt;element name="linkTyp" type="{http://soprabanking.com/amplitude}linkTyp"/>
 *         &lt;element name="toBePrintedInTheAddress" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customerJointAccountInformations", propOrder = {
    "coHolderInformations",
    "linkTyp",
    "toBePrintedInTheAddress"
})
public class CustomerJointAccountInformations {

    @XmlElement(required = true)
    protected CustomerCoHolderInformations coHolderInformations;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected LinkTyp linkTyp;
    protected boolean toBePrintedInTheAddress;

    /**
     * Obtient la valeur de la propriété coHolderInformations.
     * 
     * @return
     *     possible object is
     *     {@link CustomerCoHolderInformations }
     *     
     */
    public CustomerCoHolderInformations getCoHolderInformations() {
        return coHolderInformations;
    }

    /**
     * Définit la valeur de la propriété coHolderInformations.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerCoHolderInformations }
     *     
     */
    public void setCoHolderInformations(CustomerCoHolderInformations value) {
        this.coHolderInformations = value;
    }

    /**
     * Obtient la valeur de la propriété linkTyp.
     * 
     * @return
     *     possible object is
     *     {@link LinkTyp }
     *     
     */
    public LinkTyp getLinkTyp() {
        return linkTyp;
    }

    /**
     * Définit la valeur de la propriété linkTyp.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkTyp }
     *     
     */
    public void setLinkTyp(LinkTyp value) {
        this.linkTyp = value;
    }

    /**
     * Obtient la valeur de la propriété toBePrintedInTheAddress.
     * 
     */
    public boolean isToBePrintedInTheAddress() {
        return toBePrintedInTheAddress;
    }

    /**
     * Définit la valeur de la propriété toBePrintedInTheAddress.
     * 
     */
    public void setToBePrintedInTheAddress(boolean value) {
        this.toBePrintedInTheAddress = value;
    }

}
