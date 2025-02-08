# Práctica 2: Crear una ventana con botones en Java

## Objetivo

El objetivo de esta práctica es crear una ventana en Java que contenga botones y que permita a los usuarios interactuar
con el programa mediante la realización de acciones al hacer clic en los botones.

## Instrucciones

Para completar esta práctica, sigue los siguientes pasos:

1. Toma la ventana que creaste en la [práctica anterior](practica-1.md).
2. Agrega uno o más botones a la ventana. Arrastra los botones desde la paleta de componentes de IntelliJ IDEA.
    - Notarás que se crea un objeto de la clase `JButton` y se le asigna un nombre predeterminado, como `button1`.
    - Puedes personalizar los botones cambiando su texto, tamaño, color, fuente, etc., mediante el panel de propiedades
      del botón en el editor visual.
3. Para capturar y procesar eventos de clic en los botones, agrega un `ActionListener` a cada botón mediante el método
   `addActionListener` y define las acciones a realizar en el método `actionPerformed` de la interfaz `ActionListener`.
    - Puedes hacerlo dando clic derecho sobre el botón en el editor visual y seleccionando `Create Listener` y
      seleccionando `ActionListener`. Esto creará automáticamente el código necesario para capturar y procesar eventos
      de clic en el botón.
    - El fragmento de código generado se verá similar a lo siguiente:
      ```java
      button1.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              // Acciones a realizar al hacer clic en el botón
          }
      });
      ```
4. Haz que al dar clic al botón surja una ventana emergente con JOptionPane.
    - Puedes utilizar el método `JOptionPane.showMessageDialog` para mostrar un mensaje en una ventana emergente al
      hacer clic en el botón.
    - El fragmento de código para mostrar un mensaje en una ventana emergente se verá similar a lo siguiente:
      ```java
      JOptionPane.showMessageDialog(null, "¡Has hecho clic en el botón!");
      ```
    - Por lo que el código del evento `actionPerformed` se verá similar a lo siguiente:
      ```java
      button1.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              JOptionPane.showMessageDialog(null, "¡Has hecho clic en el botón!");
          }
      });
      ```
5. Ejecuta la aplicación y verífica que al hacer clic en los botones, se muestre una ventana emergente con el mensaje
   correspondiente.

## Clase completa

A continuación, se muestra la clase completa `Ventana` con los botones y eventos implementados:

```java
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame {
    private JPanel mainPanel;
    private JButton button1;
    private JButton button2;

    public static void main(String[] args) {
        new Ventana();
    }

    public Ventana() {
        setTitle("Mi primera ventana en Java");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setContentPane(mainPanel);
        setVisible(true);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Haz hecho clic en el botón 1");
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Haz hecho clic en el botón 2");
            }
        });
    }
}
```

> **Nota:** Recuerda que puedes personalizar los botones y los mensajes mostrados en las ventanas emergentes según tus
> preferencias.

Al ejecutar la aplicación, verás una ventana con dos botones que al hacer clic en ellos, mostrarán un mensaje en una
ventana emergente indicando que se ha hecho clic en el botón correspondiente.

## Para la entrega

1. Crea un archivo ZIP con el código fuente de la clase `Ventana` y los archivos necesarios para ejecutar la aplicación.
2. Cambia el texto del botón 1 a «Haz clic aquí» y el texto del botón 2 a «¡Haz clic aquí también!».
3. Modifica los mensajes mostrados de la siguiente manera:
    - Al hacer clic en el botón 1, mostrar el mensaje «Mi nombre es [tu nombre] y he hecho clic en el botón 1».
    - Al hacer clic en el botón 2, mostrar el mensaje «Mi edad es [tu edad] años y he hecho clic en el botón 2».
4. Ejecuta la aplicación y verífica que los mensajes mostrados en las ventanas emergentes sean correctos.
5. Realiza una captura de pantalla de la ventana de la aplicación con los botones y las ventanas emergentes mostradas.
6. Agrega las capturas a una carpeta llamada `screenshots` dentro de tu proyecto.
7. Comprime la carpeta del proyecto en un archivo ZIP para su entrega.
8. Sube el archivo ZIP a la plataforma de aprendizaje.
9. ¡Listo! Has completado la práctica de crear una ventana con botones en Java. ¡Felicidades! 🎉