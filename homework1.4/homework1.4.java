
import java.util.Scanner;

class homework4 {
	
	public static void main (String[] args) {
		
		Scanner userInput = new Scanner(System.in);
		
		int n, result = 0;
		
		System.out.print("Please enter your n value: ");
		n = userInput.nextInt();
		
		for (; n != 0;) {
			result += n%10;
			n /= 10;
		}
		
		System.out.print("Your result is " + result);
		
		userInput.close();
	}
}
