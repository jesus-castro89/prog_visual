# Proyecto 2: Gráficas en Pestañas

## Objetivo

El objetivo es crear una aplicación que permita al usuario ingresar datos numéricos en un JTextField, y al presionar un
botón (JButton), estos datos se visualicen en un gráfico de líneas utilizando JFreeChart. La aplicación tendrá una
interfaz con pestañas (JTabbedPane), donde en una pestaña se ingresarán los datos y en otra se mostrará el gráfico.
Además, se incluirá un JSlider para ajustar el rango del eje Y del gráfico y un JScrollBar para desplazar el gráfico
horizontalmente.

La aplicación tendrá cuatro pestañas:

1. **Ingreso de Datos**: Permite al usuario ingresar datos numéricos para generar gráficos.
2. **Gráfico de Líneas**: Muestra un gráfico de líneas con los datos ingresados.
3. **Gráfico de Barras**: Muestra un gráfico de barras con los mismos datos.
4. **Gráfico Circular**: Muestra un gráfico de tarta con los datos.

Además, se agregarán componentes como:

* **JComboBox**: Para seleccionar el tipo de gráfico a generar.
* **JCheckBox**: Para habilitar o deshabilitar la leyenda del gráfico.
* **JRadioButton**: Para elegir la orientación del gráfico de barras (horizontal o vertical).

## Desarrollo

### Diseño de la Interfaz

1. Crea un nuevo proyecto en IntelliJ IDEA.
2. Agrega las dependencias de JFreeChart mediante Maven, siguiendo las siguientes instrucciones:
    1. Da clic derecho en el proyecto y selecciona `Open Module Settings`.
    2. En la ventana de configuración, selecciona `Libraries` y da clic en el botón `+`.
    3. Selecciona `From Maven...` y busca `org.jfree:jfreechart:1.5.5` y `org.jfree:jcommon:1.0.24`.
    4. Da clic en `OK` para agregar las dependencias.
3. Crea una nueva ventana mediante el editor de formularios de IntelliJ IDEA.
4. Agrega un `JTabbedPane` y cuatro pestañas.
5. En la primera pestaña, realiza lo siguiente:
    1. Agrega un `JTabel` para mostrar los datos ingresados.
    2. Agrega un `JLabel` debajo de la tabla con el texto "Seleccione la temperatura".
    3. Agrega un `JLabel` con el texto "Temperatura (C°)".
    4. Agrega un `JSlider` para ajustar el rango del eje Y del gráfico.
        * El rango será de 0 a 100 grados.
        * El valor inicial será 0 grados.
        * EL major tick será de 10 grados.
        * El minor tick será de 1 grado.
        * Marcaremos las opciones: `paintTicks`, `paintLabels` y `snapToTicks`.
    5. Agrega un `JBotton` con el texto "Agregar" y el nombre `addData`.
6. En la segunda pestaña realiza lo siguiente:
    1. Agrega un `JPanel` para mostrar el gráfico de líneas, llamado `chartPanel`.
    2. Haz que el `chartPanel` esté envuelto en un `JScrollPane`.
    3. Agrega un `JComboBox` con las opciones "Líneas", "Barras" y "Circular" y el nombre `chartType`.
    4. Agrega un `JCheckBox` con el texto "Mostrar leyenda" y el nombre `showLegend`.
    5. Agrega un `JButton` con el texto "Generar gráfico" y el nombre `generateChart`.
7. En la tercera pestaña realiza lo siguiente:
    1. Agrega un `JPanel` para mostrar el gráfico de barras, llamado `barChartPanel`.
    2. Haz que el `barChartPanel` esté envuelto en un `JScrollPane`.
    3. Agrega un `JRadioButton` con el texto "Vertical" y el nombre `vertical`.
    4. Agrega un `JRadioButton` con el texto "Horizontal" y el nombre `horizontal`.
    5. Seleccione ambos botones de radio y agrúpalos en un `ButtonGroup` llamado `orientationGroup`.
    6. En la vista de diseño, selecciona la opción `Button Groups` y selecciona `orientationGroup` y dentro de este
       selecciona la opción `Bind to field`.
    7. Agrega un `JButton` con el texto "Generar gráfico" y el nombre `generateBarChart`.
