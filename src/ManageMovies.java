import java.util.*;
//import org.json.simple.*;
public class ManageMovies{
	String title, status, numberOfSeats, synopsis, runtime, prices;
	String[] showtimes, theater, reviews, castInfo;
	int i = 0;
	boolean flag = true;
	String choice;
	public void addShows() {
		Scanner sc = new Scanner(System.in);
		System.out.println("What movie would you like to add?");
		title = sc.nextLine();
		System.out.println("Current or Upcoming?");
		status = sc.nextLine();
		System.out.println("Add showtimes? Yes or No");
		choice = sc.nextLine();
		if(choice == "Yes") {
			while(flag) {
				System.out.println("Enter showtime or type exit to stop");
				choice = sc.nextLine();
				if(choice == "exit") {
					flag = false;
				}else {
					showtimes[i] = choice;
					i++;
				}
			}
		}
		flag = true;
		i = 0;
		while(flag) {
			System.out.println("Add theaters (type exit when finished)");
			choice = sc.nextLine();
			if(choice == "exit") {
				flag = false;
			}else {
				theater[i] = choice;
				i++;
			}
		}
		System.out.println("Add number of seats");
		numberOfSeats = sc.nextLine();
		System.out.println("Add synopsis");
		synopsis = sc.nextLine();
		System.out.println("Add runtime");
		runtime = sc.nextLine();
		System.out.println("Add price");
		prices = sc.nextLine();
		flag = true;
		i = 0;
		while(flag) {
			System.out.println("Add reviews (type exit when finished)");
			choice = sc.nextLine();
			if(choice == "exit") {
				flag = false;
			}else {
				reviews[i] = choice;
				i++;
			}
		}
		flag = true;
		i = 0;
		while(flag) {
			System.out.println("Add cast information (type exit when finished");
			choice = sc.nextLine();
			if(choice == "exit") {
				flag = false;
			}else {
				castInfo[i] = choice;
				i++;
			}
		}
		//Push info into file;
		System.out.println("All finished");
		sc.close();
	}
	public void removeShows() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Would movie would you like to remove?");
		title = sc.nextLine();
		// Remove from file here
		System.out.println("Movie removed from catalog");
		sc.close();
	}
	
}