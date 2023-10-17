
package gercustomerproxy;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour customerReportingAttributes complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="customerReportingAttributes">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="declaredHome" type="{http://soprabanking.com/amplitude}declaredHome" minOccurs="0"/>
 *         &lt;element name="economicAgentCode" type="{http://soprabanking.com/amplitude}centralBankCategory" minOccurs="0"/>
 *         &lt;element name="activityFieldCode" type="{http://soprabanking.com/amplitude}customerActivityField" minOccurs="0"/>
 *         &lt;element name="relationshipWithTheBank" type="{http://soprabanking.com/amplitude}relationshipWithTheBank" minOccurs="0"/>
 *         &lt;element name="gradingAgreement" type="{http://soprabanking.com/amplitude}char1" minOccurs="0"/>
 *         &lt;element name="gradingAgreementAmount" type="{http://soprabanking.com/amplitude}decimal19_4" minOccurs="0"/>
 *         &lt;element name="securityIssuer" type="{http://soprabanking.com/amplitude}char1" minOccurs="0"/>
 *         &lt;element name="internationalOperationsIndicator" type="{http://soprabanking.com/amplitude}char1" minOccurs="0"/>
 *         &lt;element name="creditInfoCentre" type="{http://soprabanking.com/amplitude}customerCreditInfoCentre" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customerReportingAttributes", propOrder = {
    "declaredHome",
    "economicAgentCode",
    "activityFieldCode",
    "relationshipWithTheBank",
    "gradingAgreement",
    "gradingAgreementAmount",
    "securityIssuer",
    "internationalOperationsIndicator",
    "creditInfoCentre"
})
public class CustomerReportingAttributes {

    protected DeclaredHome declaredHome;
    protected CentralBankCategory economicAgentCode;
    protected CustomerActivityField activityFieldCode;
    protected RelationshipWithTheBank relationshipWithTheBank;
    protected String gradingAgreement;
    protected BigDecimal gradingAgreementAmount;
    protected String securityIssuer;
    protected String internationalOperationsIndicator;
    protected CustomerCreditInfoCentre creditInfoCentre;

    /**
     * Obtient la valeur de la propri�t� declaredHome.
     * 
     * @return
     *     possible object is
     *     {@link DeclaredHome }
     *     
     */
    public DeclaredHome getDeclaredHome() {
        return declaredHome;
    }

    /**
     * D�finit la valeur de la propri�t� declaredHome.
     * 
     * @param value
     *     allowed object is
     *     {@link DeclaredHome }
     *     
     */
    public void setDeclaredHome(DeclaredHome value) {
        this.declaredHome = value;
    }

    /**
     * Obtient la valeur de la propri�t� economicAgentCode.
     * 
     * @return
     *     possible object is
     *     {@link CentralBankCategory }
     *     
     */
    public CentralBankCategory getEconomicAgentCode() {
        return economicAgentCode;
    }

    /**
     * D�finit la valeur de la propri�t� economicAgentCode.
     * 
     * @param value
     *     allowed object is
     *     {@link CentralBankCategory }
     *     
     */
    public void setEconomicAgentCode(CentralBankCategory value) {
        this.economicAgentCode = value;
    }

    /**
     * Obtient la valeur de la propri�t� activityFieldCode.
     * 
     * @return
     *     possible object is
     *     {@link CustomerActivityField }
     *     
     */
    public CustomerActivityField getActivityFieldCode() {
        return activityFieldCode;
    }

    /**
     * D�finit la valeur de la propri�t� activityFieldCode.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerActivityField }
     *     
     */
    public void setActivityFieldCode(CustomerActivityField value) {
        this.activityFieldCode = value;
    }

    /**
     * Obtient la valeur de la propri�t� relationshipWithTheBank.
     * 
     * @return
     *     possible object is
     *     {@link RelationshipWithTheBank }
     *     
     */
    public RelationshipWithTheBank getRelationshipWithTheBank() {
        return relationshipWithTheBank;
    }

    /**
     * D�finit la valeur de la propri�t� relationshipWithTheBank.
     * 
     * @param value
     *     allowed object is
     *     {@link RelationshipWithTheBank }
     *     
     */
    public void setRelationshipWithTheBank(RelationshipWithTheBank value) {
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
     *     {@link CustomerCreditInfoCentre }
     *     
     */
    public CustomerCreditInfoCentre getCreditInfoCentre() {
        return creditInfoCentre;
    }

    /**
     * D�finit la valeur de la propri�t� creditInfoCentre.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerCreditInfoCentre }
     *     
     */
    public void setCreditInfoCentre(CustomerCreditInfoCentre value) {
        this.creditInfoCentre = value;
    }

}
