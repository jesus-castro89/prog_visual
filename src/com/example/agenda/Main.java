package com.example.agenda;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
//        Agenda agenda = new Agenda();
//        Contact contact1 = new Contact("Juan", "Pérez",
//                "123456789", "juan.perez@correo.com");
//        Contact contact2 = new Contact("María", "Gómez",
//                "987654321", "maria.gomez@correo.com");
//        agenda.addContact(contact1);
//        agenda.addContact(contact2);
//        agenda.listContacts();
//        agenda.searchContact("Juan");
//        agenda.removeContact(contact1);
//        agenda.listContacts();
//        agenda.saveAgenda();
        SwingUtilities.invokeLater(AgendaApp::new);
    }
}
