
package createaccountproxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java pour requestHeader complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="requestHeader">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="requestId" type="{http://soprabanking.com/amplitude}charMax50"/>
 *         &lt;element name="serviceName" type="{http://soprabanking.com/amplitude}charMax50"/>
 *         &lt;element name="timestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="originalName" type="{http://soprabanking.com/amplitude}charMax50" minOccurs="0"/>
 *         &lt;element name="originalId" type="{http://soprabanking.com/amplitude}charMax50" minOccurs="0"/>
 *         &lt;element name="originalTimestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="languageCode" type="{http://soprabanking.com/amplitude}languageCode" minOccurs="0"/>
 *         &lt;element name="userCode" type="{http://soprabanking.com/amplitude}charMax10"/>
 *         &lt;element name="channelCode" type="{http://soprabanking.com/amplitude}channelCode" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "requestHeader", propOrder = {
    "requestId",
    "serviceName",
    "timestamp",
    "originalName",
    "originalId",
    "originalTimestamp",
    "languageCode",
    "userCode",
    "channelCode"
})
public class RequestHeader {

    @XmlElement(required = true)
    protected String requestId;
    @XmlElement(required = true)
    protected String serviceName;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar timestamp;
    protected String originalName;
    protected String originalId;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar originalTimestamp;
    protected String languageCode;
    @XmlElement(required = true)
    protected String userCode;
    protected String channelCode;

    /**
     * Obtient la valeur de la propri�t� requestId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestId() {
        return requestId;
    }

    /**
     * D�finit la valeur de la propri�t� requestId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestId(String value) {
        this.requestId = value;
    }

    /**
     * Obtient la valeur de la propri�t� serviceName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceName() {
        return serviceName;
    }

    /**
     * D�finit la valeur de la propri�t� serviceName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceName(String value) {
        this.serviceName = value;
    }

    /**
     * Obtient la valeur de la propri�t� timestamp.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTimestamp() {
        return timestamp;
    }

    /**
     * D�finit la valeur de la propri�t� timestamp.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTimestamp(XMLGregorianCalendar value) {
        this.timestamp = value;
    }

    /**
     * Obtient la valeur de la propri�t� originalName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginalName() {
        return originalName;
    }

    /**
     * D�finit la valeur de la propri�t� originalName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginalName(String value) {
        this.originalName = value;
    }

    /**
     * Obtient la valeur de la propri�t� originalId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginalId() {
        return originalId;
    }

    /**
     * D�finit la valeur de la propri�t� originalId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginalId(String value) {
        this.originalId = value;
    }

    /**
     * Obtient la valeur de la propri�t� originalTimestamp.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getOriginalTimestamp() {
        return originalTimestamp;
    }

    /**
     * D�finit la valeur de la propri�t� originalTimestamp.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setOriginalTimestamp(XMLGregorianCalendar value) {
        this.originalTimestamp = value;
    }

    /**
     * Obtient la valeur de la propri�t� languageCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLanguageCode() {
        return languageCode;
    }

    /**
     * D�finit la valeur de la propri�t� languageCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLanguageCode(String value) {
        this.languageCode = value;
    }

    /**
     * Obtient la valeur de la propri�t� userCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserCode() {
        return userCode;
    }

    /**
     * D�finit la valeur de la propri�t� userCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserCode(String value) {
        this.userCode = value;
    }

    /**
     * Obtient la valeur de la propri�t� channelCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChannelCode() {
        return channelCode;
    }

    /**
     * D�finit la valeur de la propri�t� channelCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChannelCode(String value) {
        this.channelCode = value;
    }

}
