# Proyecto 4: Parte 1 [Agenda y Contactos]

Para dar continuidad a la Actividad 7, vamos a crear una agenda de contactos. En esta actividad, implementaremos una
clase `Contacto` y una clase `Agenda` que gestionará una lista de contactos. La agenda permitirá agregar, eliminar y
mostrar contactos, así como guardar y cargar la lista de contactos desde un archivo.

De tal manera que nuestras clases deberán de verse de la siguiente manera:

## `Contacto.java`

```java
package com.example.agenda;

import java.io.Serializable;

public class Contact implements Serializable {
    private String name;
    private String lastName;
    private String phoneNumber;
    private String email;

    public Contact(String name, String lastName, String phoneNumber, String email) {
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    @Override
    public String toString() {
        return ("%s, %s, %s, %s")
                .formatted(name.trim(), lastName.trim(),
                        phoneNumber.trim(), email.trim());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
```

## `Agenda.java`

```java
package com.example.agenda;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class Agenda implements Serializable {
    private static final String FILE_PATH = "archivos/";
    private final ArrayList<Contact> contacts;

    public Agenda() {
        contacts = new ArrayList<>();
        if (new File("archivos/Contactos.agd").exists())
            loadAgenda();
    }

    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    public int getContactCount() {
        return contacts.size();
    }

    public Contact getContact(int index) {
        if (index >= 0 && index < contacts.size()) {
            return contacts.get(index);
        } else {
            return null;
        }
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
        JOptionPane.showMessageDialog(null,
                "El contacto ha sido agregado a la agenda",
                "Contacto añadido",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public void removeContact(Contact contact) {
        if (contacts.remove(contact)) {
            JOptionPane.showMessageDialog(null,
                    "El contacto ha sido eliminado de la agenda",
                    "Contacto eliminado",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null,
                    "El contacto no se encuentra en la agenda",
                    "Error al eliminar contacto",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void saveAgenda() {
        try (FileOutputStream fos =
                     new FileOutputStream(FILE_PATH + "Contactos.agd");
             ObjectOutputStream oos =
                     new ObjectOutputStream(fos)) {
            oos.writeObject(this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void loadAgenda() {
        try (FileInputStream fis =
                     new FileInputStream(FILE_PATH + "Contactos.agd");
             ObjectInputStream ois =
                     new ObjectInputStream(fis)) {
            Agenda agenda = (Agenda) ois.readObject();
            contacts.clear();
            contacts.addAll(agenda.getContacts());
        } catch (IOException | ClassNotFoundException e) {
            //throw new RuntimeException(e);
            contacts.clear();
        }
    }
}
```

> NOTA: Toma en consideración que deberás de crear el directorio `archivos` en la raíz de tu proyecto, ya que ahí se
> almacenará el archivo `Contactos.agd` donde se guardarán los contactos de la agenda.