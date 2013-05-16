package org.esa.beam.ws.server;

import org.esa.beam.framework.dataio.ProductIO;
import org.esa.beam.framework.datamodel.Band;
import org.esa.beam.framework.datamodel.Product;
import org.esa.beam.ws.model.BandId;
import org.esa.beam.ws.model.ProductId;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlMimeType;
import javax.xml.ws.soap.MTOM;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.HashMap;

/**
 * @author Norman Fomferra
 */
@MTOM
@WebService(name = "BeamWebService",
            serviceName = "BeamWebService",
            portName = "BeamWebServicePort",
            targetNamespace = "http://www.brockmann-consult.de/ws/beam")
public class BeamService {

    private final HashMap<String, Product> openProducts;

    public BeamService() {
        this.openProducts = new HashMap<String, Product>();
        System.out.println("Service started: " + this.toString());
    }

    @WebMethod
    public ProductId openProduct(String filePath) throws IOException {
        System.out.println("Opening: " + filePath);
        File file = new File(filePath).getCanonicalFile();
        Product product = getOpenProduct(file);
        if (product == null) {
            product = ProductIO.readProduct(file);
            if (product != null) {
                openProducts.put(file.getPath(), product);
            }
        }
        if (product != null) {
            return new ProductId(product.getSceneRasterWidth(),
                                 product.getSceneRasterHeight(),
                                 file.getPath());
        } else {
            return null;
        }
    }

    @WebMethod
    public void closeProduct(ProductId productId) throws IOException {
        System.out.println("Closing: " + productId.getLocation());
        Product product = getOpenProduct(productId);
        product.closeIO();
        openProducts.remove(productId.getLocation());
    }

    @WebMethod
    public BandId[] getBands(ProductId productId) throws IllegalArgumentException {
        Product product = getOpenProduct(productId);
        Band[] bands = product.getBands();
        BandId[] bandIds = new BandId[bands.length];
        for (int i = 0; i < bandIds.length; i++) {
            Band band = bands[i];
            bandIds[i] = new BandId(band.getName(), band.getUnit(), band.getSpectralWavelength());
        }
        return bandIds;
    }

    @MTOM
    @WebMethod
    @WebResult(name = "pixels")
    @XmlMimeType("application/octet-stream")
    public DataHandler readPixelsFloat(ProductId productId, String bandName, int x, int y, int w, int h) throws IllegalArgumentException, IOException {
        Product product = getOpenProduct(productId);
        Band bands = product.getBand(bandName);
        final float[] rasterData = bands.readPixels(x, y, w, h, (float[]) null);
        return new DataHandler(new FloatArrayDataSource(rasterData));
    }

    @MTOM
    @WebMethod
    @WebResult(name = "pixels")
    @XmlMimeType("application/octet-stream")
    public DataHandler readPixelsInt(@WebParam(name = "productId") ProductId productId,
                                     @WebParam(name = "bandName") String bandName,
                                     @WebParam(name = "x") int x,
                                     @WebParam(name = "y") int y,
                                     @WebParam(name = "w") int w,
                                     @WebParam(name = "h") int h) throws IllegalArgumentException, IOException {
        Product product = getOpenProduct(productId);
        Band bands = product.getBand(bandName);
        int[] rasterData = bands.readPixels(x, y, w, h, (int[]) null);
        return new DataHandler(new IntArrayDataSource(rasterData));
    }

    @WebMethod(exclude = true)
    private Product getOpenProduct(ProductId productId) {
        Product product = getOpenProduct(productId.getLocation());
        if (product == null) {
            throw new IllegalArgumentException(String.format("Product not open: %s", productId.getLocation()));
        }
        return product;
    }

    @WebMethod(exclude = true)
    private Product getOpenProduct(File file) {
        return getOpenProduct(file.getPath());
    }

    @WebMethod(exclude = true)
    private Product getOpenProduct(String path) {
        return openProducts.get(path);
    }


    public static abstract class PrimitiveArrayDataSource implements DataSource {

        @Override
        public String getName() {
            return getClass().getSimpleName();
        }

        @Override
        public String getContentType() {
            return "application/octet-stream";
        }

        @Override
        public OutputStream getOutputStream() throws IOException {
            throw new UnsupportedOperationException();
        }
    }

    public static class IntArrayDataSource extends PrimitiveArrayDataSource {
        private final int[] data;

        public IntArrayDataSource(int[] data) {
            this.data = data;
        }

        @Override
        public InputStream getInputStream() throws IOException {
            IntBuffer buffer = IntBuffer.wrap(data);
            ByteBuffer byteBuffer = ByteBuffer.allocate(data.length * 4);
            byteBuffer.asIntBuffer().put(buffer);
            return new ByteArrayInputStream(byteBuffer.array());
        }
    }

    public static class FloatArrayDataSource extends PrimitiveArrayDataSource {
        private final float[] data;

        public FloatArrayDataSource(float[] data) {
            this.data = data;
        }

        @Override
        public InputStream getInputStream() throws IOException {
            FloatBuffer buffer = FloatBuffer.wrap(data);
            ByteBuffer byteBuffer = ByteBuffer.allocate(data.length * 4);
            byteBuffer.asFloatBuffer().put(buffer);
            return new ByteArrayInputStream(byteBuffer.array());
        }
    }
}