8. En la cuarta pestaña realiza lo siguiente:
    1. Agrega un `JPanel` para mostrar el gráfico circular, llamado `pieChartPanel`.
    2. Haz que el `pieChartPanel` esté envuelto en un `JScrollPane`.
    3. Agrega un `JButton` con el texto "Generar gráfico" y el nombre `generatePieChart`.

Con esto, la interfaz de la aplicación estará lista para ser programada.

### Configurando la Tabla

Para configurar la tabla, crearemos un modelo de tabla personalizado que permita mostrar los datos ingresados por el
usuario. Para ello, crearemos una clase llamada `TemperatureTableModel` que extienda de `AbstractTableModel` y
sobreescribiremos los métodos `getRowCount`, `getColumnCount`, `getValueAt` y `getColumnName`.

Para ello daremos clic derecho en la carpeta `src` y seleccionaremos `New -> Java Class`. En el cuadro de diálogo
escribiremos el nombre `TemperatureTableModel` y daremos clic en `OK`. A continuación, escribiremos el siguiente código
para agregar un modelo de tabla personalizado que contengan dos columnas: `ID` y `Temperatura`.

```java
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class TemperatureTableModel extends AbstractTableModel {
    private final List<Integer> data;

    public TemperatureTableModel() {
        data = new ArrayList<>();
    }

    public void addData(int temperature) {
        data.add(temperature);
        fireTableRowsInserted(data.size() - 1, data.size() - 1);
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return rowIndex + 1;
        } else {
            return data.get(rowIndex);
        }
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "ID";
        } else {
            return "Temperatura";
        }
    }
}
```

> **Nota**: La clase `TemperatureTableModel` contiene un atributo `data` que almacena los datos ingresados por el
> usuario. El método `addData` permite agregar un nuevo dato a la tabla y notificar a los componentes que la tabla ha
> sido actualizada. Para ello, se utiliza el método `fireTableRowsInserted` que notifica a los componentes que se ha
> insertado una nueva fila en la tabla.

Una vez creada la clase, primero deberemos de entrar al modo de diseño y seleccionar el componente `JTable` y en la
pestaña de propiedades, en el campo `Model` seleccionaremos la opción `Custom Create`, esto generará la función
`createUIComponents()` en la clase principal, en esta función generaremos una instancia de la clase
`TemperatureTableModel` y la asignaremos al modelo de la tabla.

```java
private void createUIComponents() {
    table = new JTable();
    table.setModel(new TemperatureTableModel());
}
```

Con esto, la tabla estará lista para mostrar los datos ingresados por el usuario.

### Agregando el evento del botón "Agregar"

Para agregar el evento del botón "Agregar", primero crearemos la función `addRowToTable` que permitirá obtener el valor
del `JSlider` y agregarlo a la tabla, de la siguiente manera:

```java
private void addRowToTable() {
    int temperature = slider.getValue();
    TemperatureTableModel model = (TemperatureTableModel) table.getModel();
    model.addData(temperature);
}
```

Posteriormente crearemos la función `addActions` que permitirá agregar este y el resto de los eventos a los
componentes de la aplicación, de la siguiente manera:

```java
private void addActions() {
    addData.addActionListener(e -> addRowToTable());
}
```

Por último haremos una llamada a la función `addActions` en el constructor de la clase principal, de la siguiente
manera:

```java
// Este es el constructor de la clase principal que inicializa la interfaz de la aplicación
public App() {
    // Resto del código
    addActions();
}
```

Con esto, el evento del botón "Agregar" estará listo para ser utilizado.

### Generando el Gráfico de Líneas

Para generar el gráfico de líneas, primero crearemos las funciónes `createLineChart`, `createBarChart` y
`createPieChart` que permitirán crear un gráfico de líneas, barras o circular con los datos ingresados por el usuario,
de la siguiente manera:

