
package createcustomerproxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour customerTerritorialityCreate complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="customerTerritorialityCreate">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="territorialityCode" type="{http://soprabanking.com/amplitude}char1" minOccurs="0"/>
 *         &lt;element name="spouseTerritorialityCode" type="{http://soprabanking.com/amplitude}char1" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customerTerritorialityCreate", propOrder = {
    "territorialityCode",
    "spouseTerritorialityCode"
})
public class CustomerTerritorialityCreate {

    protected String territorialityCode;
    protected String spouseTerritorialityCode;

    /**
     * Obtient la valeur de la propri�t� territorialityCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTerritorialityCode() {
        return territorialityCode;
    }

    /**
     * D�finit la valeur de la propri�t� territorialityCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTerritorialityCode(String value) {
        this.territorialityCode = value;
    }

    /**
     * Obtient la valeur de la propri�t� spouseTerritorialityCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpouseTerritorialityCode() {
        return spouseTerritorialityCode;
    }

    /**
     * D�finit la valeur de la propri�t� spouseTerritorialityCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpouseTerritorialityCode(String value) {
        this.spouseTerritorialityCode = value;
    }

}
