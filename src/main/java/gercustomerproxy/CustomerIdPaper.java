
package gercustomerproxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java pour customerIdPaper complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="customerIdPaper">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="type" type="{http://soprabanking.com/amplitude}idPaperType" minOccurs="0"/>
 *         &lt;element name="idPaperNumber" type="{http://soprabanking.com/amplitude}charMax20" minOccurs="0"/>
 *         &lt;element name="idPaperDeliveryDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="idPaperDeliveryPlace" type="{http://soprabanking.com/amplitude}charMax30" minOccurs="0"/>
 *         &lt;element name="organisationWhichDeliver" type="{http://soprabanking.com/amplitude}charMax30" minOccurs="0"/>
 *         &lt;element name="idPaperValidityDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="nationalIdentifier" type="{http://soprabanking.com/amplitude}charMax20" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customerIdPaper", propOrder = {
    "type",
    "idPaperNumber",
    "idPaperDeliveryDate",
    "idPaperDeliveryPlace",
    "organisationWhichDeliver",
    "idPaperValidityDate",
    "nationalIdentifier"
})
public class CustomerIdPaper {

    protected IdPaperType type;
    protected String idPaperNumber;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar idPaperDeliveryDate;
    protected String idPaperDeliveryPlace;
    protected String organisationWhichDeliver;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar idPaperValidityDate;
    protected String nationalIdentifier;

    /**
     * Obtient la valeur de la propri�t� type.
     * 
     * @return
     *     possible object is
     *     {@link IdPaperType }
     *     
     */
    public IdPaperType getType() {
        return type;
    }

    /**
     * D�finit la valeur de la propri�t� type.
     * 
     * @param value
     *     allowed object is
     *     {@link IdPaperType }
     *     
     */
    public void setType(IdPaperType value) {
        this.type = value;
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
     * Obtient la valeur de la propri�t� idPaperDeliveryDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getIdPaperDeliveryDate() {
        return idPaperDeliveryDate;
    }

    /**
     * D�finit la valeur de la propri�t� idPaperDeliveryDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setIdPaperDeliveryDate(XMLGregorianCalendar value) {
        this.idPaperDeliveryDate = value;
    }

    /**
     * Obtient la valeur de la propri�t� idPaperDeliveryPlace.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdPaperDeliveryPlace() {
        return idPaperDeliveryPlace;
    }

    /**
     * D�finit la valeur de la propri�t� idPaperDeliveryPlace.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdPaperDeliveryPlace(String value) {
        this.idPaperDeliveryPlace = value;
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
     * Obtient la valeur de la propri�t� idPaperValidityDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getIdPaperValidityDate() {
        return idPaperValidityDate;
    }

    /**
     * D�finit la valeur de la propri�t� idPaperValidityDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setIdPaperValidityDate(XMLGregorianCalendar value) {
        this.idPaperValidityDate = value;
    }

    /**
     * Obtient la valeur de la propri�t� nationalIdentifier.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNationalIdentifier() {
        return nationalIdentifier;
    }

    /**
     * D�finit la valeur de la propri�t� nationalIdentifier.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNationalIdentifier(String value) {
        this.nationalIdentifier = value;
    }

}
