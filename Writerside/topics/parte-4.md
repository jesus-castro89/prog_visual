# Parte 4: [El panel de contacto y la ventana emergente]

Para completar la interfaz de usuario, vamos a crear un panel de contacto que contendrá los campos para ingresar el
nombre, apellido, teléfono y correo electrónico. Además, implementaremos una ventana emergente que haga uso de este
panel en el caso de editar un contacto existente.

## `ContactPanel.java`

```java
package com.example.agenda;

import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;

public class ContactPanel extends JPanel {
    private JTextField nameTxt;
    private JTextField lastNameTxt;
    private JFormattedTextField emailTxt;
    private JFormattedTextField telephoneTxt;
    private JButton aceptBtn;
    private JButton cancelBtn;
    private JPanel mainPanel;
    private Agenda agenda;

    public ContactPanel(Agenda agenda) {
        this.agenda = agenda;
        add(mainPanel);
        setSize(400, 300);
        emailTxt.setFormatterFactory(new DefaultFormatterFactory(new EmailFormatter()));
        telephoneTxt.setFormatterFactory(new DefaultFormatterFactory(new PhoneFormatter()));
        aceptBtn.setText("Aceptar");
        cancelBtn.setText("Limpiar");
        aceptBtn.addActionListener(e -> {
            String name = nameTxt.getText();
            String lastName = lastNameTxt.getText();
            String email = emailTxt.getText();
            String telephone = telephoneTxt.getText();
            Contact contact = new Contact(name, lastName, telephone, email);
            agenda.addContact(contact);
            JOptionPane.showMessageDialog(this, "Contacto agregado: " + contact);
            nameTxt.setText("");
            lastNameTxt.setText("");
            emailTxt.setText("");
            telephoneTxt.setText("");
            ContactTableModel contactTableModel = (ContactTableModel) ((AgendaApp) SwingUtilities.getWindowAncestor(this)).getContactTable().getModel();
            contactTableModel.fireTableDataChanged();
            ((AgendaApp) SwingUtilities.getWindowAncestor(this)).getContactTable().repaint();
        });
        cancelBtn.addActionListener(e -> {
            nameTxt.setText("");
            lastNameTxt.setText("");
            emailTxt.setText("");
            telephoneTxt.setText("");
        });
    }

    public ContactPanel(AgendaApp app, Contact contact) {
        this.agenda = app.getAgenda();
        add(mainPanel);
        setSize(400, 300);
        nameTxt.setText(contact.getName());
        lastNameTxt.setText(contact.getLastName());
        emailTxt.setText(contact.getEmail());
        telephoneTxt.setText(contact.getPhoneNumber());
        aceptBtn.setText("Actualizar");
        cancelBtn.setText("Cancelar");
        aceptBtn.addActionListener(e -> {
            if (isValidInput()) {
                updateContact(contact);
                JOptionPane.showMessageDialog(this, "Contacto actualizado: " + contact);
                ContactTableModel contactTableModel = (ContactTableModel) app.getContactTable().getModel();
                contactTableModel.fireTableDataChanged();
                app.getContactTable().repaint();
                SwingUtilities.getWindowAncestor(this).dispose();
                app.setVisible(true);
            }
        });
        cancelBtn.addActionListener(e -> {
            nameTxt.setText("");
            lastNameTxt.setText("");
            emailTxt.setText("");
            telephoneTxt.setText("");
            SwingUtilities.getWindowAncestor(this).dispose();
            app.setVisible(true);
        });
    }

    public boolean isValidInput() {
        return !nameTxt.getText().isEmpty() && !lastNameTxt.getText().isEmpty()
                && !emailTxt.getText().isEmpty() && !telephoneTxt.getText().isEmpty();
    }

    public void updateContact(Contact contact) {
        contact.setName(nameTxt.getText());
        contact.setLastName(lastNameTxt.getText());
        contact.setEmail(emailTxt.getText());
        contact.setPhoneNumber(telephoneTxt.getText());
    }

    public Agenda getAgenda() {
        return agenda;
    }
}
```

Podrás notar que el constructor de `ContactPanel` tiene dos sobrecargas, una para agregar un contacto y otra para editar
un contacto existente. En el caso de editar un contacto, se llenan los campos con la información del contacto a editar y
se cambia el texto del botón de aceptar a "Actualizar". En el caso de agregar un contacto, se limpian los campos y se
cambia el texto del botón de aceptar a "Aceptar". En ambos casos, se utiliza un `JOptionPane` para mostrar un mensaje al
usuario indicando que el contacto ha sido agregado o actualizado.

Desde el punto de vista visual se verá de la siguiente manera:

![contac-panel_1.png](contac-panel_1.png)

Toma en consideración el diseño y el uso de `JFormattedTextField` para los campos de correo electrónico y teléfono,
ya que esto ayuda a validar el formato de los datos ingresados. En el caso de que el formato no sea válido, se lanzará
una excepción `ParseException` que se puede manejar en el método `isValidInput()`.

## `EditContactWindow.java`

```java
package com.example.agenda;

import javax.swing.*;

public class EditContactWindow extends JFrame {

    public EditContactWindow(AgendaApp app, Contact contact) {
        setTitle("Editar contacto");
        add(new ContactPanel(app, contact));
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
```

