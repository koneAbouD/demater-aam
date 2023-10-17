
package createaccountproxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour createAccountRequestFlow complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="createAccountRequestFlow">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="requestHeader" type="{http://soprabanking.com/amplitude}requestHeader"/>
 *         &lt;element name="createAccountRequest" type="{http://soprabanking.com/amplitude}createAccountRequest"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createAccountRequestFlow", propOrder = {
    "requestHeader",
    "createAccountRequest"
})
public class CreateAccountRequestFlow {

    @XmlElement(required = true)
    protected RequestHeader requestHeader;
    @XmlElement(required = true)
    protected CreateAccountRequest createAccountRequest;

    /**
     * Obtient la valeur de la propri�t� requestHeader.
     * 
     * @return
     *     possible object is
     *     {@link RequestHeader }
     *     
     */
    public RequestHeader getRequestHeader() {
        return requestHeader;
    }

    /**
     * D�finit la valeur de la propri�t� requestHeader.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestHeader }
     *     
     */
    public void setRequestHeader(RequestHeader value) {
        this.requestHeader = value;
    }

    /**
     * Obtient la valeur de la propri�t� createAccountRequest.
     * 
     * @return
     *     possible object is
     *     {@link CreateAccountRequest }
     *     
     */
    public CreateAccountRequest getCreateAccountRequest() {
        return createAccountRequest;
    }

    /**
     * D�finit la valeur de la propri�t� createAccountRequest.
     * 
     * @param value
     *     allowed object is
     *     {@link CreateAccountRequest }
     *     
     */
    public void setCreateAccountRequest(CreateAccountRequest value) {
        this.createAccountRequest = value;
    }

}
