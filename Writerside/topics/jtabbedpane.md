# El componente `JTabbedPane`

El componente `JTabbedPane` es un contenedor que permite mostrar varios componentes en pestañas. Cada pestaña tiene un
título y un componente asociado. El usuario puede cambiar de pestaña haciendo clic en el título de la pestaña.

## Creación de un `JTabbedPane`

Para crear un `JTabbedPane` desde la vista de diseño de IntelliJ IDEA, arrastramos el componente `JTabbedPane` desde la
paleta de componentes a la ventana del formulario. Para agregar pestañas al `JTabbedPane`, hacemos clic derecho sobre el
componente y seleccionamos la opción `Add Tab`.

## Añadir componentes a las pestañas

Para añadir componentes a las pestañas del `JTabbedPane`, arrastramos los componentes desde la paleta de componentes a
la pestaña correspondiente. Podemos añadir cualquier tipo de componente a las pestañas del `JTabbedPane`.

## Cambiar de pestaña

Para cambiar de pestaña en un `JTabbedPane`, simplemente hacemos clic en el título de la pestaña que queremos mostrar.

## Eventos de cambio de pestaña

El `JTabbedPane` permite registrar un `ChangeListener` para escuchar los eventos de cambio de pestaña. De esta forma,
podemos ejecutar código cuando el usuario cambia de pestaña en el `JTabbedPane`.

```java
JTabbedPane tabbedPane = new JTabbedPane();
tabbedPane.addChangeListener(e -> {
    int tabIndex = tabbedPane.getSelectedIndex();
    System.out.println("Tab index changed to: " + tabIndex);
});
```

En el ejemplo anterior, se imprime en la consola el índice de la pestaña seleccionada cada vez que el usuario cambia de
pestaña en el `JTabbedPane`.