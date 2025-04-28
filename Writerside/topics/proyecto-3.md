# Proyecto 3: Registrando datos de un ServerSocket en un TableModel

## Objetivo

Crear un cliente que se conecte a un servidor y registre los datos recibidos en un TableModel que se muestre en un
JTable. Para facilitar el flujo de trabajo, se utilizará un `DefaultTableModel` para manejar los datos en la tabla. El
cliente se conectará a un servidor que envía datos de forma continua, y el cliente deberá ser capaz de recibir y mostrar
esos datos en la tabla. Y para este flujo de información, se utilizará una clase `Serializable` para enviar y recibir
objetos de forma sencilla. El cliente también debe ser capaz de manejar la desconexión del servidor y mostrar un mensaje
de error en caso de que la conexión falle. Además, se implementará un botón para cerrar la conexión y liberar los
recursos utilizados por el cliente.

## Desarrollo

Para efectos de esta práctica, las clases se generarán dentro del paquete `com.example.sensor`.

1. **Crear la clase `SensorData`**: Esta clase representará los datos que se recibirán del servidor. Debe implementar la
   interfaz `Serializable` para permitir la transmisión de objetos a través de la red.
2. **Crear la clase `SensorClient`**: Esta clase será responsable de conectarse al servidor y recibir los datos. Debe
   extender `JFrame` para mostrar la interfaz gráfica. En el constructor, se debe crear un `DefaultTableModel` y un
   `JTable` para mostrar los datos.
3. **Crear la clase `SensorClientHandler`**: Esta clase será responsable de manejar la conexión con el servidor y
   recibir los datos. Debe implementar `Runnable` para permitir la ejecución en un hilo separado. En el método `run`,
   se debe crear un socket y escuchar los datos enviados por el servidor. Cuando se reciban datos, se deben agregar al
   `DefaultTableModel` del cliente.
4. **Crear la clase `SensorServer`**: Esta clase será responsable de enviar datos a los clientes. Debe crear un
   `ServerSocket` y esperar conexiones de clientes. Cuando un cliente se conecta, se debe generar un hilo para manejar
   la conexión y enviar datos al cliente.
5. **Crear la clase `Main`**: Esta clase será responsable de iniciar el servidor y el cliente. Debe crear una instancia
   de `SensorServer` y `SensorClient` para iniciar la aplicación.

### `SensorData.java`

```java
package com.example.sensor;

import java.io.Serializable;
import java.util.Date;
import java.util.Random;

public class SensorData implements Serializable {

    private final double temperature;
    private final double humidity;
    private final double atmosphericPressure;
    private final double windSpeed;
    private final Date timestamp;

    public SensorData() {

        this.timestamp = new Date();
        this.temperature = getRandomTemperature();
        this.humidity = getRandomHumidity();
        this.atmosphericPressure = getRandomAtmosphericPressure();
        this.windSpeed = getRandomWindSpeed();
    }

    private double getRandomTemperature() {
        return 15 + (35 - 15) * Math.random();
    }

    private double getRandomHumidity() {
        return 30 + (90 - 30) * Math.random();
    }

    private double getRandomAtmosphericPressure() {
        return 950 + (1050 - 950) * Math.random();
    }

    private double getRandomWindSpeed() {
        return 0 + (20) * Math.random();
    }

    public double getTemperature() {
        return temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public double getAtmosphericPressure() {
        return atmosphericPressure;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return """
                Temperatura: %.2f °C
                 Porcentaje de Humedad: %.2f %%
                 Presión Atmosférica: %.2f hPa
                 Velocidad del Viento: %.2f m/s
                 Timestamp: %s
                """.formatted(temperature, humidity,
                atmosphericPressure, windSpeed, timestamp);
    }

    public static void main(String[] args) {
        // Generar datos de sensor aleatorios
        SensorData sensorData = new SensorData();
        System.out.println(sensorData);
    }
}
```

Analizando la clase `SensorData`:

- La clase implementa la interfaz `Serializable`, lo que permite que los objetos de esta clase se puedan enviar a través
  de la red.
