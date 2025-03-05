# El elemento `JToolBar`

El elemento `JToolBar` es un contenedor de botones que se utiliza para mostrar botones en la parte superior de la
ventana de la aplicación. Los botones pueden ser de diferentes tipos, como botones de comando, botones de radio, botones
de menú, etc.

En este tutorial, aprenderemos a utilizar el elemento `JToolBar` en una aplicación de Java Swing.

## Creación de un `JToolBar`

Para crear un `JToolBar` en una aplicación de Java Swing, primero necesitamos crear una ventana en vista de diseño. A
continuación, podemos arrastrar y soltar un `JToolBar` desde la paleta de componentes a la ventana.

![jtoolbar.png](jtoolbar.png)

Una vez que hemos agregado un `JToolBar` a la ventana, podemos agregar botones al `JToolBar` arrastrando y soltando
botones desde la paleta de componentes.

## Personalización de un `JToolBar`

Podemos personalizar un `JToolBar` cambiando su orientación, agregando separadores entre los botones, agregando
etiquetas a los botones, etc.

Para cambiar la orientación de un `JToolBar`, podemos hacer en su propiedad `orientation` en la vista de diseño.

Para agregar un separador entre los botones, podemos arrastrar y soltar un separador desde la paleta de componentes.

Para agregar etiquetas a los botones, podemos hacer clic derecho en un botón y seleccionar la opción "Edit Text" para
cambiar el texto del botón.

## Eventos de botón en un `JToolBar`

Podemos manejar eventos de botón en un `JToolBar` agregando un `ActionListener` a cada botón. Cuando se hace clic en un
botón, se invocará el método `actionPerformed` del `ActionListener`.

```java
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JToolBar;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("JToolBar Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JToolBar toolBar = new JToolBar();
        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button 1 clicked");
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button 2 clicked");
            }
        });

        toolBar.add(button1);
        toolBar.add(button2);

        frame.add(toolBar);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}
```

En este ejemplo, creamos un `JToolBar` con dos botones y agregamos un `ActionListener` a cada botón para manejar los
eventos de clic.

## Conclusión

En este tutorial, hemos aprendido a utilizar el elemento `JToolBar` en una aplicación de Java Swing. Ahora, puedes
comenzar a agregar barras de herramientas a tus aplicaciones Java para proporcionar una interfaz de usuario más
interactiva y fácil de usar.