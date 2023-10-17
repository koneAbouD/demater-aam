
package gercustomerproxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour customerGroupAndJob complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="customerGroupAndJob">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="customersGroup" type="{http://soprabanking.com/amplitude}customersGroup" minOccurs="0"/>
 *         &lt;element name="subgroup" type="{http://soprabanking.com/amplitude}customersSubgroup" minOccurs="0"/>
 *         &lt;element name="job" type="{http://soprabanking.com/amplitude}customerJob" minOccurs="0"/>
 *         &lt;element name="subjob" type="{http://soprabanking.com/amplitude}customerSubjob" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customerGroupAndJob", propOrder = {
    "customersGroup",
    "subgroup",
    "job",
    "subjob"
})
public class CustomerGroupAndJob {

    protected CustomersGroup customersGroup;
    protected CustomersSubgroup subgroup;
    protected CustomerJob job;
    protected CustomerSubjob subjob;

    /**
     * Obtient la valeur de la propri�t� customersGroup.
     * 
     * @return
     *     possible object is
     *     {@link CustomersGroup }
     *     
     */
    public CustomersGroup getCustomersGroup() {
        return customersGroup;
    }

    /**
     * D�finit la valeur de la propri�t� customersGroup.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomersGroup }
     *     
     */
    public void setCustomersGroup(CustomersGroup value) {
        this.customersGroup = value;
    }

    /**
     * Obtient la valeur de la propri�t� subgroup.
     * 
     * @return
     *     possible object is
     *     {@link CustomersSubgroup }
     *     
     */
    public CustomersSubgroup getSubgroup() {
        return subgroup;
    }

    /**
     * D�finit la valeur de la propri�t� subgroup.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomersSubgroup }
     *     
     */
    public void setSubgroup(CustomersSubgroup value) {
        this.subgroup = value;
    }

    /**
     * Obtient la valeur de la propri�t� job.
     * 
     * @return
     *     possible object is
     *     {@link CustomerJob }
     *     
     */
    public CustomerJob getJob() {
        return job;
    }

    /**
     * D�finit la valeur de la propri�t� job.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerJob }
     *     
     */
    public void setJob(CustomerJob value) {
        this.job = value;
    }

    /**
     * Obtient la valeur de la propri�t� subjob.
     * 
     * @return
     *     possible object is
     *     {@link CustomerSubjob }
     *     
     */
    public CustomerSubjob getSubjob() {
        return subjob;
    }

    /**
     * D�finit la valeur de la propri�t� subjob.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerSubjob }
     *     
     */
    public void setSubjob(CustomerSubjob value) {
        this.subjob = value;
    }

}
