# Agregando los eventos a los componentes

En esta práctica, vamos a agregar la lógica para manejar los eventos de los componentes de nuestra aplicación. Para
ello, vamos a utilizar el método `addActionListener` para los botones y el cuadro combinado, y el método
`addChangeListener` para el `JSlider`.

## La pestaña de Información Personal

Para la pestaña de Información Personal, debemos realizar lo siguiente:

* Define la siguiente función en la clase `MainApp` o cómo hayas nombrado a la clase asociada a tu formulario de diseño
  para mostrar un cuadro de diálogo con la información ingresada:

```java
private void mostrarInformacion() {
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String edad = txtEdad.getText();
        String email = txtEmail.getText();
        int numEdad;
        if (nombre.isBlank() || apellido.isBlank() ||
                edad.isBlank() || email.isBlank()) {

            JOptionPane.showMessageDialog(this,
                    "Por favor llene todos los campos.");
        } else {
            try {

                numEdad = Integer.parseInt(edad);
                if (numEdad >= 0) {

                    String info = String.format("""
                            Nombre: %s
                            Apellido: %s
                            Edad: %s
                            Email: %s
                            """, nombre, apellido, edad, email);
                    JOptionPane.showMessageDialog(this, info);
                } else {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this,
                        "La edad debe ser un número entero positivo.");
            }
        }
}
```

* Define la función `initComponents` en la clase `MainApp` o cómo hayas nombrado a la clase asociada a tu formulario de
  diseño, y agrega el siguiente código para agregar el evento al botón `btnMostrarInformacion`:

```java
private void initComponents() {
   
    btnMostrarInformacion.addActionListener(e -> mostrarInformacion());
}
```

* Por último agrega una llamada a la función `initComponents` en el constructor de la clase `MainApp` o cómo hayas
  nombrado a la clase asociada a tu formulario de diseño:

```java
public MainApp() {
    // Código previo
    initComponents();
}
```

* Ejecuta tu aplicación y verífica que al hacer clic en el botón "Mostrar Información" se muestre un cuadro de diálogo
  con la información ingresada.

## La pestaña de Calculadora

Para la pestaña de Calculadora, debemos realizar lo siguiente:

* Define la siguiente función en la clase `MainApp` o cómo hayas nombrado a la clase asociada a tu formulario de diseño
  para realizar la suma de los números ingresados:

```java
private void calcularSuma() {
        int num1, num2, suma;
        try {
            num1 = Integer.parseInt(txtNum1.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "El primer número no es válido");
            return;
        }
        try {
            num2 = Integer.parseInt(txtNum2.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "El segundo número no es válido");
            return;
        }
        suma = num1 + num2;
        lblSuma.setText("La suma de los dígitos es: " + suma);
}
```

* Agrega a la función `initComponents` en la clase `MainApp` o cómo hayas nombrado a la clase asociada a tu formulario
  de diseño, el siguiente código para agregar el evento al botón `btnCalcularSuma`:

```java
private void initComponents() {
    // Código previo

    btnCalcularSuma.addActionListener(e -> calcularSuma());
}
```

* Verifica que al hacer clic en el botón "Calcular Suma" se muestre el resultado de la suma de los números ingresados.

## La pestaña de Escogiendo un número

Para la pestaña de Escogiendo un número, debemos realizar lo siguiente:

* Define la siguiente función en la clase `MainApp` o cómo hayas nombrado a la clase asociada a tu formulario de diseño
  para mostrar el número seleccionado en el `JSlider`:

```java
private void mostrarNumeroSeleccionado() {
    int numero = sliderNumero.getValue();
    lblNumeroSeleccionado.setText("Número seleccionado: " + numero);
}
```

* Agrega a la función `initComponents` en la clase `MainApp` o cómo hayas nombrado a la clase asociada a tu formulario
  de diseño, el siguiente código para agregar el evento al `JSlider`:

```java
private void initComponents() {
    // Código previo

    sliderNumero.addChangeListener(e -> mostrarNumeroSeleccionado());
}
```

* Verífica que al mover el `JSlider` se actualice la etiqueta con el número seleccionado.

## La pestaña de Seleccionando una opción

Para la pestaña de Seleccionando una opción, debemos realizar lo siguiente:

* Define la siguiente función en la clase `MainApp` o cómo hayas nombrado a la clase asociada a tu formulario de diseño
  para mostrar la opción seleccionada en el `JComboBox`:

```java
private void mostrarOpcionSeleccionada() {
    String opcion = (String) cmbOpciones.getSelectedItem();
    lblOpcionSeleccionada.setText("Opción seleccionada: " + opcion);
}
```

* Agrega a la función `initComponents` en la clase `MainApp` o cómo hayas nombrado a la clase asociada a tu formulario
  de diseño, el siguiente código para agregar el evento al `JComboBox`:

```java
private void initComponents() {
    // Código previo

    cmbOpciones.addActionListener(e -> mostrarOpcionSeleccionada());
}
```

* Verífica que al seleccionar una opción en el `JComboBox` se actualice la etiqueta con la opción seleccionada.

Con los pasos anteriores, has agregado la lógica para manejar los eventos de los componentes de tu aplicación de
escritorio en Java. En la siguiente sección, aprenderás a compilar y ejecutar tu aplicación para probar su
funcionamiento.

## Para la entrega

* Agrega el código de la clase `MainApp` o cómo hayas nombrado a la clase asociada a tu formulario de diseño, con los
  eventos de los componentes.
* Cambia el color de fondo de cada uno de los paneles de las pestañas para que se vean diferentes.
* Cambia el tamaño de fuente de los componentes de cada pestaña para que se vean más grandes.
    * Deben tener un mínimo de 18 puntos.
* Asegúrate de que la interfaz se vea ordenada y bien distribuida.
* Realiza capturas de pantalla de la aplicación en ejecución y agrégala a tu carpeta de entrega.
    * Debe incluir las cuatro pestañas con los componentes y los eventos funcionando.
* Comprime tu carpeta de entrega en un archivo `.zip` y súbelo a la plataforma.

¡Buena suerte! 🚀

## Criterios de Evaluación

| Criterio   | Descripción                                                                   | Puntaje  |
|------------|-------------------------------------------------------------------------------|----------|
| Portada    | Incluye una portada con datos de información de los integrantes del equipo.   | 10%      |
| Interfaz   | La interfaz del editor de texto simple cumple con los requisitos indicados.   | 10%      |
| Evidencias | Se incluyen las capturas de pantalla de la aplicación funcionando.            | 20%      |
| Eventos    | Los eventos de los componentes funcionan correctamente.                       | 30%      |
| Estilo     | Se realizan las adecuaciones solicitadas.                                     | 20%      |
| Entrega    | La entrega incluye el archivo ZIP con el proyecto y las capturas de pantalla. | 10%      |
| **Total**  |                                                                               | **100%** |

> Recuerda que deberás anexar al trabajo por separado el archivo de portada y evidencias del zip con el código fuente
> de tu proyecto.
> {style="note"}

## Fecha de entrega

La fecha de entrega de este entregable es el **21 de marzo de 2025** a las **23:59**. Cualquier entrega después de esta
fecha será calificada sobre 70%.

Recuerda que la entrega se realizará a través de la plataforma **Moodle**.