# Tipos de Gráficos

Para el proyecto 3, es necesario que se agreguen al menos 5 gráficos diferentes. A continuación se presentan algunos
ejemplos de gráficos que pueden ser utilizados:

- Gráfico de dispersión (scatter plot)
- Gráfico de líneas (line plot)
- Gráfico de barras (bar plot)
- Gráfico de áreas (area plot)
- Gráfico de violín (violin plot)
- Gráfico de termómetro (thermometer plot)
- Gráfico de burbujas (bubble plot)
- Gráfico de radar (radar plot)

Entre muchos otros. La elección de los gráficos dependerá de la naturaleza de los datos y de la historia que se quiera
contar con ellos.

## Gráfica de Líneas

Para crear una gráfica de líneas con `JFreeChart`, primero deberos de crear un set de datos. Para ello, se puede
utilizar la clase `XYDataset` de `JFreeChart`. A continuación se muestra un ejemplo de cómo crear una gráfica de líneas
con `JFreeChart`:

```java
/**
 * Crea un set de datos de ejemplo para la gráfica.
 *
 * @return El set de datos de ejemplo.
 */
private XYDataset createDataset() {
    // Creamos un conjunto de datos de ejemplo
    // El nombre de la serie es "Temperatura"
    XYSeries series = new XYSeries("Temperatura");
    // Recorremos la lista de temperaturas y 
    // las agregamos al conjunto de datos.
    // Recuerda que para que esto funcione, la ventana debe 
    // contar con un arreglo de temperaturas.
    for (Double temperature : temperatures) {
        // Agregamos la temperatura al conjunto de datos
        series.add(temperatures.indexOf(temperature) + 1, temperature);
    }
    // Creamos un conjunto de datos XY
    XYSeriesCollection dataset = new XYSeriesCollection();
    // Agregamos la serie de datos al conjunto de datos
    dataset.addSeries(series);
    // Devolvemos el conjunto de datos
    return dataset;
}

/**
 * Crea una gráfica de líneas con los datos de temperatura.
 *
 * @param dataset El conjunto de datos a graficar.
 */
private JFreeChart createLineChart() {
    // Invocamos el método createDataset() para crear 
    // el conjunto de datos
    XYDataset dataset = createDataset();
    // Creamos la gráfica de líneas
    // El título de la gráfica es "Gráfico de Líneas"
    // El título del eje X es "ID"
    // El título del eje Y es "Temperatura"
    // El conjunto de datos es el que acabamos de crear
    // La orientación de la gráfica es vertical
    // La leyenda es visible
    // Las etiquetas de los ejes son visibles
    // Las herramientas son invisibles
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
    // Creamos un objeto XYPlot a partir de la gráfica
    XYPlot plot = chart.getXYPlot();
    // Creamoss un objeto NumberAxis a partir del eje Y de la gráfica
    NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
    // Establecemos el rango del eje Y de la gráfica
    // El rango es de 0 a 35
    rangeAxis.setRange(0, 35);
    // Retornamos la gráfica
    return chart;
}

/**
 * Agrega la gráfica de líneas a un panel.
 *
 */
private void addChartPanel() {
    // Creamos un nuevo objeto JFreeChart
    JFreeChart chart = createLineChart();
    // Establecemos que las etiquetas de los ejes son visibles
    chart.getLegend().setVisible(true);
    // Creamos un objeto ChartPanel a partir del chart
    ChartPanel chartPanel = new ChartPanel(chart);
    // Establecemos el tamaño del panel
    chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
    // Permitimos el zoom en la gráfica
    chartPanel.setMouseWheelEnabled(true);
    // Asignamos a un panel existe en la ventana
    // el panel de la gráfica.
    this.chartOne.setViewportView(chartPanel);
}
```

## Gráfica de Dispersión

Para crear una gráfica de dispersión con `JFreeChart`, primero deberos de crear un set de datos. Para ello, se puede
utilizar la clase `XYDataset` de `JFreeChart`. A continuación se muestra un ejemplo de cómo crear una gráfica de
dispersión con `JFreeChart`:

