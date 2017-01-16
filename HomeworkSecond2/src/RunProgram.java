import java.util.Scanner;

public class RunProgram {
    public static void main (String[] args) {

        Scanner userInput = new Scanner(System.in);

        int arraySize1 = 0, arraySize2 = 0, sizeOfTheResultArray = 1;

        ArraySize arraySizeObject = new ArraySize();

        System.out.println("Please enter the size of the first array:");
        arraySize1 = arraySizeObject.getArraySizeFromUser(userInput);

        System.out.println("Please enter the size of the second array:");
        arraySize2 = arraySizeObject.getArraySizeFromUser(userInput);

        sizeOfTheResultArray += (arraySize1 > arraySize2) ? arraySize1 : arraySize2;

        int[] array1 = new int[arraySize1];
        int[] array2 = new int[arraySize2];
        int[] sum = new int[sizeOfTheResultArray];

        ArrayOfInt arrayObject = new ArrayOfInt();

        System.out.println("Please enter the first array:");
        arrayObject.getArrayOfIntFromUser(array1, arraySize1, userInput);

        System.out.println("Please enter the second array:");
        arrayObject.getArrayOfIntFromUser(array2, arraySize2, userInput);

        PrintOutArray printArrayObject = new PrintOutArray();

        System.out.println("The first array is:");
        printArrayObject.printOutArray(array1, arraySize1);

        System.out.println("\nThe second array is:");
        printArrayObject.printOutArray(array2, arraySize2);

        SumOfArrays sumOfArraysObject = new SumOfArrays(sum);

        sumOfArraysObject.countTheSumOfTheArrays(array1, array2);
        System.out.println("\nThe SUM is: ");
        sumOfArraysObject.getTheSumOfTheArrays();

        userInput.close();
    }
}
