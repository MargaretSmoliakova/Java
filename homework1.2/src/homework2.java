
import java.util.Scanner;
import java.lang.Math;

public class homework2 {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		double a, b, c, x1, x2;
		double equationPart;
		
		System.out.print("Please enter \"a\" of the equation: ");
		a = userInput.nextFloat();
		
		System.out.print("Please enter \"b\" of the equation: ");
		b = userInput.nextFloat();
		
		System.out.print("Please enter \"c\" of the equation: ");
		c = userInput.nextFloat();
		
		equationPart = Math.pow(b, 2) - 4*a*c;
		
		if (equationPart < 0) {
			System.out.print("Impossible!!!");
		} else {
			x1 = (-b + Math.sqrt(equationPart))/(2*a);
			x2 = (-b - Math.sqrt(equationPart))/(2*a);
			
			System.out.print("\nResult of the equation (x1) is: " + x1);
			System.out.print("\nResult of the equation (x2) is: " + x2);
		}
		userInput.close();
	}
}
