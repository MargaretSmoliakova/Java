
import java.util.Scanner;

class homework6 {
	
	public static void main (String[] args) {
		
		Scanner userInput = new Scanner(System.in);
		
		int userDay, userMonth, userYear;
		
		System.out.println("Please enter your date: ");
		System.out.print("the day is ");
		userDay = userInput.nextInt();
		System.out.print("the month is ");
		userMonth = userInput.nextInt();
		System.out.print("the year is ");
		userYear = userInput.nextInt();
		
		if (userDay < 1 || userDay > 31 ||
			userMonth < 1 || userMonth > 12 ||
			userYear < 0) System.out.println("Error! You entered incorrect information! Please be careful!");
		else if (userMonth == 2 && userDay > 29 ||
				(userMonth == 4 || userMonth == 6 || userMonth == 9 || userMonth == 11) && userDay > 30) System.out.println("Error! You entered incorrect day! Please be careful!");
		else {
			switch (userDay) {
				case 31:
						if(userMonth == 12) {
							userDay = 1;
							userMonth = 1;
							userYear++;							
						} else {
						userDay = 1;
						userMonth++;
						}
						break;
				case 30:
						if(userMonth == 4 || userMonth == 6 || userMonth == 9 || userMonth == 11) {
							userDay = 1;
							userMonth++;
						} else {
							userDay++;
						}
						break;
				case 29:
						if(userYear%4 == 0 || userYear%100 == 0 && userYear%500 == 0) {
							userDay = 1;
							userMonth++;
						} else System.out.print("Entered year is not leap... Thus entered date does not exist...");
						break;
				case 28:
						if(userYear%4 == 0 || userYear%100 == 0 && userYear%500 == 0) userDay++;
						else {
							userDay = 1;
							userMonth++;
						}
						break;
				default:
						userDay++;
						break;
			}
			
			System.out.println("User's date is: " + userDay + "." + userMonth + "." + userYear);
		}
		
		userInput.close();
	}
}