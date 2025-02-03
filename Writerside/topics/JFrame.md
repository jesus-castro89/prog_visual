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

    // Panel principal de la ventana creado en el editor visual
    private JPanel mainPanel;
    
    public Ventana() {
        // Configurar la ventana
        // Título de la ventana
        setTitle("Mi primera ventana");
        // Tamaño de la ventana
        setSize(400, 300);
        // Operación de cierre de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Posición de la ventana
        setLocationRelativeTo(null);
        // Añadir el panel principal a la ventana
        setContentPane(mainPanel);
        // Mostrar la ventana en pantalla
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
- `setContentPane(Container c)`: Establece el panel principal de la ventana.
  - Por ejemplo, `setContentPane(mainPanel)` establece el panel principal de la ventana como `mainPanel`.
- `add(Component c)`: Añade un componente a la ventana.
  - Por ejemplo, `add(boton)` añade un botón a la ventana.

> **Nota**: Cuando creamos una ventana `JFrame`, es importante establecer su tamaño, título, operación de cierre y
> posición antes de mostrarla en pantalla con el método `setVisible(true)`.

> **Nota**: Cuando trabajamos con el editor de formularios de IntelliJ IDEA, podemos arrastrar y soltar los componentes
> que queremos añadir a la ventana, y personalizar sus propiedades y eventos de manera visual y sencilla. Sin embargo,
> para que los cambios realizados en el editor se reflejen en el código, debemos nombrar el panel principal de la
> ventana y agregarlo al contenedor de la ventana en el código mediante el método `add`.

Al ejecutar este código, veremos una ventana con el título "Mi primera ventana" y un tamaño de 400x300 píxeles en el
centro de la pantalla.

La clase `JFrame` nos permite crear ventanas personalizadas con diferentes componentes y funcionalidades, lo que nos
permite diseñar interfaces gráficas de usuario de manera sencilla y visual.

En resumen, la clase `JFrame` es una clase fundamental en el desarrollo de aplicaciones de escritorio en Java, ya que
nos permite crear ventanas y diseñar interfaces gráficas de usuario de manera sencilla y visual.