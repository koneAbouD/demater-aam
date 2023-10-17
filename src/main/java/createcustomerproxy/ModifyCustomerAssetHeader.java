
package createcustomerproxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour modifyCustomerAssetHeader complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="modifyCustomerAssetHeader">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="customerCode" type="{http://soprabanking.com/amplitude}customerCode" minOccurs="0"/>
 *         &lt;element name="referenceYear" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="reliabilityLevel" type="{http://soprabanking.com/amplitude}reliabilityLevel" minOccurs="0"/>
 *         &lt;element name="exhaustiveInformation" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "modifyCustomerAssetHeader", propOrder = {
    "customerCode",
    "referenceYear",
    "reliabilityLevel",
    "exhaustiveInformation"
})
public class ModifyCustomerAssetHeader {

    protected String customerCode;
    protected Integer referenceYear;
    @XmlSchemaType(name = "string")
    protected ReliabilityLevel reliabilityLevel;
    protected Boolean exhaustiveInformation;

    /**
     * Obtient la valeur de la propriété customerCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerCode() {
        return customerCode;
    }

    /**
     * Définit la valeur de la propriété customerCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerCode(String value) {
        this.customerCode = value;
    }

    /**
     * Obtient la valeur de la propriété referenceYear.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getReferenceYear() {
        return referenceYear;
    }

    /**
     * Définit la valeur de la propriété referenceYear.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setReferenceYear(Integer value) {
        this.referenceYear = value;
    }

    /**
     * Obtient la valeur de la propriété reliabilityLevel.
     * 
     * @return
     *     possible object is
     *     {@link ReliabilityLevel }
     *     
     */
    public ReliabilityLevel getReliabilityLevel() {
        return reliabilityLevel;
    }

    /**
     * Définit la valeur de la propriété reliabilityLevel.
     * 
     * @param value
     *     allowed object is
     *     {@link ReliabilityLevel }
     *     
     */
    public void setReliabilityLevel(ReliabilityLevel value) {
        this.reliabilityLevel = value;
    }

    /**
     * Obtient la valeur de la propriété exhaustiveInformation.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isExhaustiveInformation() {
        return exhaustiveInformation;
    }

    /**
     * Définit la valeur de la propriété exhaustiveInformation.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setExhaustiveInformation(Boolean value) {
        this.exhaustiveInformation = value;
    }

}
