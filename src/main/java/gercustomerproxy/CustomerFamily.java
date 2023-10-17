
package gercustomerproxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour customerFamily complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="customerFamily">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="spouseType" type="{http://soprabanking.com/amplitude}customerThirdPartyType" minOccurs="0"/>
 *         &lt;element name="spouseCode" type="{http://soprabanking.com/amplitude}charMax15" minOccurs="0"/>
 *         &lt;element name="numberOfChildren" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="customerFamilyRelationshipCode" type="{http://soprabanking.com/amplitude}charMax15" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customerFamily", propOrder = {
    "spouseType",
    "spouseCode",
    "numberOfChildren",
    "customerFamilyRelationshipCode"
})
public class CustomerFamily {

    protected String spouseType;
    protected String spouseCode;
    protected Integer numberOfChildren;
    protected String customerFamilyRelationshipCode;

    /**
     * Obtient la valeur de la propriété spouseType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpouseType() {
        return spouseType;
    }

    /**
     * Définit la valeur de la propriété spouseType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpouseType(String value) {
        this.spouseType = value;
    }

    /**
     * Obtient la valeur de la propriété spouseCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpouseCode() {
        return spouseCode;
    }

    /**
     * Définit la valeur de la propriété spouseCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpouseCode(String value) {
        this.spouseCode = value;
    }

    /**
     * Obtient la valeur de la propriété numberOfChildren.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumberOfChildren() {
        return numberOfChildren;
    }

    /**
     * Définit la valeur de la propriété numberOfChildren.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumberOfChildren(Integer value) {
        this.numberOfChildren = value;
    }

    /**
     * Obtient la valeur de la propriété customerFamilyRelationshipCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerFamilyRelationshipCode() {
        return customerFamilyRelationshipCode;
    }

    /**
     * Définit la valeur de la propriété customerFamilyRelationshipCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerFamilyRelationshipCode(String value) {
        this.customerFamilyRelationshipCode = value;
    }

}
