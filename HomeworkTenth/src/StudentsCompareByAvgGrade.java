import java.util.Comparator;

/**
 * Created by Маргарита on 26.01.2017.
 */
class StudentsCompareByAvgGrade implements Comparator<Students> {

    public int compare(Students one, Students two) {

        if (one.getAvgGrade() > two.getAvgGrade()) return 1;
        else if (one.getAvgGrade() < two.getAvgGrade()) return -1;
        else return 0;
    }
}
