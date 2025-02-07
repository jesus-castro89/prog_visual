# La clase JButton

La clase JButton es una clase que representa un botón en una interfaz gráfica de usuario. Un botón es un componente que
el usuario puede pulsar para realizar una acción. La clase JButton es una subclase de la clase AbstractButton, que a su
vez es una subclase de la clase JComponent.

Cuenta con varios constructores, pero el más común es el que recibe un String con el texto que se mostrará en el botón.

```java
JButton boton = new JButton("Aceptar");
```

En el editor visual de IntelliJ IDEA, puedes arrastrar un botón desde la paleta de componentes y soltarlo en el panel de
diseño. IntelliJ IDEA creará automáticamente el código necesario para instanciar un objeto de la clase JButton y
añadirlo al panel de diseño.

Puedes editar y configurar el botón directamente en el editor visual. Por ejemplo, puedes cambiar el texto que se
muestra en el botón, cambiar el color de fondo, cambiar el color del texto, cambiar la fuente, etc.

Con esto podrás personalizar el aspecto del botón para que se adapte a tus necesidades.

Ahora vemos los atributos y métodos más importantes de la clase JButton.

## Atributos

La clase JButton cuenta con varios atributos que te permiten personalizar el aspecto y el comportamiento del botón.

### Texto

El texto que se muestra en el botón. Puedes cambiar el texto con el método `setText()`.

```java
boton.setText("Aceptar");
```

### Icono

Un icono que se muestra en el botón. Puedes cambiar el icono con el método `setIcon()`.

```java
boton.setIcon(new ImageIcon("icono.png"));
```

> **Nota:** Para usar un icono en un botón, necesitas un objeto de la clase ImageIcon. Puedes crear un objeto de la
> clase ImageIcon pasando la ruta del archivo de imagen como argumento al constructor.

> **Nota:** El icono se muestra a la izquierda del texto en el botón. Aunque puedes cambiar la posición del icono con el
> método `setHorizontalTextPosition()`.

### Habilitado

Un booleano que indica si el botón está habilitado o no. Puedes habilitar o deshabilitar el botón con el método
`setEnabled()`.

```java
boton.setEnabled(false);
```

### Visible

Un booleano que indica si el botón es visible o no. Puedes hacer visible o invisible el botón con el método
`setVisible()`.

```java
boton.setVisible(false);
```

### Fuente

La fuente del texto que se muestra en el botón. Puedes cambiar la fuente con el método `setFont()`.

```java
boton.setFont(new Font("Arial", Font.PLAIN, 12));
```

### Color de fondo

El color de fondo del botón. Puedes cambiar el color de fondo con el método `setBackground()`.

```java
boton.setBackground(Color.RED);
```

### Color del texto

El color del texto que se muestra en el botón. Puedes cambiar el color del texto con el método `setForeground()`.

```java
boton.setForeground(Color.WHITE);
```

### Color de borde

El color del borde del botón. Puedes cambiar el color del borde con el método `setBorder()`.

```java
boton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
```

### Margen

El margen interno del botón. Puedes cambiar el margen con el método `setMargin()`.

```java
boton.setMargin(new Insets(10, 20, 10, 20));
```

### Tamaño

El tamaño del botón. Puedes cambiar el tamaño con el método `setSize()`.

```java
boton.setSize(100, 50);
```