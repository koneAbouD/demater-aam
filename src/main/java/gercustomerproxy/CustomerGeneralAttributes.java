
package gercustomerproxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour customerGeneralAttributes complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="customerGeneralAttributes">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="branchCode" type="{http://soprabanking.com/amplitude}branch" minOccurs="0"/>
 *         &lt;element name="customerOfficer" type="{http://soprabanking.com/amplitude}customerOfficer" minOccurs="0"/>
 *         &lt;element name="qualityCode" type="{http://soprabanking.com/amplitude}customerQuality" minOccurs="0"/>
 *         &lt;element name="taxableCustomer" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="internalCategoryCode" type="{http://soprabanking.com/amplitude}internalCategory" minOccurs="0"/>
 *         &lt;element name="segment" type="{http://soprabanking.com/amplitude}segment" minOccurs="0"/>
 *         &lt;element name="statisticNumber" type="{http://soprabanking.com/amplitude}charMax20" minOccurs="0"/>
 *         &lt;element name="sponsorCustomerCode" type="{http://soprabanking.com/amplitude}charMax15" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customerGeneralAttributes", propOrder = {
    "branchCode",
    "customerOfficer",
    "qualityCode",
    "taxableCustomer",
    "internalCategoryCode",
    "segment",
    "statisticNumber",
    "sponsorCustomerCode"
})
public class CustomerGeneralAttributes {

    protected Branch branchCode;
    protected CustomerOfficer customerOfficer;
    protected CustomerQuality qualityCode;
    protected Boolean taxableCustomer;
    protected InternalCategory internalCategoryCode;
    protected Segment segment;
    protected String statisticNumber;
    protected String sponsorCustomerCode;

    /**
     * Obtient la valeur de la propriété branchCode.
     * 
     * @return
     *     possible object is
     *     {@link Branch }
     *     
     */
    public Branch getBranchCode() {
        return branchCode;
    }

    /**
     * Définit la valeur de la propriété branchCode.
     * 
     * @param value
     *     allowed object is
     *     {@link Branch }
     *     
     */
    public void setBranchCode(Branch value) {
        this.branchCode = value;
    }

    /**
     * Obtient la valeur de la propriété customerOfficer.
     * 
     * @return
     *     possible object is
     *     {@link CustomerOfficer }
     *     
     */
    public CustomerOfficer getCustomerOfficer() {
        return customerOfficer;
    }

    /**
     * Définit la valeur de la propriété customerOfficer.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerOfficer }
     *     
     */
    public void setCustomerOfficer(CustomerOfficer value) {
        this.customerOfficer = value;
    }

    /**
     * Obtient la valeur de la propriété qualityCode.
     * 
     * @return
     *     possible object is
     *     {@link CustomerQuality }
     *     
     */
    public CustomerQuality getQualityCode() {
        return qualityCode;
    }

    /**
     * Définit la valeur de la propriété qualityCode.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerQuality }
     *     
     */
    public void setQualityCode(CustomerQuality value) {
        this.qualityCode = value;
    }

    /**
     * Obtient la valeur de la propriété taxableCustomer.
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
     * Définit la valeur de la propriété taxableCustomer.
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
     * Obtient la valeur de la propriété internalCategoryCode.
     * 
     * @return
     *     possible object is
     *     {@link InternalCategory }
     *     
     */
    public InternalCategory getInternalCategoryCode() {
        return internalCategoryCode;
    }

    /**
     * Définit la valeur de la propriété internalCategoryCode.
     * 
     * @param value
     *     allowed object is
     *     {@link InternalCategory }
     *     
     */
    public void setInternalCategoryCode(InternalCategory value) {
        this.internalCategoryCode = value;
    }

    /**
     * Obtient la valeur de la propriété segment.
     * 
     * @return
     *     possible object is
     *     {@link Segment }
     *     
     */
    public Segment getSegment() {
        return segment;
    }

    /**
     * Définit la valeur de la propriété segment.
     * 
     * @param value
     *     allowed object is
     *     {@link Segment }
     *     
     */
    public void setSegment(Segment value) {
        this.segment = value;
    }

    /**
     * Obtient la valeur de la propriété statisticNumber.
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
     * Définit la valeur de la propriété statisticNumber.
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
     * Obtient la valeur de la propriété sponsorCustomerCode.
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
     * Définit la valeur de la propriété sponsorCustomerCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSponsorCustomerCode(String value) {
        this.sponsorCustomerCode = value;
    }

}
