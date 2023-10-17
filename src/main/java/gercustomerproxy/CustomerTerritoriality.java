
package gercustomerproxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour customerTerritoriality complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="customerTerritoriality">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="territorialityCode" type="{http://soprabanking.com/amplitude}territorialityCode" minOccurs="0"/>
 *         &lt;element name="spouseTerritorialityCode" type="{http://soprabanking.com/amplitude}territorialityCode" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customerTerritoriality", propOrder = {
    "territorialityCode",
    "spouseTerritorialityCode"
})
public class CustomerTerritoriality {

    protected TerritorialityCode territorialityCode;
    protected TerritorialityCode spouseTerritorialityCode;

    /**
     * Obtient la valeur de la propriété territorialityCode.
     * 
     * @return
     *     possible object is
     *     {@link TerritorialityCode }
     *     
     */
    public TerritorialityCode getTerritorialityCode() {
        return territorialityCode;
    }

    /**
     * Définit la valeur de la propriété territorialityCode.
     * 
     * @param value
     *     allowed object is
     *     {@link TerritorialityCode }
     *     
     */
    public void setTerritorialityCode(TerritorialityCode value) {
        this.territorialityCode = value;
    }

    /**
     * Obtient la valeur de la propriété spouseTerritorialityCode.
     * 
     * @return
     *     possible object is
     *     {@link TerritorialityCode }
     *     
     */
    public TerritorialityCode getSpouseTerritorialityCode() {
        return spouseTerritorialityCode;
    }

    /**
     * Définit la valeur de la propriété spouseTerritorialityCode.
     * 
     * @param value
     *     allowed object is
     *     {@link TerritorialityCode }
     *     
     */
    public void setSpouseTerritorialityCode(TerritorialityCode value) {
        this.spouseTerritorialityCode = value;
    }

}
