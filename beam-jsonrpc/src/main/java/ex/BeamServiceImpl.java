package ex;

import org.esa.beam.framework.dataio.ProductIO;
import org.esa.beam.framework.datamodel.Product;

import java.util.HashMap;

/**
 * @author Norman Fomferra
 */
public class BeamServiceImpl implements BeamService {
    HashMap<ObjProxy, Object> objects;
    long currentKey;

    @Override
    public ObjProxy openProduct(String path) throws Exception {
        Product product = ProductIO.readProduct(path);
        if (product == null) {
            return null;
        }
        return newObject(product);
    }

    @Override
    public void closeProduct(ObjProxy productId) throws Exception {
        Product product = getObject(productId, Product.class);
        product.closeIO();
        removeObject(productId);
    }

    @Override
    public String[] getBandNames(ObjProxy productId) throws Exception {
        Product product = getObject(productId, Product.class);
        return product.getBandNames();
    }

    @Override
    public float[] readBandData(ObjProxy product, String bandName, int x, int y, int w, int h) {
        return new float[0];
    }

    private ObjProxy newObject(Object o) {
        ObjProxy key = new ObjProxy(++currentKey);
        objects.put(key, o);
        return key;
    }

    private <T> T getObject(ObjProxy id, Class<T> productClass) {
        Object o = objects.get(id);
        if (o == null) {
            throw new NullPointerException();
        }
        if (!productClass.isAssignableFrom(o.getClass())) {
            throw new IllegalArgumentException();
        }
        return (T) o;
    }

    private void removeObject(ObjProxy id) {
        objects.remove(id);
    }
}
