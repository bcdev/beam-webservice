package ex;

import jsonrpc.Server;

/**
 * @author Norman Fomferra
 */
public class BeamServer {

    public static final int PORT = 31415;

    public static void main(String[] args) throws Exception {
        Server.start(PORT, BeamService.class, new BeamServiceImpl());
    }
}
