
package co.gov.banrep.kepiaa.menu.webservice;

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
 * JAX-WS RI 2.3.2
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "AdministradorMenuWSPortBindingQSService", targetNamespace = "http://banrep.gov.co/s3", wsdlLocation = "http://localhost:9090/ServiciosS3/DemeMenu?WSDL")
public class AdministradorMenuWSPortBindingQSService
    extends Service
{

    private final static URL ADMINISTRADORMENUWSPORTBINDINGQSSERVICE_WSDL_LOCATION;
    private final static WebServiceException ADMINISTRADORMENUWSPORTBINDINGQSSERVICE_EXCEPTION;
    private final static QName ADMINISTRADORMENUWSPORTBINDINGQSSERVICE_QNAME = new QName("http://banrep.gov.co/s3", "AdministradorMenuWSPortBindingQSService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:9090/ServiciosS3/DemeMenu?WSDL");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        ADMINISTRADORMENUWSPORTBINDINGQSSERVICE_WSDL_LOCATION = url;
        ADMINISTRADORMENUWSPORTBINDINGQSSERVICE_EXCEPTION = e;
    }

    public AdministradorMenuWSPortBindingQSService() {
        super(__getWsdlLocation(), ADMINISTRADORMENUWSPORTBINDINGQSSERVICE_QNAME);
    }

    public AdministradorMenuWSPortBindingQSService(WebServiceFeature... features) {
        super(__getWsdlLocation(), ADMINISTRADORMENUWSPORTBINDINGQSSERVICE_QNAME, features);
    }

    public AdministradorMenuWSPortBindingQSService(URL wsdlLocation) {
        super(wsdlLocation, ADMINISTRADORMENUWSPORTBINDINGQSSERVICE_QNAME);
    }

    public AdministradorMenuWSPortBindingQSService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, ADMINISTRADORMENUWSPORTBINDINGQSSERVICE_QNAME, features);
    }

    public AdministradorMenuWSPortBindingQSService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public AdministradorMenuWSPortBindingQSService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns AdministradorMenuWS
     */
    @WebEndpoint(name = "AdministradorMenuWSPortBindingQSPort")
    public AdministradorMenuWS getAdministradorMenuWSPortBindingQSPort() {
        return super.getPort(new QName("http://banrep.gov.co/s3", "AdministradorMenuWSPortBindingQSPort"), AdministradorMenuWS.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns AdministradorMenuWS
     */
    @WebEndpoint(name = "AdministradorMenuWSPortBindingQSPort")
    public AdministradorMenuWS getAdministradorMenuWSPortBindingQSPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://banrep.gov.co/s3", "AdministradorMenuWSPortBindingQSPort"), AdministradorMenuWS.class, features);
    }

    private static URL __getWsdlLocation() {
        if (ADMINISTRADORMENUWSPORTBINDINGQSSERVICE_EXCEPTION!= null) {
            throw ADMINISTRADORMENUWSPORTBINDINGQSSERVICE_EXCEPTION;
        }
        return ADMINISTRADORMENUWSPORTBINDINGQSSERVICE_WSDL_LOCATION;
    }

}
