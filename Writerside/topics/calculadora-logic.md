# Implementando la lógica de la calculadora

## El enumerado de las operaciones

1. Crea un nuevo enumerado llamado `Operation` en el paquete `calculadora`.
    - Para hacer esto, haz clic derecho sobre el paquete `calculadora` y selecciona `New` > `Java Class`. Y en la lista
      de tipos de archivo, selecciona `Enum`.
    - ![calculadora_enum.png](calculadora_enum.png)
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

## El evento de los números

1. Crea un nuevo paquete llamado `events` dentro del paquete `calculadora`.
    - Para hacer esto, haz clic derecho sobre el paquete `calculadora` y selecciona `New` > `Package`.
    - Nuestro proyecto debería verse de la siguiente manera:
        - ![calculadora_events.png](calculadora_events.png)
2. Crea una nueva clase llamada `NumberAction` en el paquete `events`.
3. Haz que la clase implemente la interfaz `ActionListener`.
    - Para hacer esto, coloca el cursor después del nombre de la clase y agrega `implements ActionListener`.
    - Por lo que la declaración de la clase debería verse de la siguiente manera:
      ```java
      public class NumberAction implements ActionListener {
      ```
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

Por lo que el código del constructor de la clase `Calculadora` debería verse de la siguiente manera:

```java
    public Calculadora() {
        // Configuración de la ventana
        setTitle("Calculadora");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        // Eventos de los dígitos
        btn0.addActionListener(new NumberAction(this, 0));
        btn1.addActionListener(new NumberAction(this, 1));
        btn2.addActionListener(new NumberAction(this, 2));
        btn3.addActionListener(new NumberAction(this, 3));
        btn4.addActionListener(new NumberAction(this, 4));
        btn5.addActionListener(new NumberAction(this, 5));
        btn6.addActionListener(new NumberAction(this, 6));
        btn7.addActionListener(new NumberAction(this, 7));
        btn8.addActionListener(new NumberAction(this, 8));
        btn9.addActionListener(new NumberAction(this, 9));
    }
```

## El controlador de la calculadora

1. Crea un nuevo paquete llamado `controllers` dentro del paquete `calculadora`.
2. Crea una nueva clase llamada `CalculadoraController` en el paquete `controllers`.
3. Agrega los siguientes atributos a la clase:
    - private int firstNumber;
    - private int secondNumber;
    - private int partial;
    - private Operation prevOperation;
    - private final Calculadora calculadora;
4. Crea un constructor que reciba como parámetro una instancia de `Calculadora`.
5. Implementa un método llamado `calculate` que realice las operaciones aritméticas.
    - Dentro de este método, deberás realizar las operaciones aritméticas de acuerdo a la operación seleccionada.
    - Por ejemplo, si la operación es `ADDITION`, deberás sumar los números y mostrar el resultado en el campo de texto
      de la calculadora.
    - Si la operación es `EQUALS`, deberás realizar la operación aritmética y mostrar el resultado en el campo de texto
      de la calculadora, etc.
6. Implementa un método llamado `makeOperation` que reciba como parámetro una operación y realice la lógica de la
   calculadora.
    - Dentro de este método, deberás realizar la lógica de la calculadora para cada operación.
    - Por ejemplo, si la operación es `ADDITION` o cualquier otra operación aritmética, deberás invocar el método
      `calculate` y realizar la operación correspondiente.
    - Si la operación es `EQUALS`, deberás invocar el método `calculate` y mostrar el resultado en el campo de texto
      de la calculadora.
    - Si la operación es `CLEAR`, deberás limpiar los valores de los números y las operaciones.
7. Por el momento hemos terminado con el controlador de la calculadora.

El código de la clase `CalculadoraController` debería verse de la siguiente manera:

