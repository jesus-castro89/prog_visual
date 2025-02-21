# Proyecto 1: Crear una calculadora de áreas y perímetros

## Introducción

En este proyecto, vamos a crear una calculadora de áreas y perímetros. La calculadora debe ser capaz de calcular el área
y el perímetro de las siguientes figuras geométricas:

- Cuadrado
- Rectángulo
- Triángulo
- Círculo
- Trapecio
- Rombo
- Polígono regular
- Paralelogramo

La calculadora debe ser capaz de calcular el área y el perímetro de cada una de estas figuras geométricas.

### Objetivos

- Crear una calculadora de áreas y perímetros.
- Crear una interfaz gráfica para la calculadora.
- Crear una función para calcular el área y el perímetro de cada una de las figuras geométricas mencionadas.
- Crear una función para mostrar el resultado de los cálculos en la interfaz gráfica.
- Crear una función para limpiar los campos de entrada y salida de la interfaz gráfica.
- Crear una función para validar los datos de entrada.
- Crear una función para mostrar un mensaje de error en caso de que los datos de entrada no sean válidos.
- Crear una función para mostrar un mensaje de error en caso de que no se haya ingresado ningún valor en los campos de
  entrada.
- Crear una función para mostrar un mensaje de error en caso de que los valores ingresados no sean numéricos.
- Crear una función para mostrar un mensaje de error en caso de que los valores ingresados sean negativos.
- Crear una función para mostrar un mensaje de error en caso de que los valores ingresados sean cero.
- Crear una función para mostrar un mensaje de error en caso de que los valores ingresados no formen una figura
  geométrica válida.

## Parte 1: Creando el Proyecto y la Interfaz Gráfica

Para comenzar, vamos a crear un nuevo proyecto de Java en IntelliJ IDEA. Para ello, abrimos IntelliJ IDEA y
seleccionamos `File > New > Project`. En la ventana que se abre, seleccionamos `Java` en la lista de opciones y hacemos
clic en `Next`. Luego, ingresamos el nombre del proyecto (por ejemplo, `CalculadoraAreasPerimetros`) y hacemos clic en
`Finish`.

Crearemos un nuevo paquete llamado `calculadora_figuras` en el proyecto. Para ello, hacemos clic derecho en la carpeta
`src` del proyecto, seleccionamos `New > Package` y colocamos el nombre del paquete (`calculadora_figuras`). Dentro de
este paquete, crearemos la ventana de la interfaz gráfica de la calculadora, así como las clases y funciones necesarias
para realizar los cálculos.

Una vez creado el proyecto, vamos a crear una nueva ventana para la interfaz gráfica de la calculadora. Para ello,
seleccionamos `File > New > Swing UI Designer > GUI Form`. En la ventana que se abre, colocamos el nombre de la ventana
(por ejemplo, `CalculadoraFigurasUI`) y hacemos clic en `OK`.

En la ventana de diseño de la interfaz gráfica, vamos a agregar los siguientes componentes:

- Dos paneles (`JPanel`): uno para los campos de entrada y otro para los resultados de los cálculos.
    - El panel superior contendrá el resultado de los cálculos.
    - El panel inferior contendrá los campos de entrada y los botones para realizar los cálculos.
- En el panel superior, agregaremos un `JLabel` para mostrar el resultado de los cálculos.
- En el panel inferior, agregaremos los siguientes componentes:
    - Un `JComboBox` para seleccionar la figura geométrica.
        - Las opciones serán: Cuadrado, Rectángulo, Triángulo, Círculo, Trapecio, Rombo, Polígono regular, Elipse y
          Paralelogramo.
    - Un `JLabel` y un `JTextField` para ingresar el valor de la base.
    - Un `JLabel` y un `JTextField` para ingresar el valor de la altura.
    - Un `JLabel` y un `JTextField` para ingresar el valor del radio.
    - Un `JLabel` y un `JTextField` para ingresar el valor del lado.
    - Un `JLabel` y un `JTextField` para ingresar el valor de la diagonal mayor.
    - Un `JLabel` y un `JTextField` para ingresar el valor de la diagonal menor.
    - Un `JLabel` y un `JTextField` para ingresar el valor del número de lados.
    - Un `JLabel` y un `JTextField` para ingresar la apotema.
    - Un `JLabel` y un `JTextField` para ingresar el valor de la base mayor.
    - Un `JLabel` y un `JTextField` para ingresar el valor de la base menor.
    - Un `JButton` para calcular el área y el perímetro.
    - Un `JButton` para limpiar los campos de entrada y salida.

