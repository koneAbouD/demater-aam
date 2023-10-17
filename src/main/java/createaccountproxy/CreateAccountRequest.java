
package createaccountproxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour createAccountRequest complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
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
     * Obtient la valeur de la propri�t� accountType.
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
     * D�finit la valeur de la propri�t� accountType.
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
     * Obtient la valeur de la propri�t� branchCode.
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
     * D�finit la valeur de la propri�t� branchCode.
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
     * Obtient la valeur de la propri�t� currencyCode.
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
     * D�finit la valeur de la propri�t� currencyCode.
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
     * Obtient la valeur de la propri�t� customerCode.
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
     * D�finit la valeur de la propri�t� customerCode.
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
