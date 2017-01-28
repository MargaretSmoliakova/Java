import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.awt.*;

/**
 * Created by Маргарита on 27.01.2017.
 */
public class GUI {

    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JPanel panelForTable = new JPanel();
    JPanel panelBottom = new JPanel();

    public GUI () {

// frame creation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setTitle("11");
        ImageIcon imageIcon = new ImageIcon(new ImageIcon("C:\\ALL\\PROGRAMMING\\JavaProgramming\\HomeworkEleventh1\\smile.png").getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT));
        frame.setIconImage(imageIcon.getImage());
        frame.setResizable(true);
        frame.setSize(500, 500);

// panels creation

        panel.add(panelForTable);
        panel.add(panelBottom);
        frame.add(panel);

        panel.setLayout(new BorderLayout());
        panel.add(panelForTable, BorderLayout.NORTH);
        panel.add(panelBottom, BorderLayout.SOUTH);

        JButton button1 = new JButton("Button");
        JButton button2 = new JButton("Button");

        //JTable table = new JTable(5, 3);

        //JTable table = new JTable(dataModel);
        //JScrollPane scrollpane = new JScrollPane(table);

        panelForTable.add(button1);
        panelBottom.add(button2);

        frame.setVisible(true);

    }
}
