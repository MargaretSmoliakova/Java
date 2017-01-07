
import java.util.Scanner;

public class RunProgram {

    public static void main (String[] args) {

        Scanner userInput = new Scanner(System.in);

        int arraySize = 0, intForMultiplication = 0, sizeOfTheResultArray = 0;

        System.out.println("Please enter your integer for multiplication: ");
        intForMultiplication = userInput.nextInt();

        ArraySize arraySizeObject = new ArraySize();
        System.out.println("Please enter the size of the array: ");
        arraySize = arraySizeObject.getArraySizeFromUser(userInput);

        ResultArraySize resultArraySizeObject = new ResultArraySize();
        sizeOfTheResultArray = resultArraySizeObject.setResultArraySize(arraySize, intForMultiplication);

        int[] arrayOfInt = new int[arraySize];
        int[] resultOfMultiplicationArray = new int[sizeOfTheResultArray];

        ArrayOfInt arrayOfIntObject = new ArrayOfInt();
        System.out.println("Please enter the array: ");
        arrayOfIntObject.getArrayOfIntFromUser(arrayOfInt, arraySize, userInput);

        PrintOutArray printArrayObject = new PrintOutArray();
        System.out.println("Your array of int is: ");
        printArrayObject.printOutArray(arrayOfInt, arraySize);
        System.out.println("\nAnd yor integer is: " + intForMultiplication);

        Multiplication multiplicationObject = new Multiplication(resultOfMultiplicationArray, sizeOfTheResultArray);
        multiplicationObject.multiplyIntAndArray(arrayOfInt, arraySize, intForMultiplication);
        System.out.println("\nThe result of the multiplication is: ");
        multiplicationObject.getResultOfMultiplication();

        userInput.close();
    }
}
