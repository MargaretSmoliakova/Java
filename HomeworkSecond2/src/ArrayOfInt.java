
import java.util.Scanner;

public class ArrayOfInt {

    int i = 0;

    public void getArrayOfIntFromUser (int[] arrayOfInt, int arraySize, Scanner userInput) {

        for (i = 0; i < arraySize; i++) {
            if (i == arraySize - 1) System.out.println("...and one more (the last) integer...");
            arrayOfInt[i] = userInput.nextInt();
            if (i == arraySize - 1) System.out.println("...thanks!");
        }
    }
}