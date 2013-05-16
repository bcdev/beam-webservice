package ex;

/**
 * @author Norman Fomferra
 */
public interface BeamService {
    ObjId openProduct(String path) throws Exception;

    void closeProduct(ObjId product) throws Exception;

    int getRasterWidth(ObjId product) throws Exception;

    int getRasterHeight(ObjId product) throws Exception;

    String[] getBandNames(ObjId product) throws Exception;

    float[] readPixelsFloat(ObjId product, String bandName, int x, int y, int w, int h) throws Exception;
}
