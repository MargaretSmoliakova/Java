

public class MaxMultiplication {

	int i = 0, result = 0, firstVariant = 0, secondVariant = 0;
	
	public void findMaxMultiplicationResult (int[] arrayOfInt, int arraySize) {

		firstVariant = arrayOfInt[arraySize - 1] * arrayOfInt[arraySize - 2] * arrayOfInt[arraySize - 3];
		secondVariant = arrayOfInt[0] * arrayOfInt[1] * arrayOfInt[arraySize - 1];

		if (firstVariant > secondVariant) System.out.println("Your result is " + firstVariant);
		else System.out.println("Your result is " + secondVariant);
	}
}