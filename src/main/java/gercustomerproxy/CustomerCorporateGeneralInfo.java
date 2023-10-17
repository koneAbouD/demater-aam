
package gercustomerproxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java pour customerCorporateGeneralInfo complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="customerCorporateGeneralInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tradeNameToDeclare" type="{http://soprabanking.com/amplitude}charMax65" minOccurs="0"/>
 *         &lt;element name="secondTradeNameToDeclare" type="{http://soprabanking.com/amplitude}charMax65" minOccurs="0"/>
 *         &lt;element name="companyCreationDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="legalFormCode" type="{http://soprabanking.com/amplitude}legalForm" minOccurs="0"/>
 *         &lt;element name="statutoryAuditor1" type="{http://soprabanking.com/amplitude}charMax36" minOccurs="0"/>
 *         &lt;element name="statutoryAuditor2" type="{http://soprabanking.com/amplitude}charMax36" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customerCorporateGeneralInfo", propOrder = {
    "tradeNameToDeclare",
    "secondTradeNameToDeclare",
    "companyCreationDate",
    "legalFormCode",
    "statutoryAuditor1",
    "statutoryAuditor2"
})
public class CustomerCorporateGeneralInfo {

    protected String tradeNameToDeclare;
    protected String secondTradeNameToDeclare;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar companyCreationDate;
    protected LegalForm legalFormCode;
    protected String statutoryAuditor1;
    protected String statutoryAuditor2;

    /**
     * Obtient la valeur de la propriété tradeNameToDeclare.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTradeNameToDeclare() {
        return tradeNameToDeclare;
    }

    /**
     * Définit la valeur de la propriété tradeNameToDeclare.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTradeNameToDeclare(String value) {
        this.tradeNameToDeclare = value;
    }

    /**
     * Obtient la valeur de la propriété secondTradeNameToDeclare.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSecondTradeNameToDeclare() {
        return secondTradeNameToDeclare;
    }

    /**
     * Définit la valeur de la propriété secondTradeNameToDeclare.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSecondTradeNameToDeclare(String value) {
        this.secondTradeNameToDeclare = value;
    }

    /**
     * Obtient la valeur de la propriété companyCreationDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCompanyCreationDate() {
        return companyCreationDate;
    }

    /**
     * Définit la valeur de la propriété companyCreationDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCompanyCreationDate(XMLGregorianCalendar value) {
        this.companyCreationDate = value;
    }

    /**
     * Obtient la valeur de la propriété legalFormCode.
     * 
     * @return
     *     possible object is
     *     {@link LegalForm }
     *     
     */
    public LegalForm getLegalFormCode() {
        return legalFormCode;
    }

    /**
     * Définit la valeur de la propriété legalFormCode.
     * 
     * @param value
     *     allowed object is
     *     {@link LegalForm }
     *     
     */
    public void setLegalFormCode(LegalForm value) {
        this.legalFormCode = value;
    }

    /**
     * Obtient la valeur de la propriété statutoryAuditor1.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatutoryAuditor1() {
        return statutoryAuditor1;
    }

    /**
     * Définit la valeur de la propriété statutoryAuditor1.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatutoryAuditor1(String value) {
        this.statutoryAuditor1 = value;
    }

    /**
     * Obtient la valeur de la propriété statutoryAuditor2.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatutoryAuditor2() {
        return statutoryAuditor2;
    }

    /**
     * Définit la valeur de la propriété statutoryAuditor2.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatutoryAuditor2(String value) {
        this.statutoryAuditor2 = value;
    }

}
