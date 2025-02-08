# Práctica 1: Crear una ventana en Java

En esta práctica, aprenderemos a crear una ventana básica en Java utilizando la biblioteca SWING. Las ventanas son
componentes gráficos fundamentales en las interfaces de usuario, ya que proporcionan un contenedor visual para mostrar
otros componentes como botones, etiquetas, campos de texto, etc.

## ¿Cómo crear una ventana en Java?

Para crear una ventana en IntelliJ IDEA mediante el editor visual, podemos seguir los siguientes pasos:

1. Abrir IntelliJ IDEA y crear un nuevo proyecto de Java.
2. En el menú superior, seleccionar `File` > `New` > `Swing UI Designer` > `GUI Form`.
3. Ingresamos el nombre del archivo de la ventana y hacemos clic en `OK`.
4. En el archivo de la clase, deberemos hacer que la misma extienda de `JFrame`.
    - Para ello, colocamos después del nombre de la clase `extends JFrame`.
    - La clase deberá quedar de la siguiente manera:
      ```java
      public class Ventana extends JFrame {
      }
      ```
5. Asignamos un nombre el panel por defecto del editor visual desde la barra de propiedades, por ejemplo `mainPanel`.
    - Para ello, seleccionamos el panel en el editor visual y cambiamos el nombre en la barra de propiedades.
    - Al hacerlo notaremos que se genera un campo privado en la clase con el nombre del panel.
    - La clase deberá quedar de la siguiente manera:
      ```java
      public class Ventana extends JFrame {
          private JPanel mainPanel;
      }
      ```
6. Debemos crear un constructor para la clase `Ventana` que inicialice la ventana.
    - Para ello, creamos un método público con el mismo nombre de la clase y sin tipo de retorno.
    - Dentro del constructor, configuramos el título, tamaño, operación de cierre y ubicación de la ventana, además de
      hacerla visible y configurar el contenedor principal de la ventana.
    - La función deberá quedar de la siguiente manera:
      ```java
      public Ventana() {
          setTitle("Mi primera ventana en Java");
          setSize(400, 300);
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          setLocationRelativeTo(null);
          setContentPane(mainPanel);
          setVisible(true);
      }
      ```
7. Finalmente, en el método `main`, creamos un objeto de la clase `Ventana` y lo hacemos visible.
    - Para ello, creamos un método estático `main` que reciba un arreglo de cadenas como argumento.
    - Dentro del método `main`, creamos un objeto de la clase `Ventana`.
    - La función deberá quedar de la siguiente manera:
      ```java
      public static void main(String[] args) {
          new Ventana();
      }
      ```
8. Ejecutamos la aplicación y verificamos que la ventana se muestre correctamente.

## Clase completa

A continuación, se muestra la clase completa `Ventana` con todos los pasos anteriores implementados:

```java
import javax.swing.JFrame;

public class Ventana extends JFrame {

    private JPanel mainPanel;
    
    public Ventana() {
        setTitle("Mi primera ventana en Java");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setContentPane(mainPanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Ventana();
    }
}
```

Al ejecutar la aplicación, veremos que se muestra una ventana con el título "Mi primera ventana en Java" y un tamaño de
400x300 píxeles. Esta ventana se cerrará al hacer clic en el botón de cierre y se ubicará en el centro de la pantalla.

Las ventanas son elementos esenciales en las interfaces de usuario, ya que proporcionan un contenedor visual para
mostrar otros componentes y permiten a los usuarios interactuar con el programa de forma visual y sencilla.

## Conclusiones

En esta práctica, aprendimos a crear una ventana básica en Java utilizando la biblioteca SWING. Las ventanas son
componentes gráficos fundamentales en las interfaces de usuario, ya que proporcionan un contenedor visual para mostrar
otros componentes y permiten a los usuarios interactuar con el programa de forma visual y sencilla. Al trabajar con
ventanas en Java, es importante tener en cuenta cómo configurar el título, tamaño, operación de cierre y ubicación de la
ventana para proporcionar una experiencia de usuario óptima. Además, es fundamental comprender cómo agregar y configurar
otros componentes en la ventana para crear interfaces de usuario completas y funcionales.