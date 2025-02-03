# El componente JLabel

El componente `JLabel` es un componente de la interfaz gráfica de usuario (GUI) de Java que se utiliza para mostrar
texto no editable en una ventana de la aplicación. Las etiquetas son componentes estáticos que permiten mostrar
información al usuario de manera visual y descriptiva.

En este tutorial, veremos cómo utilizar el componente `JLabel` en Java para mostrar texto en una ventana y cómo
personalizar sus propiedades para adaptarlo a nuestras necesidades mediante el editor visual de IntelliJ IDEA.

## ¿Cómo crear una etiqueta en Java?

Para crear una etiqueta en Java, necesitamos seguir los siguientes pasos:

1. **Crea una nueva ventana `JFrame`**: Antes de crear la etiqueta, necesitamos crear una ventana en la que mostrarla.
2. **Arrastra y suelta una etiqueta desde la paleta de componentes**: En el editor visual de IntelliJ IDEA, podemos
   arrastrar y soltar una etiqueta (`JLabel`) desde la paleta de componentes a la ventana.
3. **Personaliza las propiedades de la etiqueta**: Podemos personalizar el texto, el color, la fuente, el tamaño y otras
   propiedades de la etiqueta mediante el inspector de propiedades.
    - Puedes modificar las propiedades en el inspector de propiedades de IntelliJ IDEA.
4. **Ejecuta la aplicación y visualiza la etiqueta**: Una vez configurada la etiqueta, podemos ejecutar la aplicación y
   ver la etiqueta en la ventana.
5. **Verífica que la etiqueta se muestra correctamente**: Al ejecutar la aplicación, verifica que la etiqueta se muestra
   correctamente con el texto y las propiedades configuradas.
6. **Documenta y comparte tu código**: Documenta el código de la aplicación y compártelo con otros desarrolladores para
   que puedan aprender de tu experiencia.

> **Nota**: Las etiquetas son componentes estáticos y no permiten la interacción directa con el usuario. Si necesitas
> permitir al usuario editar o interactuar con el texto, puedes utilizar otros componentes como `JTextField` o
> `JTextArea`.

> **Nota**: Recuerda configurar correctamente tu ventana para poder apreciar la etiqueta en la interfaz gráfica.

> **Consejo**: Utiliza las etiquetas para mostrar información descriptiva, títulos, instrucciones o mensajes al usuario
> en la interfaz de tu aplicación.

## Ejemplo de etiqueta en Java

A continuación, veremos un ejemplo de cómo crear una etiqueta en Java utilizando el editor visual de IntelliJ IDEA:

```java
import javax.swing.JFrame;

public class Ventana extends JFrame {

    private JPanel mainPanel;
    
    public Ventana() {
        setTitle("Mi primera ventana");
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

Analicemos el código:

1. Importamos la clase `JFrame` del paquete `javax.swing`. 
2. Creamos una clase `Ventana` que hereda de `JFrame`.
3. Definimos un constructor (vacío) en el que configuramos el título, el tamaño, la operación de cierre, la posición y
   la visibilidad de la ventana.
4. Agregamos el panel principal `mainPanel` a la ventana.
5. En el método `main`, creamos una instancia de la clase `Ventana` para mostrar la ventana en pantalla.
6. Al ejecutar la aplicación, veremos una ventana con el título «Mi primera ventana» y el panel principal `mainPanel`.
7. ¡Celebra el éxito de haber creado tu primera ventana con una etiqueta en Java!

> **Consejo**: Utiliza el editor visual de IntelliJ IDEA para arrastrar y soltar componentes en la ventana y
> personalizar sus propiedades de manera sencilla y visual.

> **Consejo**: Experimenta con diferentes propiedades y configuraciones de la etiqueta para adaptarla a tus necesidades
> y crear interfaces de usuario atractivas y funcionales.

¡Ahora estás listo para crear etiquetas en Java y mostrar texto en tus aplicaciones de manera visual y descriptiva!