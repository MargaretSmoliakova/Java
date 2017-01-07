import javax.swing.*;
import java.awt.*;

public class FrameCreation {

    JFrame frame = new JFrame();
    JTabbedPane tabbedPane = new JTabbedPane();

    public FrameCreation () {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);
        TabbedPaneCreation tabbedPaneCreation = new TabbedPaneCreation();

        frame.getContentPane().add(tabbedPane);
        frame.setVisible(true);
    }

    class TabbedPaneCreation {

        public TabbedPaneCreation () {

            tabbedPane.addTab("Tab(9.1)", new ImageIcon("C:\\ALL\\PROGRAMMING\\JavaProgramming\\HomeworkNinth1\\Images\\9.1.png"), new PaneNinthFirst());
            tabbedPane.addTab("Tab(9.2)", new ImageIcon("C:\\ALL\\PROGRAMMING\\JavaProgramming\\HomeworkNinth1\\Images\\9.2.png"), new PaneNinthSecond());
            tabbedPane.addTab("Tab(9.3)", new ImageIcon("C:\\ALL\\PROGRAMMING\\JavaProgramming\\HomeworkNinth1\\Images\\9.3.png"), new PaneNinthThird());
            tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

        }

    }
}
