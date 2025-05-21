package com.example.agenda;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Agenda implements Serializable {
    private static final String FILE_PATH = "archivos/";
    private final ArrayList<Contact> contacts;

    public Agenda() {
        contacts = new ArrayList<>();
        if (new File("archivos/agenda.txt").exists())
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
