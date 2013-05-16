package jsonrpc;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Norman Fomferra
 */
public abstract class Server<T> implements AutoCloseable {


    public static <T> Server<T> start(int port, Class<T> serviceInterface, T service) throws Exception {
        ServerImpl<T> server = new ServerImpl<T>(port, serviceInterface, service);
        Thread thread = new Thread(server, serviceInterface.getName() + " Server");
        thread.start();
        return server;
    }

    public abstract int getPort();

    public abstract Class<T> getServiceInterface();

    public abstract T getService();

    @Override
    public abstract void close();

    public static class ServerImpl<T> extends Server<T> implements Runnable {
        private final int port;
        private final Class<T> serviceInterface;
        private final T service;
        private final HashMap<String, Method> methods;

        private ServerSocket serverSocket;
        private Connection connection;
        private boolean closing;

        private ServerImpl(int port, Class<T> serviceInterface, T service) throws Exception {
            this.port = port;
            this.serviceInterface = serviceInterface;
            if (!serviceInterface.isInstance(service)) {
                throw new IllegalArgumentException();
            }

            this.service = service;

            methods = new HashMap<String, Method>();
            Method[] declaredMethods = serviceInterface.getDeclaredMethods();
            for (Method declaredMethod : declaredMethods) {
                methods.put(declaredMethod.getName(), declaredMethod);
            }
        }

        @Override
        public int getPort() {
            return port;
        }

        @Override
        public Class<T> getServiceInterface() {
            return serviceInterface;
        }

        @Override
        public T getService() {
            return service;
        }

        @Override
        public void run() {

            try {
                serverSocket = new ServerSocket(port);
                System.out.println("Server listening on port " + port);
                Socket socket = serverSocket.accept();
                System.out.println("Client connected.");
                connection = new Connection(socket.getInputStream(), socket.getOutputStream());
            } catch (IOException e) {
                System.out.println("I/O error: " + e.getMessage());
                e.printStackTrace();
                return;
            }


            while (!closing) {
                try {
                    waitForRequest();
                } catch (IOException e) {
                    System.out.println("I/O error: " + e.getMessage());
                    e.printStackTrace();
                }
            }

            close();
        }

        private void waitForRequest() throws IOException {
            System.out.println("Waiting for request...");
            Request request;
            Response response;
            try {
                request = connection.readRequest();
                System.out.printf("Valid request received (id=%s). Processing request...%n", request.id);
                response = handleRequest(request);
                if (response.id != null) {
                    System.out.printf("Sending result (id=%s)...%n", request.id);
                    connection.writeResponse(response);
                } else {
                    System.out.println("Processed notification.");
                }
            } catch (ParseException e) {
                System.out.println("Invalid request received.");
                response = new Response(new Response.Error(0, "Invalid Request", e), null);
                System.out.println("Sending error...");
                connection.writeResponse(response);
            }
        }

        private Response handleRequest(Request request) throws IOException {
            if (request.method.equals("sys.shutDown")) {
                closing = true;
                return new Response(closing, request.id);
            } else if (request.method.equals("sys.getMethods")) {
                Method[] methods = service.getClass().getDeclaredMethods();
                Map[] maps = new Map[methods.length];
                for (int i = 0; i < methods.length; i++) {
                    Method method = methods[i];
                    HashMap<String, Object> map = new HashMap<String, Object>();
                    map.put("name", method.getName());
                    map.put("returnType", method.getReturnType().getName());
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    String[] parameterTypeNames = new String[parameterTypes.length];
                    for (int j = 0; j < parameterTypes.length; j++) {
                        Class<?> parameterType = parameterTypes[j];
                        parameterTypeNames[j] = parameterType.getName();
                    }
                    map.put("parameterTypes", parameterTypeNames);
                    maps[i] = map;
                }
                return new Response(maps, request.id);
                // just testing here...
                // return new Response(new byte[256], request.id);
            } else if (request.method.equals("sys.echo")) {
                return new Response(request.params != null && request.params.length > 0 ? request.params[0] : null, request.id);
            }

            Method method = methods.get(request.method);
            if (method == null) {
                String message = "Unrecognized method '" + request.method + "'";
                return new Response(new Response.Error(1, message), request.id);
            }

            try {
                Object result = method.invoke(service, request.params);
                return new Response(result, request.id);
            } catch (IllegalAccessException e) {
                return new Response(new Response.Error(2, "Method invocation error", e), request.id);
            } catch (InvocationTargetException e) {
                return new Response(new Response.Error(2, "Method invocation error", e), request.id);
            }
        }

        @Override
        public void close() {
            if (connection != null) {
                try {
                    System.out.println("Closing connection...");
                    connection.close();
                    connection = null;
                } catch (IOException e) {
                    System.out.println("I/O error: " + e.getMessage());
                    e.printStackTrace();
                }
            }

            if (serverSocket != null) {
                try {
                    System.out.println("Closing server...");
                    serverSocket.close();
                    serverSocket = null;
                } catch (IOException e) {
                    System.out.println("I/O error: " + e.getMessage());
                    e.printStackTrace();
                }
            }

        }
    }
}
