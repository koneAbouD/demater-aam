
package createcustomerproxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour customerGroupAndJobCreate complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="customerGroupAndJobCreate">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="customersGroup" type="{http://soprabanking.com/amplitude}customersGroupCode" minOccurs="0"/>
 *         &lt;element name="subgroup" type="{http://soprabanking.com/amplitude}customersSubgroupCode" minOccurs="0"/>
 *         &lt;element name="job" type="{http://soprabanking.com/amplitude}customerJobCode" minOccurs="0"/>
 *         &lt;element name="subjob" type="{http://soprabanking.com/amplitude}customerSubjobCode" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customerGroupAndJobCreate", propOrder = {
    "customersGroup",
    "subgroup",
    "job",
    "subjob"
})
public class CustomerGroupAndJobCreate {

    protected String customersGroup;
    protected String subgroup;
    protected String job;
    protected String subjob;

    /**
     * Obtient la valeur de la propri�t� customersGroup.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomersGroup() {
        return customersGroup;
    }

    /**
     * D�finit la valeur de la propri�t� customersGroup.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomersGroup(String value) {
        this.customersGroup = value;
    }

    /**
     * Obtient la valeur de la propri�t� subgroup.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubgroup() {
        return subgroup;
    }

    /**
     * D�finit la valeur de la propri�t� subgroup.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubgroup(String value) {
        this.subgroup = value;
    }

    /**
     * Obtient la valeur de la propri�t� job.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJob() {
        return job;
    }

    /**
     * D�finit la valeur de la propri�t� job.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJob(String value) {
        this.job = value;
    }

    /**
     * Obtient la valeur de la propri�t� subjob.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubjob() {
        return subjob;
    }

    /**
     * D�finit la valeur de la propri�t� subjob.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubjob(String value) {
        this.subjob = value;
    }

}
