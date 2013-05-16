package ex;

import java.io.*;
import java.net.Socket;

/**
 * @author Norman Fomferra
 */
public class BeamClient {

    public static void main(String[] args) throws Exception {

        Socket socket = new Socket("localhost", 31415);

        BufferedReader socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter socketWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.print("--> ");
            String request = reader.readLine();
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
