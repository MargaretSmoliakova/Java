

import java.util.Scanner;

public class ArraySize {
	
	public int getArraySizeFromUser (Scanner userInput) {
		
		System.out.println("Please enter the size of the array (more than or equal to 4): ");
		
		return userInput.nextInt();
		
	}
}