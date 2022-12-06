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
		int movieInput, input_int, adminInput;
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

				input_int = sc.nextInt();

				switch (input_int) {
					case 1:
						c.checkData();
						c.create();
						c.storeInfo();
						break;

					case 2:
						c.checkData();
						c.login();
						flag = true;
						while(flag) {
							System.out.println(
									"\n\n--------------------------Customer Menu-----------------------------------");
							System.out.println(
									"\n1. Browse Upcoming Movies \n2. Browse Current Movies \n3. Leave a review\n4. Log Out\nChoose Option: ");
							movieInput = sc.nextInt();
							switch (movieInput) {
								case 1:
									m.browseUpcoming();
									break;
								case 2:
									m.browseCurrent("Buy");
									break;
								case 3:
									m.browseCurrent("Review");
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
						"\n\n--------------------------Welcome to Admin's Portal-----------------------------------");
				System.out.println("\n1.Create Account \n2.Login  \n3.Exit \nChoose Option: ");
				input_int = sc.nextInt();
				switch (input_int) {
					case 1:
						a.checkData();
						a.create();
						a.storeInfo();
						break;

					case 2:
						a.checkData();
						a.login();
						flag = true;
						while(flag) {
							System.out.println(
									"--------------------------Welcome to Admin Menu-----------------------------------");
							System.out.println("1. View Current Movies\\n2. View Upcoming Movies\n3. Add movies \n4. Remove movies\n5. Add showtimes\n6. Remove showtimes\n7. Log Out\nChoose Option");
							adminInput = sc.nextInt();
							switch(adminInput) {
								case 1:
									m.browseCurrent("Admin");
									break;
								case 2:
									m.browseUpcoming();
									break;
								case 3:
									ac.addShows();
									break;
								case 4:
									ac.removeShows();
									break;
								case 5:
									ac.addShowtimes();
									break;
								case 6:
									ac.removeShowtimes();
									break;
								case 7: 
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
		sc.close();
		
	}
}
