
package createaccountproxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour createAccountResponseFlow complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="createAccountResponseFlow">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="responseHeader" type="{http://soprabanking.com/amplitude}responseHeader"/>
 *         &lt;element name="responseStatus" type="{http://soprabanking.com/amplitude}responseStatus"/>
 *         &lt;element name="createAccountResponse" type="{http://soprabanking.com/amplitude}createAccountResponse" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createAccountResponseFlow", propOrder = {
    "responseHeader",
    "responseStatus",
    "createAccountResponse"
})
public class CreateAccountResponseFlow {

    @XmlElement(required = true)
    protected ResponseHeader responseHeader;
    @XmlElement(required = true)
    protected ResponseStatus responseStatus;
    protected CreateAccountResponse createAccountResponse;

    /**
     * Obtient la valeur de la propri�t� responseHeader.
     * 
     * @return
     *     possible object is
     *     {@link ResponseHeader }
     *     
     */
    public ResponseHeader getResponseHeader() {
        return responseHeader;
    }

    /**
     * D�finit la valeur de la propri�t� responseHeader.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseHeader }
     *     
     */
    public void setResponseHeader(ResponseHeader value) {
        this.responseHeader = value;
    }

    /**
     * Obtient la valeur de la propri�t� responseStatus.
     * 
     * @return
     *     possible object is
     *     {@link ResponseStatus }
     *     
     */
    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    /**
     * D�finit la valeur de la propri�t� responseStatus.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseStatus }
     *     
     */
    public void setResponseStatus(ResponseStatus value) {
        this.responseStatus = value;
    }

    /**
     * Obtient la valeur de la propri�t� createAccountResponse.
     * 
     * @return
     *     possible object is
     *     {@link CreateAccountResponse }
     *     
     */
    public CreateAccountResponse getCreateAccountResponse() {
        return createAccountResponse;
    }

    /**
     * D�finit la valeur de la propri�t� createAccountResponse.
     * 
     * @param value
     *     allowed object is
     *     {@link CreateAccountResponse }
     *     
     */
    public void setCreateAccountResponse(CreateAccountResponse value) {
        this.createAccountResponse = value;
    }

}
