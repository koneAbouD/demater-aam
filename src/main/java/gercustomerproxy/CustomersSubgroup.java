
package gercustomerproxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour customersSubgroup complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="customersSubgroup">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="customersGroupCode" type="{http://soprabanking.com/amplitude}charMax6" minOccurs="0"/>
 *         &lt;element name="customersSubgroupCode" type="{http://soprabanking.com/amplitude}charMax6" minOccurs="0"/>
 *         &lt;element name="customersSubgroupName" type="{http://soprabanking.com/amplitude}charMax36" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customersSubgroup", propOrder = {
    "customersGroupCode",
    "customersSubgroupCode",
    "customersSubgroupName"
})
public class CustomersSubgroup {

    protected String customersGroupCode;
    protected String customersSubgroupCode;
    protected String customersSubgroupName;

    /**
     * Obtient la valeur de la propriété customersGroupCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomersGroupCode() {
        return customersGroupCode;
    }

    /**
     * Définit la valeur de la propriété customersGroupCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomersGroupCode(String value) {
        this.customersGroupCode = value;
    }

    /**
     * Obtient la valeur de la propriété customersSubgroupCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomersSubgroupCode() {
        return customersSubgroupCode;
    }

    /**
     * Définit la valeur de la propriété customersSubgroupCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomersSubgroupCode(String value) {
        this.customersSubgroupCode = value;
    }

    /**
     * Obtient la valeur de la propriété customersSubgroupName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomersSubgroupName() {
        return customersSubgroupName;
    }

    /**
     * Définit la valeur de la propriété customersSubgroupName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomersSubgroupName(String value) {
        this.customersSubgroupName = value;
    }

}
