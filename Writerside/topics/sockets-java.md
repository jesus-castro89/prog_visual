# ¿Qué un Socket y como funciona?

Un socket es un punto final de una conexión de red. En Java, los sockets se utilizan para establecer una comunicación
entre un cliente y un servidor a través de una red. Un socket se compone de una dirección IP y un número de puerto, que
identifican de manera única el punto final de la conexión.

## ¿Cómo funciona un Socket?

Cuando un cliente quiere comunicarse con un servidor, crea un socket y se conecta a la dirección IP y el número de
puerto del servidor. El servidor, por su parte, escucha en un puerto específico y acepta las conexiones entrantes de los
clientes. Una vez que se establece la conexión, el cliente y el servidor pueden intercambiar datos a través del socket.
El socket se encarga de manejar la comunicación entre el cliente y el servidor, permitiendo enviar y recibir datos de
manera bidireccional. Esto significa que tanto el cliente como el servidor pueden enviar y recibir datos al mismo
tiempo.

## Ejemplo de un Socket en Java

```java
package socket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class TestServer {
    // Este es el puerto en el que el servidor escuchará las conexiones
    public static final int PORT = 12345;
    // Este es el host en el que el servidor escuchará las conexiones
    public static final String HOST = "localhost";
    // Este es un elemento para generar números aleatorios
    private static final Random RANDOM = new Random();
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
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                    System.out.println("Cliente conectado desde " + clientSocket.getInetAddress() + ":" + clientSocket.getPort());
                    while (!clientSocket.isClosed()) {
                        // Genera un número aleatorio entre 1 y 100
                        int randomNumber = RANDOM.nextInt(100) + 1;
                        // Envía el número aleatorio al cliente
                        out.println(randomNumber);
                        System.out.println("Enviado: " + randomNumber);
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
```

```java
package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

                System.out.println("Conectado al servidor");
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    System.out.println("Recibido: " + inputLine);
                    timeCounter++;
                }
            } catch (IOException e) {
                System.err.println("Error de conexión: " + e.getMessage());
            }
        }).start();
    }
}
```

## Explicación del código

### Servidor

1. **ServerSocket**: Se crea un `ServerSocket` en el puerto especificado (12345) y se inicia a la espera de conexiones
   entrantes.
2. **Socket**: Cuando un cliente se conecta, se acepta la conexión y se crea un `Socket` para manejar la
   comunicación con ese cliente.
3. **PrintWriter**: Se crea un `PrintWriter` para enviar mensajes al cliente.
4. **Generación de números aleatorios**: Se genera un número aleatorio entre 1 y 100 y se envía al cliente.
5. **Delay**: Se espera un segundo antes de enviar el siguiente número.
6. **Manejo de excepciones**: Se manejan las excepciones que pueden ocurrir durante la conexión y el envío de datos.
7. **Cierre del socket**: El socket se cierra automáticamente al salir del bloque `try-with-resources`.
8. **Ciclo infinito**: El servidor sigue escuchando conexiones entrantes y enviando números aleatorios hasta que se
   detiene
   manualmente.
9. **Impresión de mensajes**: Se imprimen mensajes en la consola para indicar el estado del servidor y los números
   enviados.

### Cliente

1. **Socket**: Se crea un `Socket` para conectarse al servidor en la dirección IP y el puerto especificados.
2. **BufferedReader**: Se crea un `BufferedReader` para leer los mensajes enviados por el servidor.
3. **Lectura de mensajes**: Se lee un mensaje del servidor y se imprime en la consola.
4. **Manejo de excepciones**: Se manejan las excepciones que pueden ocurrir durante la conexión y la lectura de datos.
5. **Cierre del socket**: El socket se cierra automáticamente al salir del bloque `try-with-resources`.
6. **Ciclo infinito**: El cliente sigue leyendo mensajes del servidor hasta que se cierra la conexión.
7. **Impresión de mensajes**: Se imprimen mensajes en la consola para indicar el estado del cliente y los números
   recibidos.

## Conclusión

Los sockets son una herramienta poderosa para establecer comunicación entre aplicaciones en red. En este ejemplo, hemos
visto cómo crear un servidor y un cliente en Java que se comunican a través de sockets. El servidor envía números
aleatorios al cliente, que los recibe y los imprime en la consola. Este es un ejemplo básico, pero los sockets se
pueden utilizar para crear aplicaciones más complejas, como servidores web, aplicaciones de chat y mucho más.
Los sockets son una parte fundamental de la programación de redes y son ampliamente utilizados en aplicaciones
distribuidas.

## Recursos adicionales

- [Documentación de Java sobre Sockets](https://docs.oracle.com/javase/tutorial/networking/sockets/index.html)
- [Guía de programación de sockets en Java](https://www.baeldung.com/java-sockets)
- [Socket Programming in Java](https://www.geeksforgeeks.org/socket-programming-in-java/)