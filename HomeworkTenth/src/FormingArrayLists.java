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

    public FormingArrayLists(MinMax<Students> students, String pathStudents, MinMax<Integer> integers, String pathIntegers) throws FileNotFoundException {
       readFromFile(students, pathStudents, integers, pathIntegers);
    }

    private void readFromFile (MinMax<Students> students, String pathStudents, MinMax<Integer> integers, String pathIntegers) throws FileNotFoundException {

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

        PrintingOutArrays printingOutArrays = new PrintingOutArrays();

        System.out.println("Original array list of Int:");
        printingOutArrays.printOutIntegers(integers);

        System.out.println("\nOriginal array list of Students:");
        printingOutArrays.printOutStudents(students);


        System.out.println("\nMin value: " + integers.getMin().intValue());
        System.out.println("Max value: " + integers.getMax().intValue());


        Students student = students.getMin();
        System.out.println("\nFirst student:\n" + "surname: " + student.getSurname() + "\nyear: " + student.getYear() + "\naverage grade: " + student.getAvgGrade());
        student = students.getMax();
        System.out.println("\nLast student:\n" + "surname: " + student.getSurname() + "\nyear: " + student.getYear() + "\naverage grade: " + student.getAvgGrade());

    }
}
