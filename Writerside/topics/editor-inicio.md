# Creando el Editor de Texto en vista de diseño

## Objetivo

Crea una aplicación de escritorio en Java usando Swing que simule un editor de texto simple. La interfaz debe incluir
una barra de herramientas (`JToolBar`) con botones (`JButton`) para acciones básicas como "**Nuevo**", "**Abrir**" y "*
*Guardar**". Además, debe tener un cuadro combinado (`JComboBox`) para seleccionar el tamaño de la fuente, un campo de
texto (`JTextField`) para ingresar el nombre del archivo, y una etiqueta (`JLabel`) para mostrar mensajes al usuario.

## Desarrollo

### Diseño de la Interfaz

1. Crea un nuevo proyecto de Java en IntelliJ IDEA.
2. Crea dentro de la carpeta `src` un nuevo paquete llamado `editor`.
3. Crea una nueva ventana mediante el editor de diseño de IntelliJ IDEA y renómbrala como `EditorTexto`.
4. Renombra el panel principal como `mainPanel`.
5. Arrastra una barra de herramientas (`JToolBar`) a la ventana y colócala en la parte superior.
6. Agrega tres botones a la barra de herramientas con los siguientes textos: "Nuevo", "Abrir" y "Guardar".
    * Nombra de los botones: `btnNuevo`, `btnAbrir`, `btnGuardar`.
7. Arrastra una etiqueta (`JLabel`) a la ventana y colócala debajo de la barra de herramientas. Cambia el texto de la
   etiqueta a "Tamaño de Fuente:".
8. Arrastra un cuadro combinado (`JComboBox`) a la ventana y colócalo al lado de la etiqueta. Agrega los siguientes
   elementos al cuadro combinado: "8", "12", "16", "20", "24". Cambia el nombre del cuadro combinado a `cmbFuente`.
9. Arrastra una etiqueta (`JLabel`) a la ventana y colócala al lado del cuadro combinado. Cambia el texto de la etiqueta
   a "Nombre del Archivo:".
10. Arrastra un campo de texto (`JTextField`) a la ventana y colócalo al lado de la etiqueta. Cambia el nombre del campo
    de texto a `txtArchivo`.
11. Selecciona las etiquetas, el cuadro combinado y el campo de texto, y agrúpalos en un panel (`JPanel`) para
    organizarlos mejor en la ventana.
12. Ajusta el tamaño y la posición de los componentes para que la ventana se vea similar a la siguiente imagen:
    ![editor_texto1.png](editor_texto1.png)
13. Arrastra un área de texto (`JTextArea`) a la ventana y colócala debajo del panel de componentes.
14. Selecciona el área de texto, da clic derecho y selecciona `Sorround With…` > ` JScrollPane` para agregar una barra
    de desplazamiento al área de texto.
15. Arrastra una etiqueta (`JLabel`) a la ventana y colócala debajo del área de texto. Cambia el texto de la etiqueta a
    "Bienvenido al Editor de Texto". Cambia el nombre de la etiqueta a `lblMensaje`.
16. Ajusta el tamaño y la posición de los componentes para que la ventana se vea similar a la siguiente imagen:
    ![editor_texto2.png](editor_texto2.png)
17. Selecciona el panel principal y ajusta los márgenes para que los componentes no queden pegados a los bordes de la
    ventana. Puedes agregar un margen de 10px en cada lado. **Aunque esto es opcional, puede mejorar la apariencia de la
    interfaz.**

Con los pasos anteriores, has creado la interfaz de tu editor de texto simple. Ahora, vamos a agregar la lógica para
manejar las acciones de los botones y el cuadro combinado.

### Ejecutando la Ventana del Editor de Texto

1. Haz que la clase asociada a la ventana (`EditorTexto`) herede de `JFrame` y crea un constructor para la misma con lo
   siguiente:
    ```java
    public class EditorTexto extends JFrame {
        private JPanel mainPanel;
        private JToolBar toolBar;
        private JButton btnNuevo;
        private JButton btnAbrir;
        private JButton btnGuardar;
        private JLabel lblFuente;
        private JComboBox<String> cmbFuente;
        private JLabel lblArchivo;
        private JTextField txtArchivo;
        private JTextArea txtArea;
        private JLabel lblMensaje;

        public EditorTexto() {
            setTitle("Editor de Texto");
            setSize(700, 600);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setContentPane(mainPanel);
            setVisible(true);
        }
    }
    ```
2. Crear un método para probar la aplicación:
    ```java
    public static void main(String[] args) {
        new EditorTexto();
    }
    ```
3. Ejecuta la aplicación y verífica que la ventana del editor de texto se muestre correctamente.
4. ¡Listo! Has creado la interfaz de un editor de texto simple en Java.

Con lo anterior ya podemos ver nuestra ventana de editor de texto simple. En la siguiente práctica, agregaremos la
funcionalidad para manejar las acciones de los botones y el cuadro combinado.

## Para el entregable

1. Realiza los pasos anteriores para crear la interfaz de un editor de texto simple en Java.
2. Cambia el color de fondo de la barra de herramientas a un tono gris claro.
3. Cambia el color de fondo del panel principal a un color de tu gusto.
4. Cambia el color de fuente de los botones de la barra de herramientas a azul.
5. Cambia el color de fondo del área de texto a blanco.
6. Cambia el color de fuente de la etiqueta `lblMensaje` a verde.
7. Cambia el color de fuente de la etiqueta `lblFuente` a azul.
8. Cambia el color de fuente de la etiqueta `lblArchivo` a azul.
9. Cambia el tamaño de fuente de todos los componentes a 16.