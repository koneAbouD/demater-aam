
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
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
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
     * Obtient la valeur de la propri�t� assetCode.
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
     * D�finit la valeur de la propri�t� assetCode.
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
     * Obtient la valeur de la propri�t� estimation.
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
     * D�finit la valeur de la propri�t� estimation.
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
     * Obtient la valeur de la propri�t� remainingCapital.
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
     * D�finit la valeur de la propri�t� remainingCapital.
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
     * Obtient la valeur de la propri�t� competition.
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
     * D�finit la valeur de la propri�t� competition.
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

}
