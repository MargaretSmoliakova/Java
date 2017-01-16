
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * Created by Маргарита on 23.12.2016.
 */

public class PaneNinthFirst extends JPanel {

    private DefaultListModel<String> leftList = new DefaultListModel<String> ();
    private DefaultListModel<String> rightList = new DefaultListModel<String> ();
    JButton buttonS = new JButton("<");
    JButton buttonN = new JButton(">");
    JList leftTextField = new JList(leftList);
    JList rightTextField = new JList(rightList);

    String stringToMoveToRight;
    String stringToMoveToLeft;

    public PaneNinthFirst () {
        super();
        this.setLayout(new BorderLayout());

// creating additional Panel for buttons
        JPanel panelForButtons = new JPanel();
        panelForButtons.setLayout(new BorderLayout());

// adding Buttons
        buttonS.setPreferredSize(new Dimension(0, 50));
        buttonN.setPreferredSize(new Dimension(0, 50));

        panelForButtons.add(buttonN, BorderLayout.NORTH);
        panelForButtons.add(buttonS, BorderLayout.SOUTH);

// adding TextFields

        leftTextField.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        rightTextField.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        formLists();

        JScrollPane leftScrollPane = new JScrollPane(leftTextField);
        leftScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        leftScrollPane.setPreferredSize(new Dimension(200, 0));

        JScrollPane rightScrollPane = new JScrollPane(rightTextField);
        rightScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        rightScrollPane.setPreferredSize(new Dimension(200, 0));

        this.add(leftScrollPane, BorderLayout.WEST);
        this.add(rightScrollPane, BorderLayout.EAST);
        this.add(panelForButtons, BorderLayout.CENTER);

        addFunctionality();
    }

    private void formLists () {
        leftList.addElement("just");
        leftList.addElement("one");
        leftList.addElement("simple");
        leftList.addElement("string");
        leftList.addElement("here");

        rightList.addElement("just");
        rightList.addElement("another");
        rightList.addElement("simple");
        rightList.addElement("string");
        rightList.addElement("here");
    }

    private void addFunctionality () {
        buttonS.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                int index = -1;

                stringToMoveToLeft = (String) rightTextField.getSelectedValue();
                index = rightTextField.getSelectedIndex();

                if (index >= 0 && stringToMoveToLeft != null) {
                    leftList.addElement(stringToMoveToLeft);
                    rightList.remove(index);
                }

                stringToMoveToLeft = null;
            }
        });

        buttonN.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                int index = -1;

                stringToMoveToRight = (String) leftTextField.getSelectedValue();
                index = leftTextField.getSelectedIndex();

                if (index >= 0 && stringToMoveToRight != null) {
                    rightList.addElement(stringToMoveToRight);
                    leftList.remove(index);
                }

                stringToMoveToLeft = null;
            }
        });
    }
}
