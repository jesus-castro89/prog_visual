package com.example.agenda;

import javax.swing.*;
import java.awt.*;

public class Main {

    static {
        UIManager.put("OptionPane.messageFont",
                new Font("Consolas", Font.BOLD, 24));
        UIManager.put("OptionPane.buttonFont",
                new Font("Arial", Font.BOLD, 24));
        UIManager.put("TextField.font",
                new Font("Arial", Font.PLAIN, 24));
        UIManager.put("ComboBox.font",
                new Font("Arial", Font.BOLD, 24));
    }

    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        Contact contact1 = new Contact("Juan", "Pérez",
                "123456789", "juan.perez@correo.com");
        Contact contact2 = new Contact("María", "Gómez",
                "987654321", "maria.gomez@correo.com");
        agenda.addContact(contact1);
        agenda.addContact(contact2);
        agenda.listContacts();
        agenda.searchContact("Juan");
        agenda.removeContact(contact1);
        agenda.listContacts();
        agenda.saveAgenda();
    }
}