```java
package calculadora.controllers;

import calculadora.Calculadora;
import calculadora.Operation;

public class CalculadoraController {

    private int firstNumber;
    private int secondNumber;
    private int partial;
    private Operation prevOperation;
    private final Calculadora calculadora;

    public CalculadoraController(Calculadora calculadora) {
        
        this.calculadora = calculadora;
        this.firstNumber = 0;
        this.secondNumber = 0;
        this.partial = 0;
        this.prevOperation = null;
    }

    public void calculate() {
        // Dependiendo de la operación previa, calculamos el resultado y lo guardamos en partial
        if (prevOperation != null) {
            switch (prevOperation) {
                case ADDITION -> partial = firstNumber + secondNumber;
                case SUBTRACTION -> partial = firstNumber - secondNumber;
                case MULTIPLICATION -> partial = firstNumber * secondNumber;
                case DIVISION -> partial = firstNumber / secondNumber;
            }
            // Asignamos el valor de partial a firstNumber y limpiamos secondNumber
            firstNumber = partial;
            secondNumber = 0;
        }
    }

    public void makeOperation(Operation operation) {

        // Si la operación es limpiar, se borra el campo de texto y se reinician las variables
        if (operation == Operation.CLEAR) {
            calculadora.getTxtResultado().setText("");
            firstNumber = 0;
            secondNumber = 0;
            partial = 0;
            prevOperation = null;
        } else {
            if (prevOperation != null) {
                // Si hay una operación previa, recuperamos el valor del campo de texto y lo asignamos a secondNumber
                secondNumber = calculadora.getTxtResultado().getText().isEmpty() ? 0
                        : Integer.parseInt(calculadora.getTxtResultado().getText());
                switch (operation) {
                    // Si la operación es una de las básicas, calculamos el resultado y lo guarda en partial
                    case ADDITION, SUBTRACTION, MULTIPLICATION, DIVISION -> {
                        calculate();
                        prevOperation = operation;
                        calculadora.getTxtResultado().setText("");
                    }
                    // Si la operación es igual, calculamos el resultado y lo mostramos en el campo de texto
                    case EQUALS -> {
                        calculate();
                        calculadora.getTxtResultado().setText(String.valueOf(partial));
                        firstNumber = partial;
                        secondNumber = 0;
                        partial = 0;
                        prevOperation = null;
                    }
                }
            } else {
                // Si no hay operación previa, guardamos el valor del campo de texto en firstNumber
                firstNumber = calculadora.getTxtResultado().getText().isEmpty() ? 0
                        : Integer.parseInt(calculadora.getTxtResultado().getText());
                // Guardamos la operación actual y limpiamos el campo de texto
                prevOperation = operation;
                calculadora.getTxtResultado().setText("");
                // Si la operación es división o multiplicación, asignamos 1 a secondNumber
                // esto es para que el resultado sea correcto y no se pierda la operación
                if (operation == Operation.DIVISION || operation == Operation.MULTIPLICATION) {
                    secondNumber = 1;
                }
                // Calculamos el resultado y lo guardamos en partial y firstNumber
                calculate();
            }
        }
    }
}
```

Con lo anterior, hemos implementado la lógica de la calculadora. Ahora deberemos agregar el controlador a la clase
`Calculadora` como un nuevo atributo final. Para ello, agregaremos el siguiente código en de la clase lo siguiente:

```java
private final CalculadoraController controller;
```

Mientras al constructor de la clase `Calculadora` lo siguiente:

```java
controller = new CalculadoraController(this);
```

Por lo que el código del constructor de la clase `Calculadora` debería verse de la siguiente manera:

```java
    public Calculadora() {
        // Controlador de la calculadora
        controller = new CalculadoraController(this);
        // Configuración de la ventana
        setTitle("Calculadora");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setContentPane(mainPanel);
        setVisible(true);
        // Eventos de los dígitos
        btn0.addActionListener(new NumberAction(this, 0));
        btn1.addActionListener(new NumberAction(this, 1));
        btn2.addActionListener(new NumberAction(this, 2));
        btn3.addActionListener(new NumberAction(this, 3));
        btn4.addActionListener(new NumberAction(this, 4));
        btn5.addActionListener(new NumberAction(this, 5));
        btn6.addActionListener(new NumberAction(this, 6));
        btn7.addActionListener(new NumberAction(this, 7));
        btn8.addActionListener(new NumberAction(this, 8));
        btn9.addActionListener(new NumberAction(this, 9));
    }
```

Además de lo anterior, deberemos agregar el método `getController` a la clase `Calculadora`. Para ello, agregaremos el
siguiente código a la clase `Calculadora`:

```java
    public CalculadoraController getController() {
        return controller;
    }
```

## El evento de las operaciones

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

Ahora deberemos agregar a los botones de la calculadora el evento de las operaciones. Para ello, colocaremos el
siguiente código en el constructor de la clase `Calculadora`:

```java
btnSuma.addActionListener(new OperationAction(this, Operation.ADDITION));
btnResta.addActionListener(new OperationAction(this, Operation.SUBTRACTION));
btnMulti.addActionListener(new OperationAction(this, Operation.MULTIPLICATION));
btnDiv.addActionListener(new OperationAction(this, Operation.DIVISION));
btnIgual.addActionListener(new OperationAction(this, Operation.EQUALS));
btnLimpiar.addActionListener(new OperationAction(this, Operation.CLEAR));
```

### Código final de la clase `Calculadora`

Una vez que hemos implementado la lógica de la calculadora, la clase `Calculadora` debería verse de la siguiente manera:

```java
package calculadora;

import calculadora.controllers.CalculadoraController;
import calculadora.events.NumberAction;
import calculadora.events.OperationAction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora extends JFrame {

    private JPanel mainPanel;
    private JTextField txtResultado;
    private JButton btn6;
    private JButton btn7;
    private JButton btn8;
    private JButton btn9;
    private JButton btn2;
    private JButton btn3;
    private JButton btn4;
    private JButton btn5;
    private JButton btn0;
    private JButton btn1;
    private JButton btnSuma;
    private JButton btnIgual;
    private JButton btnResta;
    private JButton btnMulti;
    private JButton btnDiv;
    private JButton btnLimpiar;
    private final CalculadoraController controller;

    public static void main(String[] args) {
        new Calculadora();
    }

    public Calculadora() {
        // Controlador de la calculadora
        controller = new CalculadoraController(this);
        // Configuración de la ventana
        setTitle("Calculadora");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setContentPane(mainPanel);
        setVisible(true);
        // Eventos
        // Números
        btn0.addActionListener(new NumberAction(this, 0));
        btn1.addActionListener(new NumberAction(this, 1));
        btn2.addActionListener(new NumberAction(this, 2));
        btn3.addActionListener(new NumberAction(this, 3));
        btn4.addActionListener(new NumberAction(this, 4));
        btn5.addActionListener(new NumberAction(this, 5));
        btn6.addActionListener(new NumberAction(this, 6));
        btn7.addActionListener(new NumberAction(this, 7));
        btn8.addActionListener(new NumberAction(this, 8));
        btn9.addActionListener(new NumberAction(this, 9));
        // Operaciones
        btnSuma.addActionListener(new OperationAction(this, Operation.ADDITION));
        btnResta.addActionListener(new OperationAction(this, Operation.SUBTRACTION));
        btnMulti.addActionListener(new OperationAction(this, Operation.MULTIPLICATION));
        btnDiv.addActionListener(new OperationAction(this, Operation.DIVISION));
        btnIgual.addActionListener(new OperationAction(this, Operation.EQUALS));
        btnLimpiar.addActionListener(new OperationAction(this, Operation.CLEAR));
    }

    public JTextField getTxtResultado() {
        return txtResultado;
    }

    public CalculadoraController getController() {
        return controller;
    }
}
```

Con lo anterior, hemos implementado la lógica de la calculadora. Ahora deberemos ejecutar la aplicación y verificar que
la ventana de la calculadora se muestre correctamente.

## Resumen

En esta lección, hemos implementado la lógica de la calculadora. Hemos creado un enumerado con las operaciones
aritméticas y hemos implementado los eventos de los números y las operaciones. Hemos creado un controlador de la
calculadora que realiza las operaciones aritméticas y hemos agregado la lógica de la calculadora a la clase
`Calculadora`.

## Para la entrega

Para la entrega de esta práctica, deberás realizar lo siguiente:

1. Verificar que la ventana de la calculadora se muestre correctamente.
2. Verificar que los eventos de los números y las operaciones funcionen correctamente.
3. Verificar que la lógica de la calculadora sea correcta y que realice las operaciones aritméticas correctamente.
4. Cambia el tamaño de fuente de los botones de la calculadora a 24px, al igual que el campo de texto.
5. Cambia el color de fondo de los botones de la calculadora a tu gusto.
6. Cambia el color de fondo del campo de texto de la calculadora a tu gusto.
7. Cambia el color de la fuente del campo de texto de la calculadora a tu gusto.
8. Cambia el color de la fuente de los botones de la calculadora a tu gusto.
9. Cambia el color de fondo del panel principal de la calculadora a tu gusto.
10. Comprime el proyecto en un archivo ZIP y envíalo a través de la plataforma, adjuntando además la portada de la
    práctica, con los datos de identificación de tu equipo.