Una vez agregados los componentes, vamos a organizarlos en la ventana de la interfaz gráfica de la calculadora. Para
ello, Colocaremos primero los pares de `JLabel` y `JTextField` para los campos de entrada, luego el `JButton` para
calcular el área y el perímetro, y finalmente el `JButton` para limpiar los campos de entrada y salida.

Ocultaremos los campos de entrada que no son necesarios para la figura geométrica seleccionada. Por ejemplo, si se
selecciona el cuadrado, se ocultarán los campos de la base, la altura, el radio, la diagonal mayor, la diagonal menor,
el número de lados, la apotema, la base mayor y la base menor.

Por lo que para la primera figura del `JComboBox` se mostrarán los campos de la base y la altura.

> **Nota:** Para ocultar y mostrar los campos de entrada según la figura geométrica seleccionada, podemos utilizar un
> `ItemListener` en el `JComboBox` y cambiar la visibilidad de los componentes correspondientes.

> **Nota:** Recuerda nombrar a tu gusto cada componente para poder identificarlos fácilmente en el código. Y también
> recuerda nombrar el panel principal de la ventana.
> {style="note"}

Una vez hecho lo anterior, haremos que la clase asociada a la ventana herede de `JFrame` y agregaremos un constructor
que inicialice la ventana y los componentes de la interfaz gráfica. En este constructor, agregaremos los componentes al
panel principal de la ventana y configuraremos la ventana para que sea visible y tenga un tamaño adecuado.

```java
public class CalculadoraFigurasUI extends JFrame {

    private JPanel panelPrincipal;
    private JComboBox<String> listaFiguras;
    private JLabel lblBase;
    private JTextField txtBase;
    private JLabel lblAltura;
    private JTextField txtAltura;
    private JLabel lblRadio;
    private JTextField txtRadio;
    private JLabel lblLado;
    private JTextField txtLado;
    private JLabel lblDiagonalMayor;
    private JTextField txtDiagonalMayor;
    private JLabel lblDiagonalMenor;
    private JTextField txtDiagonalMenor;
    private JLabel lblNumeroLados;
    private JTextField txtNumeroLados;
    private JLabel lblApotema;
    private JTextField txtApotema;
    private JLabel lblBaseMayor;
    private JTextField txtBaseMayor;
    private JLabel lblBaseMenor;
    private JTextField txtBaseMenor;
    private JButton btnCalcular;
    private JButton btnLimpiar;
    private JLabel lblResultado;

    public CalculadoraAreasPerimetrosUI() {
        // Configurar la ventana
        setTitle("Calculadora de Áreas y Perímetros");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panelPrincipal);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new CalculadoraAreasPerimetrosUI();
    }
}
```

Ejecutamos la aplicación para verificar que la ventana de la interfaz gráfica se muestra correctamente. Si todo está
correcto, procederemos a implementar las funciones necesarias para realizar los cálculos de las áreas y perímetros de
las figuras geométricas.

Si hemos seguidos estos pasos, la estructura de nuestro proyecto debería verse de la siguiente manera:

```
📦 proyecto_visual
└─ src
   └─ calculadora_figuras
      └─ CalculadoraFigurasUI
         ├─ CalculadoraFigurasUI.java
         └─ CalculadoraFigurasUI.form
```

