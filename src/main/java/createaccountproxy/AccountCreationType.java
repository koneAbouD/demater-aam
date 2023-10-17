
package createaccountproxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour accountCreationType complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="accountCreationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="file" type="{http://soprabanking.com/amplitude}fileaccountNature" minOccurs="0"/>
 *         &lt;element name="product" type="{http://soprabanking.com/amplitude}accountproduct" minOccurs="0"/>
 *         &lt;element name="customer" type="{http://soprabanking.com/amplitude}customerAccount" minOccurs="0"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "accountCreationType", propOrder = {
    "file",
    "product",
    "customer"
})
public class AccountCreationType {

    protected FileaccountNature file;
    protected Accountproduct product;
    protected CustomerAccount customer;

    /**
     * Obtient la valeur de la propri�t� file.
     * 
     * @return
     *     possible object is
     *     {@link FileaccountNature }
     *     
     */
    public FileaccountNature getFile() {
        return file;
    }

    /**
     * D�finit la valeur de la propri�t� file.
     * 
     * @param value
     *     allowed object is
     *     {@link FileaccountNature }
     *     
     */
    public void setFile(FileaccountNature value) {
        this.file = value;
    }

    /**
     * Obtient la valeur de la propri�t� product.
     * 
     * @return
     *     possible object is
     *     {@link Accountproduct }
     *     
     */
    public Accountproduct getProduct() {
        return product;
    }

    /**
     * D�finit la valeur de la propri�t� product.
     * 
     * @param value
     *     allowed object is
     *     {@link Accountproduct }
     *     
     */
    public void setProduct(Accountproduct value) {
        this.product = value;
    }

    /**
     * Obtient la valeur de la propri�t� customer.
     * 
     * @return
     *     possible object is
     *     {@link CustomerAccount }
     *     
     */
    public CustomerAccount getCustomer() {
        return customer;
    }

    /**
     * D�finit la valeur de la propri�t� customer.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerAccount }
     *     
     */
    public void setCustomer(CustomerAccount value) {
        this.customer = value;
    }

}
