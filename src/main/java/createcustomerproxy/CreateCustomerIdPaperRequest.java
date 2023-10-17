
package createcustomerproxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java pour createCustomerIdPaperRequest complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="createCustomerIdPaperRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="customerCode" type="{http://soprabanking.com/amplitude}customerCode" minOccurs="0"/>
 *         &lt;element name="idPaperType" type="{http://soprabanking.com/amplitude}idPaperTypeCode" minOccurs="0"/>
 *         &lt;element name="idPaperNumber" type="{http://soprabanking.com/amplitude}charMax20" minOccurs="0"/>
 *         &lt;element name="deliveryDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="deliveryPlace" type="{http://soprabanking.com/amplitude}charMax30" minOccurs="0"/>
 *         &lt;element name="organisationWhichDeliver" type="{http://soprabanking.com/amplitude}charMax30" minOccurs="0"/>
 *         &lt;element name="validityDateOfIdPaper" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createCustomerIdPaperRequest", propOrder = {
    "customerCode",
    "idPaperType",
    "idPaperNumber",
    "deliveryDate",
    "deliveryPlace",
    "organisationWhichDeliver",
    "validityDateOfIdPaper"
})
public class CreateCustomerIdPaperRequest {

    protected String customerCode;
    protected String idPaperType;
    protected String idPaperNumber;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar deliveryDate;
    protected String deliveryPlace;
    protected String organisationWhichDeliver;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar validityDateOfIdPaper;

    /**
     * Obtient la valeur de la propri�t� customerCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerCode() {
        return customerCode;
    }

    /**
     * D�finit la valeur de la propri�t� customerCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerCode(String value) {
        this.customerCode = value;
    }

    /**
     * Obtient la valeur de la propri�t� idPaperType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdPaperType() {
        return idPaperType;
    }

    /**
     * D�finit la valeur de la propri�t� idPaperType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdPaperType(String value) {
        this.idPaperType = value;
    }

    /**
     * Obtient la valeur de la propri�t� idPaperNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdPaperNumber() {
        return idPaperNumber;
    }

    /**
     * D�finit la valeur de la propri�t� idPaperNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdPaperNumber(String value) {
        this.idPaperNumber = value;
    }

    /**
     * Obtient la valeur de la propri�t� deliveryDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDeliveryDate() {
        return deliveryDate;
    }

    /**
     * D�finit la valeur de la propri�t� deliveryDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDeliveryDate(XMLGregorianCalendar value) {
        this.deliveryDate = value;
    }

    /**
     * Obtient la valeur de la propri�t� deliveryPlace.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeliveryPlace() {
        return deliveryPlace;
    }

    /**
     * D�finit la valeur de la propri�t� deliveryPlace.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeliveryPlace(String value) {
        this.deliveryPlace = value;
    }

    /**
     * Obtient la valeur de la propri�t� organisationWhichDeliver.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrganisationWhichDeliver() {
        return organisationWhichDeliver;
    }

    /**
     * D�finit la valeur de la propri�t� organisationWhichDeliver.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrganisationWhichDeliver(String value) {
        this.organisationWhichDeliver = value;
    }

    /**
     * Obtient la valeur de la propri�t� validityDateOfIdPaper.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getValidityDateOfIdPaper() {
        return validityDateOfIdPaper;
    }

    /**
     * D�finit la valeur de la propri�t� validityDateOfIdPaper.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setValidityDateOfIdPaper(XMLGregorianCalendar value) {
        this.validityDateOfIdPaper = value;
    }

}
