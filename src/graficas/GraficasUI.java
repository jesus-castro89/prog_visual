package graficas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class GraficasUI extends JFrame {

    private JTabbedPane tabbedPane1;
    private JPanel mainPanel;
    private JTable table;
    private JLabel dataLbl;
    private JSlider temperatureSld;
    private JPanel chartPanel;
    private JComboBox<String> chartType;
    private JCheckBox showLegend;
    private JButton generateChart;
    private JRadioButton horizontalRadioButton;
    private JRadioButton verticalRadioButton;
    private JButton generateBarChart;
    private JButton generatePieChart;
    private JPanel pieChartPanel;
    private JButton addData;
    private ButtonGroup orientationGroup;
    private DefaultTableModel tableModel;

    public static void main(String[] args) {

        new GraficasUI();
    }

    public GraficasUI() {

        // Inicializar la tabla
        initTable();
        // Configurar la ventana
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        // Agregar acciones a los componentes
        addActions();
    }

    private void addActions() {

        addData.addActionListener(e -> {
            addRowToTable();
        });
    }

    private void initTable() {
        // Crear el modelo de la tabla
        tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("Temperatura (C°)");
        // Asignar el modelo a la tabla
        table.setModel(tableModel);
        table.add(table.getTableHeader());
        table.setRowHeight(25);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setShowHorizontalLines(true);
        table.setShowVerticalLines(true);
    }

    private void addRowToTable() {

        int id = tableModel.getRowCount() + 1;
        int temperature = temperatureSld.getValue();
        tableModel.addRow(new Object[]{id, temperature});
    }
}
