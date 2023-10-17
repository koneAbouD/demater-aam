
package createcustomerproxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour customerIndividualSpecInfoCreate complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="customerIndividualSpecInfoCreate">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="individualGeneralInfo" type="{http://soprabanking.com/amplitude}customerIndividualGeneralInfoCreate" minOccurs="0"/>
 *         &lt;element name="birth" type="{http://soprabanking.com/amplitude}customerBirthCreate" minOccurs="0"/>
 *         &lt;element name="idPaper" type="{http://soprabanking.com/amplitude}customerIdPaperCreate" minOccurs="0"/>
 *         &lt;element name="territoriality" type="{http://soprabanking.com/amplitude}customerTerritorialityCreate" minOccurs="0"/>
 *         &lt;element name="family" type="{http://soprabanking.com/amplitude}customerFamily" minOccurs="0"/>
 *         &lt;element name="otherAttributes" type="{http://soprabanking.com/amplitude}customerOtherAttributes" minOccurs="0"/>
 *         &lt;element name="jointAccountsList" type="{http://soprabanking.com/amplitude}modifyCustomerJointAccountsRequest" minOccurs="0"/>
 *         &lt;element name="childrenList" type="{http://soprabanking.com/amplitude}modifyCustomerChildrenRequest" minOccurs="0"/>
 *         &lt;element name="customerBudget" type="{http://soprabanking.com/amplitude}modifyCustomerBudgetRequest" minOccurs="0"/>
 *         &lt;element name="professionAndIncomesList" type="{http://soprabanking.com/amplitude}modifyCustomerProfessionsAndIncomesRequest" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customerIndividualSpecInfoCreate", propOrder = {
    "individualGeneralInfo",
    "birth",
    "idPaper",
    "territoriality",
    "family",
    "otherAttributes",
    "jointAccountsList",
    "childrenList",
    "customerBudget",
    "professionAndIncomesList"
})
public class CustomerIndividualSpecInfoCreate {

    protected CustomerIndividualGeneralInfoCreate individualGeneralInfo;
    protected CustomerBirthCreate birth;
    protected CustomerIdPaperCreate idPaper;
    protected CustomerTerritorialityCreate territoriality;
    protected CustomerFamily family;
    protected CustomerOtherAttributes otherAttributes;
    protected ModifyCustomerJointAccountsRequest jointAccountsList;
    protected ModifyCustomerChildrenRequest childrenList;
    protected ModifyCustomerBudgetRequest customerBudget;
    protected ModifyCustomerProfessionsAndIncomesRequest professionAndIncomesList;

    /**
     * Obtient la valeur de la propri�t� individualGeneralInfo.
     * 
     * @return
     *     possible object is
     *     {@link CustomerIndividualGeneralInfoCreate }
     *     
     */
    public CustomerIndividualGeneralInfoCreate getIndividualGeneralInfo() {
        return individualGeneralInfo;
    }

    /**
     * D�finit la valeur de la propri�t� individualGeneralInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerIndividualGeneralInfoCreate }
     *     
     */
    public void setIndividualGeneralInfo(CustomerIndividualGeneralInfoCreate value) {
        this.individualGeneralInfo = value;
    }

    /**
     * Obtient la valeur de la propri�t� birth.
     * 
     * @return
     *     possible object is
     *     {@link CustomerBirthCreate }
     *     
     */
    public CustomerBirthCreate getBirth() {
        return birth;
    }

    /**
     * D�finit la valeur de la propri�t� birth.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerBirthCreate }
     *     
     */
    public void setBirth(CustomerBirthCreate value) {
        this.birth = value;
    }

    /**
     * Obtient la valeur de la propri�t� idPaper.
     * 
     * @return
     *     possible object is
     *     {@link CustomerIdPaperCreate }
     *     
     */
    public CustomerIdPaperCreate getIdPaper() {
        return idPaper;
    }

    /**
     * D�finit la valeur de la propri�t� idPaper.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerIdPaperCreate }
     *     
     */
    public void setIdPaper(CustomerIdPaperCreate value) {
        this.idPaper = value;
    }

