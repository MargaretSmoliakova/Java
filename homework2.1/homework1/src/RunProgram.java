

import java.util.Scanner;

class RunProgram {
	
	public static void main (String[] args) {
		Scanner userInput = new Scanner (System.in);
		
		ArraySize arraySizeObject = new ArraySize();
		int arraySize = arraySizeObject.getArraySizeFromUser(userInput);

		int[] arrayOfInt = new int [arraySize];
	
		ArrayOfInt arrayOfIntObject = new ArrayOfInt();
		arrayOfIntObject.getArrayOfIntFromUser(arrayOfInt, arraySize, userInput);
		
		MaxMultiplication maxMultiplicationObject = new MaxMultiplication();
		maxMultiplicationObject.findMaxMultiplicationResult(arrayOfInt, arraySize);
	
		userInput.close();
	}
}