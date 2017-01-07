import java.awt.*;

import javax.swing.*;
import javax.swing.event.ListDataListener;

/** Simple JList example illustrating the use of a custom
 *  ListModel (JavaLocationListModel).
 *
*/

public class JListCustomModel extends JFrame {
  public static void main(String[] args) {
    new JListCustomModel();
  }

  public JListCustomModel() {
    super("JList with a Custom Data Model");
    //WindowUtilities.setNativeLookAndFeel();
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container content = getContentPane();

    JavaLocationCollection collection =
      new JavaLocationCollection();
    JavaLocationListModel listModel =
      new JavaLocationListModel(collection);
    JList sampleJList = new JList(listModel);
    Font displayFont = new Font("Serif", Font.BOLD, 18);
    sampleJList.setFont(displayFont);
    content.add(sampleJList);

    pack();
    setVisible(true);
  }
}

/** A simple collection that stores multiple JavaLocation
 *  objects in an array and determines the number of
 *  unique countries represented in the data.
 
 */

class JavaLocationCollection {
  private static JavaLocation[] defaultLocations =
    { new JavaLocation("Belgium",
                       "near Liege",
                       "flag_belgium.png"),
      new JavaLocation("Brazil",
                       "near Salvador",
                       "flags/brazil.gif"),
      new JavaLocation("Colombia",
                       "near Bogota",
                       "flags/colombia.gif"),
      new JavaLocation("Indonesia",
                       "main island",
                       "flags/indonesia.gif"),
      new JavaLocation("Jamaica",
                       "near Spanish Town",
                       "flags/jamaica.gif"),
      new JavaLocation("Mozambique",
                       "near Sofala",
                       "flags/mozambique.gif"),
      new JavaLocation("Philippines",
                       "near Quezon City",
                       "flags/philippines.gif"),
      new JavaLocation("Sao Tome",
                       "near Santa Cruz",
                       "flags/saotome.gif"),
      new JavaLocation("Spain",
                       "near Viana de Bolo",
                       "flags/spain.gif"),
      new JavaLocation("Suriname",
                       "near Paramibo",
                       "flags/suriname.gif"),
      new JavaLocation("United States",
                       "near Montgomery, Alabama",
                       "flags/usa.gif"),
      new JavaLocation("United States",
                       "near Needles, California",
                       "flags/usa.gif"),
      new JavaLocation("United States",
                       "near Dallas, Texas",
                       "flags/usa.gif")
    };

  private JavaLocation[] locations;
  private int numCountries;

  public JavaLocationCollection(JavaLocation[] locations) {
    this.locations = locations;
    this.numCountries = countCountries(locations);
  }
  
  public JavaLocationCollection() {
    this(defaultLocations);
  }

  public JavaLocation[] getLocations() {
    return(locations);
  }

  public int getNumCountries() {
    return(numCountries);
  }

  // Count the number of unique countries in the data.
  // Assumes the list is sorted by country name
  private int countCountries(JavaLocation[] locations) {
    int n = 0;
    String currentCountry, previousCountry = "None";
    for(int i=0;i<locations.length;i++) {
      currentCountry = locations[i].getCountry();
      if (!previousCountry.equals(currentCountry)) {
        n++;
     }
      currentCountry = previousCountry;
    }
    return(n);
  }
}


/** Simple data structure with three properties: country,
 *  comment, and flagFile. All are strings, and they are
 *  intended to represent a country that has a city or
 *  province named "Java," a comment about a more
 *  specific location within the country, and a path
 *  specifying an image file containing the country's flag.
 *  Used in examples illustrating custom models and cell
 *  renderers for JLists.
*/

 class JavaLocation {
  private String country, comment, flagFile;

  public JavaLocation(String country, String comment,
                      String flagFile) {
    setCountry(country);
    setComment(comment);
    setFlagFile(flagFile);
  }

  /** String representation used in printouts and in JLists */
  
  public String toString() {
    return("Java, " + getCountry() + " (" + getComment() + ").");
  }
  
  /** Return country containing city or province named "Java." */
  
  public String getCountry() {
    return(country);
  }

  /** Specify country containing city or province named "Java." */
  
  public void setCountry(String country) {
    this.country = country;
  }

  /** Return comment about city or province named "Java."
   *  Usually of the form "near such and such a city."
   */
  
  public String getComment() {
    return(comment);
  }

  /** Specify comment about city or province named "Java". */

  public void setComment(String comment) {
    this.comment = comment;
  }
  
  /** Return path to image file of country flag. */
  
  public String getFlagFile() {
    return(flagFile);
  }

  /** Specify path to image file of country flag. */
  
  public void setFlagFile(String flagFile) {
    this.flagFile = flagFile;
  }
}


/** A simple illustration of writing your own ListModel.
 *  Note that if you wanted the user to be able to add and
 *  remove data elements at runtime, you should start with
 *  AbstractListModel and handle the event reporting part.
*/

class JavaLocationListModel implements ListModel {
  private JavaLocationCollection collection;
  
  public JavaLocationListModel(JavaLocationCollection collection) {
    this.collection = collection;
  }

  public Object getElementAt(int index) {
    return(collection.getLocations()[index]);
  }

  public int getSize() {
    return(collection.getLocations().length);
  }

  public void addListDataListener(ListDataListener l) {}

  public void removeListDataListener(ListDataListener l) {}
}
