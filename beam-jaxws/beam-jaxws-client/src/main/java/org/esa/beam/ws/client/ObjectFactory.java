
package org.esa.beam.ws.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the org.esa.beam.ws.client package.
 * <p>An ObjectFactory allows you to programatically
 * construct new instances of the Java representation
 * for XML content. The Java representation of XML
 * content can consist of schema derived interfaces
 * and classes representing the binding of schema
 * type definitions, element declarations and model
 * groups.  Factory methods for each of these are
 * provided in this class.
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _OpenProduct_QNAME = new QName("http://www.brockmann-consult.de/ws/beam", "openProduct");
    private final static QName _OpenProductResponse_QNAME = new QName("http://www.brockmann-consult.de/ws/beam", "openProductResponse");
    private final static QName _ReadPixelsFloatResponse_QNAME = new QName("http://www.brockmann-consult.de/ws/beam", "readPixelsFloatResponse");
    private final static QName _CloseProduct_QNAME = new QName("http://www.brockmann-consult.de/ws/beam", "closeProduct");
    private final static QName _IOException_QNAME = new QName("http://www.brockmann-consult.de/ws/beam", "IOException");
    private final static QName _ReadPixelsFloat_QNAME = new QName("http://www.brockmann-consult.de/ws/beam", "readPixelsFloat");
    private final static QName _ReadPixelsIntResponse_QNAME = new QName("http://www.brockmann-consult.de/ws/beam", "readPixelsIntResponse");
    private final static QName _CloseProductResponse_QNAME = new QName("http://www.brockmann-consult.de/ws/beam", "closeProductResponse");
    private final static QName _GetBandsResponse_QNAME = new QName("http://www.brockmann-consult.de/ws/beam", "getBandsResponse");
    private final static QName _ReadPixelsInt_QNAME = new QName("http://www.brockmann-consult.de/ws/beam", "readPixelsInt");
    private final static QName _GetBands_QNAME = new QName("http://www.brockmann-consult.de/ws/beam", "getBands");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.esa.beam.ws.client
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link OpenProductResponse }
     */
    public OpenProductResponse createOpenProductResponse() {
        return new OpenProductResponse();
    }

    /**
     * Create an instance of {@link OpenProduct }
     */
    public OpenProduct createOpenProduct() {
        return new OpenProduct();
    }

    /**
     * Create an instance of {@link ReadPixelsFloat }
     */
    public ReadPixelsFloat createReadPixelsFloat() {
        return new ReadPixelsFloat();
    }

    /**
     * Create an instance of {@link IOException }
     */
    public IOException createIOException() {
        return new IOException();
    }

    /**
     * Create an instance of {@link CloseProduct }
     */
    public CloseProduct createCloseProduct() {
        return new CloseProduct();
    }

    /**
     * Create an instance of {@link ReadPixelsFloatResponse }
     */
    public ReadPixelsFloatResponse createReadPixelsFloatResponse() {
        return new ReadPixelsFloatResponse();
    }

    /**
     * Create an instance of {@link ReadPixelsInt }
     */
    public ReadPixelsInt createReadPixelsInt() {
        return new ReadPixelsInt();
    }

    /**
     * Create an instance of {@link GetBandsResponse }
     */
    public GetBandsResponse createGetBandsResponse() {
        return new GetBandsResponse();
    }

    /**
     * Create an instance of {@link CloseProductResponse }
     */
    public CloseProductResponse createCloseProductResponse() {
        return new CloseProductResponse();
    }

    /**
     * Create an instance of {@link ReadPixelsIntResponse }
     */
    public ReadPixelsIntResponse createReadPixelsIntResponse() {
        return new ReadPixelsIntResponse();
    }

    /**
     * Create an instance of {@link GetBands }
     */
    public GetBands createGetBands() {
        return new GetBands();
    }

    /**
     * Create an instance of {@link BandId }
     */
    public BandId createBandId() {
        return new BandId();
    }

    /**
     * Create an instance of {@link ProductId }
     */
    public ProductId createProductId() {
        return new ProductId();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OpenProduct }{@code >}}
     */
    @XmlElementDecl(namespace = "http://www.brockmann-consult.de/ws/beam", name = "openProduct")
    public JAXBElement<OpenProduct> createOpenProduct(OpenProduct value) {
        return new JAXBElement<OpenProduct>(_OpenProduct_QNAME, OpenProduct.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OpenProductResponse }{@code >}}
     */
    @XmlElementDecl(namespace = "http://www.brockmann-consult.de/ws/beam", name = "openProductResponse")
    public JAXBElement<OpenProductResponse> createOpenProductResponse(OpenProductResponse value) {
        return new JAXBElement<OpenProductResponse>(_OpenProductResponse_QNAME, OpenProductResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadPixelsFloatResponse }{@code >}}
     */
    @XmlElementDecl(namespace = "http://www.brockmann-consult.de/ws/beam", name = "readPixelsFloatResponse")
    public JAXBElement<ReadPixelsFloatResponse> createReadPixelsFloatResponse(ReadPixelsFloatResponse value) {
        return new JAXBElement<ReadPixelsFloatResponse>(_ReadPixelsFloatResponse_QNAME, ReadPixelsFloatResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CloseProduct }{@code >}}
     */
    @XmlElementDecl(namespace = "http://www.brockmann-consult.de/ws/beam", name = "closeProduct")
    public JAXBElement<CloseProduct> createCloseProduct(CloseProduct value) {
        return new JAXBElement<CloseProduct>(_CloseProduct_QNAME, CloseProduct.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IOException }{@code >}}
     */
    @XmlElementDecl(namespace = "http://www.brockmann-consult.de/ws/beam", name = "IOException")
    public JAXBElement<IOException> createIOException(IOException value) {
        return new JAXBElement<IOException>(_IOException_QNAME, IOException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadPixelsFloat }{@code >}}
     */
    @XmlElementDecl(namespace = "http://www.brockmann-consult.de/ws/beam", name = "readPixelsFloat")
    public JAXBElement<ReadPixelsFloat> createReadPixelsFloat(ReadPixelsFloat value) {
        return new JAXBElement<ReadPixelsFloat>(_ReadPixelsFloat_QNAME, ReadPixelsFloat.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadPixelsIntResponse }{@code >}}
     */
    @XmlElementDecl(namespace = "http://www.brockmann-consult.de/ws/beam", name = "readPixelsIntResponse")
    public JAXBElement<ReadPixelsIntResponse> createReadPixelsIntResponse(ReadPixelsIntResponse value) {
        return new JAXBElement<ReadPixelsIntResponse>(_ReadPixelsIntResponse_QNAME, ReadPixelsIntResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CloseProductResponse }{@code >}}
     */
    @XmlElementDecl(namespace = "http://www.brockmann-consult.de/ws/beam", name = "closeProductResponse")
    public JAXBElement<CloseProductResponse> createCloseProductResponse(CloseProductResponse value) {
        return new JAXBElement<CloseProductResponse>(_CloseProductResponse_QNAME, CloseProductResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBandsResponse }{@code >}}
     */
    @XmlElementDecl(namespace = "http://www.brockmann-consult.de/ws/beam", name = "getBandsResponse")
    public JAXBElement<GetBandsResponse> createGetBandsResponse(GetBandsResponse value) {
        return new JAXBElement<GetBandsResponse>(_GetBandsResponse_QNAME, GetBandsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadPixelsInt }{@code >}}
     */
    @XmlElementDecl(namespace = "http://www.brockmann-consult.de/ws/beam", name = "readPixelsInt")
    public JAXBElement<ReadPixelsInt> createReadPixelsInt(ReadPixelsInt value) {
        return new JAXBElement<ReadPixelsInt>(_ReadPixelsInt_QNAME, ReadPixelsInt.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBands }{@code >}}
     */
    @XmlElementDecl(namespace = "http://www.brockmann-consult.de/ws/beam", name = "getBands")
    public JAXBElement<GetBands> createGetBands(GetBands value) {
        return new JAXBElement<GetBands>(_GetBands_QNAME, GetBands.class, null, value);
    }

}
