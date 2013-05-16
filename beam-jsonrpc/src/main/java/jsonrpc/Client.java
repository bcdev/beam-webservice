package jsonrpc;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

/**
 * @author Norman Fomferra
 */
public class Client<T> implements InvocationHandler {

    private final T service;
    private final Connection connection;
    private final Socket socket;
    private long currentId;

    public Client(String host, int port, Class<T> serviceInterface) throws Exception {
        this(new Socket(host, port), serviceInterface);
    }

    public Client(Socket socket, Class<T> serviceInterface) throws Exception {
        this.socket = socket;
        service = (T) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{serviceInterface}, this);
        connection = new Connection(socket.getInputStream(), socket.getOutputStream());
    }

    public Socket getSocket() {
        return socket;
    }

    public T getService() {
        return service;
    }

    @Override
    public Object invoke(Object serviceProxy, Method method, Object[] params) throws Throwable {
        long id = ++currentId;
        Request request = new Request(Connection.VERSION, method.getName(), params, id);
        connection.writeRequest(request);
        return waitForResponse(id, method);
    }

    private Object waitForResponse(long id, Method method) throws Exception {
        // todo wait for response with response.id == id
        Response response = connection.readResponse();
        if (response.error != null) {
            throw new Exception(response.error.message);
        }
        return response.result;
    }

    public void close() {
        if (!socket.isClosed()) {
            try {
                socket.close();
            } catch (IOException e) {
                // ok
            }
        }
    }
}
