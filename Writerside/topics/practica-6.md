# Practica 6: Definiendo un servidor y un cliente mediante sockets

## Objetivo

El objetivo de esta práctica es crear un servidor y un cliente utilizando sockets en Java que se comuniquen entre sí. El
servidor debe recibir un mensaje del cliente y responder con un mensaje de confirmación. El cliente debe enviar un
mensaje al servidor y esperar la respuesta.

## Desarrollo

### Paso 1: Crear el servidor

1. Crea un paquete llamado `servidor` en tu proyecto.
2. Crea una clase llamada `Servidor` dentro del paquete `servidor`.
3. Importa las siguientes librerías:
   ```java
   import java.io.*;
   import java.net.*;
   ```
4. Define la clase `Servidor` y el método `main`:
   ```java+
    public class Servidor {
         public static void main(String[] args) {
              // Código del servidor aquí
         }
    }
   ```
5. Define las siguientes constantes:
   ```java
   // Este es el puerto en el que el servidor escuchará las conexiones
    public static final int PORT = 12345;
    // Este es el host en el que el servidor escuchará las conexiones
    public static final String HOST = "localhost";
    // Este es un elemento para generar números aleatorios
    private static final Random RANDOM = new Random();
    // Este es el tiempo de espera entre cada mensaje enviado por el servidor (1000 ms = 1 segundo)
    private static final int DELAY = 1000;
   ```
6. Crea un socket la función `iniciarServidor` que escuche en un puerto específico (por ejemplo, 12345):
   ```java
   public static void iniciarServidor() throws IOException {
        // Crea un socket de servidor en el puerto especificado
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Servidor iniciado. Esperando conexiones...");
        } catch (IOException e) {
            System.err.println("Error al iniciar el servidor: " + e.getMessage());
            throw e;
        }
   }
   ```
7. Crea un ciclo que acepte conexiones de clientes y maneje la comunicación:
   ```java
   public static void iniciarServidor() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Servidor iniciado. Esperando conexiones...");
            while (true) {
                try (Socket clientSocket = serverSocket.accept()) {
                    System.out.println("Cliente conectado: " + clientSocket.getInetAddress());
                    manejarCliente(clientSocket);
                } catch (IOException e) {
                    System.err.println("Error al manejar el cliente: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Error al iniciar el servidor: " + e.getMessage());
            throw e;
        }
   }
   ```
8. Crea el método `manejarCliente` que maneje la comunicación con el cliente:
   ```java
   public static void manejarCliente(Socket clientSocket) {
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        System.out.println("Cliente conectado desde " + clientSocket.getInetAddress() + ":" + clientSocket.getPort());
        while (!clientSocket.isClosed()) {
            try {
                int dataA = RANDOM.nextInt(100);
                out.println(dataA);
                System.out.println("Enviando: " + dataA);
                Thread.sleep(DELAY);
            } catch (InterruptedException e) {
                System.err.println("Error al esperar: " + e.getMessage());
            }
        }
   }
   ```
9. Cierra el socket del cliente al finalizar la comunicación:
   ```java
    public static void manejarCliente(Socket clientSocket) {
          PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
          System.out.println("Cliente conectado desde " + clientSocket.getInetAddress() + ":" + clientSocket.getPort());
          while (!clientSocket.isClosed()) {
                try {
                 int dataA = RANDOM.nextInt(100);
                 out.println(dataA);
                 System.out.println("Enviando: " + dataA);
                 Thread.sleep(DELAY);
                } catch (InterruptedException e) {
                 System.err.println("Error al esperar: " + e.getMessage());
                }
          }
          clientSocket.close();
    }
    ```
10. Agrega el bloque `try-catch` para manejar excepciones:
    ```java
    public static void manejarCliente(Socket clientSocket) {
        try (PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {
            System.out.println("Cliente conectado desde " + clientSocket.getInetAddress() + ":" + clientSocket.getPort());
            while (!clientSocket.isClosed()) {
                try {
                    int dataA = RANDOM.nextInt(100);
                    out.println(dataA);
                    System.out.println("Enviando: " + dataA);
                    Thread.sleep(DELAY);
                } catch (InterruptedException e) {
                    System.err.println("Error al esperar: " + e.getMessage());
                }
            }
            clientSocket.close();
        } catch (IOException e) {
            System.err.println("Error al manejar el cliente: " + e.getMessage());
        }
    }
    ```
11. Toma en cuenta que la sección de código anterior es un ejemplo básico y puede no ser la mejor práctica para manejar
    múltiples clientes. En un entorno de producción, se recomienda utilizar hilos o un framework como Netty para manejar
    múltiples conexiones simultáneamente, por ejemplo:
    ```java
    public static void manejarCliente(Socket clientSocket) {
        new Thread(() -> {
            try (PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {
                System.out.println("Cliente conectado desde " + clientSocket.getInetAddress() + ":" + clientSocket.getPort());
                while (!clientSocket.isClosed()) {
                    try {
                        int dataA = RANDOM.nextInt(100);
                        out.println(dataA);
                        System.out.println("Enviando: " + dataA);
                        Thread.sleep(DELAY);
                    } catch (InterruptedException e) {
                        System.err.println("Error al esperar: " + e.getMessage());
                    }
                }
            } catch (IOException e) {
                System.err.println("Error al manejar el cliente: " + e.getMessage());
            } finally {
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    System.err.println("Error al cerrar el socket del cliente: " + e.getMessage());
                }
            }
        }).start();
    }
    ```
