
package gercustomerproxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour customerOtherAttributes complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="customerOtherAttributes">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="holderMotherName" type="{http://soprabanking.com/amplitude}charMax67" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customerOtherAttributes", propOrder = {
    "holderMotherName"
})
public class CustomerOtherAttributes {

    protected String holderMotherName;

    /**
     * Obtient la valeur de la propri�t� holderMotherName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHolderMotherName() {
        return holderMotherName;
    }

    /**
     * D�finit la valeur de la propri�t� holderMotherName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHolderMotherName(String value) {
        this.holderMotherName = value;
    }

}
