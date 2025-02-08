# Las clases en Java

En Java el componente más básico y fundamental es la **clase**. Una clase es una plantilla o modelo que define las
propiedades y comportamientos de un objeto. En otras palabras, una clase es un molde a partir del cual se pueden crear
múltiples objetos con características similares.

## Creando una clase en Java

Para crear una clase en Java, debemos seguir los siguientes pasos:

1. Definir la clase utilizando la palabra clave `class`, seguida del nombre de la clase y las llaves `{}` que delimitan
   el cuerpo de la clase.
2. Dentro del cuerpo de la clase, podemos definir atributos (variables) y métodos (funciones) que describen las
   propiedades y comportamientos de los objetos creados a partir de la clase.

Por ejemplo, la siguiente clase `Persona` define una plantilla para objetos que representan personas con un nombre y una
edad:

```java
public class Persona {
    // Atributos de la clase
    private String nombre;
    private int edad;

    // Constructor de la clase
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Métodos de la clase
    public void saludar() {
        System.out.println("Hola, mi nombre es " + nombre + " y tengo " + edad + " años.");
    }
}
```

En este ejemplo, la clase `Persona` tiene dos atributos `nombre` y `edad`, un constructor que inicializa estos atributos
y un método `saludar` que imprime un mensaje con el nombre y la edad de la persona.

> **Nota:** En Java, los nombres de las clases deben comenzar con una letra mayúscula y seguir la convención de
> nomenclatura CamelCase, donde cada palabra en el nombre de la clase comienza con una letra mayúscula.

> **Recuerda que tanto los atributos como funciones deben estar dentro de la clase. Es decir, no pueden estar fuera
> de la clase. Este límite lo dictan las llaves `{}` que delimitan el cuerpo de la clase.**
> {style="warning"}

## Ejemplo de Clases

### Clase `Carro` de Forma Correcta

```java
public class Carro {
    // Atributos de la clase
    private String marca;
    private String modelo;
    private int anio;

    // Constructor de la clase
    public Carro(String marca, String modelo, int anio) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
    }

    // Métodos de la clase
    public void mostrarInformacion() {
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Año: " + anio);
    }
}
```

### Clase `Carro` de Forma Incorrecta

```java
public class Carro {
    private String marca;
    private String modelo;
    private int anio;
}

public void mostrarInformacion() {
    System.out.println("Marca: " + marca);
    System.out.println("Modelo: " + modelo);
    System.out.println("Año: " + anio);
}
```

Nota como en el segundo ejemplo, el método `mostrarInformacion` está fuera de la clase `Carro`, lo cual es incorrecto y
generará un error de compilación.

## Relación de Archivos y Clases

En Java, cada archivo fuente (`.java`) debe de contener **exactamente una clase pública**. Esta clase debe tener el
mismo nombre que el archivo fuente. Por ejemplo, si tenemos una clase `Persona`, el archivo fuente debe llamarse
`Persona.java`.

> **Nota:** Aunque es posible tener múltiples clases en un solo archivo fuente, solo una de ellas puede ser pública y
> debe tener el mismo nombre que el archivo. Las demás clases pueden ser privadas o tener un nivel de acceso
> restringido. Sin embargo, es una buena práctica tener una sola clase por archivo.

## Conclusión

Las clases son los componentes fundamentales de la programación orientada a objetos en Java. Permiten definir plantillas
o modelos que describen las propiedades y comportamientos de los objetos. Al crear una clase en Java, debemos definir
sus atributos y métodos, siguiendo las convenciones de nomenclatura y estructura de la clase.