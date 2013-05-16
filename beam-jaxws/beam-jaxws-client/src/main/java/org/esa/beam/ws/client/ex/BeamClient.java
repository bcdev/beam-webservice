package org.esa.beam.ws.client.ex;

import org.esa.beam.ws.client.*;

import javax.activation.DataHandler;
import java.io.ByteArrayOutputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.List;

/**
 * @author Norman Fomferra
 */
public class BeamClient {

    public static final String URL = "http://localhost:9202/beam";

    public static void main(String[] args) throws java.io.IOException, IOException_Exception {
        //BeamWebService_Service service = new BeamWebService_Service(new URL(URL), new MTOMFeature());
        BeamWebService_Service service = new BeamWebService_Service(new URL(URL));
        BeamWebService s = service.getBeamWebServicePort();
        String[] inputs = {
                "C:\\Users\\Norman\\BC\\EOData\\binning_L1\\MER_RR__1PPBCM20110803.N1",
                "C:\\Users\\Norman\\BC\\EOData\\binning_L1\\MER_RR__1PPBCM20110805.N1",
                "C:\\Users\\Norman\\BC\\EOData\\binning_L1\\MER_RR__1PPBCM20110806.N1",
        };
        ProductId[] productIds = new ProductId[inputs.length];
        for (int i = 0; i < inputs.length; i++) {
            String input = inputs[i];
            ProductId productId = s.openProduct(input);
            productIds[i] = productId;
            System.out.println("productId = " + productId);
            if (productId == null) {
                return;
            }
            int w = productId.getRasterWidth();
            int h = productId.getRasterHeight();
            List<BandId> bands = s.getBands(productId);
            for (BandId band : bands) {
                System.out.println("band = " + band.getName());
                DataHandler dataHandler = s.readPixelsFloat(productId, band.getName(), 0, 0, w, h);
                ByteArrayOutputStream os = new ByteArrayOutputStream();
                dataHandler.writeTo(os);
                byte[] bytes = os.toByteArray();
                ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
                float[] dst = new float[w * h];
                byteBuffer.asFloatBuffer().get(dst);
                System.out.println(bytes.length + " bytes read");
            }

        }

        for (ProductId productId : productIds) {
            s.closeProduct(productId);
        }

    }
}
