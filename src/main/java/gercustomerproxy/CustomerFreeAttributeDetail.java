
package gercustomerproxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour customerFreeAttributeDetail complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="customerFreeAttributeDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="customerFreeAttributeIdentifier" type="{http://soprabanking.com/amplitude}customerFreeAttributeDetailIdentifier" minOccurs="0"/>
 *         &lt;element name="additionalDataValue" type="{http://soprabanking.com/amplitude}additionalDataValue" minOccurs="0"/>
 *         &lt;element name="typeOfLinkedAttribute" type="{http://soprabanking.com/amplitude}typeOfAttribute" minOccurs="0"/>
 *         &lt;element name="freeText" type="{http://soprabanking.com/amplitude}charMax255" minOccurs="0"/>
 *         &lt;element name="customerFreeAttributeInfo" type="{http://soprabanking.com/amplitude}customerFreeAttributeInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customerFreeAttributeDetail", propOrder = {
    "customerFreeAttributeIdentifier",
    "additionalDataValue",
    "typeOfLinkedAttribute",
    "freeText",
    "customerFreeAttributeInfo"
})
public class CustomerFreeAttributeDetail {

    protected CustomerFreeAttributeDetailIdentifier customerFreeAttributeIdentifier;
    protected AdditionalDataValue additionalDataValue;
    @XmlSchemaType(name = "string")
    protected TypeOfAttribute typeOfLinkedAttribute;
    protected String freeText;
    protected CustomerFreeAttributeInfo customerFreeAttributeInfo;

    /**
     * Obtient la valeur de la propriété customerFreeAttributeIdentifier.
     * 
     * @return
     *     possible object is
     *     {@link CustomerFreeAttributeDetailIdentifier }
     *     
     */
    public CustomerFreeAttributeDetailIdentifier getCustomerFreeAttributeIdentifier() {
        return customerFreeAttributeIdentifier;
    }

    /**
     * Définit la valeur de la propriété customerFreeAttributeIdentifier.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerFreeAttributeDetailIdentifier }
     *     
     */
    public void setCustomerFreeAttributeIdentifier(CustomerFreeAttributeDetailIdentifier value) {
        this.customerFreeAttributeIdentifier = value;
    }

    /**
     * Obtient la valeur de la propriété additionalDataValue.
     * 
     * @return
     *     possible object is
     *     {@link AdditionalDataValue }
     *     
     */
    public AdditionalDataValue getAdditionalDataValue() {
        return additionalDataValue;
    }

    /**
     * Définit la valeur de la propriété additionalDataValue.
     * 
     * @param value
     *     allowed object is
     *     {@link AdditionalDataValue }
     *     
     */
    public void setAdditionalDataValue(AdditionalDataValue value) {
        this.additionalDataValue = value;
    }

    /**
     * Obtient la valeur de la propriété typeOfLinkedAttribute.
     * 
     * @return
     *     possible object is
     *     {@link TypeOfAttribute }
     *     
     */
    public TypeOfAttribute getTypeOfLinkedAttribute() {
        return typeOfLinkedAttribute;
    }

    /**
     * Définit la valeur de la propriété typeOfLinkedAttribute.
     * 
     * @param value
     *     allowed object is
     *     {@link TypeOfAttribute }
     *     
     */
    public void setTypeOfLinkedAttribute(TypeOfAttribute value) {
        this.typeOfLinkedAttribute = value;
    }

    /**
     * Obtient la valeur de la propriété freeText.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFreeText() {
        return freeText;
    }

    /**
     * Définit la valeur de la propriété freeText.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFreeText(String value) {
        this.freeText = value;
    }

    /**
     * Obtient la valeur de la propriété customerFreeAttributeInfo.
     * 
     * @return
     *     possible object is
     *     {@link CustomerFreeAttributeInfo }
     *     
     */
    public CustomerFreeAttributeInfo getCustomerFreeAttributeInfo() {
        return customerFreeAttributeInfo;
    }

    /**
     * Définit la valeur de la propriété customerFreeAttributeInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerFreeAttributeInfo }
     *     
     */
    public void setCustomerFreeAttributeInfo(CustomerFreeAttributeInfo value) {
        this.customerFreeAttributeInfo = value;
    }

}
