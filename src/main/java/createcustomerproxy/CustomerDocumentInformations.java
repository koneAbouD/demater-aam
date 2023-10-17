
package createcustomerproxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java pour customerDocumentInformations complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="customerDocumentInformations">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="documentType" type="{http://soprabanking.com/amplitude}char3"/>
 *         &lt;element name="supportingDocumentCode" type="{http://soprabanking.com/amplitude}customerDocumentCode"/>
 *         &lt;element name="documentReference" type="{http://soprabanking.com/amplitude}charMax25" minOccurs="0"/>
 *         &lt;element name="deliveryDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="validityDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="deliveryPlace" type="{http://soprabanking.com/amplitude}charMax30" minOccurs="0"/>
 *         &lt;element name="organisationWhichDeliver" type="{http://soprabanking.com/amplitude}charMax30" minOccurs="0"/>
 *         &lt;element name="dateOnWhichSupportingDocumentWasProvided" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customerDocumentInformations", propOrder = {
    "documentType",
    "supportingDocumentCode",
    "documentReference",
    "deliveryDate",
    "validityDate",
    "deliveryPlace",
    "organisationWhichDeliver",
    "dateOnWhichSupportingDocumentWasProvided"
})
public class CustomerDocumentInformations {

    @XmlElement(required = true)
    protected String documentType;
    @XmlElement(required = true)
    protected String supportingDocumentCode;
    protected String documentReference;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar deliveryDate;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar validityDate;
    protected String deliveryPlace;
    protected String organisationWhichDeliver;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dateOnWhichSupportingDocumentWasProvided;

    /**
     * Obtient la valeur de la propriété documentType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentType() {
        return documentType;
    }

    /**
     * Définit la valeur de la propriété documentType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentType(String value) {
        this.documentType = value;
    }

    /**
     * Obtient la valeur de la propriété supportingDocumentCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSupportingDocumentCode() {
        return supportingDocumentCode;
    }

    /**
     * Définit la valeur de la propriété supportingDocumentCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSupportingDocumentCode(String value) {
        this.supportingDocumentCode = value;
    }

    /**
     * Obtient la valeur de la propriété documentReference.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentReference() {
        return documentReference;
    }

    /**
     * Définit la valeur de la propriété documentReference.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentReference(String value) {
        this.documentReference = value;
    }

    /**
     * Obtient la valeur de la propriété deliveryDate.
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
     * Définit la valeur de la propriété deliveryDate.
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
     * Obtient la valeur de la propriété validityDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getValidityDate() {
        return validityDate;
    }

    /**
     * Définit la valeur de la propriété validityDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setValidityDate(XMLGregorianCalendar value) {
        this.validityDate = value;
    }

    /**
     * Obtient la valeur de la propriété deliveryPlace.
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
     * Définit la valeur de la propriété deliveryPlace.
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
     * Obtient la valeur de la propriété organisationWhichDeliver.
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
     * Définit la valeur de la propriété organisationWhichDeliver.
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
     * Obtient la valeur de la propriété dateOnWhichSupportingDocumentWasProvided.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateOnWhichSupportingDocumentWasProvided() {
        return dateOnWhichSupportingDocumentWasProvided;
    }

    /**
     * Définit la valeur de la propriété dateOnWhichSupportingDocumentWasProvided.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateOnWhichSupportingDocumentWasProvided(XMLGregorianCalendar value) {
        this.dateOnWhichSupportingDocumentWasProvided = value;
    }

}
