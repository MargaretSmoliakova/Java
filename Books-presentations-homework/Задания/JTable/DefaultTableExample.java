
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.*;

/** JTable that uses the DefaultTableModel, which permits
 *  adding rows and columns programmatically.
 *
*/
class MyModel extends DefaultTableModel
{
	 public boolean isCellEditable(int row,
             int column)
	 {
		 if (column==4)
			 return true;
		 else
		  return false;
	 }
	 
	
}
public class DefaultTableExample extends JTable {
  
  

private String[] columnNames = 
    { "Flag", "City", "Country", "Comment", "Visited" };

  public DefaultTableExample() {
    this(new DefaultTableModel());
  }
    
  public DefaultTableExample(DefaultTableModel model) {
    super(model);
    
    JavaLocationCollection collection =
      new JavaLocationCollection();
    JavaLocation[] locations = collection.getLocations();

    // Set up the column labels and data for the table model.
    int i;
    for(i=0; i<columnNames.length; i++ ) {
      model.addColumn(columnNames[i]); 
    }
    for(i=0; i<locations.length; i++) {
      model.addRow(getRowData(locations[i]));
    }
  }
  
  

  @Override
public Class<?> getColumnClass(int arg0) {
	// TODO Auto-generated method stub
	  if (arg0==0)
		  return ImageIcon.class;
	  else
	  if (arg0==4)
		  return Boolean.class;
	  else
		  	return super.getColumnClass(arg0);
}

private Vector getRowData(JavaLocation location) {
    Vector vector = new Vector();
    vector.add(new ImageIcon(location.getFlagFile()));
    vector.add("Java");
    vector.add(location.getCountry());
    vector.add(location.getComment());
    vector.add(new Boolean(false));
    return(vector);
  }
  
  public static void main(String[] args) {
    //WindowUtilities.setNativeLookAndFeel();    
    
       JFrame fr = new JFrame();
       fr.add( new DefaultTableExample(new MyModel()));
       fr.setSize(600, 150);
       fr.setVisible(true);
                       
  }
}
