
package createcustomerproxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java pour customerGeneralAttributesCreate complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="customerGeneralAttributesCreate">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="branchCode" type="{http://soprabanking.com/amplitude}branchCode" minOccurs="0"/>
 *         &lt;element name="customerOfficer" type="{http://soprabanking.com/amplitude}customerOfficerCode" minOccurs="0"/>
 *         &lt;element name="qualityCode" type="{http://soprabanking.com/amplitude}customerQualityCode" minOccurs="0"/>
 *         &lt;element name="taxableCustomer" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="internalCategoryCode" type="{http://soprabanking.com/amplitude}internalCategoryCode" minOccurs="0"/>
 *         &lt;element name="segment" type="{http://soprabanking.com/amplitude}segmentCode" minOccurs="0"/>
 *         &lt;element name="statisticNumber" type="{http://soprabanking.com/amplitude}charMax20" minOccurs="0"/>
 *         &lt;element name="sponsorCustomerCode" type="{http://soprabanking.com/amplitude}charMax15" minOccurs="0"/>
 *         &lt;element name="freeAttributes" type="{http://soprabanking.com/amplitude}customerFreeAttributesCreate" minOccurs="0"/>
 *         &lt;element name="specificFreeAttributes" type="{http://soprabanking.com/amplitude}customerFreeAttributesCreate" minOccurs="0"/>
 *         &lt;element name="centralBankRiskEffectiveDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customerGeneralAttributesCreate", propOrder = {
    "branchCode",
    "customerOfficer",
    "qualityCode",
    "taxableCustomer",
    "internalCategoryCode",
    "segment",
    "statisticNumber",
    "sponsorCustomerCode",
    "freeAttributes",
    "specificFreeAttributes",
    "centralBankRiskEffectiveDate"
})
public class CustomerGeneralAttributesCreate {

    protected String branchCode;
    protected String customerOfficer;
    protected String qualityCode;
    protected Boolean taxableCustomer;
    protected String internalCategoryCode;
    protected String segment;
    protected String statisticNumber;
    protected String sponsorCustomerCode;
    protected CustomerFreeAttributesCreate freeAttributes;
    protected CustomerFreeAttributesCreate specificFreeAttributes;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar centralBankRiskEffectiveDate;

    /**
     * Obtient la valeur de la propri�t� branchCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBranchCode() {
        return branchCode;
    }

    /**
     * D�finit la valeur de la propri�t� branchCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBranchCode(String value) {
        this.branchCode = value;
    }

    /**
     * Obtient la valeur de la propri�t� customerOfficer.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerOfficer() {
        return customerOfficer;
    }

    /**
     * D�finit la valeur de la propri�t� customerOfficer.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerOfficer(String value) {
        this.customerOfficer = value;
    }

    /**
     * Obtient la valeur de la propri�t� qualityCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQualityCode() {
        return qualityCode;
    }

    /**
     * D�finit la valeur de la propri�t� qualityCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQualityCode(String value) {
        this.qualityCode = value;
    }

    /**
     * Obtient la valeur de la propri�t� taxableCustomer.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isTaxableCustomer() {
        return taxableCustomer;
    }

    /**
     * D�finit la valeur de la propri�t� taxableCustomer.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setTaxableCustomer(Boolean value) {
        this.taxableCustomer = value;
    }

    /**
     * Obtient la valeur de la propri�t� internalCategoryCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInternalCategoryCode() {
        return internalCategoryCode;
    }

    /**
     * D�finit la valeur de la propri�t� internalCategoryCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInternalCategoryCode(String value) {
        this.internalCategoryCode = value;
    }

    /**
     * Obtient la valeur de la propri�t� segment.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSegment() {
        return segment;
    }

    /**
     * D�finit la valeur de la propri�t� segment.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSegment(String value) {
        this.segment = value;
    }

    /**
     * Obtient la valeur de la propri�t� statisticNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatisticNumber() {
        return statisticNumber;
    }

    /**
     * D�finit la valeur de la propri�t� statisticNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatisticNumber(String value) {
        this.statisticNumber = value;
    }

    /**
     * Obtient la valeur de la propri�t� sponsorCustomerCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSponsorCustomerCode() {
        return sponsorCustomerCode;
    }

    /**
     * D�finit la valeur de la propri�t� sponsorCustomerCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSponsorCustomerCode(String value) {
        this.sponsorCustomerCode = value;
    }

    /**
     * Obtient la valeur de la propri�t� freeAttributes.
     * 
     * @return
     *     possible object is
     *     {@link CustomerFreeAttributesCreate }
     *     
     */
    public CustomerFreeAttributesCreate getFreeAttributes() {
        return freeAttributes;
    }

    /**
     * D�finit la valeur de la propri�t� freeAttributes.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerFreeAttributesCreate }
     *     
     */
    public void setFreeAttributes(CustomerFreeAttributesCreate value) {
        this.freeAttributes = value;
    }

    /**
     * Obtient la valeur de la propri�t� specificFreeAttributes.
     * 
     * @return
     *     possible object is
     *     {@link CustomerFreeAttributesCreate }
     *     
     */
    public CustomerFreeAttributesCreate getSpecificFreeAttributes() {
        return specificFreeAttributes;
    }

    /**
     * D�finit la valeur de la propri�t� specificFreeAttributes.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerFreeAttributesCreate }
     *     
     */
    public void setSpecificFreeAttributes(CustomerFreeAttributesCreate value) {
        this.specificFreeAttributes = value;
    }

    /**
     * Obtient la valeur de la propri�t� centralBankRiskEffectiveDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCentralBankRiskEffectiveDate() {
        return centralBankRiskEffectiveDate;
    }

    /**
     * D�finit la valeur de la propri�t� centralBankRiskEffectiveDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCentralBankRiskEffectiveDate(XMLGregorianCalendar value) {
        this.centralBankRiskEffectiveDate = value;
    }

}
