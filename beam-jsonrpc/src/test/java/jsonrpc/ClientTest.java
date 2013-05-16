package jsonrpc;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Norman Fomferra
 */
public class ClientTest {

    int port = 31415;
    private Server<MathService> server;
    private Client<MathService> client;

    @Before
    public void setUp() throws Exception {
        server = Server.start(port++, MathService.class, new MathServiceImpl());
        Thread.sleep(1000);
        client = new Client<MathService>("localhost", server.getPort(), MathService.class);
    }

    @After
    public void tearDown() throws Exception {
        client.close();
        Thread.sleep(1000);
        server.close();
    }

    @Test
    public void testMathService() throws Exception {
        MathService service = client.getService();
        int result = service.subtract(17, 8);
        Assert.assertEquals(9, result);
    }


}
