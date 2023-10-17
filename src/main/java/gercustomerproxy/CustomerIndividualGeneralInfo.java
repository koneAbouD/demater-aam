
package gercustomerproxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java pour customerIndividualGeneralInfo complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="customerIndividualGeneralInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="firstname" type="{http://soprabanking.com/amplitude}charMax30" minOccurs="0"/>
 *         &lt;element name="middlename" type="{http://soprabanking.com/amplitude}charMax30" minOccurs="0"/>
 *         &lt;element name="thirdname" type="{http://soprabanking.com/amplitude}charMax30" minOccurs="0"/>
 *         &lt;element name="familyStatusCode" type="{http://soprabanking.com/amplitude}familyStatus" minOccurs="0"/>
 *         &lt;element name="marriageSettlementCode" type="{http://soprabanking.com/amplitude}marriageSettlement" minOccurs="0"/>
 *         &lt;element name="holderLegalCapacity" type="{http://soprabanking.com/amplitude}legalCapacity" minOccurs="0"/>
 *         &lt;element name="applicationDateOflegalCapacity" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="RealEstateSituationCode" type="{http://soprabanking.com/amplitude}customerRealEstateSituation" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customerIndividualGeneralInfo", propOrder = {
    "firstname",
    "middlename",
    "thirdname",
    "familyStatusCode",
    "marriageSettlementCode",
    "holderLegalCapacity",
    "applicationDateOflegalCapacity",
    "realEstateSituationCode"
})
public class CustomerIndividualGeneralInfo {

    protected String firstname;
    protected String middlename;
    protected String thirdname;
    protected FamilyStatus familyStatusCode;
    protected MarriageSettlement marriageSettlementCode;
    protected LegalCapacity holderLegalCapacity;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar applicationDateOflegalCapacity;
    @XmlElement(name = "RealEstateSituationCode")
    protected CustomerRealEstateSituation realEstateSituationCode;

    /**
     * Obtient la valeur de la propri�t� firstname.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * D�finit la valeur de la propri�t� firstname.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstname(String value) {
        this.firstname = value;
    }

    /**
     * Obtient la valeur de la propri�t� middlename.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMiddlename() {
        return middlename;
    }

    /**
     * D�finit la valeur de la propri�t� middlename.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMiddlename(String value) {
        this.middlename = value;
    }

    /**
     * Obtient la valeur de la propri�t� thirdname.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getThirdname() {
        return thirdname;
    }

    /**
     * D�finit la valeur de la propri�t� thirdname.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setThirdname(String value) {
        this.thirdname = value;
    }

    /**
     * Obtient la valeur de la propri�t� familyStatusCode.
     * 
     * @return
     *     possible object is
     *     {@link FamilyStatus }
     *     
     */
    public FamilyStatus getFamilyStatusCode() {
        return familyStatusCode;
    }

    /**
     * D�finit la valeur de la propri�t� familyStatusCode.
     * 
     * @param value
     *     allowed object is
     *     {@link FamilyStatus }
     *     
     */
    public void setFamilyStatusCode(FamilyStatus value) {
        this.familyStatusCode = value;
    }

    /**
     * Obtient la valeur de la propri�t� marriageSettlementCode.
     * 
     * @return
     *     possible object is
     *     {@link MarriageSettlement }
     *     
     */
    public MarriageSettlement getMarriageSettlementCode() {
        return marriageSettlementCode;
    }

    /**
     * D�finit la valeur de la propri�t� marriageSettlementCode.
     * 
     * @param value
     *     allowed object is
     *     {@link MarriageSettlement }
     *     
     */
    public void setMarriageSettlementCode(MarriageSettlement value) {
        this.marriageSettlementCode = value;
    }

    /**
     * Obtient la valeur de la propri�t� holderLegalCapacity.
     * 
     * @return
     *     possible object is
     *     {@link LegalCapacity }
     *     
     */
    public LegalCapacity getHolderLegalCapacity() {
        return holderLegalCapacity;
    }

    /**
     * D�finit la valeur de la propri�t� holderLegalCapacity.
     * 
     * @param value
     *     allowed object is
     *     {@link LegalCapacity }
     *     
     */
    public void setHolderLegalCapacity(LegalCapacity value) {
        this.holderLegalCapacity = value;
    }

    /**
     * Obtient la valeur de la propri�t� applicationDateOflegalCapacity.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getApplicationDateOflegalCapacity() {
        return applicationDateOflegalCapacity;
    }

    /**
     * D�finit la valeur de la propri�t� applicationDateOflegalCapacity.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setApplicationDateOflegalCapacity(XMLGregorianCalendar value) {
        this.applicationDateOflegalCapacity = value;
    }

    /**
     * Obtient la valeur de la propri�t� realEstateSituationCode.
     * 
     * @return
     *     possible object is
     *     {@link CustomerRealEstateSituation }
     *     
     */
    public CustomerRealEstateSituation getRealEstateSituationCode() {
        return realEstateSituationCode;
    }

    /**
     * D�finit la valeur de la propri�t� realEstateSituationCode.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerRealEstateSituation }
     *     
     */
    public void setRealEstateSituationCode(CustomerRealEstateSituation value) {
        this.realEstateSituationCode = value;
    }

}
