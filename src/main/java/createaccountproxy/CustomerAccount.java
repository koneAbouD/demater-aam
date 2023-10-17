
package createaccountproxy;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java pour customerAccount complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="customerAccount">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountTitle" type="{http://soprabanking.com/amplitude}charMax30" minOccurs="0"/>
 *         &lt;element name="productCode" type="{http://soprabanking.com/amplitude}productCode"/>
 *         &lt;element name="accountClassCode" type="{http://soprabanking.com/amplitude}accountClassCode"/>
 *         &lt;element name="accountType" type="{http://soprabanking.com/amplitude}charMax3"/>
 *         &lt;element name="responsibleCustomer" type="{http://soprabanking.com/amplitude}customerCode" minOccurs="0"/>
 *         &lt;element name="ncsConstruction" type="{http://soprabanking.com/amplitude}charMax2" minOccurs="0"/>
 *         &lt;element name="accountSide" type="{http://soprabanking.com/amplitude}accountSide" minOccurs="0"/>
 *         &lt;element name="taxableAccount" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="accountSubjectToInterestCalculation" type="{http://soprabanking.com/amplitude}accountSubjectToInterestCalculation" minOccurs="0"/>
 *         &lt;element name="frequencyOfDebitInterestCalculation" type="{http://soprabanking.com/amplitude}periodicity"/>
 *         &lt;element name="frequencyOfCreditInterestCalculation" type="{http://soprabanking.com/amplitude}periodicity"/>
 *         &lt;element name="codeForInterestLadderPrinting" type="{http://soprabanking.com/amplitude}codeForInterestLadderPrinting" minOccurs="0"/>
 *         &lt;element name="accountSubjectToDeductionAtSource" type="{http://soprabanking.com/amplitude}decimal1_0" minOccurs="0"/>
 *         &lt;element name="maturityDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="serviceCode" type="{http://soprabanking.com/amplitude}charMax4"/>
 *         &lt;element name="accountStatementCode" type="{http://soprabanking.com/amplitude}char1"/>
 *         &lt;element name="accountStatementDeliveryMethod" type="{http://soprabanking.com/amplitude}char1" minOccurs="0"/>
 *         &lt;element name="directCreditCeiling" type="{http://soprabanking.com/amplitude}decimal12_0" minOccurs="0"/>
 *         &lt;element name="matchingCode" type="{http://soprabanking.com/amplitude}matchingCode" minOccurs="0"/>
 *         &lt;element name="accountPledging" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="thresholdForReorderingCheques" type="{http://soprabanking.com/amplitude}decimal4_0" minOccurs="0"/>
 *         &lt;element name="defaultChequeBookType" type="{http://soprabanking.com/amplitude}charMax2" minOccurs="0"/>
 *         &lt;element name="chequeDeliveryMethod" type="{http://soprabanking.com/amplitude}chequeBookDeliveryMethod" minOccurs="0"/>
 *         &lt;element name="branchThatDeliveredTheChequeBook" type="{http://soprabanking.com/amplitude}branchCode" minOccurs="0"/>
 *         &lt;element name="accountMemos" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="accountPhoneNumbers" type="{http://soprabanking.com/amplitude}accountPhoneNumbers" minOccurs="0"/>
 *         &lt;element name="accountEmailAddresses" type="{http://soprabanking.com/amplitude}accountEmailAddresses" minOccurs="0"/>
 *         &lt;element name="accountContacts" type="{http://soprabanking.com/amplitude}modifyAccountContactsRequest" minOccurs="0"/>
 *         &lt;element name="accountFreeAttributes" type="{http://soprabanking.com/amplitude}accountFreeAttributes" minOccurs="0"/>
 *         &lt;element name="accountAddress" type="{http://soprabanking.com/amplitude}createAccountAddressRequest" minOccurs="0"/>
 *         &lt;element name="chequeBookAddress" type="{http://soprabanking.com/amplitude}accountChequeBookAddress" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customerAccount", propOrder = {
    "accountTitle",
    "productCode",
    "accountClassCode",
    "accountType",
    "responsibleCustomer",
    "ncsConstruction",
    "accountSide",
    "taxableAccount",
    "accountSubjectToInterestCalculation",
    "frequencyOfDebitInterestCalculation",
    "frequencyOfCreditInterestCalculation",
    "codeForInterestLadderPrinting",
    "accountSubjectToDeductionAtSource",
    "maturityDate",
    "serviceCode",
    "accountStatementCode",
    "accountStatementDeliveryMethod",
    "directCreditCeiling",
    "matchingCode",
    "accountPledging",
    "thresholdForReorderingCheques",
    "defaultChequeBookType",
    "chequeDeliveryMethod",
    "branchThatDeliveredTheChequeBook",
    "accountMemos",
    "accountPhoneNumbers",
    "accountEmailAddresses",
    "accountContacts",
    "accountFreeAttributes",
    "accountAddress",
    "chequeBookAddress"
})
public class CustomerAccount {

