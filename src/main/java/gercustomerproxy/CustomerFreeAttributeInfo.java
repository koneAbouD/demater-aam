
package gercustomerproxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour customerFreeAttributeInfo complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="customerFreeAttributeInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="code" type="{http://soprabanking.com/amplitude}charMax10" minOccurs="0"/>
 *         &lt;element name="designation" type="{http://soprabanking.com/amplitude}charMax30" minOccurs="0"/>
 *         &lt;element name="dataFormat" type="{http://soprabanking.com/amplitude}freeAttributeFormat" minOccurs="0"/>
 *         &lt;element name="totalLengthIfAlpha" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="numberOfDecimalsIfAmountOrRate" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="managementMethod" type="{http://soprabanking.com/amplitude}additionalDataManagementMethod" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customerFreeAttributeInfo", propOrder = {
    "code",
    "designation",
    "dataFormat",
    "totalLengthIfAlpha",
    "numberOfDecimalsIfAmountOrRate",
    "managementMethod"
})
public class CustomerFreeAttributeInfo {

    protected String code;
    protected String designation;
    @XmlSchemaType(name = "string")
    protected FreeAttributeFormat dataFormat;
    protected Integer totalLengthIfAlpha;
    protected Integer numberOfDecimalsIfAmountOrRate;
    protected String managementMethod;

    /**
     * Obtient la valeur de la propri�t� code.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode() {
        return code;
    }

    /**
     * D�finit la valeur de la propri�t� code.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * Obtient la valeur de la propri�t� designation.
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
     * D�finit la valeur de la propri�t� designation.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDesignation(String value) {
        this.designation = value;
    }

    /**
     * Obtient la valeur de la propri�t� dataFormat.
     * 
     * @return
     *     possible object is
     *     {@link FreeAttributeFormat }
     *     
     */
    public FreeAttributeFormat getDataFormat() {
        return dataFormat;
    }

    /**
     * D�finit la valeur de la propri�t� dataFormat.
     * 
     * @param value
     *     allowed object is
     *     {@link FreeAttributeFormat }
     *     
     */
    public void setDataFormat(FreeAttributeFormat value) {
        this.dataFormat = value;
    }

    /**
     * Obtient la valeur de la propri�t� totalLengthIfAlpha.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTotalLengthIfAlpha() {
        return totalLengthIfAlpha;
    }

    /**
     * D�finit la valeur de la propri�t� totalLengthIfAlpha.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTotalLengthIfAlpha(Integer value) {
        this.totalLengthIfAlpha = value;
    }

    /**
     * Obtient la valeur de la propri�t� numberOfDecimalsIfAmountOrRate.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumberOfDecimalsIfAmountOrRate() {
        return numberOfDecimalsIfAmountOrRate;
    }

    /**
     * D�finit la valeur de la propri�t� numberOfDecimalsIfAmountOrRate.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumberOfDecimalsIfAmountOrRate(Integer value) {
        this.numberOfDecimalsIfAmountOrRate = value;
    }

    /**
     * Obtient la valeur de la propri�t� managementMethod.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getManagementMethod() {
        return managementMethod;
    }

    /**
     * D�finit la valeur de la propri�t� managementMethod.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setManagementMethod(String value) {
        this.managementMethod = value;
    }

}
