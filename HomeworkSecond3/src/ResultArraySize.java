
public class ResultArraySize {

    int i;

    public int setResultArraySize (int arraySize, int intForMultiplication) {

        while (intForMultiplication >= 1) {
            intForMultiplication /= 10;
            i++;
        }

        return (arraySize + i);
    }
}