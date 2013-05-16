package ex;

/**
 * @author Norman Fomferra
 */
public interface BeamService {
    ObjProxy openProduct(String path) throws Exception;

    void closeProduct(ObjProxy product) throws Exception;

    String[] getBandNames(ObjProxy product) throws Exception;

    float[] readBandData(ObjProxy product, String bandName, int x, int y, int w, int h) throws Exception;
}
