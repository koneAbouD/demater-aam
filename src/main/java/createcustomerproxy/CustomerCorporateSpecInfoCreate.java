
package createcustomerproxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour customerCorporateSpecInfoCreate complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="customerCorporateSpecInfoCreate">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="corporateGeneralInfo" type="{http://soprabanking.com/amplitude}customerCorporateGeneralInfoCreate" minOccurs="0"/>
 *         &lt;element name="corporateId" type="{http://soprabanking.com/amplitude}customerCorporateId" minOccurs="0"/>
 *         &lt;element name="legalInformation" type="{http://soprabanking.com/amplitude}customerLegalInformationCreate" minOccurs="0"/>
 *         &lt;element name="groupAndJob" type="{http://soprabanking.com/amplitude}customerGroupAndJobCreate" minOccurs="0"/>
 *         &lt;element name="leadersList" type="{http://soprabanking.com/amplitude}modifyCustomerLeadersRequest" minOccurs="0"/>
 *         &lt;element name="shareholdersList" type="{http://soprabanking.com/amplitude}customerShareholdersCreate" minOccurs="0"/>
 *         &lt;element name="financialDataList" type="{http://soprabanking.com/amplitude}modifyCustomerFinancialDataRequest" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customerCorporateSpecInfoCreate", propOrder = {
    "corporateGeneralInfo",
    "corporateId",
    "legalInformation",
    "groupAndJob",
    "leadersList",
    "shareholdersList",
    "financialDataList"
})
public class CustomerCorporateSpecInfoCreate {

    protected CustomerCorporateGeneralInfoCreate corporateGeneralInfo;
    protected CustomerCorporateId corporateId;
    protected CustomerLegalInformationCreate legalInformation;
    protected CustomerGroupAndJobCreate groupAndJob;
    protected ModifyCustomerLeadersRequest leadersList;
    protected CustomerShareholdersCreate shareholdersList;
    protected ModifyCustomerFinancialDataRequest financialDataList;

    /**
     * Obtient la valeur de la propri�t� corporateGeneralInfo.
     * 
     * @return
     *     possible object is
     *     {@link CustomerCorporateGeneralInfoCreate }
     *     
     */
    public CustomerCorporateGeneralInfoCreate getCorporateGeneralInfo() {
        return corporateGeneralInfo;
    }

    /**
     * D�finit la valeur de la propri�t� corporateGeneralInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerCorporateGeneralInfoCreate }
     *     
     */
    public void setCorporateGeneralInfo(CustomerCorporateGeneralInfoCreate value) {
        this.corporateGeneralInfo = value;
    }

    /**
     * Obtient la valeur de la propri�t� corporateId.
     * 
     * @return
     *     possible object is
     *     {@link CustomerCorporateId }
     *     
     */
    public CustomerCorporateId getCorporateId() {
        return corporateId;
    }

    /**
     * D�finit la valeur de la propri�t� corporateId.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerCorporateId }
     *     
     */
    public void setCorporateId(CustomerCorporateId value) {
        this.corporateId = value;
    }

    /**
     * Obtient la valeur de la propri�t� legalInformation.
     * 
     * @return
     *     possible object is
     *     {@link CustomerLegalInformationCreate }
     *     
     */
    public CustomerLegalInformationCreate getLegalInformation() {
        return legalInformation;
    }

    /**
     * D�finit la valeur de la propri�t� legalInformation.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerLegalInformationCreate }
     *     
     */
    public void setLegalInformation(CustomerLegalInformationCreate value) {
        this.legalInformation = value;
    }

    /**
     * Obtient la valeur de la propri�t� groupAndJob.
     * 
     * @return
     *     possible object is
     *     {@link CustomerGroupAndJobCreate }
     *     
     */
    public CustomerGroupAndJobCreate getGroupAndJob() {
        return groupAndJob;
    }

    /**
     * D�finit la valeur de la propri�t� groupAndJob.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerGroupAndJobCreate }
     *     
     */
    public void setGroupAndJob(CustomerGroupAndJobCreate value) {
        this.groupAndJob = value;
    }

    /**
     * Obtient la valeur de la propri�t� leadersList.
     * 
     * @return
     *     possible object is
     *     {@link ModifyCustomerLeadersRequest }
     *     
     */
    public ModifyCustomerLeadersRequest getLeadersList() {
        return leadersList;
    }

    /**
     * D�finit la valeur de la propri�t� leadersList.
     * 
     * @param value
     *     allowed object is
     *     {@link ModifyCustomerLeadersRequest }
     *     
     */
    public void setLeadersList(ModifyCustomerLeadersRequest value) {
        this.leadersList = value;
    }

    /**
     * Obtient la valeur de la propri�t� shareholdersList.
     * 
     * @return
     *     possible object is
     *     {@link CustomerShareholdersCreate }
     *     
     */
    public CustomerShareholdersCreate getShareholdersList() {
        return shareholdersList;
    }

    /**
     * D�finit la valeur de la propri�t� shareholdersList.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerShareholdersCreate }
     *     
     */
    public void setShareholdersList(CustomerShareholdersCreate value) {
        this.shareholdersList = value;
    }

    /**
     * Obtient la valeur de la propri�t� financialDataList.
     * 
     * @return
     *     possible object is
     *     {@link ModifyCustomerFinancialDataRequest }
     *     
     */
    public ModifyCustomerFinancialDataRequest getFinancialDataList() {
        return financialDataList;
    }

    /**
     * D�finit la valeur de la propri�t� financialDataList.
     * 
     * @param value
     *     allowed object is
     *     {@link ModifyCustomerFinancialDataRequest }
     *     
     */
    public void setFinancialDataList(ModifyCustomerFinancialDataRequest value) {
        this.financialDataList = value;
    }

}
