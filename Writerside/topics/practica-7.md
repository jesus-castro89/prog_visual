# Practica 7: Manejando Contactos y Agenda

## Objetivo

El objetivo de esta práctica es aprender a manejar contactos y una agenda utilizando la programación orientada a objetos
en Python. Se espera que los estudiantes sean capaces de crear, modificar y eliminar contactos, así como gestionar una
agenda de manera eficiente, todo mediante archivos de texto con Java.

## Actividades

1. **Crear una clase Contacto**: Definir una clase `Contacto` que contenga los siguientes atributos:
    - Nombre
    - Apellido
    - Teléfono
    - Correo electrónico
2. **Crear una clase Agenda**: Definir una clase `Agenda` que contenga una lista de contactos y los siguientes métodos:
    - `agregarContacto(contacto)`: Agregar un nuevo contacto a la agenda.
    - `eliminarContacto(nombre)`: Eliminar un contacto de la agenda por su nombre.
    - `buscarContacto(nombre)`: Buscar un contacto por su nombre y mostrar sus detalles.
    - `listarContactos()`: Listar todos los contactos en la agenda.
3. **Guardar y cargar contactos**: Implementar métodos para guardar la agenda en un archivo de texto y cargarla desde un
   archivo de texto.

## Desarrollo

Para efecto de esta práctica, se utilizará un archivo de texto para almacenar los contactos. Cada contacto se guardará
en una línea del archivo con el siguiente formato:

```
Nombre,Apellido,Teléfono,Correo electrónico
```

Así mismo, la resolución de la práctica será tomando como base el paquete `com.example.agenda`.

### Paso 1: Crear la clase Contacto

Para nuestra clase `Contacto`, definimos los atributos y un método para mostrar la información del contacto.

```java
package com.example.agenda;

public class Contacto {
    private String nombre;
    private String apellido;
    private String telefono;
    private String correo;

    public Contacto(String nombre, String apellido, String telefono, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    @Override
    public String toString() {
        return "Nombre: %s, Apellido: %s, Teléfono: %s, Correo: %s";
                .formatted(nombre, apellido, telefono, correo);
    }
}
```

Como podemos ver, la clase `Contacto` tiene un constructor que inicializa los atributos y métodos `get` para acceder a
ellos. El método `toString` se utiliza para mostrar la información del contacto de manera legible.

### Paso 2: Crear la clase Agenda

Ahora creamos la clase `Agenda`, que contendrá una lista de contactos y los métodos necesarios para gestionar la agenda.

```java
package com.example.agenda;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.JOptionPane;

public class Agenda {
    private List<Contacto> contactos;

    public Agenda() {
        this.contactos = new ArrayList<>();
    }

    public void agregarContacto(Contacto contacto) {
        contactos.add(contacto);
        JOptionPane.showMessageDialog(null, "Contacto agregado: " + contacto);
    }

    public void eliminarContacto(String nombre) {
        for (Contacto contacto : contactos) {
            if (contacto.getNombre().equalsIgnoreCase(nombre)) {
                contactos.remove(contacto);
                JOptionPane.showMessageDialog(null, "Contacto eliminado: " + contacto);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Contacto no encontrado.");
    }

    public void buscarContacto(String nombre) {
        for (Contacto contacto : contactos) {
            if (contacto.getNombre().equalsIgnoreCase(nombre)) {
                JOptionPane.showMessageDialog(null, "Contacto encontrado: " + contacto);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Contacto no encontrado.");
    }

    public void listarContactos() {
        StringBuilder sb = new StringBuilder();
        for (Contacto contacto : contactos) {
            sb.append(contacto).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    public void guardarAgenda(String archivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            for (Contacto contacto : contactos) {
                writer.write(contacto.getNombre() + "," +
                        contacto.getApellido() + "," +
                        contacto.getTelefono() + "," +
                        contacto.getCorreo());
                writer.newLine();
            }
            JOptionPane.showMessageDialog(null, "Agenda guardada en " + archivo);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar la agenda: " + e.getMessage());
        }
    }

    public void cargarAgenda(String archivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 4) {
                    Contacto contacto = new Contacto(datos[0], datos[1], datos[2], datos[3]);
                    contactos.add(contacto);
                }
            }
            JOptionPane.showMessageDialog(null, "Agenda cargada desde " + archivo);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar la agenda: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        agenda.agregarContacto(new Contacto("Juan", "Pérez", "123456789", "juan.perez@algo.com"));
        agenda.agregarContacto(new Contacto("Ana", "Gómez", "987654321", "ana.gomez@algo.com"));
        agenda.listarContactos();
        agenda.buscarContacto("Juan");
        agenda.eliminarContacto("Ana");
        agenda.listarContactos();
        agenda.guardarAgenda("agenda.txt");
        agenda.cargarAgenda("agenda_ejemplo.txt");
        agenda.listarContactos();
    }
}
```

