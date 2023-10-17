
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
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
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
     * Obtient la valeur de la propri�t� deletionCode.
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
     * D�finit la valeur de la propri�t� deletionCode.
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
     * Obtient la valeur de la propri�t� userWhoCreated.
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
     * D�finit la valeur de la propri�t� userWhoCreated.
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
     * Obtient la valeur de la propri�t� userWhoInitiated.
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
     * D�finit la valeur de la propri�t� userWhoInitiated.
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
     * Obtient la valeur de la propri�t� creationDate.
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
     * D�finit la valeur de la propri�t� creationDate.
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
     * Obtient la valeur de la propri�t� lastModificationDate.
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
     * D�finit la valeur de la propri�t� lastModificationDate.
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
     * Obtient la valeur de la propri�t� modificationSheetNumber.
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
     * D�finit la valeur de la propri�t� modificationSheetNumber.
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
     * Obtient la valeur de la propri�t� realTimeTransferCode.
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
     * D�finit la valeur de la propri�t� realTimeTransferCode.
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
