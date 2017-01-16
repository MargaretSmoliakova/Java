import java.util.Arrays;
import java.io.*;


public abstract class Series {

    protected  double firstElement;
    protected double[] progressionElements;

// constructors

    protected Series() {
    }

    public Series (double firstElement) {
        this.firstElement = firstElement;
    }

// methods

    public abstract double getCertainElement (int serialNumber, double commonRatio);

    public double getSumOfElements() {

        double sumOfElements = 0;

        for (double el: progressionElements) {
              sumOfElements += el;
        }

        return sumOfElements;
    }

    @Override
    public String toString() {

        return Arrays.toString(progressionElements);

    }

    public void savingToFile (String path) throws IOException {

        File file = new File (path);

        OutputStream outputStream = new FileOutputStream(file);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

        bufferedWriter.write(Arrays.toString(progressionElements));

        bufferedWriter.close();
        outputStreamWriter.close();
        outputStream.close();
    }

// additional useful method

    public void setProgressionElements (int stopSerialNumber, double commonRatio) {

        progressionElements = new double[stopSerialNumber];

        for (int i = 0; i < stopSerialNumber; i++) {
            progressionElements[i] = this.getCertainElement(i + 1, commonRatio);
        }
    }
}
