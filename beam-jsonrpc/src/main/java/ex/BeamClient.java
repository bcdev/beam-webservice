package ex;

import jsonrpc.Client;

/**
 * @author Norman Fomferra
 */
public class BeamClient {

    public static void main(String[] args) throws Exception {

        Client<BeamService> client = new Client<BeamService>("localhost", BeamServer.PORT, BeamService.class);
        BeamService s = client.getService();

        String[] inputs = {
                "C:\\Users\\Norman\\BC\\EOData\\binning_L1\\MER_RR__1PPBCM20110803.N1",
                "C:\\Users\\Norman\\BC\\EOData\\binning_L1\\MER_RR__1PPBCM20110805.N1",
                "C:\\Users\\Norman\\BC\\EOData\\binning_L1\\MER_RR__1PPBCM20110806.N1",
        };

        ObjId[] productIds = new ObjId[inputs.length];
        for (int i = 0; i < inputs.length; i++) {
            String input = inputs[i];
            ObjId productId = s.openProduct(input);
            productIds[i] = productId;
            System.out.println("productId = " + productId);
            if (productId == null) {
                return;
            }
            int w = s.getRasterWidth(productId);
            int h = s.getRasterHeight(productId);
            String[] bandNames = s.getBandNames(productId);
            for (String bandName : bandNames) {
                System.out.println("band = " + bandName);
                float[] data = s.readPixelsFloat(productId, bandName, 0, 0, w, h);
                System.out.println(data.length * 4 + " bytes read");
            }

        }

        for (ObjId productId : productIds) {
            s.closeProduct(productId);
        }
    }


}
