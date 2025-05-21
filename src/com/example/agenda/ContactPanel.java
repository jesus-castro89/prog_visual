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
        telephoneTxt.setFormatterFactory(new DefaultFormatterFactory(new TelephoneFormatter()));
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
            ContactTable contactTable = (ContactTable) ((AgendaApp) SwingUtilities.getWindowAncestor(this)).getContactTable().getModel();
            contactTable.fireTableDataChanged();
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
                ContactTable contactTable = (ContactTable) app.getContactTable().getModel();
                contactTable.fireTableDataChanged();
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
