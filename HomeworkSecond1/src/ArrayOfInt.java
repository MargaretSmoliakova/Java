//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.util.Scanner;

public class ArrayOfInt {
    int i = 0;

    public ArrayOfInt() {
    }

    public void getArrayOfIntFromUser(int[] var1, int var2, Scanner var3) {
        System.out.println("Please enter your array of numbers: ");

        for(this.i = 0; this.i < var2; ++this.i) {
            if(this.i == var2 - 1) {
                System.out.println("...and one more (the last) integer...");
            }

            var1[this.i] = var3.nextInt();
            if(this.i == var2 - 1) {
                System.out.println("...thanks!");
            }
        }

    }
}
