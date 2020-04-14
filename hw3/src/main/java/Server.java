import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8189)) {
            Socket socket = serverSocket.accept();
            System.out.println("Connect");
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            while (true) {
                Object obj = in.readObject();
                out.writeObject(obj);
                if (obj instanceof String) {
                    if ("end".equalsIgnoreCase((String) obj)) {
                        break;
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stsrtServer() {

    }

    public void stopServer() {

    }
}