### Paso 3: Probar la aplicación

Para probar la aplicación, puedes ejecutar el método `main` de la clase `Agenda`. Este método crea una agenda, agrega
contactos, busca, elimina y lista los contactos. También guarda la agenda en un archivo de texto y la carga desde otro
archivo de texto. Asegúrate de tener los archivos `agenda.txt` y `agenda_ejemplo.txt` en la misma carpeta que tu
código fuente para qué la carga y guardado funcionen correctamente.

## Conclusión

En esta práctica, hemos aprendido a manejar contactos y una agenda utilizando la programación orientada a objetos en
Java. Hemos creado una clase `Contacto` para representar un contacto y una clase `Agenda` para gestionar una lista de
contactos. También hemos implementado métodos para agregar, eliminar, buscar y listar contactos, así como guardar y
cargar la agenda desde archivos de texto. Esta práctica es un buen ejercicio para familiarizarse con la programación
orientada a objetos y la manipulación de archivos en Java.

## Entrega

1. Entrega el código fuente de tu proyecto en formato comprimido (zip o rar).
2. Crea un archivo con portada que contenga los datos de identificación de los miembros del equipo, el nombre de la
   práctica y la fecha de entrega.
3. Se incluyen capturas de pantalla de la ejecución de la práctica, mostrando la funcionalidad de agregar, eliminar,
   buscar y
   listar contactos, así como guardar y cargar la agenda desde archivos de texto.
4. Los archivos de texto utilizados para guardar y cargar la agenda deben estar incluidos en la entrega.
5. Asegúrate de que el código esté bien comentado y siga las convenciones de estilo de Java.

## Criterio de evaluación

| Criterio             | Descripción                                                                                         | Puntuación |
|----------------------|-----------------------------------------------------------------------------------------------------|------------|
| Código               | El código está bien estructurado y sigue las convenciones de Java.                                  | 20%        |
| Funcionalidad        | La agenda permite agregar, eliminar, buscar y listar contactos. (Ejemplo visible en las evidencias) | 30%        |
| Manejo de archivos   | La agenda guarda y carga contactos desde archivos de texto.                                         | 20%        |
| Portada              | La portada contiene la información requerida.                                                       | 10%        |
| Capturas de pantalla | Se incluyen capturas de pantalla de la ejecución de la práctica.                                    | 20%        |
| **Total**            |                                                                                                     | **100%**   |

## Fecha de entrega

La fecha de entrega es el día 16 de abril de 2025 a las 23:59 horas. Entregas posteriores serán calificadas sobre el 70%
de la puntuación total. 

> **Nota**: Asegúrate de seguir las instrucciones de entrega y cumplir con los criterios de evaluación para obtener la
> mejor calificación posible. Si tienes alguna duda o pregunta, no dudes en consultar con tu instructor.
> Recuerda que esta práctica es una oportunidad para aprender y mejorar tus habilidades en programación orientada a
> objetos y manejo de archivos en Java.
> {style="note"}

> Actividad enviada solamente texto o capturas de pantalla en lugar de código fuente no será aceptada. La actividad 
> no se calificará si no se entrega el código fuente completo y funcional. Asegúrate de seguir las instrucciones
> de entrega y cumplir con los criterios de evaluación para obtener la mejor calificación posible.
> {style="warning"}