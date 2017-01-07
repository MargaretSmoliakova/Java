import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Created by Маргарита on 19.12.2016.
 */
public class PanelCreation {

    public PanelCreation(){}

    public PanelCreation(JFrame frame, JPanel panel, JPanel gridPanel, int gridLayoutRow, int gridLayoutCol, JPanel buttonPanel, int buttonPanelEmptyBorderUp, int buttonPanelEmptyBorderRight, int buttonPanelEmptyBorderBottom, int buttonPanelEmptyBorderLeft){
        frame.getContentPane().add(panel);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        gridPanel.setLayout(new GridLayout(gridLayoutRow, gridLayoutCol));
        gridPanel.setBorder(new EmptyBorder(20, 20, 0, 20));
        buttonPanel.setLayout(new BorderLayout());
        buttonPanel.setBorder(new EmptyBorder(buttonPanelEmptyBorderUp, buttonPanelEmptyBorderRight, buttonPanelEmptyBorderBottom, buttonPanelEmptyBorderLeft));

        panel.add(gridPanel);
        panel.add(buttonPanel);
    }
}
