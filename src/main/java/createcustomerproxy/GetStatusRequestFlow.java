
package createcustomerproxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour getStatusRequestFlow complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="getStatusRequestFlow">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="getStatusRequest" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getStatusRequestFlow", propOrder = {
    "getStatusRequest"
})
public class GetStatusRequestFlow {

    @XmlElement(required = true)
    protected String getStatusRequest;

    /**
     * Obtient la valeur de la propriété getStatusRequest.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGetStatusRequest() {
        return getStatusRequest;
    }

    /**
     * Définit la valeur de la propriété getStatusRequest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGetStatusRequest(String value) {
        this.getStatusRequest = value;
    }

}
