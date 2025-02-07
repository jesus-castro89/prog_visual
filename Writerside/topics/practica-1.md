# Practica 1: Creando la ventana principal

En esta práctica vamos a crear la ventana principal de nuestra aplicación. La ventana principal contendrá un menú con
las opciones de la aplicación y un panel principal donde se mostrarán los componentes de la aplicación.

## Creando el proyecto

En IntelliJ IDEA, crea un nuevo proyecto de Java llamado `MiAplicacion` o como prefieras. Asegúrate de que el proyecto
tenga una estructura de paquetes adecuada para organizar el código de la aplicación.

## Creando el Frame principal

Crea un nuevo componente con el `SWING UI Designer` de IntelliJ IDEA. Para ello, haz clic con el botón derecho en el
paquete `src` y selecciona `New` > `Swing UI Designe` > `GUI Form`.

En el cuadro de diálogo que aparece, coloca el nombre del archivo como `MainFrame` o como más te agrade y haz clic en
`OK`.

Cuando hacemos lo anterior debemos realizar lo siguiente en la clase `MainFrame.java`:

1. Hacer que la clase herede de `JFrame`.
    - Para ello, cambia `public class MainFrame` por `public class MainFrame extends JFrame`.
    - IntelliJ IDEA te mostrará un error porque la clase `JFrame` no está importada. Haz clic en la bombilla que aparece
      al lado del error y selecciona `Import class JFrame`.
    - Ahora la clase `MainFrame` hereda de `JFrame` y código se verá así:
        ```java
        import javax.swing.*;
      
        public class MainFrame extends JFrame {
        }
        ```
2. Debemos colocar el nombre al panel principal desde la vista de diseño.
    - Haz clic en el panel principal de la vista de diseño.
    - En la sección de propiedades, busca la propiedad `field name` y coloca el nombre `mainPanel`.
    - Notarás que ahora en el código de la clase `MainFrame` aparece un atributo con el nombre `mainPanel`:
        ```java
        private JPanel mainPanel;
        ```
3. Debemos agregar un constructor a la clase `MainFrame` que configure, el título, tamaño, visibilidad y cierre de la
   ventana.
    - Agrega el siguiente constructor a la clase `MainFrame`:
        ```java
        public MainFrame() {
            // Cambia el título de la ventana
           setTitle("Mi Ventana");
           // Establece el tamaño de la ventana
           setSize(400, 300);
           // Establece la operación por defecto al cerrar la ventana
           setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           // Definimos que la ventana aparecerá en el centro de la pantalla
           setLocationRelativeTo(null);
           // Hacemos visible la ventana
           setVisible(true);
        }
        ```
4. Debemos agregar el panel principal a la ventana.
    - Agrega el siguiente código al constructor de la clase `MainFrame`:
         ```java
         // Agregamos el panel principal a la ventana
         setContentPane(mainPanel);
         ```
5. Una vez hecho esto puedes cambiar el color de fondo, margen y borde del panel principal desde la vista de diseño.
6. Finalmente, debemos crear una instancia de la clase `MainFrame` en el método `main`.
    - El código de ejecución de nuestra ventana principal se verá así:
         ```java
         public static void main(String[] args) {
            // Creamos una instancia de la ventana
            new MiVentana();
         }
         ```
7. Ejecuta la aplicación y verás la ventana principal de la aplicación.
8. ¡Listo! Has creado la ventana principal de tu aplicación.