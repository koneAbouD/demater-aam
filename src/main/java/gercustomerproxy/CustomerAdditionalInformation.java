
package gercustomerproxy;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java pour customerAdditionalInformation complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="customerAdditionalInformation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="deletionCode" type="{http://soprabanking.com/amplitude}char1" minOccurs="0"/>
 *         &lt;element name="userWhoCreated" type="{http://soprabanking.com/amplitude}charMax10" minOccurs="0"/>
 *         &lt;element name="userWhoInitiated" type="{http://soprabanking.com/amplitude}charMax10" minOccurs="0"/>
 *         &lt;element name="creationDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="lastModificationDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="modificationSheetNumber" type="{http://soprabanking.com/amplitude}decimal4_0" minOccurs="0"/>
 *         &lt;element name="realTimeTransferCode" type="{http://soprabanking.com/amplitude}char1" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customerAdditionalInformation", propOrder = {
    "deletionCode",
    "userWhoCreated",
    "userWhoInitiated",
    "creationDate",
    "lastModificationDate",
    "modificationSheetNumber",
    "realTimeTransferCode"
})
public class CustomerAdditionalInformation {

    protected String deletionCode;
    protected String userWhoCreated;
    protected String userWhoInitiated;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar creationDate;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar lastModificationDate;
    protected BigDecimal modificationSheetNumber;
    protected String realTimeTransferCode;

    /**
     * Obtient la valeur de la propriété deletionCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeletionCode() {
        return deletionCode;
    }

    /**
     * Définit la valeur de la propriété deletionCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeletionCode(String value) {
        this.deletionCode = value;
    }

    /**
     * Obtient la valeur de la propriété userWhoCreated.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserWhoCreated() {
        return userWhoCreated;
    }

    /**
     * Définit la valeur de la propriété userWhoCreated.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserWhoCreated(String value) {
        this.userWhoCreated = value;
    }

    /**
     * Obtient la valeur de la propriété userWhoInitiated.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserWhoInitiated() {
        return userWhoInitiated;
    }

    /**
     * Définit la valeur de la propriété userWhoInitiated.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserWhoInitiated(String value) {
        this.userWhoInitiated = value;
    }

    /**
     * Obtient la valeur de la propriété creationDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreationDate() {
        return creationDate;
    }

    /**
     * Définit la valeur de la propriété creationDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreationDate(XMLGregorianCalendar value) {
        this.creationDate = value;
    }

    /**
     * Obtient la valeur de la propriété lastModificationDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastModificationDate() {
        return lastModificationDate;
    }

    /**
     * Définit la valeur de la propriété lastModificationDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastModificationDate(XMLGregorianCalendar value) {
        this.lastModificationDate = value;
    }

    /**
     * Obtient la valeur de la propriété modificationSheetNumber.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getModificationSheetNumber() {
        return modificationSheetNumber;
    }

    /**
     * Définit la valeur de la propriété modificationSheetNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setModificationSheetNumber(BigDecimal value) {
        this.modificationSheetNumber = value;
    }

    /**
     * Obtient la valeur de la propriété realTimeTransferCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRealTimeTransferCode() {
        return realTimeTransferCode;
    }

    /**
     * Définit la valeur de la propriété realTimeTransferCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRealTimeTransferCode(String value) {
        this.realTimeTransferCode = value;
    }

}
