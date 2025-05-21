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
        contactTable.setModel(new ContactTable(agenda));
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
                    ((ContactTable) contactTable.getModel()).fireTableDataChanged();
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
