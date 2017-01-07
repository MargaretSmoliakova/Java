/**
 * Created by Маргарита on 26.11.2016.
 */
public class AverageNumber {

    private double result;

    public double getNumber(int[] arrayOfInt) {

        for (int el : arrayOfInt) result += el;

        result /= arrayOfInt.length;

        return result;

    }
}
