
package org.esa.beam.ws.client;

import javax.xml.namespace.QName;
import javax.xml.ws.*;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 */
@WebServiceClient(name = "BeamWebService", targetNamespace = "http://www.brockmann-consult.de/ws/beam", wsdlLocation = "file:/C:/Users/Norman/JavaProjects/beam-webservice/beam-jaxws/beam-jaxws-server/src/main/resources/org/esa/beam/ws/wsdl/BeamWebService.wsdl")
public class BeamWebService_Service
        extends Service {

    private final static URL BEAMWEBSERVICE_WSDL_LOCATION;
    private final static WebServiceException BEAMWEBSERVICE_EXCEPTION;
    private final static QName BEAMWEBSERVICE_QNAME = new QName("http://www.brockmann-consult.de/ws/beam", "BeamWebService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/C:/Users/Norman/JavaProjects/beam-webservice/beam-jaxws/beam-jaxws-server/src/main/resources/org/esa/beam/ws/wsdl/BeamWebService.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        BEAMWEBSERVICE_WSDL_LOCATION = url;
        BEAMWEBSERVICE_EXCEPTION = e;
    }

    public BeamWebService_Service() {
        super(__getWsdlLocation(), BEAMWEBSERVICE_QNAME);
    }

    public BeamWebService_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), BEAMWEBSERVICE_QNAME, features);
    }

    public BeamWebService_Service(URL wsdlLocation) {
        super(wsdlLocation, BEAMWEBSERVICE_QNAME);
    }

    public BeamWebService_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, BEAMWEBSERVICE_QNAME, features);
    }

    public BeamWebService_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public BeamWebService_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * @return returns BeamWebService
     */
    @WebEndpoint(name = "BeamWebServicePort")
    public BeamWebService getBeamWebServicePort() {
        return super.getPort(new QName("http://www.brockmann-consult.de/ws/beam", "BeamWebServicePort"), BeamWebService.class);
    }

    /**
     * @param features A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns BeamWebService
     */
    @WebEndpoint(name = "BeamWebServicePort")
    public BeamWebService getBeamWebServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.brockmann-consult.de/ws/beam", "BeamWebServicePort"), BeamWebService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (BEAMWEBSERVICE_EXCEPTION != null) {
            throw BEAMWEBSERVICE_EXCEPTION;
        }
        return BEAMWEBSERVICE_WSDL_LOCATION;
    }

}
