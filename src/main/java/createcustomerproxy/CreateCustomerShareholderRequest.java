
package createcustomerproxy;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour createCustomerShareholderRequest complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="createCustomerShareholderRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="identifier" type="{http://soprabanking.com/amplitude}shareholderCreateIdentifier"/>
 *         &lt;element name="shares" type="{http://soprabanking.com/amplitude}decimal5_2" minOccurs="0"/>
 *         &lt;element name="marketType" type="{http://soprabanking.com/amplitude}marketType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createCustomerShareholderRequest", propOrder = {
    "identifier",
    "shares",
    "marketType"
})
public class CreateCustomerShareholderRequest {

    @XmlElement(required = true)
    protected ShareholderCreateIdentifier identifier;
    protected BigDecimal shares;
    @XmlSchemaType(name = "string")
    protected MarketType marketType;

    /**
     * Obtient la valeur de la propriété identifier.
     * 
     * @return
     *     possible object is
     *     {@link ShareholderCreateIdentifier }
     *     
     */
    public ShareholderCreateIdentifier getIdentifier() {
        return identifier;
    }

    /**
     * Définit la valeur de la propriété identifier.
     * 
     * @param value
     *     allowed object is
     *     {@link ShareholderCreateIdentifier }
     *     
     */
    public void setIdentifier(ShareholderCreateIdentifier value) {
        this.identifier = value;
    }

    /**
     * Obtient la valeur de la propriété shares.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getShares() {
        return shares;
    }

    /**
     * Définit la valeur de la propriété shares.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setShares(BigDecimal value) {
        this.shares = value;
    }

    /**
     * Obtient la valeur de la propriété marketType.
     * 
     * @return
     *     possible object is
     *     {@link MarketType }
     *     
     */
    public MarketType getMarketType() {
        return marketType;
    }

    /**
     * Définit la valeur de la propriété marketType.
     * 
     * @param value
     *     allowed object is
     *     {@link MarketType }
     *     
     */
    public void setMarketType(MarketType value) {
        this.marketType = value;
    }

}
