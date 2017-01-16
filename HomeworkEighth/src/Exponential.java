

public class Exponential extends Series {

    // constructor

    public Exponential () {
        super();
    }

    public Exponential (double firstElement) {
        super(firstElement);
    }

    @Override
    public double getCertainElement(int serialNumber, double geometricRatio) {

        if (geometricRatio == 0) {
            System.out.println("Your have not defined the geometric ratio for the progression...");
            return 0;
        }
        else {
            double certainElement = firstElement * Math.pow(geometricRatio, serialNumber - 1);
            return certainElement;
        }
    }
}
