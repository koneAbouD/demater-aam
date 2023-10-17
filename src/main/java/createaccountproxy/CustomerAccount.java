
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
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
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
     * Obtient la valeur de la propriété accountTitle.
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
     * Définit la valeur de la propriété accountTitle.
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
     * Obtient la valeur de la propriété productCode.
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
     * Définit la valeur de la propriété productCode.
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
     * Obtient la valeur de la propriété accountClassCode.
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
     * Définit la valeur de la propriété accountClassCode.
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
     * Obtient la valeur de la propriété accountType.
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
     * Définit la valeur de la propriété accountType.
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
     * Obtient la valeur de la propriété responsibleCustomer.
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
     * Définit la valeur de la propriété responsibleCustomer.
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
     * Obtient la valeur de la propriété ncsConstruction.
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
     * Définit la valeur de la propriété ncsConstruction.
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
     * Obtient la valeur de la propriété accountSide.
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
     * Définit la valeur de la propriété accountSide.
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
     * Obtient la valeur de la propriété taxableAccount.
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
     * Définit la valeur de la propriété taxableAccount.
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
     * Obtient la valeur de la propriété accountSubjectToInterestCalculation.
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
     * Définit la valeur de la propriété accountSubjectToInterestCalculation.
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
     * Obtient la valeur de la propriété frequencyOfDebitInterestCalculation.
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
     * Définit la valeur de la propriété frequencyOfDebitInterestCalculation.
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
     * Obtient la valeur de la propriété frequencyOfCreditInterestCalculation.
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
     * Définit la valeur de la propriété frequencyOfCreditInterestCalculation.
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
     * Obtient la valeur de la propriété codeForInterestLadderPrinting.
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
     * Définit la valeur de la propriété codeForInterestLadderPrinting.
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
     * Obtient la valeur de la propriété accountSubjectToDeductionAtSource.
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
     * Définit la valeur de la propriété accountSubjectToDeductionAtSource.
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
     * Obtient la valeur de la propriété maturityDate.
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
     * Définit la valeur de la propriété maturityDate.
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
     * Obtient la valeur de la propriété serviceCode.
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
     * Définit la valeur de la propriété serviceCode.
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
     * Obtient la valeur de la propriété accountStatementCode.
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
     * Définit la valeur de la propriété accountStatementCode.
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
     * Obtient la valeur de la propriété accountStatementDeliveryMethod.
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
     * Définit la valeur de la propriété accountStatementDeliveryMethod.
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
     * Obtient la valeur de la propriété directCreditCeiling.
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
     * Définit la valeur de la propriété directCreditCeiling.
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
     * Obtient la valeur de la propriété matchingCode.
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
     * Définit la valeur de la propriété matchingCode.
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
     * Obtient la valeur de la propriété accountPledging.
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
     * Définit la valeur de la propriété accountPledging.
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
     * Obtient la valeur de la propriété thresholdForReorderingCheques.
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
     * Définit la valeur de la propriété thresholdForReorderingCheques.
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
     * Obtient la valeur de la propriété defaultChequeBookType.
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
     * Définit la valeur de la propriété defaultChequeBookType.
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
     * Obtient la valeur de la propriété chequeDeliveryMethod.
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
     * Définit la valeur de la propriété chequeDeliveryMethod.
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
     * Obtient la valeur de la propriété branchThatDeliveredTheChequeBook.
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
     * Définit la valeur de la propriété branchThatDeliveredTheChequeBook.
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
     * Obtient la valeur de la propriété accountMemos.
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
     * Définit la valeur de la propriété accountMemos.
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
     * Obtient la valeur de la propriété accountPhoneNumbers.
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
     * Définit la valeur de la propriété accountPhoneNumbers.
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
     * Obtient la valeur de la propriété accountEmailAddresses.
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
     * Définit la valeur de la propriété accountEmailAddresses.
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
     * Obtient la valeur de la propriété accountContacts.
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
     * Définit la valeur de la propriété accountContacts.
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
     * Obtient la valeur de la propriété accountFreeAttributes.
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
     * Définit la valeur de la propriété accountFreeAttributes.
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
     * Obtient la valeur de la propriété accountAddress.
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
     * Définit la valeur de la propriété accountAddress.
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
     * Obtient la valeur de la propriété chequeBookAddress.
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
     * Définit la valeur de la propriété chequeBookAddress.
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
