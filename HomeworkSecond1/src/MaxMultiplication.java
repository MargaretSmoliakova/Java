

public class MaxMultiplication {
    int i = 0;
    int result = 0;
    int firstVariant = 0;
    int secondVariant = 0;

    public MaxMultiplication() {
    }

    public void findMaxMultiplicationResult(int[] var1, int var2) {
        this.firstVariant = var1[var2 - 1] * var1[var2 - 2] * var1[var2 - 3];
        this.secondVariant = var1[0] * var1[1] * var1[var2 - 1];
        if(this.firstVariant > this.secondVariant) {
            System.out.println("Your result is " + this.firstVariant);
        } else {
            System.out.println("Your result is " + this.secondVariant);
        }

    }
}