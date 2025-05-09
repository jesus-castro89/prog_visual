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