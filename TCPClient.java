import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

// java TCPClient host port
public class TCPClient {
    public static void main(String... args) {
        String host = "localhost";
        int port = Integer.valueOf(17);
        try {
            Socket sock = new Socket(host, port);
            InputStream in = sock.getInputStream();
            OutputStream out = sock.getOutputStream();
            byte[] request = new byte[1];
            out.write(request);
            byte[] responseBytes = new byte[1024];
            int bytesRead = in.read(responseBytes);
            String response = new String(responseBytes, 0, bytesRead, StandardCharsets.UTF_8); // Step 7
            System.out.println("Quote Of The Day: " + response);
            sock.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
