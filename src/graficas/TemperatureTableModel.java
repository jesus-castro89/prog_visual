package graficas;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class TemperatureTableModel extends AbstractTableModel {
    private final List<Integer> data;
    private final String[] columnName = {"ID", "Temperatura"};

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

        return columnName[column];
    }
}
