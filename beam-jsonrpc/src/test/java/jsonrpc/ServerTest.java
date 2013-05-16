package jsonrpc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.net.Socket;

import static org.junit.Assert.assertEquals;

/**
 * @author Norman Fomferra
 */
public class ServerTest {
    static boolean TRACE = true;

    int port = 31415;
    private Server<MathService> server;
    private BufferedReader reader;
    private BufferedWriter writer;

    @Before
    public void setUp() throws Exception {
        server = Server.start(port++, MathService.class, new MathServiceImpl());
        Thread.sleep(1000);
        Socket socket = new Socket("localhost", server.getPort());
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
    }

    @After
    public void tearDown() throws Exception {
        server.close();
    }

    @Test
    public void testInbuiltMethods() throws Exception {


        testResponseForRequest("{" +
                                       "\"jsonrpc\": \"2.0\", " +
                                       "\"id\": 13, " +
                                       "\"method\": \"sys.echo\", " +
                                       "\"params\": [\"Hello World!\"] " +
                                       "}",
                               "{" +
                                       "\"jsonrpc\":\"2.0\"," +
                                       "\"id\":13," +
                                       "\"result\":\"Hello World!\"" +
                                       "}");

        testResponseForRequest("{" +
                                       "\"jsonrpc\": \"2.0\", " +
                                       "\"id\":14, " +
                                       "\"method\":\"sys.getMethods\" " +
                                       "}",
                               "{" +
                                       "\"jsonrpc\":\"2.0\"," +
                                       "\"id\":14," +
                                       "\"result\":[{" +
                                       "\"name\":\"subtract\"," +
                                       "\"returnType\":\"int\"," +
                                       "\"parameterTypes\":[\"int\",\"int\"]" +
                                       "}]" +
                                       "}");

        testResponseForRequest("{ " +
                                       "\"jsonrpc\": \"2.0\", " +
                                       "\"id\":15, " +
                                       "\"method\":\"sys.getCoolDrink\" " +
                                       "}",
                               "{" +
                                       "\"jsonrpc\":\"2.0\"," +
                                       "\"id\":15," +
                                       "\"error\":{\"code\":1,\"message\":\"Unrecognized method 'sys.getCoolDrink'\"}" +
                                       "}");


    }

    @Test
    public void testMathService() throws Exception {
        testResponseForRequest("{ " +
                                       "\"jsonrpc\": \"2.0\", " +
                                       "\"id\":15, " +
                                       "\"method\":\"subtract\", " +
                                       "\"params\": [17, 8]" +
                                       "}",
                               "{" +
                                       "\"jsonrpc\":\"2.0\"," +
                                       "\"id\":15," +
                                       "\"result\":9" +
                                       "}");
    }

    private void testResponseForRequest(String request, String expectedResponse) throws IOException {
        String response = getResponseForRequest(request);
        assertEquals(expectedResponse, response);
    }

    private String getResponseForRequest(String request) throws IOException {
        if (TRACE) {
            System.out.println("--> " + request);
        }
        writer.write(request);
        writer.flush();
        String response = reader.readLine().trim();
        if (TRACE) {
            System.out.println("<-- " + response);
        }
        return response;
    }

}
