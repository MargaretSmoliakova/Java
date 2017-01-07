
import java.util.Scanner;

public class Homework5 {

    public static void main (String[] args) {

        Scanner userInput = new Scanner(System.in);

        int n, count = 1, tempNumber = 1;
        double result = 1;

        System.out.print("Please enter your n value: ");
        n = userInput.nextInt();

        while (count <= n) {
            result += (double)1/(tempNumber *= count);
            count++;
        }

        System.out.print("Your result is: " + result);

        userInput.close();
    }
}
