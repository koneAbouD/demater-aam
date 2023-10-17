
package createcustomerproxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java pour customerFatcaAttributesCreate complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="customerFatcaAttributesCreate">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fatcaStatus" type="{http://soprabanking.com/amplitude}fatcaStatusCode" minOccurs="0"/>
 *         &lt;element name="fatcaStatusDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="crsStatus" type="{http://soprabanking.com/amplitude}crsStatusCode" minOccurs="0"/>
 *         &lt;element name="crsStatusDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="freeAttributes" type="{http://soprabanking.com/amplitude}customerFreeAttributesCreate" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customerFatcaAttributesCreate", propOrder = {
    "fatcaStatus",
    "fatcaStatusDate",
    "crsStatus",
    "crsStatusDate",
    "freeAttributes"
})
public class CustomerFatcaAttributesCreate {

    protected String fatcaStatus;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar fatcaStatusDate;
    protected String crsStatus;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar crsStatusDate;
    protected CustomerFreeAttributesCreate freeAttributes;

    /**
     * Obtient la valeur de la propri�t� fatcaStatus.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFatcaStatus() {
        return fatcaStatus;
    }

    /**
     * D�finit la valeur de la propri�t� fatcaStatus.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFatcaStatus(String value) {
        this.fatcaStatus = value;
    }

    /**
     * Obtient la valeur de la propri�t� fatcaStatusDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFatcaStatusDate() {
        return fatcaStatusDate;
    }

    /**
     * D�finit la valeur de la propri�t� fatcaStatusDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFatcaStatusDate(XMLGregorianCalendar value) {
        this.fatcaStatusDate = value;
    }

    /**
     * Obtient la valeur de la propri�t� crsStatus.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCrsStatus() {
        return crsStatus;
    }

    /**
     * D�finit la valeur de la propri�t� crsStatus.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCrsStatus(String value) {
        this.crsStatus = value;
    }

    /**
     * Obtient la valeur de la propri�t� crsStatusDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCrsStatusDate() {
        return crsStatusDate;
    }

    /**
     * D�finit la valeur de la propri�t� crsStatusDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCrsStatusDate(XMLGregorianCalendar value) {
        this.crsStatusDate = value;
    }

    /**
     * Obtient la valeur de la propri�t� freeAttributes.
     * 
     * @return
     *     possible object is
     *     {@link CustomerFreeAttributesCreate }
     *     
     */
    public CustomerFreeAttributesCreate getFreeAttributes() {
        return freeAttributes;
    }

    /**
     * D�finit la valeur de la propri�t� freeAttributes.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerFreeAttributesCreate }
     *     
     */
    public void setFreeAttributes(CustomerFreeAttributesCreate value) {
        this.freeAttributes = value;
    }

}
