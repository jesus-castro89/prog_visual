# Iniciando con la actividad 5

En esta actividad, se debe implementar una aplicación de escritorio en Java que permita al usuario configurar distintas
pestañas con diferentes componentes de Swing. De tal manera que las pestañas puedan ser configuradas con los siguientes
componentes:

* **Información Personal**: Esta pestaña debe contener campos de texto para ingresar el nombre, apellido, edad y correo
  electrónico del usuario. Además, debe contener un botón para mostrar un cuadro de diálogo con la información
  ingresada.
* **Calculadora**: Esta pestaña debe contener campos de texto para ingresar dos números y un botón para calcular la suma
  de los números ingresados, mismo que se mostrará en una etiqueta.
* **Escogiendo un número**: Esta pestaña debe contener un `JSlider` para seleccionar un número entre 0 y 100, y una
  etiqueta para mostrar el número seleccionado. Que se actualice cada vez que el usuario cambie el valor del `JSlider`.
* **Seleccionando una opción**: Esta pestaña debe contener un `JComboBox` con tres opciones: "Opción 1", "Opción 2" y
  "Opción 3". Además, debe contener una etiqueta para mostrar la opción seleccionada en el `JComboBox`.

## Diseño de la interfaz

1. Empezaremos creando un nuevo proyecto de Java en IntelliJ IDEA.
2. Crearemos una ventana en vista de diseño con la herramienta `Swing GUI Designer`.
3. Agregaremos un `JTabbedPane` a la ventana para poder agregar las pestañas.
4. Agregaremos un `JPanel` a cada pestaña para poder agregar los componentes.
5. Agregaremos los componentes necesarios a cada `JPanel` según la descripción de cada pestaña.
6. Ajustaremos el tamaño y la posición de los componentes a tu gusto.
7. Asegúrate de que los componentes estén bien distribuidos y que la interfaz se vea ordenada, además de nombrar
   correctamente los componentes.
8. Ajusta los márgenes y el espaciado entre los componentes para que la interfaz se vea bien.
9. Asegúrate de que los componentes estén bien alineados y que la interfaz sea fácil de usar.

Con los pasos anteriores, has creado la interfaz de tu aplicación de escritorio en Java. Ahora, vamos a agregar la
lógica para manejar los eventos de los componentes.

## La pestaña de Información Personal

Para la pestaña de Información Personal, debemos realizar lo siguiente:

1. Selecciona el `JPanel` correspondiente a la pestaña de Información Personal.
2. Agrega los campos de texto necesarios para ingresar el nombre, apellido, edad y correo electrónico del usuario.
    * Cada campo de texto debe tener un nombre descriptivo. Por ejemplo, `txtNombre`, etc.
    * Asegúrate de que los campos de texto tengan un tamaño adecuado para ingresar la información.
3. Agrega un botón con el texto "Mostrar Información" para mostrar un cuadro de diálogo con la información ingresada.
    * Asegúrate de que el botón tenga un nombre descriptivo. Por ejemplo, `btnMostrarInformacion`.
4. Asegúrate de que los componentes estén bien distribuidos y que la interfaz se vea ordenada.
5. Ajusta los márgenes y el espaciado entre los componentes para que la interfaz se vea bien. Esto lo puedes lograr
   seleccionando el panel y ajustando las propiedades `verticalGap` y `horizontalGap` en el inspector de propiedades.

## La pestaña de Calculadora

Para la pestaña de Calculadora, debemos realizar lo siguiente:

1. Selecciona el `JPanel` correspondiente a la pestaña de Calculadora.
2. Agrega dos campos de texto para ingresar los números a sumar.
    * Cada campo de texto debe tener un nombre descriptivo. Por ejemplo, `txtNumero1`, `txtNumero2`.
    * Asegúrate de que los campos de texto tengan un tamaño adecuado para ingresar los números.
3. Agrega una etiqueta para mostrar el resultado de la suma.
    * Asegúrate de que la etiqueta tenga un nombre descriptivo. Por ejemplo, `lblResultado`.
    * Ajusta el tamaño y la posición de la etiqueta para que se vea bien.
4. Agrega un botón con el texto "Calcular Suma" para realizar la suma de los números ingresados.
    * Asegúrate de que el botón tenga un nombre descriptivo. Por ejemplo, `btnCalcularSuma`.
5. Asegúrate de que los componentes estén bien distribuidos y que la interfaz se vea ordenada.
6. Ajusta los márgenes y el espaciado entre los componentes para que la interfaz se vea bien.

## La pestaña de Escogiendo un número

Para la pestaña de Escogiendo un número, debemos realizar lo siguiente:

1. Selecciona el `JPanel` correspondiente a la pestaña de Escogiendo un número.
2. Agrega un `JSlider` para seleccionar un número entre 0 y 100.
    * Asegúrate de que el `JSlider` tenga un nombre descriptivo. Por ejemplo, `sliderNumero`.
    * Ajusta el tamaño y la posición del `JSlider` para que se vea bien.
3. Agrega una etiqueta para mostrar el número seleccionado.
    * Asegúrate de que la etiqueta tenga un nombre descriptivo. Por ejemplo, `lblNumeroSeleccionado`.
    * Ajusta el tamaño y la posición de la etiqueta para que se vea bien.
4. Asegúrate de que los componentes estén bien distribuidos y que la interfaz se vea ordenada.
5. Ajusta los márgenes y el espaciado entre los componentes para que la interfaz se vea bien.

## La pestaña de Seleccionando una opción

Para la pestaña de Seleccionando una opción, debemos realizar lo siguiente:

1. Selecciona el `JPanel` correspondiente a la pestaña de Seleccionando una opción.
2. Agrega un `JComboBox` con las opciones "Opción 1", "Opción 2" y "Opción 3".
    * Asegúrate de que el `JComboBox` tenga un nombre descriptivo. Por ejemplo, `cmbOpciones`.
    * Ajusta el tamaño y la posición del `JComboBox` para que se vea bien.
3. Agrega una etiqueta para mostrar la opción seleccionada.
    * Asegúrate de que la etiqueta tenga un nombre descriptivo. Por ejemplo, `lblOpcionSeleccionada`.
    * Ajusta el tamaño y la posición de la etiqueta para que se vea bien.
4. Asegúrate de que los componentes estén bien distribuidos y que la interfaz se vea ordenada.
5. Ajusta los márgenes y el espaciado entre los componentes para que la interfaz se vea bien.

Con los pasos anteriores, has diseñado la interfaz de tu aplicación de escritorio en Java. En la siguiente sección,
aprenderás a agregar la lógica para manejar los eventos de los componentes y hacer que tu aplicación funcione
correctamente.