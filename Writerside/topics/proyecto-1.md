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
- En el panel superior, agregaremos dos `JLabel` para mostrar el resultado de los cálculos.
    - Uno para mostrar el área y otro para mostrar el perímetro.
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

![area_perimetro_1.png](area_perimetro_1.png)

> **Nota:** Puedes organizar los componentes de la interfaz gráfica de la calculadora de la forma que prefieras. Por
> ejemplo, puedes colocar los campos de entrada en una cuadrícula o en una lista vertical. También puedes cambiar el
> tamaño y la posición de los componentes según tus preferencias.

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
            // Para el cuadrado
            case 0 -> {
                lblLado.setVisible(true);
                txtLado.setVisible(true);
            }
            // Para el rectángulo y el triángulo
            case 1, 2 -> {
                lblBase.setVisible(true);
                txtBase.setVisible(true);
                lblAltura.setVisible(true);
                txtAltura.setVisible(true);
            }
            // Para el círculo
            case 3 -> {
                lblRadio.setVisible(true);
                txtRadio.setVisible(true);
            }
            // Para el trapecio
            case 4 -> {
                lblBaseMayor.setVisible(true);
                txtBaseMayor.setVisible(true);
                lblBaseMenor.setVisible(true);
                txtBaseMenor.setVisible(true);
                lblAltura.setVisible(true);
                txtAltura.setVisible(true);
            }
            // Para el rombo
            case 5 -> {
                lblDiagonalMayor.setVisible(true);
                txtDiagonalMayor.setVisible(true);
                lblDiagonalMenor.setVisible(true);
                txtDiagonalMenor.setVisible(true);
            }
            // Para el polígono regular
            case 6 -> {
                lblNumLados.setVisible(true);
                txtNumLados.setVisible(true);
                lblLado.setVisible(true);
                txtLado.setVisible(true);
                lblApotema.setVisible(true);
                txtApotema.setVisible(true);
            }
            // Para el paralelogramo
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
    mostrarCamposEntrada();

    // Agregar ItemListener al JComboBox
    listaFiguras.addItemListener(e -> {
        ocultarCamposEntrada();
        mostrarCamposEntrada();
    });
}
```

## Parte 3: Implementando la función de limpieza de campos

En esta parte, vamos a implementar la función para limpiar los campos de entrada y salida de la interfaz gráfica. Para
ello, crearemos un método llamado `limpiarCampos` que establecerá el texto de los campos de entrada y salida en blanco.

```java
private void limpiarCampos() {
    txtBase.setText("");
    txtAltura.setText("");
    txtRadio.setText("");
    txtLado.setText("");
    txtDiagonalMayor.setText("");
    txtDiagonalMenor.setText("");
    txtNumLados.setText("");
    txtApotema.setText("");
    txtBaseMayor.setText("");
    txtBaseMenor.setText("");
}
```

Luego, agregaremos un `ActionListener` al botón de limpieza para que llame al método `limpiarCampos` cada vez que se
haga clic en el botón.

```java
public CalculadoraAreasPerimetrosUI() {
    // Resto del código
    ...
    // Agregar ActionListener al botón de limpieza
    btnLimpiar.addActionListener(e -> {
        limpiarCampos();
    });
}
```

Así mismo, agregamos un llamado a la función, cada que se cambie la figura geométrica seleccionada.

```java
public CalculadoraAreasPerimetrosUI() {
    // Resto del código
    ...
    // Agregar ItemListener al JComboBox
    listaFiguras.addItemListener(e -> {
        ocultarCamposEntrada();
        mostrarCamposEntrada();
        limpiarCampos();
    });
}
```

## Parte 4: Implementando las funciones de cálculo de las áreas y perímetros

En esta parte, vamos a implementar las funciones para calcular el área y el perímetro de cada una de las figuras
geométricas mencionadas. Para ello, crearemos un método para cada figura geométrica que recibirá los valores de los
campos de entrada y devolverá el área y el perímetro correspondientes.

Crearemos entonces un método para cada figura geométrica de la lista:

```java
    private void calcularCuadrado() {

        // Obtenemos el valor del lado y lo convertimos a double
        double lado = Double.parseDouble(txtLado.getText());
        double area = lado * lado;
        double perimetro = lado * 4;
        lblArea.setText("Area del cuadrado: %.2f".formatted(area));
        lblPerimetro.setText("Perímetro del cuadrado: %.2f".formatted(perimetro));
    }

    private void calcularRectangulo() {

        // Obtenemos el valor de la base y la altura y los convertimos a double
        double base = Double.parseDouble(txtBase.getText());
        double altura = Double.parseDouble(txtAltura.getText());
        double area = base * altura;
        double perimetro = (base * 2) + (altura * 2);
        lblArea.setText("Área del Rectangulo: %.2f".formatted(area));
        lblPerimetro.setText("Perímetro del Rectangulo: %.2f".formatted(perimetro));
    }

    private void calcularTriangulo() {

        // Obtenemos el valor de la base y la altura y los convertimos a double
        double base = Double.parseDouble(txtBase.getText());
        double altura = Double.parseDouble(txtAltura.getText());
        double area = (base * altura) / 2;
        double perimetro = base * 3;
        lblArea.setText("Área del Triángulo: %.2f".formatted(area));
        lblPerimetro.setText("Perímetro del Triángulo: %.2f".formatted(perimetro));
    }

    private void calcularCirculo() {

        // Obtenemos el valor del radio y lo convertimos a double
        double radio = Double.parseDouble(txtRadio.getText());
        double area = Math.PI * Math.pow(radio, 2);
        double perimetro = 2 * Math.PI * radio;
        lblArea.setText("Área del Círculo: %.2f".formatted(area));
        lblPerimetro.setText("Perímetro del Círculo: %.2f".formatted(perimetro));
    }

    private void calcularTrapecio() {

        // Obtenemos el valor de la base mayor, la base menor y la altura y los convertimos a double
        double baseMayor = Double.parseDouble(txtBaseMayor.getText());
        double baseMenor = Double.parseDouble(txtBaseMenor.getText());
        double altura = Double.parseDouble(txtAltura.getText());
        double area = ((baseMayor + baseMenor) * altura) / 2;
        double perimetro = baseMayor + baseMenor + (2 * Math.sqrt(Math.pow((baseMayor - baseMenor) / 2, 2) + Math.pow(altura, 2)));
        lblArea.setText("Área del Trapecio: %.2f".formatted(area));
        lblPerimetro.setText("Perímetro del Trapecio: %.2f".formatted(perimetro));
    }

    private void calcularRombo() {

        // Obtenemos el valor de la diagonal mayor y la diagonal menor y los convertimos a double
        double diagonalMayor = Double.parseDouble(txtDiagonalMayor.getText());
        double diagonalMenor = Double.parseDouble(txtDiagonalMenor.getText());
        double area = (diagonalMayor * diagonalMenor) / 2;
        double perimetro = 4 * Math.sqrt(Math.pow(diagonalMayor / 2, 2) + Math.pow(diagonalMenor / 2, 2));
        lblArea.setText("Área del Rombo: %.2f".formatted(area));
        lblPerimetro.setText("Perímetro del Rombo: %.2f".formatted(perimetro));
    }

    private void calcularPoligono() {

        // Obtenemos el valor del número de lados, el lado y la apotema y los convertimos a double
        double numLados = Double.parseDouble(txtNumLados.getText());
        double lado = Double.parseDouble(txtLado.getText());
        double apotema = Double.parseDouble(txtApotema.getText());
        double perimetro = numLados * lado;
        double area = (perimetro * apotema) / 2;
        lblArea.setText("Área del Polígono: %.2f".formatted(area));
        lblPerimetro.setText("Perímetro del Polígono: %.2f".formatted(perimetro));
    }
    
    private void calcularParalelogramo() {

        // Obtenemos el valor de la base, la altura y el lado y los convertimos a double
        double base = Double.parseDouble(txtBase.getText());
        double altura = Double.parseDouble(txtAltura.getText());
        double lado = Double.parseDouble(txtLado.getText());
        double perimetro = (base * 2) + (lado * 2);
        double area = base * altura;
        lblArea.setText("Área del Paralelogramo: %.2f".formatted(area));
        lblPerimetro.setText("Perímetro del Paralelogramo: %.2f".formatted(perimetro));
    }
