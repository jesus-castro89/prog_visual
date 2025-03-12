# El componente `JProgressBar`

El componente `JProgressBar` es un componente de Swing que permite mostrar el progreso de una tarea en una barra de
progreso. Este componente es muy útil cuando se necesita mostrar el progreso de una tarea que puede tardar un tiempo en
completarse.

## Creando una barra de progreso

Para crear una barra de progreso en Swing, podemos usar el editor visual de IntelliJ IDEA. Para ello, arrastramos un
componente `JProgressBar` desde la paleta de componentes a nuestro formulario.

Una vez que hemos agregado la barra de progreso a nuestro formulario, podemos personalizarla a través de las propiedades
del componente. Por ejemplo, podemos cambiar el color de la barra de progreso, el color del texto, el valor mínimo y
máximo, etc.

## Actualizando la barra de progreso

Para actualizar la barra de progreso, podemos usar el método `setValue()` del componente `JProgressBar`. Este método
permite establecer el valor actual de la barra de progreso.

Por ejemplo, si queremos mostrar el progreso de una tarea que se está ejecutando en segundo plano, podemos actualizar
la barra de progreso en el hilo de despacho de eventos de Swing (EDT) usando el método `SwingUtilities.invokeLater()`.
Aquí hay un ejemplo de cómo hacerlo:

```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import javax.swing.SwingWorker;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.EventListenerList;
import javax.swing.event.SwingPropertyChangeSupport;

public class ProgressBarExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JProgressBar Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new BorderLayout());

        JProgressBar progressBar = new JProgressBar(0, 100);
        progressBar.setStringPainted(true);
        progressBar.setValue(0);

        JButton startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startTask(progressBar);
            }
        });

        frame.add(progressBar, BorderLayout.CENTER);
        frame.add(startButton, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
    private static void startTask(JProgressBar progressBar) {
        SwingWorker<Void, Integer> worker = new SwingWorker<Void, Integer>() {
            @Override
            protected Void doInBackground() throws Exception {
                Random random = new Random();
                for (int i = 0; i <= 100; i++) {
                    Thread.sleep(random.nextInt(100));
                    publish(i);
                }
                return null;
            }

            @Override
            protected void process(java.util.List<Integer> chunks) {
                for (Integer value : chunks) {
                    progressBar.setValue(value);
                }
            }
        };
        worker.execute();
    }
}
```

En este ejemplo, hemos creado una barra de progreso y un botón "Start". Cuando hacemos clic en el botón, se inicia
una tarea en segundo plano que simula un proceso que tarda un tiempo aleatorio en completarse. La barra de progreso se
actualiza en función del progreso de la tarea.

## Personalizando la barra de progreso

Podemos personalizar la apariencia de la barra de progreso utilizando diferentes métodos y propiedades. Por ejemplo,
podemos cambiar el color de la barra de progreso, el color del texto, el tamaño de la barra, etc. Aquí hay algunos
ejemplos de cómo personalizar la barra de progreso:

```java
progressBar.setForeground(Color.GREEN); // Cambia el color de la barra de progreso
progressBar.setBackground(Color.BLACK); // Cambia el color de fondo de la barra de progreso

progressBar.setFont(new Font("Arial", Font.BOLD, 16)); // Cambia la fuente del texto
progressBar.setString("Cargando..."); // Cambia el texto que se muestra en la barra de progreso
```

## Conclusión

El componente `JProgressBar` es una herramienta útil para mostrar el progreso de tareas en segundo plano en aplicaciones
Swing. Permite a los usuarios ver el progreso de una tarea y proporciona una forma visual de indicar que la aplicación
está ocupada realizando una operación. Con la personalización adecuada, podemos hacer que la barra de progreso se
adapte a la apariencia de nuestra aplicación y mejore la experiencia del usuario.