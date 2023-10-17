
package gercustomerproxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java pour customerSituation complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="customerSituation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nationalityCode" type="{http://soprabanking.com/amplitude}nationality" minOccurs="0"/>
 *         &lt;element name="countryOfResidence" type="{http://soprabanking.com/amplitude}country" minOccurs="0"/>
 *         &lt;element name="legalSituation" type="{http://soprabanking.com/amplitude}legalSituation" minOccurs="0"/>
 *         &lt;element name="applicationDateOflegalSituation" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customerSituation", propOrder = {
    "nationalityCode",
    "countryOfResidence",
    "legalSituation",
    "applicationDateOflegalSituation"
})
public class CustomerSituation {

    protected Nationality nationalityCode;
    protected Country countryOfResidence;
    protected LegalSituation legalSituation;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar applicationDateOflegalSituation;

    /**
     * Obtient la valeur de la propri�t� nationalityCode.
     * 
     * @return
     *     possible object is
     *     {@link Nationality }
     *     
     */
    public Nationality getNationalityCode() {
        return nationalityCode;
    }

    /**
     * D�finit la valeur de la propri�t� nationalityCode.
     * 
     * @param value
     *     allowed object is
     *     {@link Nationality }
     *     
     */
    public void setNationalityCode(Nationality value) {
        this.nationalityCode = value;
    }

    /**
     * Obtient la valeur de la propri�t� countryOfResidence.
     * 
     * @return
     *     possible object is
     *     {@link Country }
     *     
     */
    public Country getCountryOfResidence() {
        return countryOfResidence;
    }

    /**
     * D�finit la valeur de la propri�t� countryOfResidence.
     * 
     * @param value
     *     allowed object is
     *     {@link Country }
     *     
     */
    public void setCountryOfResidence(Country value) {
        this.countryOfResidence = value;
    }

    /**
     * Obtient la valeur de la propri�t� legalSituation.
     * 
     * @return
     *     possible object is
     *     {@link LegalSituation }
     *     
     */
    public LegalSituation getLegalSituation() {
        return legalSituation;
    }

    /**
     * D�finit la valeur de la propri�t� legalSituation.
     * 
     * @param value
     *     allowed object is
     *     {@link LegalSituation }
     *     
     */
    public void setLegalSituation(LegalSituation value) {
        this.legalSituation = value;
    }

    /**
     * Obtient la valeur de la propri�t� applicationDateOflegalSituation.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getApplicationDateOflegalSituation() {
        return applicationDateOflegalSituation;
    }

    /**
     * D�finit la valeur de la propri�t� applicationDateOflegalSituation.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setApplicationDateOflegalSituation(XMLGregorianCalendar value) {
        this.applicationDateOflegalSituation = value;
    }

}
