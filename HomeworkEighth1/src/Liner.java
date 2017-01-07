

public class Liner extends Series {

// constructor

    public Liner(){
        super();
    }

    public Liner (double firstElement) {
        super(firstElement);
    }

    @Override
    public double getCertainElement(int serialNumber, double arithmeticalRatio) {
        double certainElement = firstElement + (double) (serialNumber - 1) * arithmeticalRatio;
        return certainElement;
    }
}
