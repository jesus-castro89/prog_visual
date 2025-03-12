# Los contenedores `JTable` y `JList`

Los componentes `JTable` y `JList` son dos de los componentes más utilizados en Java Swing para mostrar datos tabulares
y listas, respectivamente. Ambos son parte de la biblioteca Swing y se utilizan para crear interfaces de usuario
gráficas en aplicaciones Java.

## JTable

`JTable` es un componente que se utiliza para mostrar datos en forma de tabla. Permite mostrar datos en filas y
columnas, lo que lo hace ideal para mostrar información estructurada, como hojas de cálculo o bases de datos. Aquí hay
un ejemplo básico de cómo crear un `JTable` en Java Swing:

```java
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JTableExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JTable Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        // Crear un modelo de tabla
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nombre");
        model.addColumn("Edad");

        // Crear una tabla con el modelo
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Botón para agregar datos a la tabla
        JButton addButton = new JButton("Agregar");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = JOptionPane.showInputDialog("Ingrese el nombre:");
                String edadStr = JOptionPane.showInputDialog("Ingrese la edad:");
                int edad = Integer.parseInt(edadStr);
                model.addRow(new Object[]{nombre, edad});
            }
        });
        frame.add(addButton, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}
```

En este ejemplo, creamos un `JTable` con un modelo de tabla (`DefaultTableModel`) que tiene dos columnas: "Nombre" y "
Edad".

El botón "Agregar" permite al usuario ingresar datos y agregarlos a la tabla. La tabla se muestra dentro de un
`JScrollPane` para permitir el desplazamiento si hay demasiadas filas para mostrar en la ventana.

## JList

`JList` es un componente que se utiliza para mostrar una lista de elementos. A diferencia de `JTable`, `JList` no
muestra datos en forma de tabla, sino que muestra una lista vertical de elementos. Aquí hay un ejemplo básico de cómo
crear un `JList` en Java Swing:

```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JListExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JList Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new BorderLayout());

        // Crear una lista de elementos
        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> list = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(list);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Botón para agregar elementos a la lista
        JButton addButton = new JButton("Agregar");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String item = JOptionPane.showInputDialog("Ingrese un elemento:");
                if (item != null && !item.trim().isEmpty()) {
                    listModel.addElement(item);
                }
            }
        });
        frame.add(addButton, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}
```

En este ejemplo, creamos un `JList` con un modelo de lista (`DefaultListModel`) que permite agregar elementos a la
lista. El botón "Agregar" permite al usuario ingresar un elemento y agregarlo a la lista. Al igual que con `JTable`,
la lista se muestra dentro de un `JScrollPane` para permitir el desplazamiento si hay demasiados elementos para
mostrar en la ventana.

## Conclusión

`JTable` y `JList` son componentes útiles para mostrar datos tabulares y listas en aplicaciones Java Swing. Ambos
componentes son altamente personalizables y permiten agregar, eliminar y modificar elementos de manera sencilla. Puedes
usar estos componentes para crear interfaces de usuario interactivas y atractivas en tus aplicaciones Java.