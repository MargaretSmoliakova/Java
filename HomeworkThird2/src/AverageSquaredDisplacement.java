
public class AverageSquaredDisplacement {

    private double result;

    public double getNumber(int[] arrayOfInt) {

        double average = (new AverageNumber()).getNumber(arrayOfInt);

        for (int i = 0; i < arrayOfInt.length - 1; i++) result += Math.pow(Math.abs(arrayOfInt[i + 1] - average), 2);

        result = Math.sqrt(result)/arrayOfInt.length;

        return result;
    }
}
