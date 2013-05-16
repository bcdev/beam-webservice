package jsonrpc;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * JSON-RPC as specified at http://www.jsonrpc.org/specification
 *
 * @author Norman Fomferra
 */
public class Connection {

    public static final String VERSION = "2.0";

    public static final String FIELD_VERSION = "jsonrpc";
    public static final String FIELD_RESULT = "result";
    public static final String FIELD_ERROR = "error";
    public static final String FIELD_ERROR_CODE = "code";
    public static final String FIELD_ERROR_MESSAGE = "message";
    public static final String FIELD_ERROR_DATA = "data";
    public static final String FIELD_ID = "id";
    public static final String FIELD_METHOD = "method";
    public static final String FIELD_PARAMS = "params";

    private final JsonFactory jsonFactory;
    private final InputStream inputStream;
    private final OutputStream outputStream;
    private JsonParser parser;
    private JsonGenerator generator;
    private final ObjectMapper objectMapper;

    public Connection(InputStream inputStream, OutputStream outputStream) {
        this.jsonFactory = new JsonFactory();
        jsonFactory.disable(JsonParser.Feature.AUTO_CLOSE_SOURCE);
        jsonFactory.disable(JsonGenerator.Feature.AUTO_CLOSE_TARGET);
        this.inputStream = inputStream;
        this.outputStream = outputStream;
        this.objectMapper = new ObjectMapper(jsonFactory);
    }

    public Request readRequest() throws IOException, ParseException {
        return Request.readFrom(getParser(), getObjectMapper());
    }

    public void writeRequest(Request request) throws IOException {
        request.writeTo(getGenerator(), getObjectMapper());
        getGenerator().writeRaw('\n');
        getGenerator().flush();
    }

    public Response readResponse() throws IOException, ParseException {
        return Response.readFrom(getParser(), getObjectMapper());
    }

    public void writeResponse(Response response) throws IOException {
        response.writeTo(getGenerator(), getObjectMapper());
        getGenerator().writeRaw('\n');
        getGenerator().flush();
    }

    public void close() throws IOException {
        getGenerator().close();
        getParser().close();
    }

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    public JsonParser getParser() throws IOException {
        if (parser == null) {
            parser = jsonFactory.createParser(inputStream);
        }
        return parser;
    }

    public JsonGenerator getGenerator() throws IOException {
        if (generator == null) {
            generator = jsonFactory.createGenerator(outputStream);
        }
        return generator;
    }
}
