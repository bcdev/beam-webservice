package jsonrpc;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @author Norman Fomferra
 */
public class Request {
    @JsonProperty(value = "jsonrpc", required = false)
    public String version;
    @JsonProperty(required = true)
    public String method;
    @JsonProperty(required = false)
    public Object[] params;
    @JsonProperty(required = true)
    public Object id;

    public Request() {
    }

    public Request(String version, String method, Object[] params, Object id) {
        this.version = version;
        this.method = method;
        this.params = params;
        this.id = id;
    }

    public static Request readFrom(JsonParser parser, ObjectMapper objectMapper) throws IOException, ParseException {
        return objectMapper.readValue(parser, Request.class);
    }

    public void writeTo(JsonGenerator generator, ObjectMapper objectMapper) throws IOException {
        objectMapper.writeValue(generator, this);
    }
}
