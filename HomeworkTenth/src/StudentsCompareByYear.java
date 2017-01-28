import java.util.Comparator;

/**
 * Created by Маргарита on 26.01.2017.
 */
public class StudentsCompareByYear implements Comparator<Students> {

    public int compare(Students one, Students two) {

        if (one.getYear() > two.getYear()) return 1;
        else if (one.getYear() < two.getYear()) return -1;
        else return 0;
    }
}