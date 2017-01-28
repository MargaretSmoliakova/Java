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

// adding Buttons
       /* this.add(button1);
        this.add(button2);
        this.add(button3);
        this.add(button4);
        this.add(button5);
        this.add(button6);
        this.add(button7);
        this.add(button8);
        this.add(button9);
        this.add(button10);
        this.add(button11);
        this.add(button12);
        this.add(button13);
        this.add(button14);
        this.add(button15);
        this.add(button16);
        this.add(button17);
        this.add(button18);
        this.add(button19);
        this.add(button20);*/

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
       /* button1.addMouseListener(mouseListener);
        button2.addMouseListener(mouseListener);
        button3.addMouseListener(mouseListener);
        button4.addMouseListener(mouseListener);
        button5.addMouseListener(mouseListener);
        button6.addMouseListener(mouseListener);
        button7.addMouseListener(mouseListener);
        button8.addMouseListener(mouseListener);
        button9.addMouseListener(mouseListener);
        button10.addMouseListener(mouseListener);
        button11.addMouseListener(mouseListener);
        button12.addMouseListener(mouseListener);
        button12.addMouseListener(mouseListener);
        button13.addMouseListener(mouseListener);
        button14.addMouseListener(mouseListener);
        button15.addMouseListener(mouseListener);
        button16.addMouseListener(mouseListener);
        button17.addMouseListener(mouseListener);
        button18.addMouseListener(mouseListener);
        button19.addMouseListener(mouseListener);
        button20.addMouseListener(mouseListener);*/
    }
}
