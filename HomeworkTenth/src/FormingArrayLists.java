import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Маргарита on 26.01.2017.
 */
class FormingArrayLists {

    public FormingArrayLists() {}

    public FormingArrayLists(ArrayList<Students> students, String pathStudents, List<Integer> integers, String pathIntegers) throws FileNotFoundException {
       readFromFile(students, pathStudents, integers, pathIntegers);
    }

    private void readFromFile (ArrayList<Students> students, String pathStudents, List<Integer> integers, String pathIntegers) throws FileNotFoundException {

        File fileForSrudents = new File (pathStudents);
        File fileForInt = new File (pathIntegers);

        Scanner scStudents =  new Scanner(fileForSrudents, "cp1251");
        Scanner scInt = new Scanner (fileForInt);

        while (scInt.hasNext()) {
            integers.add(new Integer(scInt.nextLine()));
        }

        while (scStudents.hasNextLine()) {
            students.add (new Students(scStudents.nextLine()));
        }
    }
}