- Contiene atributos para almacenar la temperatura, humedad, presión atmosférica, velocidad del viento y una marca
  de tiempo.
- El constructor inicializa los atributos con valores aleatorios dentro de un rango específico.
- Los métodos `get` permiten acceder a los valores de los atributos.
- El método `main` genera un objeto `SensorData` y lo imprime en la consola. Esto es útil para probar la clase
  independientemente del cliente o servidor.

### `SensorServer.java`

```java
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
```

Analizando la clase `SensorServer`:

* La clase crea un servidor que escucha en el puerto 12345 y envía datos de sensor a los clientes conectados.
* El servidor utiliza un `ServerSocket` para aceptar conexiones de clientes.
* Cuando un cliente se conecta, se crea un `ObjectOutputStream` para enviar objetos `SensorData` al cliente.
* El servidor genera datos de sensor aleatorios y los envía al cliente cada segundo.
* El servidor maneja excepciones y cierra la conexión con el cliente si ocurre un error.
* El método `main` inicia el servidor y lo mantiene en ejecución.
* El método `startServer` es el encargado de crear el `ServerSocket` y aceptar conexiones de clientes. Dentro de un
  bucle infinito, espera a que un cliente se conecte y luego envía datos de sensor aleatorios al cliente cada segundo.
  Si ocurre un error, se imprime un mensaje en la consola.

### `SensorClient.java`

En este caso deberás de crear una ventana con un conjunto de `ArrayList` que contenga los datos de los sensores,
recuerda que el `SensorData` propuesto contiene una serie de datos que puedes utilizar para mostrar en las gráficas.

```java
package com.example.sensor;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;

public class SensorClient extends JFrame {

    private static final String SERVER_IP = "localhost";
    private static final int PORT = 12345;
    private JPanel mainPanel;
    private JScrollPane chartOne;
    private JTabbedPane tabbedPane1;
    private JScrollPane chartTwo;
    private JScrollPane chartThree;
    private JScrollPane chartFive;
    private JScrollPane chartSix;
    private JScrollPane chartSeven;
    private ArrayList<Double> temperatures;
    private ArrayList<Double> windSpeeds;
    private ArrayList<Double> humidities;
    private ArrayList<Double> atmosphericPressures;

    public SensorClient() {
        temperatures = new ArrayList<>();
        windSpeeds = new ArrayList<>();
        humidities = new ArrayList<>();
        atmosphericPressures = new ArrayList<>();
        setTitle("Sensor Data");
        setSize(900, 600);
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        connectToServer();
    }

    private void connectToServer() {

        new Thread(() -> {
            try (Socket socket = new Socket(SERVER_IP, PORT);
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                System.out.println("Conectado al servidor");
                SensorData data;
                do {
                    data = (SensorData) ois.readObject();
                    if (data != null) {
                        temperatures.add(data.getTemperature());
                        windSpeeds.add(data.getWindSpeed());
                        humidities.add(data.getHumidity());
                        atmosphericPressures.add(data.getAtmosphericPressure());
                        addChartPanel();
                        addVelocityChartPanel();
                        addLineChartPanel();
                        addWindSpeedPanel();
                        addBarChartPanel();
                        addThermometerChartPanel();
                    }
                } while (data != null);
            } catch (IOException e) {
                System.err.println("Error de conexión: " + e.getMessage());
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

    private void addChartPanel() {
        // Aquí puedes agregar el código para crear y agregar el panel de gráficos
        // utilizando los datos de temperaturas, humidities, etc.
    }

    private void addVelocityChartPanel() {
        // Aquí puedes agregar el código para crear y agregar el panel de gráficos
        // utilizando los datos de windSpeeds.
    }

    private void addLineChartPanel() {
        // Aquí puedes agregar el código para crear y agregar el panel de gráficos
        // utilizando los datos de temperaturas, humidities, etc.
    }

    private void addWindSpeedPanel() {
        // Aquí puedes agregar el código para crear y agregar el panel de gráficos
        // utilizando los datos de windSpeeds.
    }

    private void addBarChartPanel() {
        // Aquí puedes agregar el código para crear y agregar el panel de gráficos
        // utilizando los datos de temperatures, humidities, etc.
    }

    private void addThermometerChartPanel() {
        // Aquí puedes agregar el código para crear y agregar el panel de gráficos
        // utilizando los datos de temperatures.
    }
}
```