12. Finalmente, llama al método `iniciarServidor` en el método `main`:
    ```java
    public static void main(String[] args) {
        try {
            iniciarServidor();
        } catch (IOException e) {
            System.err.println("Error al iniciar el servidor: " + e.getMessage());
        }
    }
    ```

Con los pasos anteriores, el servidor estará listo para recibir conexiones de clientes y enviar mensajes aleatorios.
Toma en consideración que el servidor se ejecutará indefinidamente hasta que se detenga manualmente. Así mismo, el
servidor deberá de enviar al menos 4 enteros aleatorios al cliente en cada iteración. El cliente deberá de recibir
los mensajes y mostrarlos en consola. El cliente deberá de cerrar la conexión cuando haya recibido 10 mensajes.

### Paso 2: Crear el cliente

1. Crea un paquete llamado `cliente` en tu proyecto.
2. Crea una clase llamada `Cliente` dentro del paquete `cliente`.
3. Importa las siguientes librerías:
   ```java
   import java.io.*;
   import java.net.*;
   ```
4. Define la clase `Cliente` y el método `main`:
   ```java
    public class Cliente {
          public static void main(String[] args) {
                 // Código del cliente aquí
          }
    }
    ```
5. Define las siguientes constantes:
   ```java
   // Este es el puerto en el que el cliente se conectará al servidor
    public static final int PORT = 12345;
    // Este es el host al que el cliente se conectará (localhost)
    public static final String HOST = "localhost";
   ```
6. Crea un socket en el método `iniciarCliente` que se conecte al servidor:
   ```java
    public static void iniciarCliente() throws IOException {
          try (Socket socket = new Socket(HOST, PORT)) {
                System.out.println("Conectado al servidor: " + socket.getInetAddress());
          } catch (IOException e) {
                System.err.println("Error al conectar al servidor: " + e.getMessage());
                throw e;
          }
    }
    ```
7. Crea un ciclo que reciba mensajes del servidor y los muestre en consola:
   ```java
    public static void iniciarCliente() throws IOException {
          try (Socket socket = new Socket(HOST, PORT);
               BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                System.out.println("Conectado al servidor: " + socket.getInetAddress());
                String mensaje;
                while ((mensaje = in.readLine()) != null) {
                    System.out.println("Recibido del servidor: " + mensaje);
                }
          } catch (IOException e) {
                System.err.println("Error al conectar al servidor: " + e.getMessage());
                throw e;
          }
    }
    ```
8. Agrega el bloque `try-catch` para manejar excepciones:
   ```java
    public static void iniciarCliente() throws IOException {
          try (Socket socket = new Socket(HOST, PORT);
               BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                System.out.println("Conectado al servidor: " + socket.getInetAddress());
                String mensaje;
                while ((mensaje = in.readLine()) != null) {
                    System.out.println("Recibido del servidor: " + mensaje);
                }
          } catch (IOException e) {
                System.err.println("Error al conectar al servidor: " + e.getMessage());
                throw e;
          }
    }
    ```
9. Llama al método `iniciarCliente` en el método `main`:
   ```java
    public static void main(String[] args) {
          try {
                iniciarCliente();
          } catch (IOException e) {
                System.err.println("Error al iniciar el cliente: " + e.getMessage());
          }
    }
    ```
10. Agrega un contador para cerrar la conexión después de recibir 10 mensajes:
    ```java
    public static void iniciarCliente() throws IOException {
          try (Socket socket = new Socket(HOST, PORT);
               BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                System.out.println("Conectado al servidor: " + socket.getInetAddress());
                String mensaje;
                int contador = 0;
                while ((mensaje = in.readLine()) != null && contador < 10) {
                    System.out.println("Recibido del servidor: " + mensaje);
                    contador++;
                }
          } catch (IOException e) {
                System.err.println("Error al conectar al servidor: " + e.getMessage());
                throw e;
          }
    }
    ```
11. Por último, cierra el socket del cliente al finalizar la comunicación:
    ```java
    public static void iniciarCliente() throws IOException {
          try (Socket socket = new Socket(HOST, PORT);
               BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                System.out.println("Conectado al servidor: " + socket.getInetAddress());
                String mensaje;
                int contador = 0;
                while ((mensaje = in.readLine()) != null && contador < 10) {
                    System.out.println("Recibido del servidor: " + mensaje);
                    contador++;
                }
                socket.close();
          } catch (IOException e) {
                System.err.println("Error al conectar al servidor: " + e.getMessage());
                throw e;
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