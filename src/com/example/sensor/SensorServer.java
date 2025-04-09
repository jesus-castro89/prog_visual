package com.example.sensor;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Random;

public class SensorServer {

    // Este es el puerto en el que el servidor escuchará las conexiones
    public static final int PORT = 12345;
    // Este es el host en el que el servidor escuchará las conexiones
    public static final String HOST = "localhost";
    // Este es el tiempo de espera entre cada mensaje enviado por el servidor (1000 ms = 1 segundo)
    private static final int DELAY = 1000;

    public static void main(String[] args) {
        // Inicia el servidor
        startServer();
    }

    public static void startServer() {
        // Crea una nueva instancia de ServerSocket en el puerto especificado
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Servidor iniciado en " + HOST + ":" + PORT);
            while (true) {
                try (Socket clientSocket = serverSocket.accept()) {
                    // Crea un writer para enviar mensajes al cliente
                    //PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                    ObjectOutputStream objectOut = new ObjectOutputStream(clientSocket.getOutputStream());
                    System.out.println("Cliente conectado desde " + clientSocket.getInetAddress() + ":" + clientSocket.getPort());
                    while (!clientSocket.isClosed()) {
                        // Genera un número aleatorio entre 1 y 100
                        SensorData s = new SensorData();
                        // Envía el número aleatorio al cliente
                        objectOut.writeObject(s);
                        System.out.println("Enviado: " + s);
                        // Espera un segundo antes de enviar el siguiente número
                        Thread.sleep(DELAY);
                    }
                } catch (Exception e) {
                    System.out.println("Error con cliente: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Error al iniciar el servidor: " + e.getMessage());
        }
    }
}
