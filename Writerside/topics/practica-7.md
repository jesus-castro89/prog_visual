# Practica 7: Registrando datos de un ServerSocket en un TableModel

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