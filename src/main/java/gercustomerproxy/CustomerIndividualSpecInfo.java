
package gercustomerproxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour customerIndividualSpecInfo complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="customerIndividualSpecInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="individualGeneralInfo" type="{http://soprabanking.com/amplitude}customerIndividualGeneralInfo" minOccurs="0"/>
 *         &lt;element name="birth" type="{http://soprabanking.com/amplitude}customerBirth" minOccurs="0"/>
 *         &lt;element name="idPaper" type="{http://soprabanking.com/amplitude}customerIdPaper" minOccurs="0"/>
 *         &lt;element name="territoriality" type="{http://soprabanking.com/amplitude}customerTerritoriality" minOccurs="0"/>
 *         &lt;element name="family" type="{http://soprabanking.com/amplitude}customerFamily" minOccurs="0"/>
 *         &lt;element name="otherAttributes" type="{http://soprabanking.com/amplitude}customerOtherAttributes" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customerIndividualSpecInfo", propOrder = {
    "individualGeneralInfo",
    "birth",
    "idPaper",
    "territoriality",
    "family",
    "otherAttributes"
})
public class CustomerIndividualSpecInfo {

    protected CustomerIndividualGeneralInfo individualGeneralInfo;
    protected CustomerBirth birth;
    protected CustomerIdPaper idPaper;
    protected CustomerTerritoriality territoriality;
    protected CustomerFamily family;
    protected CustomerOtherAttributes otherAttributes;

    /**
     * Obtient la valeur de la propriété individualGeneralInfo.
     * 
     * @return
     *     possible object is
     *     {@link CustomerIndividualGeneralInfo }
     *     
     */
    public CustomerIndividualGeneralInfo getIndividualGeneralInfo() {
        return individualGeneralInfo;
    }

    /**
     * Définit la valeur de la propriété individualGeneralInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerIndividualGeneralInfo }
     *     
     */
    public void setIndividualGeneralInfo(CustomerIndividualGeneralInfo value) {
        this.individualGeneralInfo = value;
    }

    /**
     * Obtient la valeur de la propriété birth.
     * 
     * @return
     *     possible object is
     *     {@link CustomerBirth }
     *     
     */
    public CustomerBirth getBirth() {
        return birth;
    }

    /**
     * Définit la valeur de la propriété birth.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerBirth }
     *     
     */
    public void setBirth(CustomerBirth value) {
        this.birth = value;
    }

    /**
     * Obtient la valeur de la propriété idPaper.
     * 
     * @return
     *     possible object is
     *     {@link CustomerIdPaper }
     *     
     */
    public CustomerIdPaper getIdPaper() {
        return idPaper;
    }

    /**
     * Définit la valeur de la propriété idPaper.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerIdPaper }
     *     
     */
    public void setIdPaper(CustomerIdPaper value) {
        this.idPaper = value;
    }

    /**
     * Obtient la valeur de la propriété territoriality.
     * 
     * @return
     *     possible object is
     *     {@link CustomerTerritoriality }
     *     
     */
    public CustomerTerritoriality getTerritoriality() {
        return territoriality;
    }

    /**
     * Définit la valeur de la propriété territoriality.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerTerritoriality }
     *     
     */
    public void setTerritoriality(CustomerTerritoriality value) {
        this.territoriality = value;
    }

    /**
     * Obtient la valeur de la propriété family.
     * 
     * @return
     *     possible object is
     *     {@link CustomerFamily }
     *     
     */
    public CustomerFamily getFamily() {
        return family;
    }

    /**
     * Définit la valeur de la propriété family.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerFamily }
     *     
     */
    public void setFamily(CustomerFamily value) {
        this.family = value;
    }

    /**
     * Obtient la valeur de la propriété otherAttributes.
     * 
     * @return
     *     possible object is
     *     {@link CustomerOtherAttributes }
     *     
     */
    public CustomerOtherAttributes getOtherAttributes() {
        return otherAttributes;
    }

    /**
     * Définit la valeur de la propriété otherAttributes.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerOtherAttributes }
     *     
     */
    public void setOtherAttributes(CustomerOtherAttributes value) {
        this.otherAttributes = value;
    }

}
