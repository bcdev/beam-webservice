package jsonrpc.cli;

import java.io.*;
import java.net.Socket;

/**
 * @author Norman Fomferra
 */
public class PlainJsonClient {

    public static void main(String[] args) throws Exception {

        if (args.length != 2) {
            System.out.println("Usage: jsonrpc.cli.PlainJsonClient <host> <port>");
            System.out.println("  Lets you enter plain JSON which is send to a JSON-RCP server.");
            System.out.println("  Example: jsonrpc.cli.PlainJsonClient localhost 31415");
            return;
        }

        String host = args[0];
        int port = Integer.parseInt(args[1]);

        Socket socket;
        try {
            socket = new Socket(host, port);
        } catch (IOException e) {
            System.out.println("Error: Can't establish connection to server '" + host + ":" + port + "'. Is the server running?");
            return;
        }

        BufferedReader socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter socketWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        BufferedReader commandLineReader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.print("--> ");
            String request = commandLineReader.readLine();
            if (request == null) {
                break;
            }
            request = request.trim();
            if (request.isEmpty()) {
                continue;
            }
            if (request.equalsIgnoreCase("exit")) {
                break;
            }
            processRequest(socketReader, socketWriter, false, request);
        }
    }

    private static void processRequest(BufferedReader reader,
                                       BufferedWriter writer,
                                       boolean echoRequest,
                                       String request) throws IOException {
        if (echoRequest) {
            System.out.println("--> " + request);
        }
        writer.write(request);
        writer.flush();
        String response = reader.readLine();
        System.out.println("<-- " + response);
    }
}
