
import java.util.Scanner;

class RunHomework2 {

    public static void main (String[] args) {

        int arraySize1 = 0, arraySize2 = 0;
        long checkResult = 1L;

        Scanner userInput = new Scanner (System.in);

        ArraySize arraySizeObject = new ArraySize();

        System.out.println("Please enter the size of the first array: ");   // Get arrays' sizes.
        arraySize1 = arraySizeObject.getArraySizeFromUser(userInput);

        System.out.println("Please enter the size of the second array: ");
        arraySize2 = arraySizeObject.getArraySizeFromUser(userInput);

        while (arraySize1 >= 20 || arraySize1 <= 0) {                       // Check if the size of the array is correct
            System.out.println("Please input correct data! The type long could contain up to 19 integers. Try again...");
            arraySize1 = arraySizeObject.getArraySizeFromUser(userInput);
        }

        while (arraySize2 >= 10 || arraySize2 <= 0) {
            System.out.println("Please input correct data! The type int could contain up to 10 integers. Try again...");
            arraySize2 = arraySizeObject.getArraySizeFromUser(userInput);
        }

        int[] arrayOfInt1 = new int[arraySize1];
        int[] arrayOfInt2 = new int[arraySize2];

        System.out.println("Please enter the first array of numbers: ");        // Get arrays of int
        ArrayOfInt arrayObject1 = new ArrayOfInt();
        arrayObject1.getArrayOfIntFromUser(arrayOfInt1, arraySize1, userInput);

        System.out.println("Please enter the second array of numbers: ");
        ArrayOfInt arrayObject2 = new ArrayOfInt();
        arrayObject2.getArrayOfIntFromUser(arrayOfInt2, arraySize2, userInput);

        if (arraySize1 == 19) {
            CheckArray checkArrayObject = new CheckArray();
            checkResult = checkArrayObject.checkArray(arrayOfInt1, arraySize1);
            System.out.println("Check result is:" + checkResult);
            if (checkResult == 0) {
                System.out.println("Your array of int exceeded the maximum value of the long type...Please change your array of int...");
                arrayObject1.getArrayOfIntFromUser(arrayOfInt1, arraySize1, userInput);
            }
        }

        System.out.println("Your first array is:");
        PrintOutArray printArray1Object = new PrintOutArray();
        printArray1Object.PrintOutArray(arrayOfInt1, arraySize1);

        System.out.println("\nYour second array is:");
        PrintOutArray printArray2Object = new PrintOutArray();
        printArray2Object.PrintOutArray(arrayOfInt2, arraySize2);

        userInput.close();
    }
}
