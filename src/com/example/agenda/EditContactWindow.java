package com.example.agenda;

import javax.swing.*;

public class EditContactWindow extends JFrame {

    private ContactPanel contactPanel;

    public EditContactWindow(AgendaApp app, Contact contact) {
        setTitle("Editar contacto");
        add(contactPanel = new ContactPanel(app, contact));
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
