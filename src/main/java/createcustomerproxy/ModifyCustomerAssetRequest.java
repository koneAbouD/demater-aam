
package createcustomerproxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour modifyCustomerAssetRequest complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="modifyCustomerAssetRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="assetHeader" type="{http://soprabanking.com/amplitude}modifyCustomerAssetHeader" minOccurs="0"/>
 *         &lt;element name="assetsDetail" type="{http://soprabanking.com/amplitude}modifyCustomerAssets" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "modifyCustomerAssetRequest", propOrder = {
    "assetHeader",
    "assetsDetail"
})
public class ModifyCustomerAssetRequest {

    protected ModifyCustomerAssetHeader assetHeader;
    protected ModifyCustomerAssets assetsDetail;

    /**
     * Obtient la valeur de la propri�t� assetHeader.
     * 
     * @return
     *     possible object is
     *     {@link ModifyCustomerAssetHeader }
     *     
     */
    public ModifyCustomerAssetHeader getAssetHeader() {
        return assetHeader;
    }

    /**
     * D�finit la valeur de la propri�t� assetHeader.
     * 
     * @param value
     *     allowed object is
     *     {@link ModifyCustomerAssetHeader }
     *     
     */
    public void setAssetHeader(ModifyCustomerAssetHeader value) {
        this.assetHeader = value;
    }

    /**
     * Obtient la valeur de la propri�t� assetsDetail.
     * 
     * @return
     *     possible object is
     *     {@link ModifyCustomerAssets }
     *     
     */
    public ModifyCustomerAssets getAssetsDetail() {
        return assetsDetail;
    }

    /**
     * D�finit la valeur de la propri�t� assetsDetail.
     * 
     * @param value
     *     allowed object is
     *     {@link ModifyCustomerAssets }
     *     
     */
    public void setAssetsDetail(ModifyCustomerAssets value) {
        this.assetsDetail = value;
    }

}
