package com.example.sensor;

import graficas.TemperatureTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.*;

import javax.swing.*;
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
    private ArrayList<Double> temperatures;
    private ArrayList<Double> windSpeeds;

    public static void main(String[] args) {

        SwingUtilities.invokeLater(SensorClient::new);
    }

    public SensorClient() {
        temperatures = new ArrayList<>();
        windSpeeds = new ArrayList<>();
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
                        addChartPanel();
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

    private WindDataset createWindDataset() {
        DefaultWindDataset dataset = new DefaultWindDataset();
        for (Double windSpeed : windSpeeds) {
            dataset.addWindData(windSpeeds.indexOf(windSpeed) + 1, windSpeed);
        }
        WindDataset dataset = new WindDataset();
        for (Double windSpeed : windSpeeds) {
            dataset.addWindData(windSpeeds.indexOf(windSpeed) + 1, windSpeed);
        }
        return dataset;
    }

    /*private void addVelocityChartPanel() {

        JFreeChart chart = ChartFactory.createWindPlot(
                "Gráfico de Viento",
                "ID",
                "Velocidad del Viento",
                createWindDataset(),
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );
    }*/

    private void addChartPanel() {

        JFreeChart chart = createLineChart();
        chart.getLegend().setVisible(true);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        chartPanel.setMouseWheelEnabled(true);
        this.chartOne.setViewportView(chartPanel);
    }
}