    protected String accountTitle;
    @XmlElement(required = true)
    protected String productCode;
    @XmlElement(required = true)
    protected String accountClassCode;
    @XmlElement(required = true)
    protected String accountType;
    protected String responsibleCustomer;
    protected String ncsConstruction;
    @XmlSchemaType(name = "string")
    protected AccountSide accountSide;
    protected Boolean taxableAccount;
    @XmlSchemaType(name = "string")
    protected AccountSubjectToInterestCalculation accountSubjectToInterestCalculation;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected Periodicity frequencyOfDebitInterestCalculation;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected Periodicity frequencyOfCreditInterestCalculation;
    @XmlSchemaType(name = "string")
    protected CodeForInterestLadderPrinting codeForInterestLadderPrinting;
    protected BigDecimal accountSubjectToDeductionAtSource;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar maturityDate;
    @XmlElement(required = true)
    protected String serviceCode;
    @XmlElement(required = true)
    protected String accountStatementCode;
    protected String accountStatementDeliveryMethod;
    protected BigDecimal directCreditCeiling;
    protected String matchingCode;
    protected Boolean accountPledging;
    protected BigDecimal thresholdForReorderingCheques;
    protected String defaultChequeBookType;
    @XmlSchemaType(name = "string")
    protected ChequeBookDeliveryMethod chequeDeliveryMethod;
    protected String branchThatDeliveredTheChequeBook;
    protected String accountMemos;
    protected AccountPhoneNumbers accountPhoneNumbers;
    protected AccountEmailAddresses accountEmailAddresses;
    protected ModifyAccountContactsRequest accountContacts;
    protected AccountFreeAttributes accountFreeAttributes;
    protected CreateAccountAddressRequest accountAddress;
    protected AccountChequeBookAddress chequeBookAddress;

    /**
     * Obtient la valeur de la propri�t� accountTitle.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountTitle() {
        return accountTitle;
    }

    /**
     * D�finit la valeur de la propri�t� accountTitle.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountTitle(String value) {
        this.accountTitle = value;
    }

    /**
     * Obtient la valeur de la propri�t� productCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductCode() {
        return productCode;
    }

    /**
     * D�finit la valeur de la propri�t� productCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductCode(String value) {
        this.productCode = value;
    }

    /**
     * Obtient la valeur de la propri�t� accountClassCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountClassCode() {
        return accountClassCode;
    }

    /**
     * D�finit la valeur de la propri�t� accountClassCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountClassCode(String value) {
        this.accountClassCode = value;
    }

    /**
     * Obtient la valeur de la propri�t� accountType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountType() {
        return accountType;
    }

    /**
     * D�finit la valeur de la propri�t� accountType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountType(String value) {
        this.accountType = value;
    }

    /**
     * Obtient la valeur de la propri�t� responsibleCustomer.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResponsibleCustomer() {
        return responsibleCustomer;
    }

    /**
     * D�finit la valeur de la propri�t� responsibleCustomer.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResponsibleCustomer(String value) {
        this.responsibleCustomer = value;
    }

    /**
     * Obtient la valeur de la propri�t� ncsConstruction.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNcsConstruction() {
        return ncsConstruction;
    }

    /**
     * D�finit la valeur de la propri�t� ncsConstruction.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNcsConstruction(String value) {
        this.ncsConstruction = value;
    }

    /**
     * Obtient la valeur de la propri�t� accountSide.
     * 
     * @return
     *     possible object is
     *     {@link AccountSide }
     *     
     */
    public AccountSide getAccountSide() {
        return accountSide;
    }

