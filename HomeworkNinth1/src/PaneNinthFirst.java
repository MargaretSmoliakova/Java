

import com.sun.xml.internal.ws.util.StringUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * Created by Маргарита on 23.12.2016.
 */
public class PaneNinthFirst extends JPanel {

    private ArrayList<String> leftArrayList = new ArrayList<String> ();
    private ArrayList<String> rightArrayList = new ArrayList<String> ();
    JButton buttonS = new JButton("<");
    JButton buttonN = new JButton(">");
    JTextArea leftTextField = new JTextArea();
    JTextArea rightTextField = new JTextArea();

    String stringToMove;

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
        leftTextField.setEditable(false);
        leftTextField.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        formArrayLists();
        for (int i = 0; i < leftArrayList.size(); i++) {
            leftTextField.append(leftArrayList.get(i));
            leftTextField.append("\n");
        }
        JScrollPane leftScrollPane = new JScrollPane(leftTextField);
        leftScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        leftScrollPane.setPreferredSize(new Dimension(200, 0));

        rightTextField.setEditable(false);
        rightTextField.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        for (int i = 0; i < rightArrayList.size(); i++) {
            rightTextField.append(rightArrayList.get(i));
            rightTextField.append("\n");
        }
        JScrollPane rightScrollPane = new JScrollPane(rightTextField);
        rightScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        rightScrollPane.setPreferredSize(new Dimension(200, 0));

        this.add(leftScrollPane, BorderLayout.WEST);
        this.add(rightScrollPane, BorderLayout.EAST);
        this.add(panelForButtons, BorderLayout.CENTER);

        addFunctionality();
    }

    private void formArrayLists () {
        leftArrayList.add("just");
        leftArrayList.add("one");
        leftArrayList.add("simple");
        leftArrayList.add("string");
        leftArrayList.add("here");

        rightArrayList.add("just");
        rightArrayList.add("another");
        rightArrayList.add("simple");
        rightArrayList.add("string");
        rightArrayList.add("here");
    }

    private void addFunctionality () {

        buttonN.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                if (stringToMove != null) {
                    rightArrayList.add(stringToMove);
                    leftArrayList.remove(stringToMove);

                    leftTextField.setText("");
                    rightTextField.setText("");

                    for (int i = 0; i < leftArrayList.size(); i++) {
                        leftTextField.append(leftArrayList.get(i));
                        leftTextField.append("\n");
                    }

                    for (int i = 0; i < rightArrayList.size(); i++) {
                        rightTextField.append(rightArrayList.get(i));
                        rightTextField.append("\n");
                    }

                    stringToMove = null;
                }
            }
        });

        leftTextField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                int i =
                stringToMove = StringUtils. //(leftTextField.getSelectedText(), "\n");
            }
        });
    }
}
