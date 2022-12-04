import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import org.json.simple.parser.ParseException;

public class Main {
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		Scanner sc = new Scanner(System.in);
		CustomerDriver c = new CustomerDriver();
		AdminDriver a = new AdminDriver();
		MovieDriver m = new MovieDriver();
		AdminControl ac = new AdminControl();

		boolean notexit = true, flag = true;
		int input = 0;
		String choice;

		System.out.print("\n\n");
		System.out.println("Welcome to Movie Booking System ");
		System.out.println(
				"\n*****Choose the User Type*****\nIf you are a Customer, Press(c)\nIf you are Admin, Press(a) \n Option: ");
		choice = sc.nextLine();

		while (notexit) {

			if (choice.equals("c")) {
				System.out.println(
						"--------------------------Welcome to Customer's Portal-----------------------------------");
				System.out.println("\n\n1.Create Account \n2.Login  \n3.Exit \nChoose Option: ");

				int input_int = sc.nextInt();

				switch (input_int) {
					case 1:
						c.create();
						break;

					case 2:
						c.login();
						flag = true;
						while(flag) {
							System.out.println(
									"\n\n1.Browse Upcoming Movies \n2.Browse Current Movies \n3.Return to previous menu\n4. Leave a review \nChoose Option: ");
	
							int movieInput = sc.nextInt();
	
							switch (movieInput) {
								case 1:
									m.browseUpcoming();
									break;
								case 2:
									m.browseCurrent();
									break;
								case 3:
									m.leaveReview();
									break;
								case 4:
									flag = false;
									break;
							}
						}
						break;

					case 3:
						System.out.println("Terminating from the program!");
						notexit = false;
						break;

					default:
						break;
				}
			}

			if (choice.equals("a")) {
				System.out.println(
						"--------------------------Welcome to Admin's Portal-----------------------------------");
				System.out.println("\n\n1.Create Account \n2.Login  \n3.Exit \nChoose Option: ");
				int input_int = sc.nextInt();
				//
				switch (input_int) {
					case 1:
						a.create();
						break;

					case 2:
						a.login();
						while(flag) {
							System.out.println("\n1. Add movies \n2. Remove movies\n3. Add showtimes\n4. Remove showtimes\n5. Return to previous menu\nChoose Option");
							int adminInput = sc.nextInt();
							switch(adminInput) {
								case 1:
									ac.addShows();
								case 2:
									ac.removeShows();
								case 3:
									ac.addShowtimes();
								case 4:
									ac.removeShowtimes();
								case 5: 
									flag = false;
									break;
							}
						}
						break;
						

					case 3:
						System.out.println("Terminating from the program!");
						notexit = false;
						break;

					default:
						break;

				}
			}
			
		}
		
	}
}
