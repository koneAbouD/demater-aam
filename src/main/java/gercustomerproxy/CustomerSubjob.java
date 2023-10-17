
package gercustomerproxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour customerSubjob complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="customerSubjob">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="jobCode" type="{http://soprabanking.com/amplitude}charMax6" minOccurs="0"/>
 *         &lt;element name="subjobCode" type="{http://soprabanking.com/amplitude}charMax6" minOccurs="0"/>
 *         &lt;element name="subjobName" type="{http://soprabanking.com/amplitude}charMax36" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customerSubjob", propOrder = {
    "jobCode",
    "subjobCode",
    "subjobName"
})
public class CustomerSubjob {

    protected String jobCode;
    protected String subjobCode;
    protected String subjobName;

    /**
     * Obtient la valeur de la propriété jobCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJobCode() {
        return jobCode;
    }

    /**
     * Définit la valeur de la propriété jobCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJobCode(String value) {
        this.jobCode = value;
    }

    /**
     * Obtient la valeur de la propriété subjobCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubjobCode() {
        return subjobCode;
    }

    /**
     * Définit la valeur de la propriété subjobCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubjobCode(String value) {
        this.subjobCode = value;
    }

    /**
     * Obtient la valeur de la propriété subjobName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubjobName() {
        return subjobName;
    }

    /**
     * Définit la valeur de la propriété subjobName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubjobName(String value) {
        this.subjobName = value;
    }

}
