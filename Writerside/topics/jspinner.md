# El componente `JSpinner`

El componente `JSpinner` es un control de interfaz gráfica de usuario que permite a los usuarios seleccionar un valor
numérico o de otro tipo de una lista de opciones. Es útil para situaciones en las que se necesita seleccionar un valor
dentro de un rango específico, como la selección de una cantidad, una fecha o una hora.

## Creando un JSpinner

Para crear un `JSpinner`, puedes usar el constructor de la clase `JSpinner` y especificar el modelo de datos que deseas
utilizar. Por ejemplo, si deseas crear un `JSpinner` que permita seleccionar un número entero entre 0 y 100, puedes usar
el modelo `SpinnerNumberModel` de la siguiente manera:

```java
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JSpinnerExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JSpinner Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new FlowLayout());

        // Crear un modelo de número para el JSpinner
        SpinnerNumberModel model = new SpinnerNumberModel(0, 0, 100, 1);
        JSpinner spinner = new JSpinner(model);

        // Agregar un ChangeListener al JSpinner
        spinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int value = (int) spinner.getValue();
                System.out.println("Valor seleccionado: " + value);
            }
        });

        // Botón para mostrar el valor seleccionado
        JButton button = new JButton("Mostrar Valor");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int value = (int) spinner.getValue();
                JOptionPane.showMessageDialog(frame, "Valor seleccionado: " + value);
            }
        });

        frame.add(spinner);
        frame.add(button);
        frame.setVisible(true);
    }
}
```

En este ejemplo, creamos un `JSpinner` con un modelo de número (`SpinnerNumberModel`) que permite seleccionar un
número entero entre 0 y 100. También agregamos un `ChangeListener` al `JSpinner` para que se imprima el valor
seleccionado en la consola cada vez que cambie. Además, hay un botón que muestra el valor seleccionado en un cuadro de
diálogo cuando se hace clic en él.

## Personalizando el JSpinner

Puedes personalizar el aspecto y el comportamiento del `JSpinner` utilizando diferentes modelos de datos, como
`SpinnerDateModel` para fechas y horas, o `SpinnerListModel` para listas de elementos personalizados. También puedes
cambiar el formato de visualización del valor seleccionado utilizando un `JSpinner.DefaultEditor` y un
`JSpinner.DateEditor` para formatear fechas y horas.

## Conclusión

El `JSpinner` es un componente útil en Java Swing para permitir a los usuarios seleccionar valores de una lista de
opciones. Puedes personalizar su comportamiento y apariencia según tus necesidades. En este ejemplo, hemos visto cómo
crear un `JSpinner` básico y cómo agregar un `ChangeListener` para manejar los cambios en el valor seleccionado. También
hemos mostrado cómo usar un botón para mostrar el valor seleccionado en un cuadro de diálogo. Puedes explorar más
opciones de personalización y modelos de datos según tus requisitos específicos.