    /**
     * D�finit la valeur de la propri�t� accountSide.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountSide }
     *     
     */
    public void setAccountSide(AccountSide value) {
        this.accountSide = value;
    }

    /**
     * Obtient la valeur de la propri�t� taxableAccount.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isTaxableAccount() {
        return taxableAccount;
    }

    /**
     * D�finit la valeur de la propri�t� taxableAccount.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setTaxableAccount(Boolean value) {
        this.taxableAccount = value;
    }

    /**
     * Obtient la valeur de la propri�t� accountSubjectToInterestCalculation.
     * 
     * @return
     *     possible object is
     *     {@link AccountSubjectToInterestCalculation }
     *     
     */
    public AccountSubjectToInterestCalculation getAccountSubjectToInterestCalculation() {
        return accountSubjectToInterestCalculation;
    }

    /**
     * D�finit la valeur de la propri�t� accountSubjectToInterestCalculation.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountSubjectToInterestCalculation }
     *     
     */
    public void setAccountSubjectToInterestCalculation(AccountSubjectToInterestCalculation value) {
        this.accountSubjectToInterestCalculation = value;
    }

    /**
     * Obtient la valeur de la propri�t� frequencyOfDebitInterestCalculation.
     * 
     * @return
     *     possible object is
     *     {@link Periodicity }
     *     
     */
    public Periodicity getFrequencyOfDebitInterestCalculation() {
        return frequencyOfDebitInterestCalculation;
    }

    /**
     * D�finit la valeur de la propri�t� frequencyOfDebitInterestCalculation.
     * 
     * @param value
     *     allowed object is
     *     {@link Periodicity }
     *     
     */
    public void setFrequencyOfDebitInterestCalculation(Periodicity value) {
        this.frequencyOfDebitInterestCalculation = value;
    }

    /**
     * Obtient la valeur de la propri�t� frequencyOfCreditInterestCalculation.
     * 
     * @return
     *     possible object is
     *     {@link Periodicity }
     *     
     */
    public Periodicity getFrequencyOfCreditInterestCalculation() {
        return frequencyOfCreditInterestCalculation;
    }

    /**
     * D�finit la valeur de la propri�t� frequencyOfCreditInterestCalculation.
     * 
     * @param value
     *     allowed object is
     *     {@link Periodicity }
     *     
     */
    public void setFrequencyOfCreditInterestCalculation(Periodicity value) {
        this.frequencyOfCreditInterestCalculation = value;
    }

    /**
     * Obtient la valeur de la propri�t� codeForInterestLadderPrinting.
     * 
     * @return
     *     possible object is
     *     {@link CodeForInterestLadderPrinting }
     *     
     */
    public CodeForInterestLadderPrinting getCodeForInterestLadderPrinting() {
        return codeForInterestLadderPrinting;
    }

    /**
     * D�finit la valeur de la propri�t� codeForInterestLadderPrinting.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeForInterestLadderPrinting }
     *     
     */
    public void setCodeForInterestLadderPrinting(CodeForInterestLadderPrinting value) {
        this.codeForInterestLadderPrinting = value;
    }

