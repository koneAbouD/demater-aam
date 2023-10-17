
package createcustomerproxy;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour customerIdPapersCreate complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="customerIdPapersCreate">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idPaper" type="{http://soprabanking.com/amplitude}createCustomerIdPaperRequest" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customerIdPapersCreate", propOrder = {
    "idPaper"
})
public class CustomerIdPapersCreate {

    protected List<CreateCustomerIdPaperRequest> idPaper;

    /**
     * Gets the value of the idPaper property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the idPaper property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIdPaper().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CreateCustomerIdPaperRequest }
     * 
     * 
     */
    public List<CreateCustomerIdPaperRequest> getIdPaper() {
        if (idPaper == null) {
            idPaper = new ArrayList<CreateCustomerIdPaperRequest>();
        }
        return this.idPaper;
    }

}
