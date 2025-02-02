# La ventana JFrame

La clase `JFrame` es una clase que pertenece al paquete `javax.swing` y que nos permite crear ventanas en las
aplicaciones de escritorio. La clase `JFrame` es una subclase de la clase `Frame` de AWT, pero con muchas más
funcionalidades.

Dentro de IntelliJ IDEA, podemos crear una ventana `JFrame` de la siguiente manera:

1. Creamos un nuevo proyecto de Java en IntelliJ IDEA.
2. Creamos un nuevo archivo del tipo "GUI Form" (formulario de interfaz gráfica de usuario).
3. En el archivo creado, podemos arrastrar y soltar los componentes que queremos añadir a la ventana.
4. Podemos personalizar la ventana y los componentes añadidos mediante las propiedades de cada componente.
5. Podemos añadir eventos a los componentes para que realicen acciones específicas al interactuar con ellos.
6. Podemos ejecutar la aplicación y ver la ventana creada con los componentes añadidos.

A continuación, veremos un ejemplo de cómo crear una ventana `JFrame` en Java:

```java
import javax.swing.JFrame;

public class Ventana extends JFrame {
    public Ventana() {
        setTitle("Mi primera ventana");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Ventana();
    }
}
```

En este ejemplo, creamos una clase `Ventana` que hereda de la clase `JFrame` y que define un constructor en el que
configuramos el título de la ventana, su tamaño, la operación de cierre, la posición y la visibilidad. Luego, en el
método `main`, creamos una instancia de la clase `Ventana` para mostrar la ventana en pantalla.

Para ello, utilizamos los siguientes métodos de la clase `JFrame`:

- `setTitle(String title)`: Establece el título de la ventana.
  - Por ejemplo, `setTitle("Mi primera ventana")` establece el título de la ventana como "Mi primera ventana".
- `setSize(int width, int height)`: Establece el tamaño de la ventana en píxeles.
    - Por ejemplo, `setSize(400, 300)` establece el tamaño de la ventana en 400x300 píxeles.
- `setDefaultCloseOperation(int operation)`: Establece la operación de cierre de la ventana.
  - Por ejemplo, `setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)` cierra la aplicación al cerrar la ventana.
- `setLocationRelativeTo(Component c)`: Establece la posición de la ventana en relación a un componente.
  - Por ejemplo, `setLocationRelativeTo(null)` centra la ventana en la pantalla.
- `setVisible(boolean visible)`: Establece la visibilidad de la ventana.
  - Por ejemplo, `setVisible(true)` muestra la ventana en pantalla.

Al ejecutar este código, veremos una ventana con el título "Mi primera ventana" y un tamaño de 400x300 píxeles en el
centro de la pantalla.

La clase `JFrame` nos permite crear ventanas personalizadas con diferentes componentes y funcionalidades, lo que nos
permite diseñar interfaces gráficas de usuario de manera sencilla y visual.

En resumen, la clase `JFrame` es una clase fundamental en el desarrollo de aplicaciones de escritorio en Java, ya que
nos permite crear ventanas y diseñar interfaces gráficas de usuario de manera sencilla y visual.