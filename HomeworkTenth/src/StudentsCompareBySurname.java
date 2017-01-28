import java.util.Comparator;

/**
 * Created by Маргарита on 26.01.2017.
 */
public class StudentsCompareBySurname implements Comparator<Students> {

    public int compare(Students one, Students two) {

        return one.getSurname().compareTo(two.getSurname());
    }
}