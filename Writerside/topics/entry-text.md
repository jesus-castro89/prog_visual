# Los componentes de entrada

Los componentes de entrada en la interfaz gráfica de usuario (GUI) de Java son elementos que permiten al usuario
introducir datos en una ventana de la aplicación. Estos componentes son esenciales para interactuar con el usuario y
recopilar información de manera interactiva.

En este tutorial, veremos los diferentes tipos de componentes de entrada que podemos utilizar en Java, cómo crearlos y
personalizarlos, y cómo trabajar con ellos para recopilar datos en una aplicación.

## JTextField

El componente `JTextField` es un componente de la interfaz gráfica de usuario (GUI) de Java que permite al usuario
introducir texto de manera interactiva en una ventana de la aplicación.

En este tutorial, veremos cómo utilizar el componente `JTextField` en Java para crear campos de texto en una ventana y
cómo personalizar sus propiedades para adaptarlos a nuestras necesidades mediante el editor visual de IntelliJ IDEA.

### ¿Cómo crear un campo de texto en Java?

Para crear un campo de texto en Java, necesitamos seguir los siguientes pasos:

1. **Crea una nueva ventana `JFrame`**: Antes de crear el campo de texto, necesitamos crear una ventana en la que
   mostrarlo.
2. **Arrastra y suelta un campo de texto desde la paleta de componentes**: En el editor visual de IntelliJ IDEA, podemos
   arrastrar y soltar un campo de texto (`JTextField`) desde la paleta de componentes a la ventana.
3. **Personaliza las propiedades del campo de texto**: Podemos personalizar el texto, el color, el tamaño, la fuente, el
   tamaño y otras propiedades del campo de texto mediante el inspector de propiedades.
    - Puedes modificar las propiedades en el inspector de propiedades de IntelliJ IDEA.
4. **Ejecuta la aplicación y visualiza el campo de texto**: Una vez configurado el campo de texto, podemos ejecutar la
   aplicación y ver el campo de texto en la ventana.
5. **Verífica que el campo de texto funciona correctamente**: Al ejecutar la aplicación, verifica que el campo de texto
   permite al usuario introducir texto de manera interactiva.
6. **Documenta y comparte tu código**: Documenta el código de la aplicación y compártelo con otros desarrolladores para
   que puedan aprender de tu experiencia.
7. **Celebra el éxito de haber creado un campo de texto en Java**.

> **Nota**: Los campos de texto son componentes interactivos que permiten al usuario introducir texto de manera
> interactiva. Si necesitas mostrar texto no editable, puedes utilizar una etiqueta (`JLabel`) en su lugar.

## JPasswordField

El componente `JPasswordField` es un componente de la interfaz gráfica de usuario (GUI) de Java que permite al usuario
introducir texto de manera interactiva en una ventana de la aplicación, pero oculta el texto introducido para proteger
la privacidad del usuario.

En este tutorial, veremos cómo utilizar el componente `JPasswordField` en Java para crear campos de contraseña en una
ventana y cómo personalizar sus propiedades para adaptarlos a nuestras necesidades mediante el editor visual de IntelliJ
IDEA.

### ¿Cómo crear un campo de contraseña en Java?

Para crear un campo de contraseña en Java, necesitamos seguir los siguientes pasos:

1. **Crea una nueva ventana `JFrame`**: Antes de crear el campo de contraseña, necesitamos crear una ventana en la que
   mostrarlo.
2. **Arrastra y suelta un campo de contraseña desde la paleta de componentes**: En el editor visual de IntelliJ IDEA,
   podemos arrastrar y soltar un campo de contraseña (`JPasswordField`) desde la paleta de componentes a la ventana.
3. **Personaliza las propiedades del campo de contraseña**: Podemos personalizar el texto, el color, el tamaño, la
   fuente,
   el tamaño y otras propiedades del campo de contraseña mediante el inspector de propiedades.
    - Puedes modificar las propiedades en el inspector de propiedades de IntelliJ IDEA.
4. **Ejecuta la aplicación y visualiza el campo de contraseña**: Una vez configurado el campo de contraseña, podemos
   ejecutar la aplicación y ver el campo de contraseña en la ventana.
5. **Verífica que el campo de contraseña funciona correctamente**: Al ejecutar la aplicación, verifica que el campo de
   contraseña permite al usuario introducir texto de manera interactiva y oculta el texto introducido.
6. **Documenta y comparte tu código**: Documenta el código de la aplicación y compártelo con otros desarrolladores para
   que puedan aprender de tu experiencia.
7. **Celebra el éxito de haber creado un campo de contraseña en Java**.

> **Nota**: Los campos de contraseña son componentes interactivos que permiten al usuario introducir texto de manera
> interactiva, pero ocultan el texto introducido para proteger la privacidad del usuario.

## JFormattedTextField

El componente `JFormattedTextField` es un componente de la interfaz gráfica de usuario (GUI) de Java que permite al
usuario introducir texto con un formato específico en una ventana de la aplicación.

