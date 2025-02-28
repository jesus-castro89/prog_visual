# Introducción a la programación de puertos con Java

## Introducción

En este tutorial aprenderemos a programar puertos con Java. Para ello, utilizaremos la librería `RXTX` que nos permitirá
comunicarnos con los puertos de nuestro ordenador.

## Instalación de RXTX

Para instalar `RXTX` en nuestro ordenador, debemos seguir los siguientes pasos:

1. Descargar la librería `RXTX` desde la página oficial: [RXTX](http://rxtx.qbang.org/wiki/index.php/Download)
2. Descomprimir el archivo descargado
3. Copiar los archivos `RXTXcomm.jar` y `librxtxSerial.so` en la carpeta `lib` de nuestro proyecto
4. Añadir la librería `RXTXcomm.jar` al `classpath` de nuestro proyecto
5. Listo!

## Programación de puertos

Una vez que hemos instalado `RXTX` en nuestro ordenador, podemos comenzar a programar puertos con Java. A continuación,
se muestra un ejemplo de cómo abrir un puerto serie:

```java
import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;

public class Main {

    public static void main(String[] args) {
        try {
            CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier("/dev/ttyUSB0");
            if (portIdentifier.isCurrentlyOwned()) {
                System.out.println("Error: Port is currently in use");
            } else {
                CommPort commPort = portIdentifier.open(Main.class.getName(), 2000);

                if (commPort instanceof SerialPort) {
                    SerialPort serialPort = (SerialPort) commPort;
                    serialPort.setSerialPortParams(9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
                } else {
                    System.out.println("Error: Only serial ports are handled by this example.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

En este ejemplo, abrimos el puerto serie `/dev/ttyUSB0` con una velocidad de 9600 baudios, 8 bits de datos, 1 bit de
parada y sin paridad.

## Conclusión

En este tutorial, hemos aprendido a programar puertos con Java utilizando la librería `RXTX`. Ahora, puedes comenzar a
experimentar con la comunicación de puertos en tus proyectos Java.