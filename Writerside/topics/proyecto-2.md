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