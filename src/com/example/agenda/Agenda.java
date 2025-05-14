package com.example.agenda;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Agenda {
    private ArrayList<Contact> contacts;

    public Agenda() {
        contacts = new ArrayList<>();
        if (new File("archivos/agenda.txt").exists())
            loadAgenda();
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

    public Contact searchContact(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                JOptionPane.showMessageDialog(null,
                        contact.toString(),
                        "Contacto encontrado",
                        JOptionPane.INFORMATION_MESSAGE);
                return contact;
            }
        }
        JOptionPane.showMessageDialog(null,
                "El contacto no se encuentra en la agenda",
                "Contacto no encontrado",
                JOptionPane.ERROR_MESSAGE);
        return null;
    }

    public void listContacts() {
        if (contacts.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "No hay contactos en la agenda",
                    "Agenda vacía",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            StringBuilder contactList = new StringBuilder();
            for (Contact contact : contacts) {
                contactList.append(contact.toString()).append("\n");
            }
            JOptionPane.showMessageDialog(null,
                    contactList.toString(),
                    "Lista de contactos",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void saveAgenda() {
        try (BufferedWriter bwrite = new BufferedWriter(
                new FileWriter("archivos/agenda.txt")
        )) {
            for (Contact contact : contacts) {
                bwrite.write(contact.toString());
                bwrite.newLine();
            }
            bwrite.close();
            JOptionPane.showMessageDialog(null,
                    "La agenda ha sido guardada",
                    "Agenda guardada",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Error al guardar la agenda: " + e.getMessage(),
                    "Error al guardar",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void loadAgenda() {
        try (BufferedReader reader = new BufferedReader(new FileReader("archivos/agenda.txt"))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                System.out.println(Arrays.toString(datos));
                if (datos.length == 4) {
                    Contact contact = new Contact(datos[0], datos[1], datos[2], datos[3]);
                    contacts.add(contact);
                }
            }
            reader.close();
            JOptionPane.showMessageDialog(null, "Agenda cargada desde: agenda.txt ",
                    "Agenda cargada", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar la agenda: " + e.getMessage());
        }
    }
}
