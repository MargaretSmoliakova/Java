import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * Created by Маргарита on 15.01.2017.
 */
public class FrameCreation {

    JFrame frame;
    GraficCreation graficPanel;

    ArrayList<Bubbles> arrayListOfBubbles = new ArrayList<>();

    int red;
    int green;
    int blue;

    int x, y, r = 20;

    boolean isDrawFirstTime = true;
    boolean isIncBubble;

    public FrameCreation() {

// creating frame
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        frame.setTitle("Bubbles");
        ImageIcon imageIcon = new ImageIcon(new ImageIcon("C:\\ALL\\PROGRAMMING\\JavaProgramming\\HomeworkNinth2\\Images\\smiley_face.png").getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT));
        frame.setIconImage(imageIcon.getImage());
        frame.setResizable(true);
        frame.setSize(500, 500);

// creating panel
        graficPanel = new GraficCreation();
        graficPanel.setBackground(Color.black);
        graficPanel.setOpaque(true);
        frame.add(graficPanel);

        frame.setVisible(true);
        setFunctionality();
    }

    public void setFunctionality() {

        graficPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                if (SwingUtilities.isLeftMouseButton(e)) {

                    x = e.getX();
                    y = e.getY();

                // check if we in the area of a bubble
                    for (Bubbles bubble : arrayListOfBubbles) {
                        if (bubble.isInside(x, y)) {
                            bubble.incRadius();
                            isIncBubble = true;
                        }
                    }

                // grafic panel not to be drawn at the first time
                    isDrawFirstTime = false;

                    frame.repaint();
                }
            }
        });
    }

    public class GraficCreation extends JPanel {

        public void paintComponent(Graphics g) {
            super.paintComponent(g);

        // check wether panel is drawing in the first time and whether we are not in the area of a bubble
            if (!isDrawFirstTime && !isIncBubble) {

                red = (int) (Math.random() * 255);
                green = (int) (Math.random() * 255);
                blue = (int) (Math.random() * 255);

                arrayListOfBubbles.add(new Bubbles(x, y, r, red, green, blue));

            } else isIncBubble = false;

         // drawing
            for (Bubbles bubble : arrayListOfBubbles) {
                g.setColor(new Color(bubble.red, bubble.green, bubble.blue));

                g.drawOval(bubble.x - bubble.r, bubble.y - bubble.r, bubble.r * 2, bubble.r * 2);
            }
        }
    }
}
