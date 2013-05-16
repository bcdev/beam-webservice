package jsonrpc;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author Norman Fomferra
 */
public class Response {
    @JsonProperty(value = "jsonrpc", required = false)
    public String version;
    @JsonProperty(required = false)
    public Object result;
    @JsonProperty(required = false)
    public Error error;
    @JsonProperty(required = false)
    public Object id;

    public Response() {
    }

    public Response(Object result, Object id) {
        this(Connection.VERSION, result, null, id);
    }

    public Response(Error error, Object id) {
        this(Connection.VERSION, null, error, id);
    }

    public Response(String version, Object result, Error error, Object id) {
        this.version = version;
        this.result = result;
        this.error = error;
        this.id = id;
    }

    public static Response readFrom(JsonParser parser, ObjectMapper objectMapper) throws IOException, ParseException {
        if (parser.nextToken() != JsonToken.START_OBJECT) {
            throw new ParseException(0, "Expected data to start with an Object, but got " + parser.getText());
        }

        Object id = null;
        Object result = null;
        String version = null;
        Error error = null;

        StringBuffer errorMessage = null;
        while (parser.nextToken() != JsonToken.END_OBJECT) {
            String fieldName = parser.getCurrentName();
            parser.nextToken();
            if (fieldName.equals(Connection.FIELD_ID)) {
                id = objectMapper.readValue(parser, Object.class);
            } else if (fieldName.equals(Connection.FIELD_VERSION)) {
                version = parser.getText();
            } else if (fieldName.equals(Connection.FIELD_RESULT)) {
                result = readResult(parser, objectMapper);
            } else if (fieldName.equals(Connection.FIELD_ERROR)) {
                error = Error.readFrom(parser, objectMapper);
            } else {
                if (errorMessage == null) {
                    errorMessage = new StringBuffer();
                } else {
                    errorMessage.append("\n");
                }
                errorMessage.append(String.format("Unrecognized field '%s'", fieldName));
            }
        }

        if (error == null && errorMessage != null) {
            throw new ParseException(0, errorMessage.toString());
        }

        return new Response(version, result, error, id);
    }

    private static Object readResult(JsonParser parser, ObjectMapper objectMapper) throws IOException {
        return objectMapper.readValue(parser, Object.class);
    }

    public void writeTo(JsonGenerator generator, ObjectMapper objectMapper) throws IOException {
        /*
        objectMapper.enable(SerializationFeature.WRITE_NULL_MAP_VALUES);
        objectMapper.writeValue(generator, this);
        */
        generator.writeStartObject();
        if (version != null) {
            generator.writeStringField(Connection.FIELD_VERSION, version);
        }
        generator.writeObjectField(Connection.FIELD_ID, id);
        if (error != null) {
            error.writeTo(generator, objectMapper);
        } else {
            generator.writeFieldName(Connection.FIELD_RESULT);
            objectMapper.writeValue(generator, result);
        }
        generator.writeEndObject();
    }

    /**
     * @author Norman Fomferra
     */
    public static class Error {
        @JsonProperty(required = true)
        public int code;
        @JsonProperty(required = true)
        public String message;
        @JsonProperty(required = false)
        public Object data;

        public Error(int code, String message, Throwable throwable) {
            this(code, message, getStackTrace(throwable));
        }

        public Error(int code, String message) {
            this(code, message, (String) null);
        }

        private Error(int code, String message, Object data) {
            this.code = code;
            this.message = message;
            this.data = data;
        }

        private static String getStackTrace(Throwable throwable) {
            StringWriter stringWriter = new StringWriter();
            throwable.printStackTrace(new PrintWriter(stringWriter));
            return stringWriter.toString();
        }

        public static Error readFrom(JsonParser parser, ObjectMapper objectMapper) throws IOException {
            return objectMapper.readValue(parser, Error.class);
        }

        public void writeTo(JsonGenerator generator, ObjectMapper objectMapper) throws IOException {
            generator.writeObjectFieldStart(Connection.FIELD_ERROR);
            generator.writeNumberField(Connection.FIELD_ERROR_CODE, code);
            generator.writeStringField(Connection.FIELD_ERROR_MESSAGE, message);
            if (data != null) {
                generator.writeFieldName(Connection.FIELD_ERROR_DATA);
                objectMapper.writeValue(generator, data);
            }
            generator.writeEndObject();
        }
    }
}
