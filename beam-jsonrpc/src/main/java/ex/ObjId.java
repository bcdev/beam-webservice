package ex;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Norman Fomferra
 */
public class ObjId {
    @JsonProperty
    public long key;

    public ObjId(long key) {
        this.key = key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ObjId)) return false;
        ObjId objId = (ObjId) o;
        return key == objId.key;
    }

    @Override
    public int hashCode() {
        return (int) (key ^ (key >>> 32));
    }
}
