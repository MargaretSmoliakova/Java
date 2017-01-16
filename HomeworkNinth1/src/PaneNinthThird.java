import javax.swing.*;
import java.awt.*;

/**
 * Created by Маргарита on 23.12.2016.
 */
public class PaneNinthThird extends JPanel {

    public PaneNinthThird() {
        super();
        this.setLayout(new GridLayout(0, 3));
        this.setBorder(BorderFactory.createEmptyBorder(40,40,40,40));


// adding radio buttons

        ImageIcon imageIcon1 = new ImageIcon("C:\\ALL\\PROGRAMMING\\JavaProgramming\\HomeworkNinth1\\Images\\jerry.png");
        ImageIcon imageIcon2 = new ImageIcon("C:\\ALL\\PROGRAMMING\\JavaProgramming\\HomeworkNinth1\\Images\\jerry-2.png");
        ImageIcon imageIcon3 = new ImageIcon("C:\\ALL\\PROGRAMMING\\JavaProgramming\\HomeworkNinth1\\Images\\jerry-3.png");

        JRadioButton jRadioButton1 = new JRadioButton();
        JRadioButton jRadioButton2 = new JRadioButton();
        JRadioButton jRadioButton3 = new JRadioButton();

        jRadioButton1.setIcon(imageIcon1);
        jRadioButton1.setSelectedIcon(imageIcon2);
        jRadioButton1.setRolloverIcon(imageIcon3);

        jRadioButton2.setIcon(imageIcon1);
        jRadioButton2.setSelectedIcon(imageIcon2);
        jRadioButton2.setRolloverIcon(imageIcon3);

        jRadioButton3.setIcon(imageIcon1);
        jRadioButton3.setSelectedIcon(imageIcon2);
        jRadioButton3.setRolloverIcon(imageIcon3);

        this.add(jRadioButton1);
        this.add(jRadioButton2);
        this.add(jRadioButton3);
    }
}
