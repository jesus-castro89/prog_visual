# Los `Listeners` en Java

Los `Listeners` en Java son interfaces que manejan eventos en los componentes gráficos de una aplicación. Estos eventos
pueden ser de varios tipos, como clics de ratón, teclas presionadas, selección de elementos en una lista desplegable,
entre otros.

## ¿Qué es un Listener?

Un `Listener` en Java es una interfaz que maneja eventos en los componentes gráficos de una aplicación. Estos eventos
pueden ser de varios tipos, como clics de ratón, teclas presionadas, selección de elementos en una lista desplegable,
entre otros.

## Tipos de Listeners

Los `Listeners` más comunes en Java son:

| Listener       | Descripción                                                                |
|----------------|----------------------------------------------------------------------------|
| ActionListener | Se activa cuando se hace clic en el componente.                            |
| FocusListener  | Se activa cuando el componente gana o pierde el foco.                      |
| ItemListener   | Se activa cuando se selecciona un nuevo elemento en la lista desplegable.  |
| KeyListener    | Se activa cuando se presiona, suelta o escribe una tecla en el componente. |
| MouseListener  | Se activa cuando se hace clic, se presiona o se suelta un botón del ratón. |

Como podrás imaginar, cada uno de estos `Listeners` maneja un tipo específico de evento en un componente gráfico. Por
ejemplo, el `ActionListener` maneja eventos de clic, mientras que el `KeyListener` maneja eventos de teclado.

## Creando un Listener

Para crear un `Listener` en IntelliJ IDEA, primero debemos seleccionar el componente gráfico al que queremos agregar el
`Listener`. Luego, podemos hacer clic derecho sobre el componente y seleccionar la opción `Create Listener`, lo que nos
permitirá agregar un nuevo `Listener` al componente.

## Conclusiones

Los `Listeners` en Java son una parte fundamental de la programación de interfaces gráficas, ya que nos permiten manejar
eventos en los componentes de una aplicación. Al conocer los diferentes tipos de `Listeners` y cómo crearlos, podemos
hacer que nuestras aplicaciones sean más interactivas y fáciles de usar.