import java.awt.*;
import javax.swing.*;

/**
 * Created by Маргарита on 16.12.2016.
 */
public class LabelCreation {

    public LabelCreation() {}
    public LabelCreation(String text, int sizeWidth, int sizeHeight, int fontSize, Label labelChooseProgression) {
        labelChooseProgression.setText(text);
        labelChooseProgression.setSize(sizeWidth, sizeHeight);
        labelChooseProgression.setForeground(Color.BLACK);
        labelChooseProgression.setFont(new Font("Bla", Font.PLAIN, fontSize));
    }
}
