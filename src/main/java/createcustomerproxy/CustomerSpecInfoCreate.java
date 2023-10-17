
package createcustomerproxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour customerSpecInfoCreate complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="customerSpecInfoCreate">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="individualSpecInfo" type="{http://soprabanking.com/amplitude}customerIndividualSpecInfoCreate"/>
 *         &lt;element name="corporateSpecInfo" type="{http://soprabanking.com/amplitude}customerCorporateSpecInfoCreate"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customerSpecInfoCreate", propOrder = {
    "individualSpecInfo",
    "corporateSpecInfo"
})
public class CustomerSpecInfoCreate {

    protected CustomerIndividualSpecInfoCreate individualSpecInfo;
    protected CustomerCorporateSpecInfoCreate corporateSpecInfo;

    /**
     * Obtient la valeur de la propriété individualSpecInfo.
     * 
     * @return
     *     possible object is
     *     {@link CustomerIndividualSpecInfoCreate }
     *     
     */
    public CustomerIndividualSpecInfoCreate getIndividualSpecInfo() {
        return individualSpecInfo;
    }

    /**
     * Définit la valeur de la propriété individualSpecInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerIndividualSpecInfoCreate }
     *     
     */
    public void setIndividualSpecInfo(CustomerIndividualSpecInfoCreate value) {
        this.individualSpecInfo = value;
    }

    /**
     * Obtient la valeur de la propriété corporateSpecInfo.
     * 
     * @return
     *     possible object is
     *     {@link CustomerCorporateSpecInfoCreate }
     *     
     */
    public CustomerCorporateSpecInfoCreate getCorporateSpecInfo() {
        return corporateSpecInfo;
    }

    /**
     * Définit la valeur de la propriété corporateSpecInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerCorporateSpecInfoCreate }
     *     
     */
    public void setCorporateSpecInfo(CustomerCorporateSpecInfoCreate value) {
        this.corporateSpecInfo = value;
    }

}