En esta clase se crea una ventana emergente que contiene el panel de contacto y se le pasa el contacto a editar. Al
hacer clic en el botón de aceptar, se actualiza el contacto y se cierra la ventana. En caso de hacer clic en el botón de
cancelar, se cierra la ventana sin realizar ningún cambio.

## `AgendaApp.form`

Esta es la clase principal de la aplicación, donde se inicializa la agenda y se muestra la interfaz gráfica. Aquí es
donde se crea la tabla de contactos y se agrega el panel de contacto. También se implementan los métodos para agregar,
eliminar y editar contactos. A continuación se muestra la interfaz gráfica de la aplicación:

![app_1.png](app_1.png)

![app_2.png](app_2.png)

Como podrás notar, la interfaz gráfica es bastante sencilla y se basa en el uso de `JTable` para mostrar los contactos.
Al dar clic en la pestaña de "Agregar contacto", se abrirá el panel de contacto para agregar un nuevo contacto. Al dar
clic en la pestaña de "Agenda", veremos la tabla de contactos y podremos editar o eliminar un contacto existente. Al dar
clic en el botón de "Eliminar", se eliminará el contacto seleccionado de la tabla. Al dar clic en el botón de "Editar",
se abrirá la ventana emergente para editar el contacto seleccionado.

De igual manera toma en consideración que el componente `addContact` deberá de estar marcado como `Custom Created` para
que podamos configurar dicho componente como un nuevo `ContactPanel` y no como un `JPanel` normal.

## `AgendaApp.java`

```java
package com.example.agenda;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AgendaApp extends JFrame {
    private JPanel mainPanel;
    private JTabbedPane tabbedPane1;
    private JTable contactTable;
    private JPanel addContact;
    private JButton editContactBtn;
    private JButton deleteContactBtn;
    private Agenda agenda;

    public AgendaApp() {
        contactTable.setModel(new ContactTableModel(agenda));
        setTitle("Agenda");
        setContentPane(mainPanel);
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        editContactBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = contactTable.getSelectedRow();
                if (selectedRow != -1) {
                    setVisible(false);
                    Contact contact = agenda.getContact(selectedRow);
                    EditContactWindow editContactWindow = new EditContactWindow(AgendaApp.this, contact);
                    editContactWindow.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione un contacto para editar.");
                }
            }
        });
        deleteContactBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = contactTable.getSelectedRow();
                if (selectedRow != -1) {
                    agenda.removeContact(agenda.getContact(selectedRow));
                    ((ContactTableModel) contactTable.getModel()).fireTableDataChanged();
                    contactTable.repaint();
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione un contacto para eliminar.");
                }
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                agenda.saveAgenda();
            }
        });
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public JTable getContactTable() {
        return contactTable;
    }

    private void createUIComponents() {
        agenda = new Agenda();
        agenda.loadAgenda();
        addContact = new ContactPanel(agenda);
    }
}
```

Con esta clase se inicializa la aplicación y se configura la tabla de contactos. También se implementan los métodos para
agregar, eliminar y editar contactos. Al dar clic en el botón de "Agregar contacto", se abrirá el panel de contacto para
agregar un nuevo contacto. Al dar clic en el botón de "Eliminar contacto", se eliminará el contacto seleccionado de la
tabla. Al dar clic en el botón de "Editar contacto", se abrirá la ventana emergente para editar el contacto
seleccionado.

Al cerrar la ventana, se guardará la agenda en el archivo `Contactos.agd` para que no se pierdan los contactos
agregados.

## Conclusión

Para concluir solo deberás de crear una clase `Main` que contenga el método `main` y que inicialice la aplicación

```java
package com.example.agenda;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(AgendaApp::new);
    }
}
```

Con esto hemos terminado la práctica de la agenda de contactos. Recuerda que puedes agregar más funcionalidades a la
aplicación, como por ejemplo, la búsqueda de contactos por nombre o apellido, la validación de los campos de entrada,
la implementación de un menú para guardar y cargar la agenda, entre otras cosas. La idea es que puedas seguir
experimentando y aprendiendo con Java y Swing.

## Para la entrega

1. Realiza el desarrollo de la aplicación siguiendo los pasos anteriores.
2. Comprueba que la aplicación funcione correctamente.
3. Graba un video de la aplicación en funcionamiento.
4. Crea un archivo ZIP con el código fuente del proyecto.
5. Sube el video y el archivo ZIP a la plataforma.

## Criterios de Evaluación

| Criterio      | Descripción                                                                       | Puntaje  |
|---------------|-----------------------------------------------------------------------------------|----------|
| Portada       | Se anexa portada con datos del equipo.                                            | 5%       |
| Código        | El código fuente cumple con los requerimientos y está correctamente estructurado. | 30%      |
| Funcionalidad | La aplicación cumple con los requerimientos y funciona correctamente.             | 30%      |
| Video         | Se anexa video de la aplicación en funcionamiento.                                | 20%      |
| Entrega       | Se anexa archivo ZIP con el código fuente del proyecto.                           | 15%      |
| **Total**     |                                                                                   | **100%** |

## Fecha de Entrega

La fecha de entrega de este entregable es el **27 de mayo de 2025** a las **23:59**. Cualquier entrega después de esta
fecha no será calificada.

Recuerda que la entrega se realizará a través de la plataforma **Moodle**.

**Entrega fuera de tiempo no será calificada.**

> Recuerda que deberás anexar al trabajo por separado el archivo de portada, video y zip con el código fuente de tu
> proyecto.
> {style="note"}