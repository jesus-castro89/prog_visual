package com.example.agenda;

import javax.swing.*;
import java.text.ParseException;

public class TelephoneFormatter extends JFormattedTextField.AbstractFormatter {
    @Override
    public Object stringToValue(String text) throws ParseException {
        if (text == null || text.isEmpty()) {
            return null;
        }
        if (!text.matches("^\\d{10}$")) {
            throw new ParseException("Invalid telephone format", 0);
        }
        return text;
    }

    @Override
    public String valueToString(Object value) throws ParseException {
        if (value == null) {
            return "";
        }
        if (!(value instanceof String telephone)) {
            throw new ParseException("Invalid value type", 0);
        }
        if (!telephone.matches("^\\d{10}$")) {
            throw new ParseException("Invalid telephone format", 0);
        }
        return telephone;
    }
}