```java
private JFreeChart createLineChart() {
    XYDataset dataset = createDataset();
    JFreeChart chart = ChartFactory.createXYLineChart(
            "Gráfico de Líneas",
            "ID",
            "Temperatura",
            dataset,
            PlotOrientation.VERTICAL,
            true,
            true,
            false
    );
    XYPlot plot = chart.getXYPlot();
    NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
    rangeAxis.setRange(0, 100);
    return chart;
}

private JFreeChart createBarChart() {
    IntervalXYDataset dataset = (IntervalXYDataset) createDataset();
    JFreeChart chart = ChartFactory.createXYBarChart(
            "Gráfico de Barras",
            "ID",
            true,
            "Temperatura",
            dataset,
            PlotOrientation.VERTICAL,
            true,
            true,
            false
    );
    XYPlot plot = chart.getXYPlot();
    NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
    rangeAxis.setRange(0, 100);
    return chart;
}

private JFreeChart createPieChart() {
    PieDataset<Integer> dataset = createPieDataset();
    return ChartFactory.createPieChart(
            "Gráfico de Pastel",
            dataset,
            showLegend.isSelected(),
            true,
            false
    );
}
```

Posteriormente crearemos las funciónes `createDataset` y `createPieDataset()` que permitirán crear un conjunto de datos
con los datos ingresados por el usuario, de la siguiente manera:

```java
private XYDataset createDataset() {
    XYSeries series = new XYSeries("Temperatura");
    TemperatureTableModel model = (TemperatureTableModel) table.getModel();
    for (int i = 0; i < model.getRowCount(); i++) {
        series.add(i + 1, (Integer) model.getValueAt(i, 1));
    }
    XYSeriesCollection dataset = new XYSeriesCollection();
    dataset.addSeries(series);
    return dataset;
}

private PieDataset<Integer> createPieDataset() {
    DefaultPieDataset<Integer> dataset = new DefaultPieDataset<>();
    TemperatureTableModel model = (TemperatureTableModel) table.getModel();
    for (int i = 0; i < model.getRowCount(); i++) {
        dataset.setValue((i + 1), (Number) model.getValueAt(i, 1));
    }
    return dataset;
}
```

Posteriormente, crearemos la función `addChartPanel` que permitirá agregar el gráfico de líneas al panel `chartPanel`,
de la
siguiente manera:

```java
private void addChartPanel() {

    String chartType = (String) this.chartType.getSelectedItem();
    JFreeChart chart = null;
    if (chartType != null) {
        chart = switch (chartType) {
            case "Líneas" -> createLineChart();
            case "Barras" -> createBarChart();
            case "Circular" -> createPieChart();
            default -> throw new IllegalStateException("Unexpected value: " + chartType);
        };
    }
    ChartPanel chartPanel = new ChartPanel(chart);
    chartPanel.setMouseWheelEnabled(true);
    this.chartPanel.setViewportView(chartPanel);
}
```

Por último agregaremos el evento del botón "Generar gráfico" que permitirá generar el gráfico de líneas, de la siguiente
manera:

```java
private void addActions() {
    addData.addActionListener(e -> addRowToTable());
    generateChart.addActionListener(e -> addChartPanel());
}
```

Con esto, el gráfico de líneas estará listo para ser generado.

### Mostrando y ocultando la leyenda

Para mostrar y ocultar la leyenda del gráfico, crearemos la función `addLegend` que permitirá mostrar u ocultar la
leyenda del gráfico, de la siguiente manera:

```java
private void addLegend(JFreeChart chart) {
    if (chart.getLegend() != null)
        chart.getLegend().setVisible(showLegend.isSelected());
}
```

Posteriormente, modificaremos la función `addChartPanel` para que llame a la función `addLegend` y muestre u oculte la
leyenda del gráfico, de la siguiente manera:

```java
private void addChartPanel() {
    String chartType = (String) this.chartType.getSelectedItem();
    JFreeChart chart = null;
    if (chartType != null) {
        chart = switch (chartType) {
            case "Líneas" -> createLineChart();
            case "Barras" -> createBarChart();
            case "Circular" -> createPieChart();
            default -> throw new IllegalStateException("Unexpected value: " + chartType);
        };
    }
    addLegend(chart);
    ChartPanel chartPanel = new ChartPanel(chart);
    chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
    chartPanel.setMouseWheelEnabled(true);
    this.chartPanel.setViewportView(chartPanel);
}
```

