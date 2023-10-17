
package gercustomerproxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour getCustomerDetailResponseFlow complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="getCustomerDetailResponseFlow">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="responseHeader" type="{http://soprabanking.com/amplitude}responseHeader"/>
 *         &lt;element name="responseStatus" type="{http://soprabanking.com/amplitude}responseStatus"/>
 *         &lt;element name="getCustomerDetailResponse" type="{http://soprabanking.com/amplitude}getCustomerDetailResponse" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getCustomerDetailResponseFlow", propOrder = {
    "responseHeader",
    "responseStatus",
    "getCustomerDetailResponse"
})
public class GetCustomerDetailResponseFlow {

    @XmlElement(required = true)
    protected ResponseHeader responseHeader;
    @XmlElement(required = true)
    protected ResponseStatus responseStatus;
    protected GetCustomerDetailResponse getCustomerDetailResponse;

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
     * Obtient la valeur de la propri�t� getCustomerDetailResponse.
     * 
     * @return
     *     possible object is
     *     {@link GetCustomerDetailResponse }
     *     
     */
    public GetCustomerDetailResponse getGetCustomerDetailResponse() {
        return getCustomerDetailResponse;
    }

    /**
     * D�finit la valeur de la propri�t� getCustomerDetailResponse.
     * 
     * @param value
     *     allowed object is
     *     {@link GetCustomerDetailResponse }
     *     
     */
    public void setGetCustomerDetailResponse(GetCustomerDetailResponse value) {
        this.getCustomerDetailResponse = value;
    }

}
