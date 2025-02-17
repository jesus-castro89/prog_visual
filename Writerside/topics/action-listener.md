# La Interfaz `ActionListener`

El `ActionListener` es una interfaz en Java que maneja eventos de acción en los componentes gráficos de una aplicación.
Estos eventos pueden ser de varios tipos, como clics de ratón, teclas presionadas, selección de elementos en una lista
desplegable, entre otros.

## Eventos de Acción

Los eventos de acción son eventos que se activan cuando un usuario interactúa con un componente gráfico, como hacer clic
en un botón, seleccionar un elemento en una lista desplegable o presionar una tecla en un campo de texto. Estos eventos
son manejados por el `ActionListener`, que es una interfaz que define un método llamado `actionPerformed` que se ejecuta
cuando se produce un evento de acción.

## Creando un ActionListener

Para crear un `ActionListener` en IntelliJ IDEA, primero debemos seleccionar el componente gráfico al que queremos
agregar el `ActionListener`. Luego, podemos hacer clic derecho sobre el componente y seleccionar la opción `Create
Listener`, lo que nos permitirá agregar un nuevo `ActionListener` al componente.

## Implementando un ActionListener

Una vez que hemos creado un `ActionListener`, debemos implementar el método `actionPerformed` en nuestra clase para
manejar el evento de acción. Este método recibe un parámetro de tipo `ActionEvent`, que contiene información sobre la
funcionalidad a ejecutar cuando se produce el evento de acción.

```java
import java.awt.event.ActionEvent;

public class MyActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Código para manejar el evento de acción
    }
}
```

> **Nota:** El `ActionListener` es una interfaz muy útil en Java, ya que nos permite manejar eventos de acción en los
> componentes gráficos de una aplicación. Al conocer cómo implementar un `ActionListener`, podemos hacer que nuestras
> aplicaciones sean más interactivas y fáciles de usar.