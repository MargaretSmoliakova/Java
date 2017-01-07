import java.util.Arrays;

public class CurrencyNoteNumber {

    private String currencyNoteNumber;

    private boolean result;
    private int sumInts;

    private CurrencyNoteInformation Austria = new CurrencyNoteInformation("Austria", 'N', 3);
    private CurrencyNoteInformation Belgium = new CurrencyNoteInformation("Belgium", 'Z', 9);
    private CurrencyNoteInformation Germany = new CurrencyNoteInformation("Germany", 'X', 2);
    private CurrencyNoteInformation Greece = new CurrencyNoteInformation("Greece", 'Y', 1);
    private CurrencyNoteInformation Ireland = new CurrencyNoteInformation("Ireland", 'T', 6);
    private CurrencyNoteInformation Spain = new CurrencyNoteInformation("Spain", 'V', 4);
    private CurrencyNoteInformation Italy = new CurrencyNoteInformation("Italy", 'S', 7);
    private CurrencyNoteInformation Cyprus = new CurrencyNoteInformation("Cyprus", 'G', 1);
    private CurrencyNoteInformation Malta = new CurrencyNoteInformation("Malta", 'F', 2);
    private CurrencyNoteInformation Netherlands = new CurrencyNoteInformation("Netherlands",	'P', 1);
    private CurrencyNoteInformation Portugal = new CurrencyNoteInformation("Portugal", 'M', 4);
    private CurrencyNoteInformation Slovakia = new CurrencyNoteInformation("Slovakia", 'E', 3);
    private CurrencyNoteInformation Slovenia = new CurrencyNoteInformation("Slovenia", 'H', 9);
    private CurrencyNoteInformation Finland = new CurrencyNoteInformation("Finland", 'L',	5);
    private CurrencyNoteInformation France = new CurrencyNoteInformation("France", 'U', 5);
    private CurrencyNoteInformation Estonia = new CurrencyNoteInformation("Estonia", 'D', 4);

    private CurrencyNoteInformation[] arrayCurrencyNoteInformation = {Austria, Belgium, Germany, Greece, Ireland, Spain, Italy, Cyprus, Malta, Netherlands, Portugal, Slovakia, Slovenia, Finland, France, Estonia};

    public boolean getTestResult() throws WrongCurrencyNoteNumber {

        int i = 0, sum = 0, sumToCheck = 0;

// Catching exceptions
        if (currencyNoteNumber.length() != 12) throw new WrongCurrencyNoteNumber("The length of your currency note number is not 12...");

        for (i = 1; i < currencyNoteNumber.length(); i++)
            if (Character.isLetter(currencyNoteNumber.charAt(i))) throw new WrongCurrencyNoteNumber("Your currency note number contains too much letters...");


//Main code
        for (i = 0; i < currencyNoteNumber.length(); i++) {
            if (currencyNoteNumber.charAt(i) < '0' || currencyNoteNumber.charAt(i) > '9') continue;
            sum += Character.digit(currencyNoteNumber.charAt(i), 10);
        }

        i = currencyNoteNumber.charAt(0) - 'A' + 1;

        sumInts = sum;
        sum += i;

        do {
            sumToCheck += sum % 10;
            sum /= 10;
        } while (sum != 0);

        if (sumToCheck > 9) {
            sum = sumToCheck % 10;
            sumToCheck /= 10;
            sumToCheck += sum;
        }

        if (sumToCheck == 8) result = true;

        return result;
    }

    public void printOutInf () {

        int sumIntsToCheck = 0;

        do {
            sumIntsToCheck += sumInts % 10;
            sumInts /= 10;
        } while (sumInts != 0);

        if (sumIntsToCheck > 9) {
            sumInts = sumIntsToCheck % 10;
            sumIntsToCheck /= 10;
            sumIntsToCheck += sumInts;
        }

        for (CurrencyNoteInformation el: arrayCurrencyNoteInformation) {
            if ((el.number == sumIntsToCheck) && (currencyNoteNumber.charAt(0) == el.letter)) System.out.println("\nYour currency note is made in " + el.country + ".");
        }
    }

    public CurrencyNoteNumber () {
        super();
    }

    public CurrencyNoteNumber (String currencyNoteNumber) {

        this.currencyNoteNumber = currencyNoteNumber;
    }
}
