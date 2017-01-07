
public class CheckArray {

    public static long checkArray (int[] arrayOfInt, int arraySize) {     // result - int type ????????????????

        long maxValue = 9223372036854775807L, result = 0L, valueForCheck = 1000000000000000000L, ten = 1;
        int i = arraySize - 1;

        for (i = arraySize - 1; i >= 0; i--) {
            if (i == 0 && arrayOfInt[i] == 9) {
                if (result > maxValue%valueForCheck) return 0;
            }
            result += (long)(arrayOfInt[i]*ten);
            ten *= 10;
        }

        return result;
    }
}