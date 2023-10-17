
package createcustomerproxy;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java pour modifyCustomerAsset complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="modifyCustomerAsset">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="assetCode" type="{http://soprabanking.com/amplitude}assetCode" minOccurs="0"/>
 *         &lt;element name="estimation" type="{http://soprabanking.com/amplitude}decimal19_4" minOccurs="0"/>
 *         &lt;element name="remainingCapital" type="{http://soprabanking.com/amplitude}decimal19_4" minOccurs="0"/>
 *         &lt;element name="currency" type="{http://soprabanking.com/amplitude}currencyCode" minOccurs="0"/>
 *         &lt;element name="competition" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="maturityDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "modifyCustomerAsset", propOrder = {
    "assetCode",
    "estimation",
    "remainingCapital",
    "currency",
    "competition",
    "maturityDate"
})
public class ModifyCustomerAsset {

    protected String assetCode;
    protected BigDecimal estimation;
    protected BigDecimal remainingCapital;
    protected String currency;
    protected Boolean competition;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar maturityDate;

    /**
     * Obtient la valeur de la propriété assetCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAssetCode() {
        return assetCode;
    }

    /**
     * Définit la valeur de la propriété assetCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAssetCode(String value) {
        this.assetCode = value;
    }

    /**
     * Obtient la valeur de la propriété estimation.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getEstimation() {
        return estimation;
    }

    /**
     * Définit la valeur de la propriété estimation.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setEstimation(BigDecimal value) {
        this.estimation = value;
    }

    /**
     * Obtient la valeur de la propriété remainingCapital.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getRemainingCapital() {
        return remainingCapital;
    }

    /**
     * Définit la valeur de la propriété remainingCapital.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setRemainingCapital(BigDecimal value) {
        this.remainingCapital = value;
    }

    /**
     * Obtient la valeur de la propriété currency.
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
     * Définit la valeur de la propriété currency.
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
     * Obtient la valeur de la propriété competition.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCompetition() {
        return competition;
    }

    /**
     * Définit la valeur de la propriété competition.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCompetition(Boolean value) {
        this.competition = value;
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

}
