
package gercustomerproxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour getCustomerDetailRequestFlow complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="getCustomerDetailRequestFlow">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="requestHeader" type="{http://soprabanking.com/amplitude}requestHeader"/>
 *         &lt;element name="getCustomerDetailRequest" type="{http://soprabanking.com/amplitude}getCustomerDetailRequest"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getCustomerDetailRequestFlow", propOrder = {
    "requestHeader",
    "getCustomerDetailRequest"
})
public class GetCustomerDetailRequestFlow {

    @XmlElement(required = true)
    protected RequestHeader requestHeader;
    @XmlElement(required = true)
    protected GetCustomerDetailRequest getCustomerDetailRequest;

    /**
     * Obtient la valeur de la propriété requestHeader.
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
     * Définit la valeur de la propriété requestHeader.
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
     * Obtient la valeur de la propriété getCustomerDetailRequest.
     * 
     * @return
     *     possible object is
     *     {@link GetCustomerDetailRequest }
     *     
     */
    public GetCustomerDetailRequest getGetCustomerDetailRequest() {
        return getCustomerDetailRequest;
    }

    /**
     * Définit la valeur de la propriété getCustomerDetailRequest.
     * 
     * @param value
     *     allowed object is
     *     {@link GetCustomerDetailRequest }
     *     
     */
    public void setGetCustomerDetailRequest(GetCustomerDetailRequest value) {
        this.getCustomerDetailRequest = value;
    }

}
