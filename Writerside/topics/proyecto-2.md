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

1. Crea un nuevo proyecto en IntelliJ IDEA.
2. Agrega las dependencias de JFreeChart mediante Maven, siguiendo las siguientes instrucciones:
    1. Da clic derecho en el proyecto y selecciona `Open Module Settings`.
    2. En la ventana de configuración, selecciona `Libraries` y da clic en el botón `+`.
    3. Selecciona `From Maven...` y busca `org.jfree:jfreechart:1.5.5` y `org.jfree:jcommon:1.0.24`.
    4. Da clic en `OK` para agregar las dependencias.
3. Crea una nueva ventana mediante el editor de formularios de IntelliJ IDEA.
4. Agrega un `JTabbedPane` y cuatro pestañas.
5. En la primer pestaña, agrega un `JTabel` para ingresar los datos y un `JButton` para generar el gráfico.