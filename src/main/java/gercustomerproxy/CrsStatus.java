
package gercustomerproxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour crsStatus complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="crsStatus">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="crsStatusCode" type="{http://soprabanking.com/amplitude}crsStatusCode" minOccurs="0"/>
 *         &lt;element name="designation" type="{http://soprabanking.com/amplitude}charMax30" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "crsStatus", propOrder = {
    "crsStatusCode",
    "designation"
})
public class CrsStatus {

    protected String crsStatusCode;
    protected String designation;

    /**
     * Obtient la valeur de la propriété crsStatusCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCrsStatusCode() {
        return crsStatusCode;
    }

    /**
     * Définit la valeur de la propriété crsStatusCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCrsStatusCode(String value) {
        this.crsStatusCode = value;
    }

    /**
     * Obtient la valeur de la propriété designation.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDesignation() {
        return designation;
    }

    /**
     * Définit la valeur de la propriété designation.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDesignation(String value) {
        this.designation = value;
    }

}
