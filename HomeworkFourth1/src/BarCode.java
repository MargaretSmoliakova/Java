

public class BarCode {

    private boolean result;

    public boolean getTestResult(String barCode) throws WrongBarCodeException {

        int i = 0, sum1 = 0, sum2 = 0, sumFinal = 0;
        char[]  barCodeCharArray = barCode.toCharArray();

        if (barCodeCharArray.length != 13) throw new WrongBarCodeException("The length is not 13...");

        for (char c: barCodeCharArray) {
            if (Character.isDigit(c)) throw new WrongBarCodeException("Your bar code contains letter(-s)...");
        }

        for (i = 0; i < barCodeCharArray.length; i++) {
            if (i % 2 == 0) sum1 += barCodeCharArray[i] - '0';
            else sum2 += barCodeCharArray[i] - '0';
        }

        sum2 *= 3;

        sum1 %= 10;
        sum2 %=10;

        sumFinal = (sum1 + sum2) % 10;

        if (sumFinal == 0) result = true;

        return result;
    }
}
