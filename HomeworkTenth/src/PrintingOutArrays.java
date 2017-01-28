import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Маргарита on 26.01.2017.
 */
public class PrintingOutArrays {

    public void printOutIntegers (List<Integer> integers) {

        for (int number: integers) {
            System.out.println(number);
        }
    }

    public void printOutStudents (ArrayList<Students> students) {
        for (Students student : students) {
            System.out.println("Student's surname: " + student.getSurname() + "; Year: " + student.getYear() + "; average grade: " + student.getAvgGrade() + ".");
        }
    }

    public void printOutIntegersMin (List<Integer> integers) {

        System.out.println(integers.get(0));
    }

    public void printOutIntegersMax (List<Integer> integers) {

        int size = integers.size();
        System.out.println(integers.get(size - 1));
    }

    public void printOutStudentsMin (ArrayList<Students> students) {

        System.out.println("Student's surname: " + students.get(0).getSurname() + "; Year: " + students.get(0).getYear() + "; average grade: " + students.get(0).getAvgGrade() + ".");
    }

    public void printOutStudentsMax (ArrayList<Students> students) {

        int size = students.size();
        System.out.println("Student's surname: " + students.get(size - 1).getSurname() + "; Year: " + students.get(size - 1).getYear() + "; average grade: " + students.get(size - 1).getAvgGrade() + ".");
    }
}
