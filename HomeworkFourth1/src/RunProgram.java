
import java.util.Scanner;

public class RunProgram {
    public static void main (String[] args) {

        Scanner userInput = new Scanner(System.in);

        boolean result = false;

        String barCode;

        System.out.println("Please input your bar code:");
        barCode = userInput.nextLine();

        System.out.println("Your bar code is: " + barCode);

        BarCode barCodeObject = new BarCode();

        try {

            result = barCodeObject.getTestResult(barCode);

            if (result) System.out.println("\nAnd your bar code is correct... :)");
            else System.out.println("\nNext time please input correct data...");

        } catch (WrongBarCodeException wrongBarCodeException) {
            System.out.println(wrongBarCodeException.getMessage());
        }

        userInput.close();
    }
}
