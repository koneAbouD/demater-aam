
package createcustomerproxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour customerFinancialDataInformations complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="customerFinancialDataInformations">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dataType" type="{http://soprabanking.com/amplitude}charMax6"/>
 *         &lt;element name="values" type="{http://soprabanking.com/amplitude}customerFinancialDataValues"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customerFinancialDataInformations", propOrder = {
    "dataType",
    "values"
})
public class CustomerFinancialDataInformations {

    @XmlElement(required = true)
    protected String dataType;
    @XmlElement(required = true)
    protected CustomerFinancialDataValues values;

    /**
     * Obtient la valeur de la propri�t� dataType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataType() {
        return dataType;
    }

    /**
     * D�finit la valeur de la propri�t� dataType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataType(String value) {
        this.dataType = value;
    }

    /**
     * Obtient la valeur de la propri�t� values.
     * 
     * @return
     *     possible object is
     *     {@link CustomerFinancialDataValues }
     *     
     */
    public CustomerFinancialDataValues getValues() {
        return values;
    }

    /**
     * D�finit la valeur de la propri�t� values.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerFinancialDataValues }
     *     
     */
    public void setValues(CustomerFinancialDataValues value) {
        this.values = value;
    }

}
