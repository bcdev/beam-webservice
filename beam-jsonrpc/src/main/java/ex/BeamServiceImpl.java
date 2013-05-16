package ex;

import org.esa.beam.framework.dataio.ProductIO;
import org.esa.beam.framework.datamodel.Band;
import org.esa.beam.framework.datamodel.Product;

import java.util.HashMap;

/**
 * @author Norman Fomferra
 */
public class BeamServiceImpl implements BeamService {
    private final HashMap<ObjId, Object> objects;
    private long lastObjKey;

    public BeamServiceImpl() {
        objects = new HashMap<ObjId, Object>(10000);
    }

    @Override
    public ObjId openProduct(String path) throws Exception {
        Product product = ProductIO.readProduct(path);
        if (product == null) {
            return null;
        }
        return newObject(product);
    }

    @Override
    public void closeProduct(ObjId productId) throws Exception {
        Product product = getObject(productId, Product.class);
        product.closeIO();
        removeObject(productId);
    }

    @Override
    public int getRasterWidth(ObjId productId) throws Exception {
        Product product = getObject(productId, Product.class);
        return product.getSceneRasterWidth();
    }

    @Override
    public int getRasterHeight(ObjId productId) throws Exception {
        Product product = getObject(productId, Product.class);
        return product.getSceneRasterHeight();
    }

    @Override
    public String[] getBandNames(ObjId productId) throws Exception {
        Product product = getObject(productId, Product.class);
        return product.getBandNames();
    }

    @Override
    public float[] readPixelsFloat(ObjId productId, String bandName, int x, int y, int w, int h) throws Exception {
        Product product = getObject(productId, Product.class);
        Band band = product.getBand(bandName);
        return band.readPixels(x, y, w, h, (float[]) null);
    }

    private ObjId newObject(Object object) {
        lastObjKey++;
        ObjId objId = new ObjId(lastObjKey);
        objects.put(objId, object);
        return objId;
    }

    private <T> T getObject(ObjId objId, Class<T> type) {
        Object object = objects.get(objId);
        if (object == null) {
            throw new NullPointerException();
        }
        if (!type.isAssignableFrom(object.getClass())) {
            throw new IllegalArgumentException();
        }
        return (T) object;
    }

    private void removeObject(ObjId objId) {
        objects.remove(objId);
    }
}