Con esto, la leyenda del gráfico podrá ser mostrada u ocultada.

### Generando el Gráfico de Barras en formato Horizontal o Vertical

Ya contamos la función `createBarChart` que permite generar un gráfico de barras, ahora crearemos la función
`addOrientation` que permitirá mostrar el gráfico de barras en formato horizontal o vertical, de la siguiente manera:

```java
private void addOrientation(JFreeChart chart) {
    XYPlot plot = chart.getXYPlot();
    if (horizontalRadioButton.isSelected()) {
        plot.setOrientation(PlotOrientation.HORIZONTAL);
    } else {
        plot.setOrientation(PlotOrientation.VERTICAL);
    }
}
```

Posteriormente, crearemos la función `addBarChartPanel` que permitirá agregar el gráfico de barras al panel
`barChartPanel`, de la siguiente manera:

```java
private void addBarChartPanel() {
    JFreeChart chart = createBarChart();
    addOrientation(chart);
    ChartPanel chartPanel = new ChartPanel(chart);
    chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
    chartPanel.setMouseWheelEnabled(true);
    this.barChartPanel.setViewportView(chartPanel);
}
```

Por último, agregaremos el evento del botón "Generar gráfico" que permitirá generar el gráfico de barras, de la
siguiente manera:

```java
private void addActions() {
    addData.addActionListener(e -> addRowToTable());
    generateChart.addActionListener(e -> addChartPanel());
    generateBarChart.addActionListener(e -> addBarChartPanel());
}
```

Con esto, el gráfico de barras podrá ser generado en formato horizontal o vertical.

### Generando el Gráfico Circular

Para generar el gráfico circular, crearemos la función `addPieChartPanel` que permitirá agregar el gráfico circular al
panel `pieChartPanel`, de la siguiente manera:

```java
private void addPieChartPanel() {
    JFreeChart chart = createPieChart();
    ChartPanel chartPanel = new ChartPanel(chart);
    chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
    chartPanel.setMouseWheelEnabled(true);
    this.pieChartPanel.setViewportView(chartPanel);
}
```

Por último, agregaremos el evento del botón "Generar gráfico" que permitirá generar el gráfico circular, de la
siguiente manera:

```java
private void addActions() {
    addData.addActionListener(e -> addRowToTable());
    generateChart.addActionListener(e -> addChartPanel());
    generateBarChart.addActionListener(e -> addBarChartPanel());
    generatePieChart.addActionListener(e -> addPieChartPanel());
}
```

Con esto, el gráfico circular podrá ser generado.

## Para la entrega

1. Realiza el desarrollo de la aplicación siguiendo los pasos anteriores.
2. Comprueba que la aplicación funcione correctamente.
3. Graba un video de la aplicación en funcionamiento.
4. Crea un archivo ZIP con el código fuente del proyecto.
5. Sube el video y el archivo ZIP a la plataforma.

## Criterios de Evaluación

| Criterio      | Descripción                                                                       | Puntaje  |
|---------------|-----------------------------------------------------------------------------------|----------|
| Portada       | Se anexa portada con datos del equipo.                                            | 5%       |
| Código        | El código fuente cumple con los requerimientos y está correctamente estructurado. | 30%      |
| Funcionalidad | La aplicación cumple con los requerimientos y funciona correctamente.             | 30%      |
| Video         | Se anexa video de la aplicación en funcionamiento.                                | 20%      |
| Entrega       | Se anexa archivo ZIP con el código fuente del proyecto.                           | 15%      |
| **Total**     |                                                                                   | **100%** |

## Fecha de Entrega

La fecha de entrega de este entregable es el **28 de marzo de 2025** a las **23:59**. Cualquier entrega después de esta
fecha no será calificada.

Recuerda que la entrega se realizará a través de la plataforma **Moodle**.

> Recuerda que deberás anexar al trabajo por separado el archivo de portada, video y zip con el código fuente de tu
> proyecto.
> {style="note"}