
package client;

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
@WebServiceClient(name = "StartServerService", targetNamespace = "http://server/", wsdlLocation = "http://localhost:8080/hand/?wsdl")
public class StartServerService
    extends Service
{

    private final static URL STARTSERVERSERVICE_WSDL_LOCATION;
    private final static WebServiceException STARTSERVERSERVICE_EXCEPTION;
    private final static QName STARTSERVERSERVICE_QNAME = new QName("http://server/", "StartServerService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/hand/?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        STARTSERVERSERVICE_WSDL_LOCATION = url;
        STARTSERVERSERVICE_EXCEPTION = e;
    }

    public StartServerService() {
        super(__getWsdlLocation(), STARTSERVERSERVICE_QNAME);
    }

    public StartServerService(WebServiceFeature... features) {
        super(__getWsdlLocation(), STARTSERVERSERVICE_QNAME, features);
    }

    public StartServerService(URL wsdlLocation) {
        super(wsdlLocation, STARTSERVERSERVICE_QNAME);
    }

    public StartServerService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, STARTSERVERSERVICE_QNAME, features);
    }

    public StartServerService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public StartServerService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns StartServer
     */
    @WebEndpoint(name = "StartServerPort")
    public StartServer getStartServerPort() {
        return super.getPort(new QName("http://server/", "StartServerPort"), StartServer.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns StartServer
     */
    @WebEndpoint(name = "StartServerPort")
    public StartServer getStartServerPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://server/", "StartServerPort"), StartServer.class, features);
    }

    private static URL __getWsdlLocation() {
        if (STARTSERVERSERVICE_EXCEPTION!= null) {
            throw STARTSERVERSERVICE_EXCEPTION;
        }
        return STARTSERVERSERVICE_WSDL_LOCATION;
    }

}
