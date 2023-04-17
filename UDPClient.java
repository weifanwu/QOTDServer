import java.net.*;
import java.io.*;

public class UDPClient {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket();
            InetAddress address = InetAddress.getByName("localhost");
            int port = 17;
            byte[] data = new byte[100];
            DatagramPacket packet = new DatagramPacket(data, data.length, address, port);
            socket.send(packet);
            DatagramPacket packet2 = new DatagramPacket(data, data.length);
            socket.receive(packet2);
            String quote = new String(packet2.getData(), 0, packet2.getLength());
            System.out.print(quote);
            socket.close();;
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }
}
