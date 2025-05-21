package com.example.agenda;

import javax.swing.*;
import java.text.ParseException;

public class EmailFormatter extends JFormattedTextField.AbstractFormatter {

    @Override
    public Object stringToValue(String text) throws ParseException {
        if (text == null || text.isEmpty()) {
            return null;
        }
        if (!text.matches("^[\\w-.]+@[\\w-]+\\.[a-z]{2,4}$")) {
            throw new ParseException("Invalid email format", 0);
        }
        return text;
    }

    @Override
    public String valueToString(Object value) throws ParseException {
        if (value == null) {
            return "";
        }
        if (!(value instanceof String email)) {
            throw new ParseException("Invalid value type", 0);
        }
        if (!email.matches("^[\\w-.]+@[\\w-]+\\.[a-z]{2,4}$")) {
            throw new ParseException("Invalid email format", 0);
        }
        return email;
    }
}