    /**
     * Obtient la valeur de la propri�t� territoriality.
     * 
     * @return
     *     possible object is
     *     {@link CustomerTerritorialityCreate }
     *     
     */
    public CustomerTerritorialityCreate getTerritoriality() {
        return territoriality;
    }

    /**
     * D�finit la valeur de la propri�t� territoriality.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerTerritorialityCreate }
     *     
     */
    public void setTerritoriality(CustomerTerritorialityCreate value) {
        this.territoriality = value;
    }

    /**
     * Obtient la valeur de la propri�t� family.
     * 
     * @return
     *     possible object is
     *     {@link CustomerFamily }
     *     
     */
    public CustomerFamily getFamily() {
        return family;
    }

    /**
     * D�finit la valeur de la propri�t� family.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerFamily }
     *     
     */
    public void setFamily(CustomerFamily value) {
        this.family = value;
    }

    /**
     * Obtient la valeur de la propri�t� otherAttributes.
     * 
     * @return
     *     possible object is
     *     {@link CustomerOtherAttributes }
     *     
     */
    public CustomerOtherAttributes getOtherAttributes() {
        return otherAttributes;
    }

    /**
     * D�finit la valeur de la propri�t� otherAttributes.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerOtherAttributes }
     *     
     */
    public void setOtherAttributes(CustomerOtherAttributes value) {
        this.otherAttributes = value;
    }

    /**
     * Obtient la valeur de la propri�t� jointAccountsList.
     * 
     * @return
     *     possible object is
     *     {@link ModifyCustomerJointAccountsRequest }
     *     
     */
    public ModifyCustomerJointAccountsRequest getJointAccountsList() {
        return jointAccountsList;
    }

    /**
     * D�finit la valeur de la propri�t� jointAccountsList.
     * 
     * @param value
     *     allowed object is
     *     {@link ModifyCustomerJointAccountsRequest }
     *     
     */
    public void setJointAccountsList(ModifyCustomerJointAccountsRequest value) {
        this.jointAccountsList = value;
    }

    /**
     * Obtient la valeur de la propri�t� childrenList.
     * 
     * @return
     *     possible object is
     *     {@link ModifyCustomerChildrenRequest }
     *     
     */
    public ModifyCustomerChildrenRequest getChildrenList() {
        return childrenList;
    }

    /**
     * D�finit la valeur de la propri�t� childrenList.
     * 
     * @param value
     *     allowed object is
     *     {@link ModifyCustomerChildrenRequest }
     *     
     */
    public void setChildrenList(ModifyCustomerChildrenRequest value) {
        this.childrenList = value;
    }

    /**
     * Obtient la valeur de la propri�t� customerBudget.
     * 
     * @return
     *     possible object is
     *     {@link ModifyCustomerBudgetRequest }
     *     
     */
    public ModifyCustomerBudgetRequest getCustomerBudget() {
        return customerBudget;
    }

    /**
     * D�finit la valeur de la propri�t� customerBudget.
     * 
     * @param value
     *     allowed object is
     *     {@link ModifyCustomerBudgetRequest }
     *     
     */
    public void setCustomerBudget(ModifyCustomerBudgetRequest value) {
        this.customerBudget = value;
    }

    /**
     * Obtient la valeur de la propri�t� professionAndIncomesList.
     * 
     * @return
     *     possible object is
     *     {@link ModifyCustomerProfessionsAndIncomesRequest }
     *     
     */
    public ModifyCustomerProfessionsAndIncomesRequest getProfessionAndIncomesList() {
        return professionAndIncomesList;
    }

    /**
     * D�finit la valeur de la propri�t� professionAndIncomesList.
     * 
     * @param value
     *     allowed object is
     *     {@link ModifyCustomerProfessionsAndIncomesRequest }
     *     
     */
    public void setProfessionAndIncomesList(ModifyCustomerProfessionsAndIncomesRequest value) {
        this.professionAndIncomesList = value;
    }

}