    /**
     * Obtient la valeur de la propri�t� accountSubjectToDeductionAtSource.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAccountSubjectToDeductionAtSource() {
        return accountSubjectToDeductionAtSource;
    }

    /**
     * D�finit la valeur de la propri�t� accountSubjectToDeductionAtSource.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAccountSubjectToDeductionAtSource(BigDecimal value) {
        this.accountSubjectToDeductionAtSource = value;
    }

    /**
     * Obtient la valeur de la propri�t� maturityDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getMaturityDate() {
        return maturityDate;
    }

    /**
     * D�finit la valeur de la propri�t� maturityDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setMaturityDate(XMLGregorianCalendar value) {
        this.maturityDate = value;
    }

    /**
     * Obtient la valeur de la propri�t� serviceCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceCode() {
        return serviceCode;
    }

    /**
     * D�finit la valeur de la propri�t� serviceCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceCode(String value) {
        this.serviceCode = value;
    }

    /**
     * Obtient la valeur de la propri�t� accountStatementCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountStatementCode() {
        return accountStatementCode;
    }

    /**
     * D�finit la valeur de la propri�t� accountStatementCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountStatementCode(String value) {
        this.accountStatementCode = value;
    }

    /**
     * Obtient la valeur de la propri�t� accountStatementDeliveryMethod.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountStatementDeliveryMethod() {
        return accountStatementDeliveryMethod;
    }

    /**
     * D�finit la valeur de la propri�t� accountStatementDeliveryMethod.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountStatementDeliveryMethod(String value) {
        this.accountStatementDeliveryMethod = value;
    }

    /**
     * Obtient la valeur de la propri�t� directCreditCeiling.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDirectCreditCeiling() {
        return directCreditCeiling;
    }

    /**
     * D�finit la valeur de la propri�t� directCreditCeiling.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDirectCreditCeiling(BigDecimal value) {
        this.directCreditCeiling = value;
    }

    /**
     * Obtient la valeur de la propri�t� matchingCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMatchingCode() {
        return matchingCode;
    }

    /**
     * D�finit la valeur de la propri�t� matchingCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMatchingCode(String value) {
        this.matchingCode = value;
    }

    /**
     * Obtient la valeur de la propri�t� accountPledging.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAccountPledging() {
        return accountPledging;
    }

    /**
     * D�finit la valeur de la propri�t� accountPledging.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAccountPledging(Boolean value) {
        this.accountPledging = value;
    }

    /**
     * Obtient la valeur de la propri�t� thresholdForReorderingCheques.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getThresholdForReorderingCheques() {
        return thresholdForReorderingCheques;
    }

    /**
     * D�finit la valeur de la propri�t� thresholdForReorderingCheques.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setThresholdForReorderingCheques(BigDecimal value) {
        this.thresholdForReorderingCheques = value;
    }

    /**
     * Obtient la valeur de la propri�t� defaultChequeBookType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDefaultChequeBookType() {
        return defaultChequeBookType;
    }

    /**
     * D�finit la valeur de la propri�t� defaultChequeBookType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDefaultChequeBookType(String value) {
        this.defaultChequeBookType = value;
    }

    /**
     * Obtient la valeur de la propri�t� chequeDeliveryMethod.
     * 
     * @return
     *     possible object is
     *     {@link ChequeBookDeliveryMethod }
     *     
     */
    public ChequeBookDeliveryMethod getChequeDeliveryMethod() {
        return chequeDeliveryMethod;
    }

    /**
     * D�finit la valeur de la propri�t� chequeDeliveryMethod.
     * 
     * @param value
     *     allowed object is
     *     {@link ChequeBookDeliveryMethod }
     *     
     */
    public void setChequeDeliveryMethod(ChequeBookDeliveryMethod value) {
        this.chequeDeliveryMethod = value;
    }