```java
/**
 * Crea un set de datos de ejemplo para la gráfica.
 *
 * @return El set de datos de ejemplo.
 */
private XYDataset createDataset() {
    // Creamos un conjunto de datos de ejemplo
    // El nombre de la serie es "Temperatura"
    XYSeries series = new XYSeries("Temperatura");
    // Recorremos la lista de temperaturas y 
    // las agregamos al conjunto de datos.
    // Recuerda que para que esto funcione, la ventana debe 
    // contar con un arreglo de temperaturas.
    for (Double temperature : temperatures) {
        // Agregamos la temperatura al conjunto de datos
        series.add(temperatures.indexOf(temperature) + 1, temperature);
    }
    // Creamos un conjunto de datos XY
    XYSeriesCollection dataset = new XYSeriesCollection();
    // Agregamos la serie de datos al conjunto de datos
    dataset.addSeries(series);
    // Devolvemos el conjunto de datos
    return dataset;
}

/**
 * Crea una gráfica de dispersión con los datos de temperatura.
 *
 * @param dataset El conjunto de datos a graficar.
 */
private JFreeChart createScatterPlot() {
    // Invocamos el método createDataset() para crear 
    // el conjunto de datos
    XYDataset dataset = createDataset();
    // Creamos la gráfica de dispersión
    // El título de la gráfica es "Gráfico de Dispersión"
    // El título del eje X es "ID"
    // El título del eje Y es "Temperatura"
    // El conjunto de datos es el que acabamos de crear
    // La orientación de la gráfica es vertical
    // La leyenda es visible
    // Las etiquetas de los ejes son visibles
    // Las herramientas son invisibles
    JFreeChart chart = ChartFactory.createScatterPlot(
            "Gráfico de Dispersión",
            "ID",
            "Temperatura",
            dataset,
            PlotOrientation.VERTICAL,
            true,
            true,
            false
    );
    // Creamos un objeto XYPlot a partir de la gráfica
    XYPlot plot = chart.getXYPlot();
    // Creamoss un objeto NumberAxis a partir del eje Y de la gráfica
    NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
    // Establecemos el rango del eje Y de la gráfica
    // El rango es de 0 a 35
    rangeAxis.setRange(0, 35);
    // Retornamos la gráfica
    return chart;
}

/**
 * Agrega la gráfica de dispersión a un panel.
 *
 */
private void addChartPanel() {
    // Creamos un nuevo objeto JFreeChart
    JFreeChart chart = createScatterPlot();
    // Establecemos que las etiquetas de los ejes son visibles
    chart.getLegend().setVisible(true);
    // Creamos un objeto ChartPanel a partir del chart
    ChartPanel chartPanel = new ChartPanel(chart);
    // Establecemos el tamaño del panel
    chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
    // Permitimos el zoom en la gráfica
    chartPanel.setMouseWheelEnabled(true);
    // Asignamos a un panel existe en la ventana
    // el panel de la gráfica.
    this.chartOne.setViewportView(chartPanel);
}
```

Toma en consideración que los ejemplos previos se está modificando el componente `chartOne` de la ventana.
Por lo que es importante saber qué `JScrollPane` se le está asignando el `ChartPanel`.

## Gráfica de Barras

Para crear una gráfica de barras con `JFreeChart`, primero deberos de crear un set de datos. Para ello, se puede
utilizar la clase `CategoryDataset` de `JFreeChart`. A continuación se muestra un ejemplo de cómo crear una gráfica de
barras con `JFreeChart`:

```java
/**
 * Crea un set de datos de ejemplo para la gráfica.
 *
 * @return El set de datos de ejemplo.
 */
private CategoryDataset createDataset() {
    // Creamos un conjunto de datos de ejemplo
    // El nombre de la serie es "Temperatura"
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    // Recorremos la lista de temperaturas y 
    // las agregamos al conjunto de datos.
    // Recuerda que para que esto funcione, la ventana debe 
    // contar con un arreglo de temperaturas.
    for (Double temperature : temperatures) {
        // Agregamos la temperatura al conjunto de datos
        dataset.addValue(temperature, "Temperatura", String.valueOf(temperatures.indexOf(temperature) + 1));
    }
    // Devolvemos el conjunto de datos
    return dataset;
}

/**
 * Crea una gráfica de barras con los datos de temperatura.
 *
 * @param dataset El conjunto de datos a graficar.
 */
private JFreeChart createBarChart() {
    // Invocamos el método createDataset() para crear 
    // el conjunto de datos
    CategoryDataset dataset = createDataset();
    // Creamos la gráfica de barras
    // El título de la gráfica es "Gráfico de Barras"
    // El título del eje X es "ID"
    // El título del eje Y es "Temperatura"
    // El conjunto de datos es el que acabamos de crear
    // La orientación de la gráfica es vertical
    // La leyenda es visible
    // Las etiquetas de los ejes son visibles
    // Las herramientas son invisibles
    JFreeChart chart = ChartFactory.createBarChart(
            "Gráfico de Barras",
            "ID",
            "Temperatura",
            dataset,
            PlotOrientation.VERTICAL,
            true,
            true,
            false
    );
    // Creamos un objeto CategoryPlot a partir de la gráfica
    CategoryPlot plot = (CategoryPlot) chart.getPlot();
    // Creamoss un objeto NumberAxis a partir del eje Y de la gráfica
    NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
    // Establecemos el rango del eje Y de la gráfica
    // El rango es de 0 a 35
    rangeAxis.setRange(0, 35);
    // Retornamos la gráfica
    return chart;
}

/**
 * Agrega la gráfica de barras a un panel.
 *
 */
private void addChartPanel() {
    // Creamos un nuevo objeto JFreeChart
    JFreeChart chart = createBarChart();
    // Establecemos que las etiquetas de los ejes son visibles
    chart.getLegend().setVisible(true);
    // Creamos un objeto ChartPanel a partir del chart
    ChartPanel chartPanel = new ChartPanel(chart);
    // Establecemos el tamaño del panel
    chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
    // Permitimos el zoom en la gráfica
    chartPanel.setMouseWheelEnabled(true);
    // Asignamos a un panel existe en la ventana
    // el panel de la gráfica.
    this.chartOne.setViewportView(chartPanel);
}
```