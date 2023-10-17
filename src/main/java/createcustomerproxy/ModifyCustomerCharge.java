
package createcustomerproxy;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java pour modifyCustomerCharge complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="modifyCustomerCharge">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="chargeCode" type="{http://soprabanking.com/amplitude}chargeCode" minOccurs="0"/>
 *         &lt;element name="periodicityCode" type="{http://soprabanking.com/amplitude}periodicity" minOccurs="0"/>
 *         &lt;element name="amount" type="{http://soprabanking.com/amplitude}decimal19_4" minOccurs="0"/>
 *         &lt;element name="initialAmount" type="{http://soprabanking.com/amplitude}decimal19_4" minOccurs="0"/>
 *         &lt;element name="currency" type="{http://soprabanking.com/amplitude}currencyCode" minOccurs="0"/>
 *         &lt;element name="maturityDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="organisation" type="{http://soprabanking.com/amplitude}charMax30" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "modifyCustomerCharge", propOrder = {
    "chargeCode",
    "periodicityCode",
    "amount",
    "initialAmount",
    "currency",
    "maturityDate",
    "organisation"
})
public class ModifyCustomerCharge {

    protected String chargeCode;
    @XmlSchemaType(name = "string")
    protected Periodicity periodicityCode;
    protected BigDecimal amount;
    protected BigDecimal initialAmount;
    protected String currency;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar maturityDate;
    protected String organisation;

    /**
     * Obtient la valeur de la propri�t� chargeCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChargeCode() {
        return chargeCode;
    }

    /**
     * D�finit la valeur de la propri�t� chargeCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChargeCode(String value) {
        this.chargeCode = value;
    }

    /**
     * Obtient la valeur de la propri�t� periodicityCode.
     * 
     * @return
     *     possible object is
     *     {@link Periodicity }
     *     
     */
    public Periodicity getPeriodicityCode() {
        return periodicityCode;
    }

    /**
     * D�finit la valeur de la propri�t� periodicityCode.
     * 
     * @param value
     *     allowed object is
     *     {@link Periodicity }
     *     
     */
    public void setPeriodicityCode(Periodicity value) {
        this.periodicityCode = value;
    }

    /**
     * Obtient la valeur de la propri�t� amount.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * D�finit la valeur de la propri�t� amount.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAmount(BigDecimal value) {
        this.amount = value;
    }

    /**
     * Obtient la valeur de la propri�t� initialAmount.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getInitialAmount() {
        return initialAmount;
    }

    /**
     * D�finit la valeur de la propri�t� initialAmount.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setInitialAmount(BigDecimal value) {
        this.initialAmount = value;
    }

    /**
     * Obtient la valeur de la propri�t� currency.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * D�finit la valeur de la propri�t� currency.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrency(String value) {
        this.currency = value;
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
     * Obtient la valeur de la propri�t� organisation.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrganisation() {
        return organisation;
    }

    /**
     * D�finit la valeur de la propri�t� organisation.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrganisation(String value) {
        this.organisation = value;
    }

}
