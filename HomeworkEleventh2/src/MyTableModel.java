import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

/**
 * Created by Маргарита on 03.02.2017.
 */
public class MyTableModel extends DefaultTableModel {

    public MyTableModel () {};

    public MyTableModel (Object[][] data, String[] headers) {super(data, headers);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 0) return ImageIcon.class;
        else if (columnIndex == 4) return Boolean.class;
        else return String.class;
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        if (column == 3) {
            boolean isChecked = (boolean) getValueAt(row, column + 1);

            if (isChecked) return false;
            else return true;
        }

        else return true;
    }
}
