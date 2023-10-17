
package createaccountproxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour accountIdentifierOurBranch complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="accountIdentifierOurBranch">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="internalFormatAccountOurBranch" type="{http://soprabanking.com/amplitude}internalFormatAccountOurBranch" minOccurs="0"/>
 *         &lt;element name="ibanFormatAccount" type="{http://soprabanking.com/amplitude}ibanFormatAccount" minOccurs="0"/>
 *         &lt;element name="externalFormatAccount" type="{http://soprabanking.com/amplitude}externalFormatAccount" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "accountIdentifierOurBranch", propOrder = {
    "internalFormatAccountOurBranch",
    "ibanFormatAccount",
    "externalFormatAccount"
})
public class AccountIdentifierOurBranch {

    protected InternalFormatAccountOurBranch internalFormatAccountOurBranch;
    protected IbanFormatAccount ibanFormatAccount;
    protected ExternalFormatAccount externalFormatAccount;

    /**
     * Obtient la valeur de la propri�t� internalFormatAccountOurBranch.
     * 
     * @return
     *     possible object is
     *     {@link InternalFormatAccountOurBranch }
     *     
     */
    public InternalFormatAccountOurBranch getInternalFormatAccountOurBranch() {
        return internalFormatAccountOurBranch;
    }

    /**
     * D�finit la valeur de la propri�t� internalFormatAccountOurBranch.
     * 
     * @param value
     *     allowed object is
     *     {@link InternalFormatAccountOurBranch }
     *     
     */
    public void setInternalFormatAccountOurBranch(InternalFormatAccountOurBranch value) {
        this.internalFormatAccountOurBranch = value;
    }

    /**
     * Obtient la valeur de la propri�t� ibanFormatAccount.
     * 
     * @return
     *     possible object is
     *     {@link IbanFormatAccount }
     *     
     */
    public IbanFormatAccount getIbanFormatAccount() {
        return ibanFormatAccount;
    }

    /**
     * D�finit la valeur de la propri�t� ibanFormatAccount.
     * 
     * @param value
     *     allowed object is
     *     {@link IbanFormatAccount }
     *     
     */
    public void setIbanFormatAccount(IbanFormatAccount value) {
        this.ibanFormatAccount = value;
    }

    /**
     * Obtient la valeur de la propri�t� externalFormatAccount.
     * 
     * @return
     *     possible object is
     *     {@link ExternalFormatAccount }
     *     
     */
    public ExternalFormatAccount getExternalFormatAccount() {
        return externalFormatAccount;
    }

    /**
     * D�finit la valeur de la propri�t� externalFormatAccount.
     * 
     * @param value
     *     allowed object is
     *     {@link ExternalFormatAccount }
     *     
     */
    public void setExternalFormatAccount(ExternalFormatAccount value) {
        this.externalFormatAccount = value;
    }

}
