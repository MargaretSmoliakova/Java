import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Маргарита on 23.12.2016.
 */
public class PaneNinthSecond extends JPanel {

    JButton button1 = new JButton("1");
    JButton button2 = new JButton("2");
    JButton button3 = new JButton("3");
    JButton button4 = new JButton("4");
    JButton button5 = new JButton("5");
    JButton button6 = new JButton("6");
    JButton button7 = new JButton("7");
    JButton button8 = new JButton("8");
    JButton button9 = new JButton("9");
    JButton button10 = new JButton("10");
    JButton button11 = new JButton("11");
    JButton button12 = new JButton("12");
    JButton button13 = new JButton("13");
    JButton button14 = new JButton("14");
    JButton button15 = new JButton("15");
    JButton button16 = new JButton("16");
    JButton button17 = new JButton("17");
    JButton button18 = new JButton("18");
    JButton button19 = new JButton("19");
    JButton button20 = new JButton("20");

    String buttonText;

    public PaneNinthSecond () {
// creating additional Panel for buttons
        super();
        this.setLayout(new GridLayout(4, 5));

        addFunctionality();
    }

    private void addFunctionality () {

        MouseListener mouseListener = new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                JButton button = (JButton) e.getSource();
                button.setBackground(Color.yellow);
            }

            public void mouseExited(MouseEvent e) {
                JButton button = (JButton) e.getSource();
                button.setBackground(null);
            }

            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    JButton button = (JButton) e.getSource();
                    buttonText = button.getText();
                    button.setText("Clicked!");
                }
            }

            public void mouseReleased(MouseEvent e) {
                JButton button = (JButton) e.getSource();
                if (e.getButton() == MouseEvent.BUTTON1) {
                    button.setText(buttonText);

                    buttonText = null;
                }
            }
        };

        for (int i = 1; i < 30; i++) {
            JButton button = new JButton(Integer.toString(i));
            this.add(button);
            button.addMouseListener(mouseListener);
        }
    }
}
