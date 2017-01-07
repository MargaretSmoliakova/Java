
import java.util.Arrays;
import java.util.Scanner;

public class RunProgram {
    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);

        int numberOfElements = 0, max = 0, i = 0;

        System.out.println("Please enter the number of elements in yor future array: ");
        numberOfElements = userInput.nextInt();
        System.out.println("Please enter the maximum value of an integer in you future arrya: ");
        max = userInput.nextInt();

        int[] arrayOfInt = new int[numberOfElements];

        System.out.println("Your array is: ");

        for (i = 0; i < numberOfElements; i++) {
            arrayOfInt[i] = (int) (Math.random() * (max + 1));
            System.out.print(arrayOfInt[i] + " ");
        }

        AverageNumber averageNumber = new AverageNumber();
        AverageSquaredDisplacement averageSquaredDisplacement = new AverageSquaredDisplacement();

        double avarage = averageNumber.getNumber(arrayOfInt);

        System.out.println("\nThe average number of the array is: " + avarage);
        System.out.println("\nThe average squared displacement is: " + averageSquaredDisplacement.getNumber(arrayOfInt));

        userInput.close();
    }
}
