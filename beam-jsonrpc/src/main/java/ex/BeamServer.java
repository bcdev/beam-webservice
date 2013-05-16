package ex;

import jsonrpc.Server;

/**
 * @author Norman Fomferra
 */
public class BeamServer {
    public static void main(String[] args) throws Exception {
        Server.start(31415, BeamService.class, new BeamServiceImpl());
    }
}
