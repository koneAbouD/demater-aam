
package createcustomerproxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java pour customerProfessionAndIncomesInformations complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="customerProfessionAndIncomesInformations">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="hireDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="professionCode" type="{http://soprabanking.com/amplitude}professionCode" minOccurs="0"/>
 *         &lt;element name="employerCode" type="{http://soprabanking.com/amplitude}employerCode" minOccurs="0"/>
 *         &lt;element name="incomesBracketCode" type="{http://soprabanking.com/amplitude}incomesBracketCode" minOccurs="0"/>
 *         &lt;element name="employerDepartment" type="{http://soprabanking.com/amplitude}charMax30" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customerProfessionAndIncomesInformations", propOrder = {
    "hireDate",
    "professionCode",
    "employerCode",
    "incomesBracketCode",
    "employerDepartment"
})
public class CustomerProfessionAndIncomesInformations {

    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar hireDate;
    protected String professionCode;
    protected String employerCode;
    protected String incomesBracketCode;
    protected String employerDepartment;

    /**
     * Obtient la valeur de la propri�t� hireDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getHireDate() {
        return hireDate;
    }

    /**
     * D�finit la valeur de la propri�t� hireDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setHireDate(XMLGregorianCalendar value) {
        this.hireDate = value;
    }

    /**
     * Obtient la valeur de la propri�t� professionCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProfessionCode() {
        return professionCode;
    }

    /**
     * D�finit la valeur de la propri�t� professionCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProfessionCode(String value) {
        this.professionCode = value;
    }

    /**
     * Obtient la valeur de la propri�t� employerCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmployerCode() {
        return employerCode;
    }

    /**
     * D�finit la valeur de la propri�t� employerCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmployerCode(String value) {
        this.employerCode = value;
    }

    /**
     * Obtient la valeur de la propri�t� incomesBracketCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIncomesBracketCode() {
        return incomesBracketCode;
    }

    /**
     * D�finit la valeur de la propri�t� incomesBracketCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIncomesBracketCode(String value) {
        this.incomesBracketCode = value;
    }

    /**
     * Obtient la valeur de la propri�t� employerDepartment.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmployerDepartment() {
        return employerDepartment;
    }

    /**
     * D�finit la valeur de la propri�t� employerDepartment.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmployerDepartment(String value) {
        this.employerDepartment = value;
    }

}
