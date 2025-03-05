# El Componente `JSplitPane`

El componente `JSplitPane` es un contenedor que permite dividir la interfaz de usuario en dos o más áreas
redimensionables. Cada área puede contener cualquier tipo de componente, como paneles, tablas, árboles, etc.

## Creación de un `JSplitPane`

Para crear un `JSplitPane` desde la vista de diseño de IntelliJ IDEA, arrastramos el componente `JSplitPane` desde la
paleta de componentes a la ventana del formulario. El `JSplitPane` se divide en dos áreas por defecto, pero podemos
colocar más `JSplitPane` dentro de cada área para crear una estructura de paneles anidados.

## Agregar áreas al `JSplitPane`

Para agregar más áreas al `JSplitPane`, desde el editor de IntelliJ IDEA, seleccionamos el `JSplitPane` y hacemos clic
derecho sobre él. En el menú contextual, seleccionamos la opción `Add Split`. Esto añadirá una nueva área al

## Añadir componentes a las áreas del `JSplitPane`

Para añadir componentes a las áreas del `JSplitPane`, arrastramos los componentes desde la paleta de componentes a
cada una de las áreas. Podemos añadir cualquier tipo de componente a las áreas del `JSplitPane`. Los componentes
se pueden redimensionar arrastrando el divisor entre las áreas.

## Cambiar la orientación del `JSplitPane`

El `JSplitPane` permite cambiar la orientación de las áreas. Por defecto, el `JSplitPane` divide las áreas de forma
horizontal, pero podemos cambiar la orientación a vertical si es necesario. Para cambiar la orientación, seleccionamos
el `JSplitPane` y modificamos la propiedad `Orientation` en la ventana de propiedades.

## Cambiar el tamaño de las áreas

Podemos cambiar el tamaño de las áreas del `JSplitPane` arrastrando el divisor entre las áreas. También podemos
especificar un tamaño fijo para una de las áreas si es necesario. Para ello, seleccionamos el divisor y modificamos
la propiedad `Divider Size` en la ventana de propiedades.

## Eventos de cambio de tamaño

El `JSplitPane` permite registrar un `ComponentListener` para escuchar los eventos de cambio de tamaño de las áreas.

```java
JSplitPane splitPane = new JSplitPane();

splitPane.addComponentListener(new ComponentAdapter() {
    @Override
    public void componentResized(ComponentEvent e) {
        System.out.println("SplitPane resized");
    }
});
```

En el ejemplo anterior, se imprime en la consola un mensaje cada vez que el `JSplitPane` cambia de tamaño.