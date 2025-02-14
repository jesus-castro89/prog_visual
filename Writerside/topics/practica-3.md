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

### El evento de los números

1. Crea un nuevo paquete llamado `events` dentro del paquete `calculadora`.
2. Crea una nueva clase llamada `NumberAction` en el paquete `events`.
3. Haz que la clase implemente la interfaz `ActionListener`.
4. Agregamos los siguientes atributos:
    - private final Calculadora calculadora;
    - private final int number;
5. Creamos un constructor que reciba como parámetros una instancia de `Calculadora` y un número entero.
6. Implementamos el método `actionPerformed` y dentro de él, agregamos el siguiente código:
    - ```java
      public void actionPerformed(java.awt.event.ActionEvent e) {
        calculadora.getTxtResultado().setText(calculadora.getTxtResultado().getText() + number);
      }
      ```
7. Por el momento hemos terminado con el evento de los números.

El código de la clase `NumberAction` debería verse de la siguiente manera:

```java
package calculadora.events;

import calculadora.Calculadora;

import java.awt.event.ActionListener;

public class NumberAction implements ActionListener {

    private final int number;
    private final Calculadora calculadora;

    public NumberAction(Calculadora calculadora, int number) {
        this.number = number;
        this.calculadora = calculadora;
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        calculadora.getTxtResultado().setText(calculadora.getTxtResultado().getText() + number);
    }
}
```

Ahora deberemos agregar a los botones de la calculadora el evento de los números. Para ello, colocaremos el siguiente
código en el constructor de la clase `Calculadora`:

```java
btn1.addActionListener(new NumberAction(this, 1));
```

Repetiremos este paso para los botones `btn2`, `btn3`, `btn4`, `btn5`, `btn6`, `btn7`, `btn8`, `btn9` y `btn0`.

### El controlador de la calculadora

1. Crea un nuevo paquete llamado `controllers` dentro del paquete `calculadora`.
2. Crea una nueva clase llamada `CalculadoraController` en el paquete `controllers`.
3. Agrega los siguientes atributos a la clase:
    - private final Calculadora calculadora;
    - private int number1, number2;
    - private Operation lastOperation, operation;
4. Crea un constructor que reciba como parámetro una instancia de `Calculadora`.
5. Agrega un método `calculate` que calcule el resultado de la operación en caso de que se presione nuevamente una
   acción diferente a la igualdad.
6. Agrega un método `makeOperation` que almacene en las variables `number1` y `number2` los valores actuales y la
   operación a realizar.
7. Una vez hecho lo anterior, deberemos agregar el controlador a los botones de operaciones. Para ello, colocaremos el
   siguiente código en el constructor de la clase `Calculadora`:
    - ```java
      btnSuma.addActionListener(new OperationAction(this, Operation.ADDITION));
      btnResta.addActionListener(new OperationAction(this, Operation.SUBTRACTION));
      btnMultiplicacion.addActionListener(new OperationAction(this, Operation.MULTIPLICATION));
      btnDivision.addActionListener(new OperationAction(this, Operation.DIVISION));
      btnIgual.addActionListener(new OperationAction(this, Operation.EQUALS));
      btnLimpiar.addActionListener(new OperationAction(this, Operation.CLEAR));
      ```
8. Por el momento hemos terminado con el controlador de la calculadora.

El código de la clase `CalculadoraController` debería verse de la siguiente manera:

```java
package calculadora.controllers;

import calculadora.Calculadora;
import calculadora.Operation;

public class CalculadoraController {

    private final Calculadora calculadora;
    private int number1, number2;
    private Operation lastOperation, operation;

    public CalculadoraController(Calculadora calculadora) {

        this.calculadora = calculadora;
        this.number1 = 0;
        this.number2 = 0;
        this.operation = null;
        this.lastOperation = null;
    }

    public void makeOperation(Operation operation) {

        if (this.operation == null) {
            this.operation = operation;
            this.number1 = Integer.parseInt(calculadora.getTxtResultado().getText());
            this.calculadora.getTxtResultado().setText("");
        } else {
            this.lastOperation = this.operation;
            this.operation = operation;
            this.number2 = Integer.parseInt(calculadora.getTxtResultado().getText());
        }
        switch (this.operation) {
            case ADDITION:
            case SUBTRACTION:
            case MULTIPLICATION:
            case DIVISION:
                calculate();
                break;
            case EQUALS:
                calculate();
                this.calculadora.getTxtResultado().setText(String.valueOf(number1));
                break;
            case CLEAR:
                this.number1 = 0;
                this.number2 = 0;
                this.lastOperation = null;
                this.operation = null;
                this.calculadora.getTxtResultado().setText("");
                break;
        }
    }

    private void calculate() {

        if (lastOperation != null) {

            switch (lastOperation) {
                case ADDITION:
                    number1 += number2;
                    break;
                case SUBTRACTION:
                    number1 -= number2;
                    break;
                case MULTIPLICATION:
                    number1 *= number2;
                    break;
                case DIVISION:
                    number1 /= number2;
                    break;
            }
            calculadora.getTxtResultado().setText("");
        }
    }
}
```

### El evento de las operaciones

1. Crea una nueva clase llamada `OperationAction` en el paquete `events`.
2. Haz que la clase implemente la interfaz `ActionListener`.
3. Agregamos los siguientes atributos:
    - private final Calculadora calculadora;
    - private final Operation operation;
4. Creamos un constructor que reciba como parámetros una instancia de `Calculadora` y una operación.
5. Implementamos el método `actionPerformed` y dentro de él, agregamos el siguiente código:
    - ```java
      public void actionPerformed(java.awt.event.ActionEvent e) {
        calculadora.getCalculadoraController().makeOperation(operation);
      }
      ```
6. Por el momento hemos terminado con el evento de las operaciones.

El código de la clase `OperationAction` debería verse de la siguiente manera:

```java
package calculadora.events;

import calculadora.Calculadora;
import calculadora.Operation;

import java.awt.event.ActionListener;

public class OperationAction implements ActionListener {

    private final Operation operation;
    private final Calculadora calculadora;

    public OperationAction(Calculadora calculadora, Operation operation) {
        this.operation = operation;
        this.calculadora = calculadora;
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        calculadora.getController().makeOperation(operation);
    }
}
```