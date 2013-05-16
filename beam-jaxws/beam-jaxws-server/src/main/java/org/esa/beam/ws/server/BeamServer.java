package org.esa.beam.ws.server;

import javax.xml.ws.Endpoint;

/**
 * Starts a local BEAM WebService.
 * <p/>Usage: BeamServer [&lt;port&gt;]
 * <p/>After starting the server, try in a browser:
 * http://localhost:9202/beam/BeamWebService?wsdl
 *
 * @author Norman Fomferra
 */
public class BeamServer {

    public static final String DEFAULT_ADDRESS = "http://localhost:%s/beam";
    private static final String DEFAULT_PORT = "9202";
    private String address;

    /**
     * Starts the server.
     *
     * @param args The arguments
     */
    public static void main(String[] args) {
        String port = DEFAULT_PORT;
        if (args.length == 1) {
            port = args[0];
        }
        String address = String.format(DEFAULT_ADDRESS, port);
        Endpoint.publish(address, new BeamService());
        System.out.println("BEAM-Server ready at: " + address);
    }

}
