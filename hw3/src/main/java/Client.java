import java.io.*;
import java.net.Socket;
import java.util.Date;

public class Client {
private final static String SERVER_ADDR = "localhost";
private final static int SERVER_PORT = 8189;
private static ObjectOutputStream out;
private static ObjectInputStream in;

    public static void main(String[] args) {
        Socket socket;

        try {
            socket = new Socket(SERVER_ADDR, SERVER_PORT);
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            Object obj = in.readObject();
                            if (obj instanceof String) {
                                if ("end".equalsIgnoreCase((String) obj)) {
                                    break;
                                }
                            } else {

                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });

            House savedHouse = new House("garag", new Date(System.currentTimeMillis()), "brick", 2);
            System.out.println(savedHouse);
            out.writeObject(savedHouse);
            House loadedHouse = (House) in.readObject();
            System.out.println(loadedHouse);
            out.writeObject("end");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