En este tutorial, veremos cómo utilizar el componente `JFormattedTextField` en Java para crear campos de texto con
formato en una ventana y cómo personalizar sus propiedades para adaptarlos a nuestras necesidades mediante el editor
visual de IntelliJ IDEA.

### ¿Cómo crear un campo de texto con formato en Java?

Para crear un campo de texto con formato en Java, necesitamos seguir los siguientes pasos:

1. **Crea una nueva ventana `JFrame`**: Antes de crear el campo de texto con formato, necesitamos crear una ventana en
   la que mostrarlo.
2. **Arrastra y suelta un campo de texto con formato desde la paleta de componentes**: En el editor visual de IntelliJ
   IDEA, podemos arrastrar y soltar un campo de texto con formato (`JFormattedTextField`) desde la paleta de componentes
   a la ventana.
3. **Personaliza las propiedades del campo de texto con formato**: Podemos personalizar el texto, el color, el tamaño,
   la fuente, el tamaño y otras propiedades del campo de texto con formato mediante el inspector de propiedades.
    - Puedes modificar las propiedades en el inspector de propiedades de IntelliJ IDEA.
4. **Ejecuta la aplicación y visualiza el campo de texto con formato**: Una vez configurado el campo de texto con
   formato, podemos ejecutar la aplicación y ver el campo de texto con formato en la ventana.
5. **Verífica que el campo de texto con formato funciona correctamente**: Al ejecutar la aplicación, verifica que el
   campo de texto con formato permite al usuario introducir texto con un formato específico.
6. **Documenta y comparte tu código**: Documenta el código de la aplicación y compártelo con otros desarrolladores para
   que puedan aprender de tu experiencia.
7. **Celebra el éxito de haber creado un campo de texto con formato en Java**.

> **Nota**: Los campos de texto con formato son componentes interactivos que permiten al usuario introducir texto con un
> formato específico, como números, fechas o monedas.

En capítulos siguientes, veremos cómo trabajar con formatos personalizados en los campos de texto con formato y cómo
validar los datos introducidos por el usuario.

### Formatos de texto comunes

Algunos de los formatos de texto más comunes que podemos utilizar en un campo de texto con formato son:

- **Números**: Podemos utilizar un formato numérico para permitir al usuario introducir números enteros o decimales en
  el campo de texto.
  - Por ejemplo, podemos utilizar `#,##0.00` para permitir al usuario introducir números con dos decimales y separador
    de miles. De la siguiente manera:
    ```java
    textField.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0.00"))));
    ```
  - O podemos utilizar `0.00` para permitir al usuario introducir números con dos decimales. De la siguiente manera:
    ```java
    textField.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("0.00"))));
    ```
- **Monedas**: Podemos utilizar un formato de moneda para permitir al usuario introducir cantidades de dinero en el
  campo de texto.
  - Por ejemplo, podemos utilizar `¤ #,##0.00` para permitir al usuario introducir cantidades de dinero con el símbolo
    de la moneda y dos decimales. De la siguiente manera:
    ```java
    textField.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("¤ #,##0.00"))));
    ```
- **Fechas**: Podemos utilizar un formato de fecha para permitir al usuario introducir fechas en el campo de texto.
  - Por ejemplo, podemos utilizar `dd/MM/yyyy` para permitir al usuario introducir fechas en el formato día/mes/año. De
    la siguiente manera:
    ```java
    textField.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(new SimpleDateFormat("dd/MM/yyyy"))));
    ```
- **Horas**: Podemos utilizar un formato de hora para permitir al usuario introducir horas en el campo de texto.
  - Por ejemplo, podemos utilizar `HH:mm:ss` para permitir al usuario introducir horas en el formato 24 horas. De la
    siguiente manera:
    ```java
    textField.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(new SimpleDateFormat("HH:mm:ss"))));
    ```
- **Teléfonos**: Podemos utilizar un formato de teléfono para permitir al usuario introducir números de teléfono en el
  campo de texto.
  - Por ejemplo, podemos utilizar `###-###-####` para permitir al usuario introducir números de teléfono en el formato
    ###-###-#### de la siguiente manera:
    ```java
    textField.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("###-###-####")));
    ```
- **Códigos postales**: Podemos utilizar un formato de código postal para permitir al usuario introducir códigos postales
  en el campo de texto.
  - Por ejemplo, podemos utilizar `#####` para permitir al usuario introducir códigos postales de cinco dígitos de la
    siguiente manera:
    ```java
    textField.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("#####")));
    ```

## Conclusion

En este tutorial, hemos explorado los diferentes tipos de componentes de entrada que podemos utilizar en Java para
recopilar datos de manera interactiva en una aplicación. Desde los campos de texto simples hasta los campos de texto con
formato, estos componentes son esenciales para interactuar con el usuario y crear interfaces de usuario interactivas y
atractivas.