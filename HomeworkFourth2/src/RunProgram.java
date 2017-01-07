import java.util.Scanner;

public class RunProgram {
    public static void main (String[] args) {

        Scanner userInput = new Scanner(System.in);

        String currencyNoteNumber;
        boolean result = false;

        System.out.println("Please enter your currency note number:");
        currencyNoteNumber = userInput.nextLine();

        CurrencyNoteNumber currencyNoteNumberObject = new CurrencyNoteNumber(currencyNoteNumber);
        try {
            result = currencyNoteNumberObject.getTestResult();

            if (result) {
                System.out.println("\nAnd your currency note number is correct... :) ");
                currencyNoteNumberObject.printOutInf();
            }
            else System.out.println("\nAnd your currency note number is not correct... Sorry... :( ");

        } catch (WrongCurrencyNoteNumber wrongCurrencyNoteNumber) {
            System.out.println(wrongCurrencyNoteNumber.getMessage());
        }

        userInput.close();
    }
}