Analizando la clase `SensorClient`:

* La clase extiende `JFrame` para crear una ventana gráfica.
* Contiene un `JPanel` principal y un `JTabbedPane` para mostrar diferentes gráficos.
* Contiene listas para almacenar los datos de temperatura, velocidad del viento, humedad y presión atmosférica.
* El constructor inicializa la ventana, establece el título y el tamaño, y llama al método `connectToServer` para
  conectarse al servidor.
* El método `connectToServer` crea un socket y se conecta al servidor. Luego, recibe objetos `SensorData` del servidor
  y los almacena en las listas correspondientes. También llama a métodos para agregar gráficos a la ventana.
* Los métodos `addChartPanel`, `addVelocityChartPanel`, `addLineChartPanel`, `addWindSpeedPanel`, `addBarChartPanel` y
  `addThermometerChartPanel` son métodos de marcador de posición donde se puede agregar el código para crear y agregar
  los gráficos correspondientes a la ventana. Estos métodos deben implementarse para mostrar los datos de manera
  visual.
* El cliente maneja excepciones de conexión y de clase no encontrada. Si ocurre un error, se imprime un mensaje en la
  consola.
* El cliente se ejecuta en un hilo separado para no bloquear la interfaz gráfica mientras espera datos del servidor.
* El cliente se conecta al servidor en el puerto 12345 y espera recibir datos de sensor. Cuando recibe un objeto
  `SensorData`, lo almacena en las listas correspondientes y llama a los métodos para agregar gráficos a la ventana.
* El cliente utiliza un `ObjectInputStream` para leer objetos `SensorData` del servidor. Esto permite recibir datos
  complejos en lugar de solo cadenas de texto.

Toma en consideración que debes de implementar los métodos para mostrar los gráficos en la interfaz gráfica. Puedes
utilizar los ejemplos de ejercicios previos o investigar como implementarlos con `JFreeChart`. Recuerda que debes de
instalar la librería de `JFreeChart` para poder utilizarla en tu proyecto. Puedes descargarla desde su sitio web oficial
o agregarla como dependencia en tu proyecto si estás utilizando un sistema de gestión de dependencias como Maven o
Gradle.

## Para la entrega

1. Realiza el desarrollo de la aplicación siguiendo los pasos anteriores.
2. Comprueba que la aplicación funcione correctamente.
3. Graba un video de la aplicación en funcionamiento.
4. Crea un archivo ZIP con el código fuente del proyecto.
5. Sube el video y el archivo ZIP a la plataforma.

## Criterios de Evaluación

| Criterio      | Descripción                                                                       | Puntaje  |
|---------------|-----------------------------------------------------------------------------------|----------|
| Portada       | Se anexa portada con datos del equipo.                                            | 5%       |
| Código        | El código fuente cumple con los requerimientos y está correctamente estructurado. | 30%      |
| Funcionalidad | La aplicación cumple con los requerimientos y funciona correctamente.             | 30%      |
| Video         | Se anexa video de la aplicación en funcionamiento.                                | 20%      |
| Entrega       | Se anexa archivo ZIP con el código fuente del proyecto.                           | 15%      |
| **Total**     |                                                                                   | **100%** |

## Fecha de Entrega

La fecha de entrega de este entregable es el **6 de mayo de 2025** a las **23:59**. Cualquier entrega después de esta
fecha no será calificada.

Recuerda que la entrega se realizará a través de la plataforma **Moodle**.

> Recuerda que deberás anexar al trabajo por separado el archivo de portada, video y zip con el código fuente de tu
> proyecto.
> {style="note"}