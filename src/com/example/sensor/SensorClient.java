package com.example.sensor;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.*;
import org.jfree.chart.renderer.xy.VectorRenderer;
import org.jfree.data.Range;
import org.jfree.data.general.DefaultValueDataset;
import org.jfree.data.xy.*;
import org.jfree.ui.StrokeSample;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;

public class SensorClient extends JFrame {

    private static final String SERVER_IP = "localhost";
    private static final int PORT = 12345;
    private JPanel mainPanel;
    private JScrollPane chartOne;
    private JTabbedPane tabbedPane1;
    private JScrollPane chartTwo;
    private JScrollPane chartThree;
    private JScrollPane chartFive;
    private JScrollPane chartSix;
    private JScrollPane chartSeven;
    private ArrayList<Double> temperatures;
    private ArrayList<Double> windSpeeds;
    private ArrayList<Double> humidities;
    private ArrayList<Double> atmosphericPressures;

    public static void main(String[] args) {

        SwingUtilities.invokeLater(SensorClient::new);
    }

    public SensorClient() {
        temperatures = new ArrayList<>();
        windSpeeds = new ArrayList<>();
        humidities = new ArrayList<>();
        atmosphericPressures = new ArrayList<>();
        setTitle("Sensor Data");
        setSize(900, 600);
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        connectToServer();
    }

    private void connectToServer() {

        new Thread(() -> {
            try (Socket socket = new Socket(SERVER_IP, PORT);
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                System.out.println("Conectado al servidor");
                SensorData data;
                do {
                    data = (SensorData) ois.readObject();
                    if (data != null) {
                        temperatures.add(data.getTemperature());
                        windSpeeds.add(data.getWindSpeed());
                        humidities.add(data.getHumidity());
                        atmosphericPressures.add(data.getAtmosphericPressure());
                        addChartPanel();
                        addVelocityChartPanel();
                        addLineChartPanel();
                        addWindSpeedPanel();
                        addBarChartPanel();
                        addThermometerChartPanel();
                    }
                } while (data != null);
            } catch (IOException e) {
                System.err.println("Error de conexión: " + e.getMessage());
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

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
        rangeAxis.setRange(0, 35);
        return chart;
    }

    private XYDataset createDataset() {

        XYSeries series = new XYSeries("Temperatura");
        for (Double temperature : temperatures) {
            series.add(temperatures.indexOf(temperature) + 1, temperature);
        }
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);
        return dataset;
    }

    private XYDataset createWindPolarData() {

        XYSeries series = new XYSeries("Temperatura");
        for (Double temperature : windSpeeds) {
            series.add((int) (Math.random() * 360), temperature);
        }
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);
        return dataset;
    }

    private XYBarDataset createHumidityData() {

        XYSeries series = new XYSeries("Humedad");
        for (Double humidity : humidities) {
            series.add(humidities.indexOf(humidity) + 1, humidity);
        }
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);
        XYBarDataset barDataset = new XYBarDataset(dataset, 0.5);
        return barDataset;
    }

    private VectorSeriesCollection createVectorSeriesCollection() {

        VectorSeries series = new VectorSeries("Viento");
        series.add(1, 1, -0.5, 0.5);  // Viento hacia el noroeste
        series.add(1, 2, 0, 1);       // Viento hacia el norte
        series.add(2, 1, 1, 0);       // Viento hacia el este
        series.add(2, 2, 0.7, 0.7);    // Viento hacia el noreste
        VectorSeriesCollection dataset = new VectorSeriesCollection();
        dataset.addSeries(series);
        return dataset;
    }

    private void addWindSpeedPanel() {
        DefaultValueDataset dataset = new DefaultValueDataset(windSpeeds.getLast());
        MeterPlot plot = new MeterPlot(dataset);
        plot.setRange(new Range(0, 20));
        plot.addInterval(new MeterInterval("Bajo", new Range(0, 5),
                Color.green, new BasicStroke(0.7f), Color.green));
        plot.addInterval(new MeterInterval("Medio", new Range(5, 10),
                Color.yellow, new BasicStroke(0.7f), Color.yellow));
        plot.addInterval(new MeterInterval("Alto", new Range(10, 20),
                Color.red, new BasicStroke(0.7f), Color.red));
        plot.setDialOutlinePaint(Color.BLACK);
        plot.setDialBackgroundPaint(Color.WHITE);
        plot.setNeedlePaint(Color.BLUE);
        plot.setTickLabelsVisible(true);
        plot.setTickLabelFont(new Font("Arial", Font.BOLD, 12));
        plot.setTickLabelPaint(Color.DARK_GRAY);
        plot.setUnits("km/h");
        plot.setDialShape(DialShape.PIE);
        JFreeChart chart = new JFreeChart("Velocímetro",
                JFreeChart.DEFAULT_TITLE_FONT,
                plot,
                false);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(400, 300));
        chartFive.setViewportView(chartPanel);
    }

    private void addLineChartPanel() {

        JFreeChart chart = ChartFactory.createXYLineChart(
                "Gráfico de Vectores de Viento",
                "X", "Y", createVectorSeriesCollection()
        );
        XYPlot plot = (XYPlot) chart.getPlot();
        VectorRenderer renderer = new VectorRenderer();
        renderer.setSeriesPaint(0, Color.blue);
        plot.setRenderer(renderer);
        // Configurar ejes
        NumberAxis domainAxis = (NumberAxis) plot.getDomainAxis();
        domainAxis.setRange(0, 3);
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setRange(0, 3);
        // Configurar el panel
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        this.chartThree.setViewportView(chartPanel);
    }

    private void addThermometerChartPanel() {

        DefaultValueDataset dataset = new DefaultValueDataset(temperatures.getLast());
        ThermometerPlot plot = new ThermometerPlot(dataset);
        plot.setRange(0, 35);
        plot.setThermometerStroke(new BasicStroke(2.0f));
        plot.setSubrange(0, 0, 19);
        plot.setSubrange(1, 19, 30);
        plot.setSubrange(2, 30, 35);
        plot.setUnits(ThermometerPlot.UNITS_CELCIUS);
        JFreeChart chart = new JFreeChart("Termómetro",
                JFreeChart.DEFAULT_TITLE_FONT,
                plot,
                false);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(400, 300));
        chartSeven.setViewportView(chartPanel);
    }

    private void addVelocityChartPanel() {

        JFreeChart chart = ChartFactory.createPolarChart(
                "Rosa de los Vientos",
                createWindPolarData(),
                true,
                true,
                false
        );
        PolarPlot polarPlot = (PolarPlot) chart.getPlot();
        polarPlot.setAngleGridlinesVisible(true);
        polarPlot.setRadiusGridlinesVisible(true);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        this.chartTwo.setViewportView(chartPanel);
    }

    private void addChartPanel() {

        JFreeChart chart = createLineChart();
        chart.getLegend().setVisible(true);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        chartPanel.setMouseWheelEnabled(true);
        this.chartOne.setViewportView(chartPanel);
    }

    private void addBarChartPanel() {
        JFreeChart chart = ChartFactory.createXYBarChart(
                "Gráfico de Barras",
                "ID",
                false,
                "Temperatura",
                createHumidityData(),
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );
        XYPlot plot = (XYPlot) chart.getPlot();
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setRange(0, 90);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        this.chartSix.setViewportView(chartPanel);
    }
}
