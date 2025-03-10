# Agregando las Funcionalidades

Ahora que hemos creado la interfaz de nuestro editor de texto simple, vamos a agregar la lógica para manejar las
acciones de los botones y el cuadro combinado.

### Agregando Funcionalidades a los Botones

Para manejar las acciones de los botones, vamos a utilizar la clase `ActionListener`. Esta clase nos permite capturar
los eventos de los botones y ejecutar una acción específica cuando se presionan.

1. En la clase `EditorTexto`, crea un método para manejar las acciones de los botones:
    ```java
    public class EditorTexto extends JFrame{
        // Código anterior

        public EditorTexto() {
            // Código anterior
            btnNuevo.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Acción para el botón Nuevo
                }
            });
            btnAbrir.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Acción para el botón Abrir
                }
            });
            btnGuardar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Acción para el botón Guardar
                }
            });
        }
    }
    ```
2. Dentro del método `actionPerformed`, agrega la lógica para cada botón.
3. Para el botón `Nuevo`, crea un método que limpie el área de texto:
    * ```java
      private void limpiarTexto() {
        txtArea.setText("");
      }
      ```
    * Posteriormente, agrega la llamada al método `limpiarTexto` en el bloque correspondiente del método
      `actionPerformed`:
        ```java
        btnNuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarTexto();
            }
        });
        ```
4. Para el botón `Abrir`, crea un método que modifique el campo de texto `txtArchivo` con el texto "Archivo Nuevo" y
   modifique la etiqueta `lblMensaje` con el texto "Archivo Abierto":
    *  ```java
       private void abrirArchivo() {
            txtArchivo.setText("Archivo Nuevo");
            lblMensaje.setText("Archivo Abierto");
       }
       ```
    * Agrega la llamada al método `abrirArchivo` en el bloque correspondiente del método `actionPerformed`:
        ```java
        btnAbrir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirArchivo();
            }
        });
        ```
5. Para el botón `Guardar`, crea un método que permita tomar el contenido del campo de texto y modificar el contenido de
   la etiqueta `lblMensaje` con el texto "Archivo [Nombre del Archivo] Guardado":
    *  ```java
       private void guardarArchivo() {
            String contenido = txtArea.getText();
            lblMensaje.setText("Archivo "+ contenido +" Guardado");
       }
       ```
    * Agrega la llamada al método `guardarArchivo` en el bloque correspondiente del método `actionPerformed`:
        ```java
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarArchivo();
            }
        });
        ```
6. ¡Listo! Ahora puedes probar tu editor de texto simple y verificar que las acciones de los botones funcionen
   correctamente.

### Agregando Funcionalidades al Cuadro Combinado

Para manejar las acciones del cuadro combinado, vamos a utilizar la clase `ItemListener`. Esta clase nos permite
capturar los eventos de selección de un elemento en el cuadro combinado y ejecutar una acción específica.

1. En la clase `EditorTexto`, crea un listener para el cuadro combinado y sobreescribe el método `itemStateChanged`:
    ```java
    public class EditorTexto extends JFrame {
        // Código anterior

        public EditorTexto() {
            // Código anterior
            cmbFuente.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        // Acción para el cuadro combinado
                    }
                }
            });
        }
    }
    ```
2. Dentro del método `itemStateChanged`, agrega la lógica para cambiar la fuente del área de texto según la selección
   del cuadro combinado:
    * ```java
      private void cambiarFuente() {
          int fuenteIndex = Integer.parseInt(cmbFuente.getSelectedItem().toString());
          Font font = new Font("Arial", Font.PLAIN, fuenteIndex);
          txtArea.setFont(font);
      }
      ```
    * Agrega la llamada al método `cambiarFuente` en el bloque correspondiente del método `itemStateChanged`:
        ```java
        cmbFuente.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    cambiarFuente();
                }
            }
        });
        ```
3. ¡Listo! Ahora puedes probar tu editor de texto simple y verificar que la fuente del área de texto cambie según la
   selección del cuadro combinado.
4. Recuerda que puedes personalizar las acciones de los botones y el cuadro combinado según tus necesidades y
   preferencias.

Con los pasos anteriores, has agregado la lógica necesaria para manejar las acciones de los botones y el cuadro
combinado en tu editor de texto simple.

## Para el Entregable

* Realiza los pasos anteriores para agregar la lógica de los botones y el cuadro combinado en tu editor de texto simple.
* Haz pruebas para verificar que las acciones de los botones y el cuadro combinado funcionen correctamente.
* Comprime tu proyecto en un archivo ZIP y envíalo como parte de tu entrega.

## Criteria de Evaluación

| Criterio        | Descripción                                                                   | Puntaje |
|-----------------|-------------------------------------------------------------------------------|---------|
| Portada         | Incluye una portada con datos de información de los integrantes del equipo.   | 10%     |
| Interfaz        | La interfaz del editor de texto simple cumple con los requisitos indicados.   | 30%     |
| Funcionalidades | Se han implementado las funcionalidades de los botones y el cuadro combinado. | 30%     |
| Capturas        | Se incluyen capturas de pantalla que muestren el funcionamiento del editor.   | 30%     |

## Fecha de Entrega

La fecha de entrega de este entregable es el **14 de marzo de 2025** a las **23:59**. Cualquier entrega después de esta
fecha será calificada sobre 70%.

Recuerda que la entrega se realizará a través de la plataforma **Moodle**.