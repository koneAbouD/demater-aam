
package gercustomerproxy;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */

//Dev
//@WebServiceClient(name = "getCustomerDetail", targetNamespace = "http://soprabanking.com/amplitude", wsdlLocation = "file:/C:/Users/VAS 6/entreprise/Amplitude/getCustomerDetail_1.wsdl")

//    Prod
@WebServiceClient(name = "getCustomerDetail", targetNamespace = "http://soprabanking.com/amplitude", wsdlLocation = "file:/C:/DEMATER/AppDM/Amplitude/getCustomerDetail_1.wsdl")
public class GetCustomerDetail
    extends Service
{

    private final static URL GETCUSTOMERDETAIL_WSDL_LOCATION;
    private final static WebServiceException GETCUSTOMERDETAIL_EXCEPTION;
    private final static QName GETCUSTOMERDETAIL_QNAME = new QName("http://soprabanking.com/amplitude", "getCustomerDetail");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
        // Dev
        //url = new URL("file:/C:/Users/VAS 6/entreprise/Amplitude/getCustomerDetail_1.wsdl");
        //Prod
            url = new URL("file:/C:/DEMATER/AppDM/Amplitude/getCustomerDetail_1.wsdl");

        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        GETCUSTOMERDETAIL_WSDL_LOCATION = url;
        GETCUSTOMERDETAIL_EXCEPTION = e;
    }

    public GetCustomerDetail() {
        super(__getWsdlLocation(), GETCUSTOMERDETAIL_QNAME);
    }

    public GetCustomerDetail(WebServiceFeature... features) {
        super(__getWsdlLocation(), GETCUSTOMERDETAIL_QNAME, features);
    }

    public GetCustomerDetail(URL wsdlLocation) {
        super(wsdlLocation, GETCUSTOMERDETAIL_QNAME);
    }

    public GetCustomerDetail(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, GETCUSTOMERDETAIL_QNAME, features);
    }

    public GetCustomerDetail(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public GetCustomerDetail(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns GetCustomerDetailPortType
     */
    @WebEndpoint(name = "getCustomerDetailPortType")
    public GetCustomerDetailPortType getGetCustomerDetailPortType() {
        return super.getPort(new QName("http://soprabanking.com/amplitude", "getCustomerDetailPortType"), GetCustomerDetailPortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns GetCustomerDetailPortType
     */
    @WebEndpoint(name = "getCustomerDetailPortType")
    public GetCustomerDetailPortType getGetCustomerDetailPortType(WebServiceFeature... features) {
        return super.getPort(new QName("http://soprabanking.com/amplitude", "getCustomerDetailPortType"), GetCustomerDetailPortType.class, features);
    }

    private static URL __getWsdlLocation() {
        if (GETCUSTOMERDETAIL_EXCEPTION!= null) {
            throw GETCUSTOMERDETAIL_EXCEPTION;
        }
        return GETCUSTOMERDETAIL_WSDL_LOCATION;
    }

}