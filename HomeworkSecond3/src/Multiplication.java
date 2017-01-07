
public class Multiplication {

    int sizeOfTheResultArray;
    int[] resultOfMultiplicationArray;       // !!!!!!!!!!!!!!!!How to get the size of the array from the user?????

    public Multiplication (int[] resultOfMultiplicationArray, int sizeOfTheResultArray) {

        this.resultOfMultiplicationArray = resultOfMultiplicationArray;
        this.sizeOfTheResultArray = sizeOfTheResultArray;
    }

    public void multiplyIntAndArray (int[] arrayOfInt, int arraySize, int intForMultiplication) {

        int i = 0, ten = 10, excess = 0;

        for (i = 0; i < arraySize; i++) {
            if (i == arraySize - 1) {
                resultOfMultiplicationArray[i] = (arrayOfInt[arraySize - 1 - i] * intForMultiplication) + excess;
                break;
            }
            resultOfMultiplicationArray[i] = (arrayOfInt[arraySize - 1 - i] * intForMultiplication) + excess;
            excess = resultOfMultiplicationArray[i]/ten;
            resultOfMultiplicationArray[i] %= ten;
        }
    }

    public void getResultOfMultiplication () {

        int i = 0, j = 0;

        for (i = sizeOfTheResultArray - 1; i != 0; i--) {
            if (resultOfMultiplicationArray[i] != 0) {
                j = i;
                break;
            }
        }

        for (i = j; i >= 0; i--) System.out.print(resultOfMultiplicationArray[i]);
    }


}
