# Parte 2: [Los formatos de E-mail y teléfono]

Para que nuestros contactos sean dados de alta, es necesario que el formato de los números de teléfono y correos
electrónicos sean válidos. Para ello, vamos a implementar dos clases que validen el formato de los números de teléfono y
correos electrónicos.

## `EmailFormatter.java`

```java
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
```

## `PhoneFormatter.java`

```java
package com.example.agenda;

import javax.swing.*;
import java.text.ParseException;

public class PhoneFormatter extends JFormattedTextField.AbstractFormatter {
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
```

Con estos formatos podemos asegurarnos de que los campos de nuestra interfaz, validen que dichos datos sean correctos.
En caso de que no lo sean, se borrará el campo.