
package createcustomerproxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java pour customerSituationCreate complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="customerSituationCreate">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nationalityCode" type="{http://soprabanking.com/amplitude}nationalityCode" minOccurs="0"/>
 *         &lt;element name="countryOfResidence" type="{http://soprabanking.com/amplitude}countryCode" minOccurs="0"/>
 *         &lt;element name="legalSituation" type="{http://soprabanking.com/amplitude}legalSituationCode" minOccurs="0"/>
 *         &lt;element name="applicationDateOfLegalSituation" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customerSituationCreate", propOrder = {
    "nationalityCode",
    "countryOfResidence",
    "legalSituation",
    "applicationDateOfLegalSituation"
})
public class CustomerSituationCreate {

    protected String nationalityCode;
    protected String countryOfResidence;
    protected String legalSituation;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar applicationDateOfLegalSituation;

    /**
     * Obtient la valeur de la propri�t� nationalityCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNationalityCode() {
        return nationalityCode;
    }

    /**
     * D�finit la valeur de la propri�t� nationalityCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNationalityCode(String value) {
        this.nationalityCode = value;
    }

    /**
     * Obtient la valeur de la propri�t� countryOfResidence.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountryOfResidence() {
        return countryOfResidence;
    }

    /**
     * D�finit la valeur de la propri�t� countryOfResidence.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountryOfResidence(String value) {
        this.countryOfResidence = value;
    }

    /**
     * Obtient la valeur de la propri�t� legalSituation.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLegalSituation() {
        return legalSituation;
    }

    /**
     * D�finit la valeur de la propri�t� legalSituation.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLegalSituation(String value) {
        this.legalSituation = value;
    }

    /**
     * Obtient la valeur de la propri�t� applicationDateOfLegalSituation.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getApplicationDateOfLegalSituation() {
        return applicationDateOfLegalSituation;
    }

    /**
     * D�finit la valeur de la propri�t� applicationDateOfLegalSituation.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setApplicationDateOfLegalSituation(XMLGregorianCalendar value) {
        this.applicationDateOfLegalSituation = value;
    }

}
