package graficas;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.xy.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class GraficasUI extends JFrame {

    private JTabbedPane tabbedPane1;
    private JPanel mainPanel;
    private JTable table;
    private JLabel dataLbl;
    private JSlider temperatureSld;
    private JComboBox<String> chartType;
    private JCheckBox showLegend;
    private JButton generateChart;
    private JRadioButton horizontalRadioButton;
    private JRadioButton verticalRadioButton;
    private JButton generateBarChart;
    private JButton generatePieChart;
    private JButton addData;
    private JScrollPane chartPanel;
    private JScrollPane barChartPanel;
    private JScrollPane pieChartPanel;
    private ButtonGroup orientationGroup;
    private DefaultTableModel tableModel;

    public static void main(String[] args) {

        new GraficasUI();
    }

    public GraficasUI() {

        // Configurar la ventana
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setSize(1000, 900);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        // Agregar acciones a los componentes
        addActions();
    }

    private void addActions() {

        addData.addActionListener(e -> addRowToTable());
        generateChart.addActionListener(e -> addChartPanel());
        generateBarChart.addActionListener(e -> addBarChartPanel());
        generatePieChart.addActionListener(e -> addPieChartPanel());
    }

    /**
     * Función que agrega una fila a la tabla con el valor del slider de temperatura.
     */
    private void addRowToTable() {
        // Obtener el valor del slider de temperatura
        int temperature = temperatureSld.getValue();
        // Obtener el modelo de la tabla
        TemperatureTableModel model = (TemperatureTableModel) table.getModel();
        // Agregar una nueva fila a la tabla con el valor del slider
        model.addData(temperature);
    }

    private void addLegend(JFreeChart chart) {
        if (chart.getLegend() != null)
            chart.getLegend().setVisible(showLegend.isSelected());
    }

    /**
     * Función que crea un gráfico de líneas.
     *
     * @return JFreeChart La instancia del gráfico de líneas.
     */
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

    private void addOrientation(JFreeChart chart) {
        XYPlot plot = chart.getXYPlot();
        if (horizontalRadioButton.isSelected()) {
            plot.setOrientation(PlotOrientation.HORIZONTAL);
        } else {
            plot.setOrientation(PlotOrientation.VERTICAL);
        }
    }

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
        if (chartType.equals("Barras")) {
            addOrientation(chart);
        }
        addLegend(chart);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        chartPanel.setMouseWheelEnabled(true);
        this.chartPanel.setViewportView(chartPanel);
    }

    private void addBarChartPanel() {
        JFreeChart chart = createBarChart();
        addOrientation(chart);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        chartPanel.setMouseWheelEnabled(true);
        this.barChartPanel.setViewportView(chartPanel);
    }

    private void addPieChartPanel() {
        JFreeChart chart = createPieChart();
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setMouseWheelEnabled(true);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        this.pieChartPanel.setViewportView(chartPanel);
    }

    private void createUIComponents() {

        table = new JTable();
        table.setModel(new TemperatureTableModel());
    }
}
