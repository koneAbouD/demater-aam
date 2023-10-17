
package createcustomerproxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java pour customerRetail complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="customerRetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="pmlDefault" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="pmlDefaultEntry" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="nonPmlDefault" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="nonPmlDefaultEntry" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customerRetail", propOrder = {
    "pmlDefault",
    "pmlDefaultEntry",
    "nonPmlDefault",
    "nonPmlDefaultEntry"
})
public class CustomerRetail {

    protected Boolean pmlDefault;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar pmlDefaultEntry;
    protected Boolean nonPmlDefault;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar nonPmlDefaultEntry;

    /**
     * Obtient la valeur de la propriété pmlDefault.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPmlDefault() {
        return pmlDefault;
    }

    /**
     * Définit la valeur de la propriété pmlDefault.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPmlDefault(Boolean value) {
        this.pmlDefault = value;
    }

    /**
     * Obtient la valeur de la propriété pmlDefaultEntry.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPmlDefaultEntry() {
        return pmlDefaultEntry;
    }

    /**
     * Définit la valeur de la propriété pmlDefaultEntry.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPmlDefaultEntry(XMLGregorianCalendar value) {
        this.pmlDefaultEntry = value;
    }

    /**
     * Obtient la valeur de la propriété nonPmlDefault.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isNonPmlDefault() {
        return nonPmlDefault;
    }

    /**
     * Définit la valeur de la propriété nonPmlDefault.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setNonPmlDefault(Boolean value) {
        this.nonPmlDefault = value;
    }

    /**
     * Obtient la valeur de la propriété nonPmlDefaultEntry.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getNonPmlDefaultEntry() {
        return nonPmlDefaultEntry;
    }

    /**
     * Définit la valeur de la propriété nonPmlDefaultEntry.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setNonPmlDefaultEntry(XMLGregorianCalendar value) {
        this.nonPmlDefaultEntry = value;
    }

}
