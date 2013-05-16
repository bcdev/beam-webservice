package ex;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Norman Fomferra
 */
public class ObjProxy {
    @JsonProperty
    public long id;

    public ObjProxy(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ObjProxy)) return false;
        ObjProxy ProxyObj = (ObjProxy) o;
        return id == ProxyObj.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
