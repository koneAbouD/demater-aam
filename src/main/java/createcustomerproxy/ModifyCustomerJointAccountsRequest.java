
package createcustomerproxy;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour modifyCustomerJointAccountsRequest complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="modifyCustomerJointAccountsRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="mainCustomerCode" type="{http://soprabanking.com/amplitude}customerCode" minOccurs="0"/>
 *         &lt;element name="customerJointAccount" type="{http://soprabanking.com/amplitude}customerJointAccountInformations" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "modifyCustomerJointAccountsRequest", propOrder = {
    "mainCustomerCode",
    "customerJointAccount"
})
public class ModifyCustomerJointAccountsRequest {

    protected String mainCustomerCode;
    protected List<CustomerJointAccountInformations> customerJointAccount;

    /**
     * Obtient la valeur de la propriété mainCustomerCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMainCustomerCode() {
        return mainCustomerCode;
    }

    /**
     * Définit la valeur de la propriété mainCustomerCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMainCustomerCode(String value) {
        this.mainCustomerCode = value;
    }

    /**
     * Gets the value of the customerJointAccount property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the customerJointAccount property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCustomerJointAccount().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CustomerJointAccountInformations }
     * 
     * 
     */
    public List<CustomerJointAccountInformations> getCustomerJointAccount() {
        if (customerJointAccount == null) {
            customerJointAccount = new ArrayList<CustomerJointAccountInformations>();
        }
        return this.customerJointAccount;
    }

}
