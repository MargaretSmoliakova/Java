
import java.util.Scanner;
import java.lang.Math;
import static java.lang.Math.PI;

class homework1 {
	public static void main (String[] args) {
		
		double squareArea, circleArea, diameter, diagonal;
		
		Scanner userInput = new Scanner(System.in);
				
		System.out.print("Please input circle's area: ");
		circleArea = userInput.nextFloat();
		
		System.out.print("Please input square's area: ");
		squareArea = userInput.nextFloat();
		
		diameter = 2*Math.sqrt(circleArea/PI);		
		diagonal = Math.sqrt(squareArea*2.0);
				
		System.out.print("\n\nIs the square could be located in the sphere?\n");
		
		if (diagonal > diameter) System.out.print("It is impossible...");
		else System.out.print("It is possible!!!");
		
		userInput.close();
	}
}
