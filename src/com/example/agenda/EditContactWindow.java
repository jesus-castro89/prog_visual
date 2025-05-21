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
