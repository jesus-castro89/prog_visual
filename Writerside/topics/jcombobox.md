# El Componente JComboBox en SWING

El componente `JComboBox` en SWING es un elemento gráfico que permite a los usuarios seleccionar una opción de una lista
desplegable. Es similar a un menú desplegable en una página web, donde el usuario puede elegir entre varias opciones.

## Creando un JComboBox

Para crear un `JComboBox` en Java, primero debemos crear un nuevo proyecto en IntelliJ IDEA y una nueva ventana desde el
editor de diseño. Luego, podemos arrastrar y soltar un `JComboBox` desde la paleta de componentes a la ventana, lo que
creará un nuevo `JComboBox` en la interfaz.

![jcombobox_1.png](jcombobox_1.png)

Con lo anterior, hemos agregado un `JComboBox` a nuestra ventana. Podemos personalizarlo cambiando sus opciones y
manejando eventos de selección.

## Propiedades del JComboBox

Al igual que los campos de texto, podemos modificar su color de fondo y fuente, así como la tipografía empleada por
el componente. Además de contar con la opción `editable`, la cual permite editar la selección.

Sin embargo, quizás la más importante de todas es la llamada `model`, ya que es la que controla la lista de componentes
o elementos de la lista desplegable.

![jcombobox_2.png](jcombobox_2.png)

## Eventos del JComboBox

El `JComboBox` tiene varios eventos que podemos manejar, como `ItemStateChanged`, que se activa cuando se selecciona
un nuevo elemento en la lista desplegable. También podemos manejar eventos de clic y teclado, como `MouseClicked` y
`KeyPressed`.

Por lo tanto, desde la interfaz de edición, podemos seleccionar el componente y al dar clic derecho sobre el y luego
seleccionar la opción `Create Listener`, podemos agregar un nuevo evento a nuestro `JComboBox`.

Los siguientes son los `Listener` más comunes que podemos agregar a un `JComboBox`:

| Listener       | Descripción                                                                |
|----------------|----------------------------------------------------------------------------|
| ActionListener | Se activa cuando se hace clic en el componente.                            |
| FocusListener  | Se activa cuando el componente gana o pierde el foco.                      |
| ItemListener   | Se activa cuando se selecciona un nuevo elemento en la lista desplegable.  |
| KeyListener    | Se activa cuando se presiona, suelta o escribe una tecla en el componente. |
| MouseListener  | Se activa cuando se hace clic, se presiona o se suelta un botón del ratón. |

Los siguientes son los eventos más comunes que podemos manejar en un `JComboBox`:

| Evento           | Descripción                                                               |
|------------------|---------------------------------------------------------------------------|
| ItemStateChanged | Se activa cuando se selecciona un nuevo elemento en la lista desplegable. |
| KeyPressed       | Se activa cuando se presiona una tecla en el componente.                  |
| KeyReleased      | Se activa cuando se suelta una tecla en el componente.                    |
| KeyTyped         | Se activa cuando se presiona y suelta una tecla en el componente.         |

> **Nota:** El `JComboBox` es un componente muy versátil y útil en SWING, ya que nos permite crear interfaces de 
> usuario interactivas y fáciles de usar. Podemos personalizarlo y manejar eventos para adaptarlo a nuestras 
> necesidades.

