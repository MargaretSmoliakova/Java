/**
 * Created by Маргарита on 07.11.2016.
 */
public class SumOfTheSeries {


    public double calculateSumOfTheSeries(String[] args) throws MyException {

        double sNext = (1.0 / 6.0), result = sNext, k = 1;

        if (args.length != 2) {
            throw new MyException("There should be only 2 arguments in the function calculateSumOfTheSeries! (class SumOfTheSeries)");
        }

        double limitOfInaccuracyMeasure = Double.parseDouble(args[0]);
        double measure_of_inaccuracy = Double.parseDouble(args[1]);

        while (Math.abs(sNext) > limitOfInaccuracyMeasure) {
            sNext *= (measure_of_inaccuracy * (k + 1)) / (k + 3);
            k++;
            result += sNext;
        }

        return result;
    }
}