    /**
     * Obtient la valeur de la propri�t� branchThatDeliveredTheChequeBook.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBranchThatDeliveredTheChequeBook() {
        return branchThatDeliveredTheChequeBook;
    }

    /**
     * D�finit la valeur de la propri�t� branchThatDeliveredTheChequeBook.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBranchThatDeliveredTheChequeBook(String value) {
        this.branchThatDeliveredTheChequeBook = value;
    }

    /**
     * Obtient la valeur de la propri�t� accountMemos.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountMemos() {
        return accountMemos;
    }

    /**
     * D�finit la valeur de la propri�t� accountMemos.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountMemos(String value) {
        this.accountMemos = value;
    }

    /**
     * Obtient la valeur de la propri�t� accountPhoneNumbers.
     * 
     * @return
     *     possible object is
     *     {@link AccountPhoneNumbers }
     *     
     */
    public AccountPhoneNumbers getAccountPhoneNumbers() {
        return accountPhoneNumbers;
    }

    /**
     * D�finit la valeur de la propri�t� accountPhoneNumbers.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountPhoneNumbers }
     *     
     */
    public void setAccountPhoneNumbers(AccountPhoneNumbers value) {
        this.accountPhoneNumbers = value;
    }

    /**
     * Obtient la valeur de la propri�t� accountEmailAddresses.
     * 
     * @return
     *     possible object is
     *     {@link AccountEmailAddresses }
     *     
     */
    public AccountEmailAddresses getAccountEmailAddresses() {
        return accountEmailAddresses;
    }

    /**
     * D�finit la valeur de la propri�t� accountEmailAddresses.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountEmailAddresses }
     *     
     */
    public void setAccountEmailAddresses(AccountEmailAddresses value) {
        this.accountEmailAddresses = value;
    }

    /**
     * Obtient la valeur de la propri�t� accountContacts.
     * 
     * @return
     *     possible object is
     *     {@link ModifyAccountContactsRequest }
     *     
     */
    public ModifyAccountContactsRequest getAccountContacts() {
        return accountContacts;
    }

    /**
     * D�finit la valeur de la propri�t� accountContacts.
     * 
     * @param value
     *     allowed object is
     *     {@link ModifyAccountContactsRequest }
     *     
     */
    public void setAccountContacts(ModifyAccountContactsRequest value) {
        this.accountContacts = value;
    }

    /**
     * Obtient la valeur de la propri�t� accountFreeAttributes.
     * 
     * @return
     *     possible object is
     *     {@link AccountFreeAttributes }
     *     
     */
    public AccountFreeAttributes getAccountFreeAttributes() {
        return accountFreeAttributes;
    }

    /**
     * D�finit la valeur de la propri�t� accountFreeAttributes.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountFreeAttributes }
     *     
     */
    public void setAccountFreeAttributes(AccountFreeAttributes value) {
        this.accountFreeAttributes = value;
    }

    /**
     * Obtient la valeur de la propri�t� accountAddress.
     * 
     * @return
     *     possible object is
     *     {@link CreateAccountAddressRequest }
     *     
     */
    public CreateAccountAddressRequest getAccountAddress() {
        return accountAddress;
    }

    /**
     * D�finit la valeur de la propri�t� accountAddress.
     * 
     * @param value
     *     allowed object is
     *     {@link CreateAccountAddressRequest }
     *     
     */
    public void setAccountAddress(CreateAccountAddressRequest value) {
        this.accountAddress = value;
    }

    /**
     * Obtient la valeur de la propri�t� chequeBookAddress.
     * 
     * @return
     *     possible object is
     *     {@link AccountChequeBookAddress }
     *     
     */
    public AccountChequeBookAddress getChequeBookAddress() {
        return chequeBookAddress;
    }

    /**
     * D�finit la valeur de la propri�t� chequeBookAddress.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountChequeBookAddress }
     *     
     */
    public void setChequeBookAddress(AccountChequeBookAddress value) {
        this.chequeBookAddress = value;
    }

}
