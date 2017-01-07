import javax.swing.*;
import java.awt.*;
import java.util.*;


class JavaLocationRenderer extends 
                                  DefaultListCellRenderer {
  private Hashtable iconTable = new Hashtable();
  
  public Component getListCellRendererComponent(JList list,
                                                Object value,
                                                int index,
                                                boolean isSelected,
                                                boolean hasFocus) {
    // First build the label containing the text, then 
    // later add the image.
    JLabel label =
      (JLabel)super.getListCellRendererComponent(list,
                                                 value,
                                                 index,
                                                 isSelected,
                                                 hasFocus);
    if (value instanceof JavaLocation) {
      JavaLocation location = (JavaLocation)value;
      ImageIcon icon = (ImageIcon)iconTable.get(value);
      if (icon == null) {
        icon = new ImageIcon(location.getFlagFile());
        iconTable.put(value, icon);
      }
      label.setIcon(icon);
    } else {
      // Clear old icon; needed in 1st release of JDK 1.2.
      label.setIcon(null); 
    }
    return(label);
  }
}



/** Simple JList example illustrating the use of a custom
 *  cell renderer (JavaLocationRenderer).
*/

public class JListCustomRenderer extends JFrame {
  public static void main(String[] args) {
    new JListCustomRenderer();
  }

  public JListCustomRenderer() {
    super("JList with a Custom Cell Renderer");
    //WindowUtilities.setNativeLookAndFeel();
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container content = getContentPane();

    JavaLocationCollection collection = 
      new JavaLocationCollection();
    JavaLocationListModel listModel =
      new JavaLocationListModel(collection);
    JList sampleJList = new JList(listModel);
    sampleJList.setCellRenderer(new JavaLocationRenderer());
    Font displayFont = new Font("Serif", Font.BOLD, 18);
    sampleJList.setFont(displayFont);
    content.add(sampleJList);

    pack();
    setVisible(true);
  }
}
