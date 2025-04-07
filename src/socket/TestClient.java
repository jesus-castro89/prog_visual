package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.Socket;

public class TestClient {

    private static final String SERVER_IP = "localhost";
    private static final int PORT = 12345;
    private static int timeCounter = 0;

    public static void main(String[] args) {
        // Inicia el cliente
        connectToServer();
    }

    public static void connectToServer() {
        new Thread(() -> {
            try (Socket socket = new Socket(SERVER_IP, PORT);
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                System.out.println("Conectado al servidor");
                SensorData data = (SensorData) ois.readObject();
                while (data != null) {
                    System.out.println("Recibido: " + data);
                    timeCounter++;
                    data = (SensorData) ois.readObject();
                }
            } catch (IOException e) {
                System.err.println("Error de conexión: " + e.getMessage());
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}
