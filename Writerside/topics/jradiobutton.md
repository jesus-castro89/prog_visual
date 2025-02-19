# Los Botones de Radio o RadioButtons en SWING

Los botones de radio, o `JRadioButton`, en SWING son componentes gráficos que permiten a los usuarios seleccionar una
opción de una lista de opciones mutuamente excluyentes. Es similar a un grupo de botones de opción en una página web,
donde el usuario puede elegir una sola opción entre varias.

## Creando un JRadioButton

Para crear un `JRadioButton` en Java, primero debemos crear un nuevo proyecto en IntelliJ IDEA y una nueva ventana desde
el editor de diseño. Luego, podemos arrastrar y soltar un `JRadioButton` desde la paleta de componentes a la ventana,
lo que creará un nuevo `JRadioButton` en la interfaz.

En este caso, hemos agregado dos `JRadioButton` a nuestra ventana. Podemos personalizarlos cambiando sus etiquetas y
manejando eventos de selección.

## Propiedades del JRadioButton

Al igual que otros componentes gráficos en SWING, los `JRadioButton` tienen varias propiedades que podemos modificar,
como su color de fondo, fuente y tamaño. Además, podemos cambiar la etiqueta que se muestra junto al botón.

## Grupos de JRadioButton

Una característica importante de los botones de radio en SWING es que pueden agruparse en grupos lógicos para garantizar
que solo se pueda seleccionar una opción a la vez. Para hacer esto, podemos utilizar la clase `ButtonGroup` y agregar
los botones de radio al grupo.

Por ejemplo, para agrupar dos botones de radio `radioButton1` y `radioButton2`, podemos hacer lo siguiente:

```java
ButtonGroup group = new ButtonGroup();
group.add(radioButton1);
group.add(radioButton2);
```

Con lo anterior, solo se podrá seleccionar una de las dos opciones a la vez, ya que pertenecen al mismo grupo.

## Eventos del JRadioButton

Los `JRadioButton` tienen varios eventos que podemos manejar, como `ItemStateChanged`, que se activa cuando se
selecciona un nuevo botón de radio. También podemos manejar eventos de clic y teclado, como `MouseClicked` y
`KeyPressed`.

Por lo tanto, desde la interfaz de edición, podemos seleccionar el componente y al dar clic derecho sobre él y luego
seleccionar la opción `Create Listener`, podemos agregar un nuevo evento a nuestro `JRadioButton`.

Los siguientes son los `Listener` más comunes que podemos agregar a un `JRadioButton`:

| Listener       | Descripción                                                                |
|----------------|----------------------------------------------------------------------------|
| ActionListener | Se activa cuando se hace clic en el componente.                            |
| FocusListener  | Se activa cuando el componente gana o pierde el foco.                      |
| ItemListener   | Se activa cuando se selecciona un nuevo botón de radio.                    |
| KeyListener    | Se activa cuando se presiona, suelta o escribe una tecla en el componente. |
| MouseListener  | Se activa cuando se hace clic, se presiona o se suelta un botón del ratón. |

Los siguientes son los eventos más comunes que podemos manejar en un `JRadioButton`:

| Evento           | Descripción                                                       |
|------------------|-------------------------------------------------------------------|
| ItemStateChanged | Se activa cuando se selecciona un nuevo botón de radio.           |
| KeyPressed       | Se activa cuando se presiona una tecla en el componente.          |
| KeyReleased      | Se activa cuando se suelta una tecla en el componente.            |
| KeyTyped         | Se activa cuando se presiona y suelta una tecla en el componente. |

> **Nota:** Los botones de radio en SWING son componentes muy útiles para crear interfaces de usuario interactivas y
> fáciles de usar. Al agruparlos y manejar eventos, podemos personalizarlos y adaptarlos a nuestras necesidades.