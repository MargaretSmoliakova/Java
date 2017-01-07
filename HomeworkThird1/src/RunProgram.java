
import java.util.InputMismatchException;


public class RunProgram {

    public static void main(String[] args) {

        double result = 0.0;

        try {

            SumOfTheSeries sumOfTheSeriesObject = new SumOfTheSeries();

            result = sumOfTheSeriesObject.calculateSumOfTheSeries(args);

            System.out.println("The sum is: " + result);
        } catch (NumberFormatException e) {
            System.out.println("The both of the argument must be of an int type!");
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }

    }
}
