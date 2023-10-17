
package gercustomerproxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour getCustomerActiveProfileResponse complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="getCustomerActiveProfileResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="activeProfile" type="{http://soprabanking.com/amplitude}customerProfile"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getCustomerActiveProfileResponse", propOrder = {
    "activeProfile"
})
public class GetCustomerActiveProfileResponse {

    @XmlElement(required = true)
    protected CustomerProfile activeProfile;

    /**
     * Obtient la valeur de la propriété activeProfile.
     * 
     * @return
     *     possible object is
     *     {@link CustomerProfile }
     *     
     */
    public CustomerProfile getActiveProfile() {
        return activeProfile;
    }

    /**
     * Définit la valeur de la propriété activeProfile.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerProfile }
     *     
     */
    public void setActiveProfile(CustomerProfile value) {
        this.activeProfile = value;
    }

}
