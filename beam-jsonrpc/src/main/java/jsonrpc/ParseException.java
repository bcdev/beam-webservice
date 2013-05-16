package jsonrpc;

/**
 * @author Norman Fomferra
 */
public class ParseException extends Exception {
    int code;

    public ParseException(int code, String message) {
        super(message);
        this.code = code;
    }

    public ParseException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }
}
