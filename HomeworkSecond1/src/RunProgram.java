/**
 * Created by Маргарита on 16.01.2017.
 */

import java.util.Scanner;

    class RunProgram {
        RunProgram() {
        }

        public static void main(String[] var0) {
            Scanner var1 = new Scanner(System.in);
            ArraySize var2 = new ArraySize();
            int var3 = var2.getArraySizeFromUser(var1);
            int[] var4 = new int[var3];
            ArrayOfInt var5 = new ArrayOfInt();
            var5.getArrayOfIntFromUser(var4, var3, var1);
            MaxMultiplication var6 = new MaxMultiplication();
            var6.findMaxMultiplicationResult(var4, var3);
            var1.close();
        }
    }


