
package createcustomerproxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java pour customerNonRetail complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="customerNonRetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="default" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="defaultEntry" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customerNonRetail", propOrder = {
    "_default",
    "defaultEntry"
})
public class CustomerNonRetail {

    @XmlElement(name = "default")
    protected boolean _default;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar defaultEntry;

    /**
     * Obtient la valeur de la propriété default.
     * 
     */
    public boolean isDefault() {
        return _default;
    }

    /**
     * Définit la valeur de la propriété default.
     * 
     */
    public void setDefault(boolean value) {
        this._default = value;
    }

    /**
     * Obtient la valeur de la propriété defaultEntry.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDefaultEntry() {
        return defaultEntry;
    }

    /**
     * Définit la valeur de la propriété defaultEntry.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDefaultEntry(XMLGregorianCalendar value) {
        this.defaultEntry = value;
    }

}
