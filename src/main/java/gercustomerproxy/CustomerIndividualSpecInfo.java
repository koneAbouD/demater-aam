
package gercustomerproxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour customerIndividualSpecInfo complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
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
     * Obtient la valeur de la propri�t� individualGeneralInfo.
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
     * D�finit la valeur de la propri�t� individualGeneralInfo.
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
     * Obtient la valeur de la propri�t� birth.
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
     * D�finit la valeur de la propri�t� birth.
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
     * Obtient la valeur de la propri�t� idPaper.
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
     * D�finit la valeur de la propri�t� idPaper.
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
     * Obtient la valeur de la propri�t� territoriality.
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
     * D�finit la valeur de la propri�t� territoriality.
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
     * Obtient la valeur de la propri�t� family.
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
     * D�finit la valeur de la propri�t� family.
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
     * Obtient la valeur de la propri�t� otherAttributes.
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
     * D�finit la valeur de la propri�t� otherAttributes.
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
