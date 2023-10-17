
package createcustomerproxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java pour customerPaymentMethods complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="customerPaymentMethods">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="chequeBookFacilitySuspension" type="{http://soprabanking.com/amplitude}char1" minOccurs="0"/>
 *         &lt;element name="chequeBookFacilitySuspensionDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="withdrawalOfCreditCard" type="{http://soprabanking.com/amplitude}char1" minOccurs="0"/>
 *         &lt;element name="dateOfWithdrawalOfCreditCard" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customerPaymentMethods", propOrder = {
    "chequeBookFacilitySuspension",
    "chequeBookFacilitySuspensionDate",
    "withdrawalOfCreditCard",
    "dateOfWithdrawalOfCreditCard"
})
public class CustomerPaymentMethods {

    protected String chequeBookFacilitySuspension;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar chequeBookFacilitySuspensionDate;
    protected String withdrawalOfCreditCard;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dateOfWithdrawalOfCreditCard;

    /**
     * Obtient la valeur de la propriété chequeBookFacilitySuspension.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChequeBookFacilitySuspension() {
        return chequeBookFacilitySuspension;
    }

    /**
     * Définit la valeur de la propriété chequeBookFacilitySuspension.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChequeBookFacilitySuspension(String value) {
        this.chequeBookFacilitySuspension = value;
    }

    /**
     * Obtient la valeur de la propriété chequeBookFacilitySuspensionDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getChequeBookFacilitySuspensionDate() {
        return chequeBookFacilitySuspensionDate;
    }

    /**
     * Définit la valeur de la propriété chequeBookFacilitySuspensionDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setChequeBookFacilitySuspensionDate(XMLGregorianCalendar value) {
        this.chequeBookFacilitySuspensionDate = value;
    }

    /**
     * Obtient la valeur de la propriété withdrawalOfCreditCard.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWithdrawalOfCreditCard() {
        return withdrawalOfCreditCard;
    }

    /**
     * Définit la valeur de la propriété withdrawalOfCreditCard.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWithdrawalOfCreditCard(String value) {
        this.withdrawalOfCreditCard = value;
    }

    /**
     * Obtient la valeur de la propriété dateOfWithdrawalOfCreditCard.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateOfWithdrawalOfCreditCard() {
        return dateOfWithdrawalOfCreditCard;
    }

    /**
     * Définit la valeur de la propriété dateOfWithdrawalOfCreditCard.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateOfWithdrawalOfCreditCard(XMLGregorianCalendar value) {
        this.dateOfWithdrawalOfCreditCard = value;
    }

}
