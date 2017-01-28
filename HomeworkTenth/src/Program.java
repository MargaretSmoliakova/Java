import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Маргарита on 25.01.2017.
 */
public class Program {

    public static void main (String[] args) throws IOException {

        ArrayList<Students> arrayListOfStudents = new ArrayList<>();
        List<Integer> arrayListOfInt = new ArrayList<>();

        String pathFileOfStudents = "in2.txt";
        String pathFileOfInt = "in.txt";

// Forming array lists
        FormingArrayLists formingArrayLists = new FormingArrayLists(arrayListOfStudents, pathFileOfStudents, arrayListOfInt, pathFileOfInt);

// Printing out array list

        PrintingOutArrays printingOutArrays = new PrintingOutArrays();

        System.out.println("Original array list of Int:");
        printingOutArrays.printOutIntegers(arrayListOfInt);

        System.out.println("\nOriginal array list of Students:");
        printingOutArrays.printOutStudents(arrayListOfStudents);

        MinMax<Integer> minMaxArrayListOfInt = new MinMax<>();
        System.out.println("\nMin value: " + minMaxArrayListOfInt.getMin(arrayListOfInt).intValue());
        System.out.println("Max value: " + minMaxArrayListOfInt.getMax(arrayListOfInt).intValue());

        MinMax<Students> minMaxArrayListOfStudents = new MinMax<>();
        Students student = minMaxArrayListOfStudents.getMin(arrayListOfStudents);
        System.out.println("\nFirst student:\n" + "surname: " + student.getSurname() + "\nyear: " + student.getYear() + "\naverage grade: " + student.getAvgGrade());
        student = minMaxArrayListOfStudents.getMax(arrayListOfStudents);
        System.out.println("\nLast student:\n" + "surname: " + student.getSurname() + "\nyear: " + student.getYear() + "\naverage grade: " + student.getAvgGrade());



        /*System.out.println("\nMin int:");
        Collections.sort(arrayListOfInt);
        printingOutArrays.printOutIntegersMin(arrayListOfInt);

        System.out.println("Max int:");
        printingOutArrays.printOutIntegersMax(arrayListOfInt);

// Printing out array list of Students + sorted
        System.out.println("\nOriginal array list of Students:");
        printingOutArrays.printOutStudents(arrayListOfStudents);

        StudentsCompareBySurname compareBySurname = new StudentsCompareBySurname();
        Collections.sort(arrayListOfStudents, compareBySurname);
        System.out.println("First student (sorted by surname):");
        printingOutArrays.printOutStudentsMin(arrayListOfStudents);
        System.out.println("Last student (sorted by surname):");
        printingOutArrays.printOutStudentsMax(arrayListOfStudents);

        StudentsCompareByYear compareByYear = new StudentsCompareByYear();
        Collections.sort(arrayListOfStudents, compareByYear);
        System.out.println("First student (sorted by Year):");
        printingOutArrays.printOutStudentsMin(arrayListOfStudents);
        System.out.println("Last student (sorted by Year):");
        printingOutArrays.printOutStudentsMax(arrayListOfStudents);

        StudentsCompareByAvgGrade compareByAvgGrade = new StudentsCompareByAvgGrade();
        Collections.sort(arrayListOfStudents, compareByAvgGrade);
        System.out.println("First student (sorted by average grade):");
        printingOutArrays.printOutStudentsMin(arrayListOfStudents);
        System.out.println("Last student (sorted by average grade):");
        printingOutArrays.printOutStudentsMax(arrayListOfStudents);*/
    }
}
