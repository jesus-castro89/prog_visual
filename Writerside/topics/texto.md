# ¿Qué son los elementos de Texto en la GUI de Java?

Los elementos de texto en la interfaz gráfica de usuario (GUI) de Java son componentes que permiten mostrar y editar
texto en una ventana de la aplicación. Estos elementos son fundamentales para interactuar con el usuario y presentar
información de manera visual.

En este tutorial, veremos los diferentes tipos de elementos de texto que podemos utilizar en Java, cómo crearlos y
personalizarlos, y cómo trabajar con ellos para mostrar y editar texto en una aplicación.

## ¿Qué tipos de elementos de texto existen en Java?

En Java, existen varios tipos de elementos de texto que podemos utilizar en la interfaz gráfica de usuario. Algunos de
los más comunes son:

1. **Etiqueta (`JLabel`)**: Un componente que muestra texto no editable en la ventana.
2. **Campo de texto (`JTextField`)**: Un componente que permite al usuario introducir texto de manera interactiva.
3. **Área de texto (`JTextArea`)**: Un componente que permite al usuario introducir y editar texto de manera
   interactiva.
4. **Campo de contraseña (`JPasswordField`)**: Un componente similar al campo de texto, pero oculta el texto introducido
   para proteger la privacidad del usuario.
5. **Etiqueta HTML (`JEditorPane`)**: Un componente que muestra texto con formato HTML en la ventana.
6. **Campo de texto con formato (`JFormattedTextField`)**: Un componente que permite al usuario introducir texto con un
   formato específico, como números, fechas o monedas.
7. **Panel de texto (`JTextPane`)**: Un componente que permite mostrar y editar texto con formato en la ventana.

Estos elementos de texto son muy versátiles y nos permiten crear interfaces de usuario interactivas y atractivas para
nuestras aplicaciones.

## ¿Cómo crear y personalizar elementos de texto en Java?

Para crear y personalizar elementos de texto en Java, necesitamos seguir los siguientes pasos:

1. **Crear un objeto del tipo de elemento de texto que queremos utilizar**: Por ejemplo, para crear una etiqueta,
   podemos utilizar la clase `JLabel` y su constructor para establecer el texto que queremos mostrar.
2. **Configurar las propiedades del elemento de texto**: Podemos personalizar el texto, el color, el tamaño, la fuente y
   otras propiedades del elemento de texto para que se ajuste a nuestras necesidades.
3. **Añadir el elemento de texto a la ventana**: Una vez configurado el elemento de texto, lo añadimos a la ventana
   utilizando el método `add` del contenedor en el que queremos mostrarlo.
4. **Mostrar la ventana en pantalla**: Finalmente, mostramos la ventana en pantalla para que el usuario pueda interactuar
   con los elementos de texto.