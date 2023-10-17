
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
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
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
     * Obtient la valeur de la propriété firstname.
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
     * Définit la valeur de la propriété firstname.
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
     * Obtient la valeur de la propriété middlename.
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
     * Définit la valeur de la propriété middlename.
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
     * Obtient la valeur de la propriété thirdname.
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
     * Définit la valeur de la propriété thirdname.
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
     * Obtient la valeur de la propriété familyStatusCode.
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
     * Définit la valeur de la propriété familyStatusCode.
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
     * Obtient la valeur de la propriété marriageSettlementCode.
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
     * Définit la valeur de la propriété marriageSettlementCode.
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
     * Obtient la valeur de la propriété holderLegalCapacity.
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
     * Définit la valeur de la propriété holderLegalCapacity.
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
     * Obtient la valeur de la propriété applicationDateOflegalCapacity.
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
     * Définit la valeur de la propriété applicationDateOflegalCapacity.
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
     * Obtient la valeur de la propriété realEstateSituationCode.
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
     * Définit la valeur de la propriété realEstateSituationCode.
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
