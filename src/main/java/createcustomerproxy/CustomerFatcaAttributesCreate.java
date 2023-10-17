
package createcustomerproxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java pour customerFatcaAttributesCreate complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
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
     * Obtient la valeur de la propriété fatcaStatus.
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
     * Définit la valeur de la propriété fatcaStatus.
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
     * Obtient la valeur de la propriété fatcaStatusDate.
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
     * Définit la valeur de la propriété fatcaStatusDate.
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
     * Obtient la valeur de la propriété crsStatus.
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
     * Définit la valeur de la propriété crsStatus.
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
     * Obtient la valeur de la propriété crsStatusDate.
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
     * Définit la valeur de la propriété crsStatusDate.
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
     * Obtient la valeur de la propriété freeAttributes.
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
     * Définit la valeur de la propriété freeAttributes.
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
