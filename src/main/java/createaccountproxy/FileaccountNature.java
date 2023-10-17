
package createaccountproxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour fileaccountNature complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="fileaccountNature">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="moduleCode" type="{http://soprabanking.com/amplitude}char3"/>
 *         &lt;element name="accountNature" type="{http://soprabanking.com/amplitude}char3"/>
 *         &lt;element name="fileType" type="{http://soprabanking.com/amplitude}char3" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "fileaccountNature", propOrder = {
    "moduleCode",
    "accountNature",
    "fileType"
})
public class FileaccountNature {

    @XmlElement(required = true)
    protected String moduleCode;
    @XmlElement(required = true)
    protected String accountNature;
    protected String fileType;

    /**
     * Obtient la valeur de la propriété moduleCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModuleCode() {
        return moduleCode;
    }

    /**
     * Définit la valeur de la propriété moduleCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModuleCode(String value) {
        this.moduleCode = value;
    }

    /**
     * Obtient la valeur de la propriété accountNature.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountNature() {
        return accountNature;
    }

    /**
     * Définit la valeur de la propriété accountNature.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountNature(String value) {
        this.accountNature = value;
    }

    /**
     * Obtient la valeur de la propriété fileType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFileType() {
        return fileType;
    }

    /**
     * Définit la valeur de la propriété fileType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFileType(String value) {
        this.fileType = value;
    }

}
