
package createaccountproxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour createAccountRequest complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="createAccountRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountType" type="{http://soprabanking.com/amplitude}accountCreationType"/>
 *         &lt;element name="branchCode" type="{http://soprabanking.com/amplitude}branchCode"/>
 *         &lt;element name="currencyCode" type="{http://soprabanking.com/amplitude}currencyCode"/>
 *         &lt;element name="customerCode" type="{http://soprabanking.com/amplitude}customerCode"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createAccountRequest", propOrder = {
    "accountType",
    "branchCode",
    "currencyCode",
    "customerCode"
})
public class CreateAccountRequest {

    @XmlElement(required = true)
    protected AccountCreationType accountType;
    @XmlElement(required = true)
    protected String branchCode;
    @XmlElement(required = true)
    protected String currencyCode;
    @XmlElement(required = true)
    protected String customerCode;

    /**
     * Obtient la valeur de la propriété accountType.
     * 
     * @return
     *     possible object is
     *     {@link AccountCreationType }
     *     
     */
    public AccountCreationType getAccountType() {
        return accountType;
    }

    /**
     * Définit la valeur de la propriété accountType.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountCreationType }
     *     
     */
    public void setAccountType(AccountCreationType value) {
        this.accountType = value;
    }

    /**
     * Obtient la valeur de la propriété branchCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBranchCode() {
        return branchCode;
    }

    /**
     * Définit la valeur de la propriété branchCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBranchCode(String value) {
        this.branchCode = value;
    }

    /**
     * Obtient la valeur de la propriété currencyCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrencyCode() {
        return currencyCode;
    }

    /**
     * Définit la valeur de la propriété currencyCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrencyCode(String value) {
        this.currencyCode = value;
    }

    /**
     * Obtient la valeur de la propriété customerCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerCode() {
        return customerCode;
    }

    /**
     * Définit la valeur de la propriété customerCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerCode(String value) {
        this.customerCode = value;
    }

}