```

### Parte 5: Creamos una función de validación de datos

En esta parte, vamos a implementar una función para validar los datos de entrada. Esta función verificará que los
valores ingresados en los campos de entrada sean numéricos y positivos. Si los valores no son válidos, la función
mostrará un mensaje de error en la interfaz gráfica.

Para ello, crearemos un método llamado `validarDatosEntrada` que verificará que los valores ingresados en los campos de
entrada sean numéricos y positivos. Si los valores no son válidos, la función mostrará un mensaje de error en la
interfaz gráfica.

```java
private boolean validarDatosEntrada() {

    try {
        // Verificamos que los valores ingresados sean numéricos
        double base = Double.parseDouble(txtBase.getText());
        double altura = Double.parseDouble(txtAltura.getText());
        double radio = Double.parseDouble(txtRadio.getText());
        double lado = Double.parseDouble(txtLado.getText());
        double diagonalMayor = Double.parseDouble(txtDiagonalMayor.getText());
        double diagonalMenor = Double.parseDouble(txtDiagonalMenor.getText());
        double numLados = Double.parseDouble(txtNumLados.getText());
        double apotema = Double.parseDouble(txtApotema.getText());
        double baseMayor = Double.parseDouble(txtBaseMayor.getText());
        double baseMenor = Double.parseDouble(txtBaseMenor.getText());

        // Verificamos que los valores ingresados sean positivos
        if (base <= 0 || altura <= 0 || radio <= 0 || lado <= 0 || diagonalMayor <= 0 || diagonalMenor <= 0 || numLados <= 0 || apotema <= 0 || baseMayor <= 0 || baseMenor <= 0) {
            JOptionPane.showMessageDialog(this, "Los valores ingresados deben ser positivos", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Los valores ingresados deben ser numéricos", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }
}
```

Con esta función, solo nos falta una función que se encargue de realizar los cálculos de las áreas y perímetros de las
figuras geométricas. Para ello, crearemos un método llamado `calcularFigura` que llamará a la función de validación de
datos y luego a la función correspondiente a la figura geométrica seleccionada.

```java
    private void calcularFigura() {

        int index = listaFiguras.getSelectedIndex();
        if (validarDatosEntrada(index)) {
            switch (index) {
                case 0 -> calcularCuadrado();
                case 1 -> calcularRectangulo();
                case 2 -> calcularTriangulo();
                case 3 -> calcularCirculo();
                case 4 -> calcularTrapecio();
                case 5 -> calcularRombo();
                case 6 -> calcularPoligono();
                default -> calcularParalelogramo();
            }
        }
    }
```

Finalmente, agregaremos un `ActionListener` al botón de cálculo para que llame al método `calcularFigura` cada vez que
se haga clic en el botón.

```java
public CalculadoraAreasPerimetrosUI() {
    // Resto del código
    ...
    // Agregar ActionListener al botón de cálculo
    btnCalcular.addActionListener(e -> {
        calcularFigura();
    });
}
```

Con esto, hemos implementado las funciones necesarias para realizar los cálculos de las áreas y perímetros de las
figuras geométricas. Ahora podemos ejecutar la aplicación y probar la calculadora de áreas y perímetros.

## Para la entrega

Para la entrega de este proyecto, debes realizar lo siguiente:

* Modifica las etiquetas de los campos y asigna un color de texto diferente a cada una.
* Modifica el color del texto del área dea de 24px y color Azul.
* Modifica el color del texto del perímetro sea de 24px y color Rojo.

Por último comprime tu proyecto y súbelo a la plataforma junto a la portada con los datos del estudiante y el
profesor.