
package createcustomerproxy;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour customerReportingAttributesCreate complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="customerReportingAttributesCreate">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="declaredHome" type="{http://soprabanking.com/amplitude}declaredHomeCode" minOccurs="0"/>
 *         &lt;element name="economicAgentCode" type="{http://soprabanking.com/amplitude}centralBankCategoryCode" minOccurs="0"/>
 *         &lt;element name="activityFieldCode" type="{http://soprabanking.com/amplitude}customerActivityFieldCode" minOccurs="0"/>
 *         &lt;element name="relationshipWithTheBank" type="{http://soprabanking.com/amplitude}relationshipWithTheBankCode" minOccurs="0"/>
 *         &lt;element name="gradingAgreement" type="{http://soprabanking.com/amplitude}char1" minOccurs="0"/>
 *         &lt;element name="gradingAgreementAmount" type="{http://soprabanking.com/amplitude}decimal19_4" minOccurs="0"/>
 *         &lt;element name="securityIssuer" type="{http://soprabanking.com/amplitude}char1" minOccurs="0"/>
 *         &lt;element name="internationalOperationsIndicator" type="{http://soprabanking.com/amplitude}char1" minOccurs="0"/>
 *         &lt;element name="creditInfoCentre" type="{http://soprabanking.com/amplitude}customerCreditInfoCentreCreate" minOccurs="0"/>
 *         &lt;element name="freeAttributes" type="{http://soprabanking.com/amplitude}customerFreeAttributesCreate" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customerReportingAttributesCreate", propOrder = {
    "declaredHome",
    "economicAgentCode",
    "activityFieldCode",
    "relationshipWithTheBank",
    "gradingAgreement",
    "gradingAgreementAmount",
    "securityIssuer",
    "internationalOperationsIndicator",
    "creditInfoCentre",
    "freeAttributes"
})
public class CustomerReportingAttributesCreate {

    protected String declaredHome;
    protected String economicAgentCode;
    protected String activityFieldCode;
    protected String relationshipWithTheBank;
    protected String gradingAgreement;
    protected BigDecimal gradingAgreementAmount;
    protected String securityIssuer;
    protected String internationalOperationsIndicator;
    protected CustomerCreditInfoCentreCreate creditInfoCentre;
    protected CustomerFreeAttributesCreate freeAttributes;

    /**
     * Obtient la valeur de la propri�t� declaredHome.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeclaredHome() {
        return declaredHome;
    }

    /**
     * D�finit la valeur de la propri�t� declaredHome.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeclaredHome(String value) {
        this.declaredHome = value;
    }

    /**
     * Obtient la valeur de la propri�t� economicAgentCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEconomicAgentCode() {
        return economicAgentCode;
    }

    /**
     * D�finit la valeur de la propri�t� economicAgentCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEconomicAgentCode(String value) {
        this.economicAgentCode = value;
    }

    /**
     * Obtient la valeur de la propri�t� activityFieldCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActivityFieldCode() {
        return activityFieldCode;
    }

    /**
     * D�finit la valeur de la propri�t� activityFieldCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActivityFieldCode(String value) {
        this.activityFieldCode = value;
    }

    /**
     * Obtient la valeur de la propri�t� relationshipWithTheBank.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRelationshipWithTheBank() {
        return relationshipWithTheBank;
    }

    /**
     * D�finit la valeur de la propri�t� relationshipWithTheBank.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRelationshipWithTheBank(String value) {
        this.relationshipWithTheBank = value;
    }

    /**
     * Obtient la valeur de la propri�t� gradingAgreement.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGradingAgreement() {
        return gradingAgreement;
    }

    /**
     * D�finit la valeur de la propri�t� gradingAgreement.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGradingAgreement(String value) {
        this.gradingAgreement = value;
    }

    /**
     * Obtient la valeur de la propri�t� gradingAgreementAmount.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getGradingAgreementAmount() {
        return gradingAgreementAmount;
    }

    /**
     * D�finit la valeur de la propri�t� gradingAgreementAmount.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setGradingAgreementAmount(BigDecimal value) {
        this.gradingAgreementAmount = value;
    }

    /**
     * Obtient la valeur de la propri�t� securityIssuer.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSecurityIssuer() {
        return securityIssuer;
    }

    /**
     * D�finit la valeur de la propri�t� securityIssuer.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSecurityIssuer(String value) {
        this.securityIssuer = value;
    }

    /**
     * Obtient la valeur de la propri�t� internationalOperationsIndicator.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInternationalOperationsIndicator() {
        return internationalOperationsIndicator;
    }

    /**
     * D�finit la valeur de la propri�t� internationalOperationsIndicator.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInternationalOperationsIndicator(String value) {
        this.internationalOperationsIndicator = value;
    }

    /**
     * Obtient la valeur de la propri�t� creditInfoCentre.
     * 
     * @return
     *     possible object is
     *     {@link CustomerCreditInfoCentreCreate }
     *     
     */
    public CustomerCreditInfoCentreCreate getCreditInfoCentre() {
        return creditInfoCentre;
    }

    /**
     * D�finit la valeur de la propri�t� creditInfoCentre.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerCreditInfoCentreCreate }
     *     
     */
    public void setCreditInfoCentre(CustomerCreditInfoCentreCreate value) {
        this.creditInfoCentre = value;
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

}
