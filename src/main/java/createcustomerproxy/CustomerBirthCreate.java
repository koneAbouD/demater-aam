
package createcustomerproxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java pour customerBirthCreate complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="customerBirthCreate">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="holderSex" type="{http://soprabanking.com/amplitude}sex" minOccurs="0"/>
 *         &lt;element name="maidenName" type="{http://soprabanking.com/amplitude}charMax36" minOccurs="0"/>
 *         &lt;element name="birthDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="birthCity" type="{http://soprabanking.com/amplitude}charMax30" minOccurs="0"/>
 *         &lt;element name="birthCounty" type="{http://soprabanking.com/amplitude}charMax30" minOccurs="0"/>
 *         &lt;element name="birthRegion" type="{http://soprabanking.com/amplitude}charMax50" minOccurs="0"/>
 *         &lt;element name="birthCountry" type="{http://soprabanking.com/amplitude}countryCode" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customerBirthCreate", propOrder = {
    "holderSex",
    "maidenName",
    "birthDate",
    "birthCity",
    "birthCounty",
    "birthRegion",
    "birthCountry"
})
public class CustomerBirthCreate {

    protected String holderSex;
    protected String maidenName;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar birthDate;
    protected String birthCity;
    protected String birthCounty;
    protected String birthRegion;
    protected String birthCountry;

    /**
     * Obtient la valeur de la propri�t� holderSex.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHolderSex() {
        return holderSex;
    }

    /**
     * D�finit la valeur de la propri�t� holderSex.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHolderSex(String value) {
        this.holderSex = value;
    }

    /**
     * Obtient la valeur de la propri�t� maidenName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaidenName() {
        return maidenName;
    }

    /**
     * D�finit la valeur de la propri�t� maidenName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaidenName(String value) {
        this.maidenName = value;
    }

    /**
     * Obtient la valeur de la propri�t� birthDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getBirthDate() {
        return birthDate;
    }

    /**
     * D�finit la valeur de la propri�t� birthDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setBirthDate(XMLGregorianCalendar value) {
        this.birthDate = value;
    }

    /**
     * Obtient la valeur de la propri�t� birthCity.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBirthCity() {
        return birthCity;
    }

    /**
     * D�finit la valeur de la propri�t� birthCity.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBirthCity(String value) {
        this.birthCity = value;
    }

    /**
     * Obtient la valeur de la propri�t� birthCounty.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBirthCounty() {
        return birthCounty;
    }

    /**
     * D�finit la valeur de la propri�t� birthCounty.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBirthCounty(String value) {
        this.birthCounty = value;
    }

    /**
     * Obtient la valeur de la propri�t� birthRegion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBirthRegion() {
        return birthRegion;
    }

    /**
     * D�finit la valeur de la propri�t� birthRegion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBirthRegion(String value) {
        this.birthRegion = value;
    }

    /**
     * Obtient la valeur de la propri�t� birthCountry.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBirthCountry() {
        return birthCountry;
    }

    /**
     * D�finit la valeur de la propri�t� birthCountry.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBirthCountry(String value) {
        this.birthCountry = value;
    }

}
