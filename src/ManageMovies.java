import java.io.*;
import java.util.*;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
public class ManageMovies{
	String title, status, numberOfSeats, synopsis, runtime, prices;
	String[] showtimes, theater, reviews, castInfo;
	boolean flag = true;
	String choice;
	@SuppressWarnings("unchecked")
	public void addShows() throws FileNotFoundException, IOException, ParseException {
		Scanner sc = new Scanner(System.in);
		System.out.println("What movie would you like to add?");
		title = sc.nextLine();
		System.out.println("Current or Upcoming?");
		status = sc.nextLine();
		System.out.println("Add showtimes? Yes or No");
		choice = sc.nextLine();
		int i = 0;
		switch(choice) {
			case "Yes", "yes": 
				while(flag) {
					System.out.println("Enter showtime or type exit to stop");
					choice = sc.nextLine();
					switch(choice) {
							case "exit":
								flag = false;
							default:
								showtimes[i] = choice;
								i++;
					}
				}
			default:
				break;
		}
		flag = true;
		int j = 0;
		while(flag) {
			System.out.println("Add theaters (type exit when finished)");
			choice = sc.nextLine();
			switch(choice) {
				case "exit":
					flag = false;
					System.out.println("Working");
				default:
					theater[j] = choice;
					j++;
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
		int k = 0;
		while(flag) {
			System.out.println("Add reviews (type exit when finished)");
			choice = sc.nextLine();
			switch(choice) {
				case "exit":
					flag = false;
				default:
					reviews[k] = choice;
					k++;
			}
		}
		flag = true;
		int n = 0;
		while(flag) {
			System.out.println("Add cast information (type exit when finished");
			choice = sc.nextLine();
			switch(choice) {
				case "exit": 
					flag = false;
				default:
					castInfo[n] = choice;
					n++;
			}
		}
		JSONParser parser = new JSONParser();
	    Object obj = parser.parse(new FileReader("src/movies.json"));
	    JSONObject jsonObject = (JSONObject) obj;
	    JSONArray jsonArray = (JSONArray) jsonObject.get(status);
		JSONObject newObject = new JSONObject();
		newObject.put("title", title);	
		JSONArray showtime = new JSONArray();
		int z = 0;
		while(z < i) {
			showtime.add(showtimes[z]);
			z++;
		}
		newObject.put("showtimes", showtime);
		JSONArray theaters = new JSONArray();
		z = 0;
		while(z < j) {
			theaters.add(theater[z]);
			z++;
		}
		newObject.put("theater", theaters);
		newObject.put("numberOfSeats", numberOfSeats);
		newObject.put("synopsis", synopsis);
		newObject.put("runtime", runtime);
		newObject.put("price", prices);
		JSONArray review = new JSONArray();
		z = 0;
		while(z < k) {
			review.add(reviews[z]);
			z++;
		}
		newObject.put("reviews", review);
		JSONArray castInfos = new JSONArray();
		z = 0;
		while(z < n) {
			castInfos.add(castInfo[z]);
			z++;
		}
		newObject.put("castInfo", castInfos);
		jsonArray.add(newObject);
		jsonObject.put(status, jsonArray);
		FileWriter fileToWrite = new FileWriter("src/movies.json", false);
		try {
			fileToWrite.write(jsonObject.toJSONString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		fileToWrite.close();
		System.out.println(jsonObject);
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