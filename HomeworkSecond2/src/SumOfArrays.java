
public class SumOfArrays {

    private int[] sum;

    public SumOfArrays (int[] sum) {

        this.sum = sum;
    }

    public void countTheSumOfTheArrays(int[] array1, int[] array2) {

        int i = 0, tempNumber = 0, theSmallestSizeOfArray = 0;
        //this.setArrayForSumSize(array1, array2);

        if (array1.length != array2.length) theSmallestSizeOfArray = (array1.length < array2.length) ? array1.length : array2.length;
        else theSmallestSizeOfArray = array1.length;

        for (i = 0; i < theSmallestSizeOfArray; i++) {
            sum[i] = (array1[array1.length - 1 - i] + array2[array2.length - 1 - i]) + tempNumber;
            tempNumber = sum[i]/10;
            sum[i] %= 10;
        }

        if (array1.length < array2.length) {
            sum[i] = array2[array2.length - 1 - i] + tempNumber;
            i++;
            if (sum[i] > 9) {
                tempNumber = sum[i]/10;
                sum[i] %= 10;
            } else tempNumber = 0;
            while (i < array2.length) {
                sum[i] = array2[array2.length - 1 - i] + tempNumber;
                i++;
                tempNumber = 0;
            }
        } else if (array1.length > array2.length) {
            sum[i] = array1[array1.length - 1 - i] + tempNumber;
            i++;
            if (sum[i] > 9) {
                tempNumber = sum[i]/10;
                sum[i] %= 10;
            } else tempNumber = 0;
            while (i < array1.length) {
                sum[i] = array1[array1.length - 1 - i] + tempNumber;
                i++;
                tempNumber = 0;
            }
        } else if (array1.length == array2.length && (array1[array1.length - 1 - i + 1] + array2[array2.length - 1 - i + 1]) > 9) {
            sum[i] = tempNumber;
        }
    }

    /*private void setArrayForSumSize(int[] array1, int[] array2) {

        arrayForSumSize = array1.length + array2.length;
    }*/

    public void getTheSumOfTheArrays () {

        int i = 0, j = 0;

        for (i = sum.length - 1; i != 0; i--) {
            if (sum[i] != 0) {
                j = i;
                break;
            }
        }

        for (i = j; i >= 0; i--) System.out.print(sum[i]);
    }
}
