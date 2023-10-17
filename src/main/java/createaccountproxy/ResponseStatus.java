
package createaccountproxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour responseStatus complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="responseStatus">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="statusCode" type="{http://soprabanking.com/amplitude}statusCodeType"/>
 *         &lt;element name="messages" type="{http://soprabanking.com/amplitude}responseStatusMessages" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "responseStatus", propOrder = {
    "statusCode",
    "messages"
})
public class ResponseStatus {

    @XmlElement(required = true)
    protected String statusCode;
    protected ResponseStatusMessages messages;

    /**
     * Obtient la valeur de la propri�t� statusCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusCode() {
        return statusCode;
    }

    /**
     * D�finit la valeur de la propri�t� statusCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusCode(String value) {
        this.statusCode = value;
    }

    /**
     * Obtient la valeur de la propri�t� messages.
     * 
     * @return
     *     possible object is
     *     {@link ResponseStatusMessages }
     *     
     */
    public ResponseStatusMessages getMessages() {
        return messages;
    }

    /**
     * D�finit la valeur de la propri�t� messages.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseStatusMessages }
     *     
     */
    public void setMessages(ResponseStatusMessages value) {
        this.messages = value;
    }

}
