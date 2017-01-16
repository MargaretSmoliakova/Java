import javax.swing.*;
import java.awt.*;

/**
 * Created by Маргарита on 18.12.2016.
 */
public class FrameCreation {

    public FrameCreation() {
    }

    public FrameCreation(String title, String imageIconPath, int imageIconWidth, int imageIconHeight, boolean resizable, int frameWidth, int frameHeight, JFrame frame) {

        frame.setTitle(title);
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(imageIconPath).getImage().getScaledInstance(imageIconWidth, imageIconHeight, Image.SCALE_DEFAULT));
        frame.setIconImage(imageIcon.getImage());
        frame.setResizable(resizable);
        frame.setSize(frameWidth, frameHeight);
    }
}
