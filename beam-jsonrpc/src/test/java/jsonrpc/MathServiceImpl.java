package jsonrpc;

/**
 * @author Norman Fomferra
 */
public class MathServiceImpl implements MathService {
    @Override
    public int subtract(int x, int y) {
        return x - y;
    }
}
