package com.example.agenda;

import javax.swing.table.AbstractTableModel;

public class ContactTableModel extends AbstractTableModel {

    private final Agenda agenda;
    private final String[] columnNames = {"Nombre", "Teléfono", "Email"};

    public ContactTableModel(Agenda agenda) {
        this.agenda = agenda;
    }

    @Override
    public int getRowCount() {
        return agenda.getContactCount();
    }

    @Override
    public int getColumnCount() {
        return 3; // Assuming 3 columns: Name, Phone, Email
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return switch (columnIndex) {
            case 0 -> agenda.getContact(rowIndex).getName();
            case 1 -> agenda.getContact(rowIndex).getPhoneNumber();
            case 2 -> agenda.getContact(rowIndex).getEmail();
            default -> null;
        };
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}
