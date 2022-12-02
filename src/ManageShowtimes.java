import java.util.*;
//import org.json.simple.*;
public class ManageShowtimes {
	Scanner sc = new Scanner(System.in);
	String userInput, status, showtime;
	boolean flag = true;
	public void addShowtimes() {
		System.out.println("What is the name of the movie for which you'd like to add showtimes");
		userInput = sc.nextLine();
		System.out.println("Is the movie current or upcoming?");
		status = sc.nextLine();
		while(flag) {
			System.out.println("Please enter the showtimes you'd like to create (type exit when finished)");
			userInput = sc.nextLine();
			if(userInput == "exit") {
				flag = false;
			}else {
				showtime = userInput;
			}
		}
	}
	public void removeShowtimes() {
		System.out.println("What is the name of the movie for which you'd like to remove showtimes");
		userInput = sc.nextLine();
		System.out.println("Is the movie current or upcoming?");
		status = sc.nextLine();
		while(flag) {
			System.out.println("Please enter the showtimes you'd like to remove (type exit when finished)");
			userInput = sc.nextLine();
			if(userInput == "exit") {
				flag = false;
			}else {
				showtime = userInput;
			}
		}
	}
}