©generated by [Project Tree Generator](https://woochanleee.github.io/project-tree-generator)

## Parte 2: Ocultando y Mostrando los Campos de Entrada

En esta parte, vamos a implementar la lógica para ocultar y mostrar los campos de entrada según la figura geométrica
seleccionada en el `JComboBox`. Para ello, vamos a utilizar un `ItemListener` en el `JComboBox` que cambiará la
visibilidad de los componentes correspondientes.

Primero, vamos a crear un método llamado `ocultarCamposEntrada` que ocultará todos los campos de entrada. Luego,
crearemos un método llamado `mostrarCamposEntrada` que mostrará los campos de entrada correspondientes a la figura
geométrica seleccionada.

```java

    private void ocultarCamposEntrada() {

        lblBase.setVisible(false);
        txtBase.setVisible(false);
        lblAltura.setVisible(false);
        txtAltura.setVisible(false);
        lblRadio.setVisible(false);
        txtRadio.setVisible(false);
        lblLado.setVisible(false);
        txtLado.setVisible(false);
        lblDiagonalMayor.setVisible(false);
        txtDiagonalMayor.setVisible(false);
        lblDiagonalMenor.setVisible(false);
        txtDiagonalMenor.setVisible(false);
        lblNumLados.setVisible(false);
        txtNumLados.setVisible(false);
        lblApotema.setVisible(false);
        txtApotema.setVisible(false);
        lblBaseMayor.setVisible(false);
        txtBaseMayor.setVisible(false);
        lblBaseMenor.setVisible(false);
        txtBaseMenor.setVisible(false);
    }

    private void mostrarCamposEntrada() {
        // Obtenemos el índice del elemento seleccionado
        int index = listaFiguras.getSelectedIndex();
        // Mostramos los campos correspondientes
        // al índice seleccionado
        switch (index) {
            case 0 -> {
                lblLado.setVisible(true);
                txtLado.setVisible(true);
            }
            case 1, 2 -> {
                lblBase.setVisible(true);
                txtBase.setVisible(true);
                lblAltura.setVisible(true);
                txtAltura.setVisible(true);
            }
            case 3 -> {
                lblRadio.setVisible(true);
                txtRadio.setVisible(true);
            }
            case 4 -> {
                lblBaseMayor.setVisible(true);
                txtBaseMayor.setVisible(true);
                lblBaseMenor.setVisible(true);
                txtBaseMenor.setVisible(true);
                lblAltura.setVisible(true);
                txtAltura.setVisible(true);
            }
            case 5 -> {
                lblDiagonalMayor.setVisible(true);
                txtDiagonalMayor.setVisible(true);
                lblDiagonalMenor.setVisible(true);
                txtDiagonalMenor.setVisible(true);
            }
            case 6 -> {
                lblNumLados.setVisible(true);
                txtNumLados.setVisible(true);
                lblLado.setVisible(true);
                txtLado.setVisible(true);
                lblApotema.setVisible(true);
                txtApotema.setVisible(true);
            }
            default -> {
                lblBase.setVisible(true);
                txtBase.setVisible(true);
                lblAltura.setVisible(true);
                txtAltura.setVisible(true);
                lblLado.setVisible(true);
                txtLado.setVisible(true);
            }
        }
    }
```

Luego, vamos a agregar un `ItemListener` al `JComboBox` para que llame a los métodos `ocultarCamposEntrada` y
`mostrarCamposEntrada` cada vez que se seleccione una figura geométrica.

```java
public CalculadoraAreasPerimetrosUI() {
    // Configurar la ventana
    setTitle("Calculadora de Áreas y Perímetros");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setContentPane(panelPrincipal);
    pack();
    setLocationRelativeTo(null);
    setVisible(true);

    // Ocultar los campos de entrada
    ocultarCamposEntrada();
    
    // Mostramos los campos de la primer figura
    lblLado.setVisible(true);
    txtLado.setVisible(true);

    // Agregar ItemListener al JComboBox
    listaFiguras.addItemListener(e -> {
        ocultarCamposEntrada();
        mostrarCamposEntrada();
    });
}
```