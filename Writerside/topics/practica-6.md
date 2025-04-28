# Practica 6: Definiendo un servidor y un cliente mediante sockets

## Objetivo

El objetivo de esta práctica es crear un servidor y un cliente utilizando sockets en Java que se comuniquen entre sí. El
servidor debe recibir un mensaje del cliente y responder con un mensaje de confirmación. El cliente debe enviar un
mensaje al servidor y esperar la respuesta.

## Desarrollo

### Paso 1: Crear el servidor

1. Crea un paquete llamado `servidor` en tu proyecto.
2. Crea una clase llamada `Server` dentro del paquete `servidor`.
3. Importa las siguientes librerías:
   ```java
   import java.io.*;
   import java.net.*;
   ```
4. Define la clase `Servidor` y el método `main`:
   ```java
    package servidor;

    import java.io.IOException;
    import java.io.ObjectOutputStream;
    import java.io.PrintWriter;
    import java.net.ServerSocket;
    import java.net.Socket;
    import java.util.Date;
    import java.util.Random;
    
    public class Server {
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
            new Thread(() -> {
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
            }).start();
        }
    }
   ```

Con los pasos anteriores, el servidor estará listo para recibir conexiones de clientes y enviar mensajes aleatorios.
Toma en consideración que el servidor se ejecutará indefinidamente hasta que se detenga manualmente. Así mismo, el
servidor deberá de enviar al menos 4 enteros aleatorios al cliente en cada iteración. El cliente deberá de recibir
los mensajes y mostrarlos en consola. El cliente deberá de cerrar la conexión cuando haya recibido 10 mensajes.

### Paso 2: Crear el cliente

1. Crea un paquete llamado `cliente` en tu proyecto.
2. Crea una clase llamada `Client` dentro del paquete `cliente`.
3. Importa las siguientes librerías:
   ```java
   import java.io.*;
   import java.net.*;
   ```
4. Define la clase `Cliente` y el método `main`:
   ```java
    package socket;

    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.io.ObjectInputStream;
    import java.net.Socket;
    
    public class Client {
    
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
                    String mensaje= in.readLine();
                    System.out.println("Recibido del servidor: " + mensaje);
                    int contador = 0;
                    while ((mensaje = in.readLine()) != null && contador < 10) {
                        System.out.println("Recibido del servidor: " + mensaje);
                        contador++;
                    }
                    socket.close();
                } catch (IOException e) {
                    System.err.println("Error de conexión: " + e.getMessage());
                    throw new RuntimeException(e);
                }
            }).start();
        }
    }
    ```

Con los pasos anteriores, el cliente estará listo para conectarse al servidor y recibir mensajes. El cliente se
desconectará automáticamente después de recibir 10 mensajes. Asegúrate de que el servidor esté en ejecución antes de
iniciar el cliente.

### Paso 3: Ejecutar el servidor y el cliente

1. Ejecuta la clase `Servidor` para iniciar el servidor.
2. Ejecuta la clase `Cliente` para iniciar el cliente.
3. Observa la salida en la consola del servidor y del cliente. El servidor enviará mensajes aleatorios al cliente y el
   cliente los mostrará en su consola.
4. Verifica que el cliente se desconecte después de recibir 10 mensajes.
5. Si deseas probar múltiples clientes, puedes ejecutar varias instancias de la clase `Cliente` y observar cómo el
   servidor maneja las conexiones simultáneas.
6. Asegúrate de manejar adecuadamente las excepciones y cerrar los sockets al finalizar la comunicación para evitar
   fugas de recursos.
7. Recuerda que este es un ejemplo básico de comunicación entre un servidor y un cliente utilizando sockets en Java.
   En un entorno de producción, se recomienda utilizar hilos o un framework como Netty para manejar múltiples
   conexiones simultáneamente y mejorar la eficiencia del servidor.

## Conclusión

En esta práctica, has aprendido a crear un servidor y un cliente utilizando sockets en Java. Has implementado la
comunicación entre ambos, enviando y recibiendo mensajes. También has aprendido a manejar excepciones y cerrar
sockets adecuadamente. Esta es una base sólida para desarrollar aplicaciones de red más complejas en Java.

## Para la entrega

1. Entrega el código fuente de tu proyecto en formato comprimido (zip o rar).
2. Crea un archivo con portada que contenga los datos de identificación de los miembros del equipo, el nombre de la
   práctica y la fecha de entrega.
3. Incluye en dicho archivo capturas de pantalla de la ejecución del servidor y el cliente, mostrando la comunicación
   entre ambos.
4. Sube ambos archivos a la plataforma de entrega indicada por el instructor.

## Criterio de evaluación

| Criterio              | Descripción                                                                 | Puntuación     |
|-----------------------|-----------------------------------------------------------------------------|----------------|
| Código                | El código está bien estructurado y sigue las convenciones de Java.          | 20 puntos      |
| Funcionalidad         | El servidor y el cliente se comunican correctamente.                        | 30 puntos      |
| Manejo de excepciones | Se manejan adecuadamente las excepciones y se cierran los sockets.          | 20 puntos      |
| Portada               | La portada contiene la información requerida.                               | 10 puntos      |
| Capturas de pantalla  | Se incluyen capturas de pantalla de la ejecución del servidor y el cliente. | 20 puntos      |
| **Total**             |                                                                             | **100 puntos** |

## Fecha de entrega

La fecha de entrega es el día 28 de abril de 2025 a las 23:59 horas. Entregas posteriores serán calificadas sobre el 70%
de la puntuación total.