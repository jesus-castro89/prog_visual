# Practica 3: Creando una calculadora en Java

En esta práctica, aprenderemos a crear una calculadora básica en Java utilizando la biblioteca SWING. Las calculadoras
son herramientas útiles que permiten a los usuarios realizar operaciones matemáticas de forma rápida y sencilla. Al
aprender a crear una calculadora en Java, podrás mejorar tus habilidades de programación y diseño de interfaces de
usuario.

## Creando la interfaz de la calculadora

1. Crea un nuevo proyecto de Java en IntelliJ IDEA.
2. Crea dentro de la carpeta `src` un nuevo paquete llamado `calculadora`.
    - Para hacer esto, haz clic derecho sobre la carpeta `src` y selecciona `New` > `Package`.
    - ![calculadora_package.png](calculadora_package.png)
3. Crea una nueva ventana mediante el editor de diseño de IntelliJ IDEA.
    - Para hacer esto, haz clic derecho sobre el paquete `calculadora` y selecciona
      `New` > `Swing GUI Designer` > `GUI Form`.
    - ![calculadora_window.png](calculadora_window.png)
4. Renombra el panel principal como `mainPanel`.
    - Para hacer esto, selecciona el panel en el editor visual y cambia el nombre en la barra de propiedades.
    - ![calculadora_panel.png](calculadora_panel.png)
5. Haz que la clase de la ventana extienda de `JFrame` y crea un constructor para la misma con lo siguiente:
    ```java
    public class Calculadora extends JFrame {
        private JPanel mainPanel;

        public Calculadora() {
            setTitle("Calculadora");
            setSize(300, 400);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setContentPane(mainPanel);
            setVisible(true);
        }
    }
    ```
6. Arrastra dos paneles a la ventana para dividir la interfaz en dos secciones: una para los botones y otra para el
   resultado.
    - ![calculadora_panels.png](calculadora_paneles.png)
7. Agrega un campo de texto para mostrar el resultado de las operaciones en la parte superior de la ventana y renombralo
   a `txtResultado`.
    - ![calculadora_textfield.png](calculadora_textfield.png)
8. Agrega botones para los números y operaciones matemáticas en la parte inferior de la ventana.
    - ![calculadora_buttons.png](calculadora_buttons.png)
    - > **Nota:** En este ejemplo los botones se llamarán btn1, ..., btn9, btnSuma, btnResta, btnMultiplicacion,
      btnDivision, btnIgual y btnLimpiar. Pero tú puedes nombrarlos como desees.
      > **Nota:** De igual manera, puedes personalizar la disposición y diseño de los botones según tus preferencias.
9. Si hemos seguimos los pasos anteriores, la clase `Calculadora` debería verse de la siguiente manera:
    ```java
    public class Calculadora extends JFrame {
        private JPanel mainPanel;
        private JTextField txtResultado;
        private JButton btn1;
        private JButton btn2;
        private JButton btn3;
        private JButton btn4;
        private JButton btn5;
        private JButton btn6;
        private JButton btn7;
        private JButton btn8;
        private JButton btn9;
        private JButton btnSuma;
        private JButton btnResta;
        private JButton btnMultiplicacion;
        private JButton btnDivision;
        private JButton btnIgual;
        private JButton btnLimpiar;

        public Calculadora() {
            setTitle("Calculadora");
            setSize(300, 400);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setContentPane(mainPanel);
            setVisible(true);
        }
    }
    ```
10. Podemos crear la función main para ejecutar la aplicación y mostrar la ventana de la calculadora.
    ```java
    public static void main(String[] args) {
        new Calculadora();
    }
    ```
11. Ejecuta la aplicación y verifica que la ventana de la calculadora se muestre correctamente.
12. ¡Listo! Has creado la interfaz de la calculadora en Java.

> **Nota:** Para esta práctica agregaré un margen sobre el panel principal de 10px. Para ello, selecciona el panel en el
> editor visual y en la barra de propiedades, busca la propiedad `margins` y coloca el valor `10` en los campos `top`,
> `left`, `bottom` y `right`.

## Implementando la lógica de la calculadora

### El enumerado de las operaciones

1. Crea un nuevo enumerado llamado `Operation` en el paquete `calculadora`.
2. Agrega las siguientes constantes al enumerado:
    - `ADDITION`
    - `SUBTRACTION`
    - `MULTIPLICATION`
    - `DIVISION`
    - `EQUALS`
    - `CLEAR`

El enumerado debería verse de la siguiente manera:

```java
public enum Operation {
    ADDITION,
    SUBTRACTION,
    MULTIPLICATION,
    DIVISION,
    EQUALS,
    CLEAR
}
```

### La clase `CalculadoraController`

1. Crea un nuevo paquete llamado `controllers` dentro del paquete `calculadora`.
2. Crea una nueva clase llamada `CalculadoraController` en el paquete `controllers`.
3. Agrega un campo de tipo `Calculadora` a la clase.
4. Agrega un campo de tipo `Operation` para almacenar la operación actual.
5. Agrega campos de tipo `double` para almacenar el primer y segundo operando.
6. Crear un constructor para la clase que reciba una instancia de `Calculadora` y la asigne al campo correspondiente.
7. Agrega un método `init` que inicialice los campos de la clase.
8. 