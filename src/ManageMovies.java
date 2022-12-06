import java.io.*;
import java.util.*;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ManageMovies{
	String key, title, status, numberOfSeats, synopsis, runtime, prices;
	boolean flag = true;
	String choice = "";
	@SuppressWarnings("unchecked")
	public void addShows() throws FileNotFoundException, IOException, ParseException {
		String[] showtimes = new String[10]; 
		String[] theater = new String[10]; 
		String[] reviews = new String[10]; 
		String[] castInfo = new String[10]; 
		Scanner sc = new Scanner(System.in);
		System.out.println("What movie would you like to add?");
		title = sc.nextLine();
		System.out.println("Current or Upcoming?");
		status = sc.nextLine();
		int i = 0;
		while(flag) {
			System.out.println("Enter showtimes (type exit to stop)");
			choice = sc.nextLine();
			switch(choice) {
					case "exit":
						flag = false;
					default:
						showtimes[i] = choice;
						i++;
			}
		}
		flag = true;
		int j = 0;
		while(flag) {
			System.out.println("Add theaters (type exit when finished)");
			choice = sc.nextLine();
			switch(choice) {
				case "exit":
					flag = false;
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
			System.out.println("Add cast information (type exit when finished)");
			choice = sc.nextLine();
			switch(choice) {
				case "exit": 
					flag = false;
				default:
					castInfo[n] = choice;
					n++;
			}
		}
		
		//JSON formatter and printing to file
		JSONParser parser = new JSONParser();
	    JSONObject jsonObject = (JSONObject) parser.parse(new FileReader("Src/movies.json"));
	    JSONArray jsonArray = (JSONArray) jsonObject.get(status);
	    JSONObject finalObject = new JSONObject();
	    int key = jsonArray.size();
	    if(status == "Current") {
	    	status = "Upcoming";
	    }else {
	    	status = "Current";
	    }
	    finalObject.put(status, jsonObject.get(status));
	    if(status == "Current") {
	    	status = "Upcoming";
	    }else {
	    	status = "Current";
	    }
		JSONObject newObject = new JSONObject();
		newObject.put("title", title);	
		newObject.put("status", status);
		JSONArray showtime = new JSONArray();
		int z = 0;
		while(z < i - 1) {
			showtime.add(showtimes[z]);
			z++;
		}
		newObject.put("showtimes", showtime);
		JSONArray theaters = new JSONArray();
		z = 0;
		while(z < j - 1) {
			theaters.add(theater[z]);
			z++;
		}
		newObject.put("theater", theaters);
		newObject.put("numberOfSeats", numberOfSeats);
		newObject.put("synopsis", synopsis);
		newObject.put("runtime", runtime);
		newObject.put("prices", prices);
		JSONArray review = new JSONArray();
		z = 0;
		while(z < k - 1) {
			review.add(reviews[z]);
			z++;
		}
		newObject.put("reviews", review);
		JSONArray castInfos = new JSONArray();
		z = 0;
		while(z < n - 1) {
			castInfos.add(castInfo[z]);
			z++;
		}
		newObject.put("castInfo", castInfos);
		
		jsonArray.add(newObject);
		finalObject.put(status, jsonArray);
		FileWriter fileToWrite = new FileWriter("src/movies.json", false);
		try {
			fileToWrite.write(finalObject.toJSONString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		fileToWrite.flush();
		fileToWrite.close();
		System.out.println("Movie information added to database");
	}
	@SuppressWarnings("unchecked")
	public void removeShows() throws FileNotFoundException, IOException, ParseException{
		Scanner sc = new Scanner(System.in);
		System.out.println("What is the movie key you'd like to remove?");
		key = sc.nextLine();
		System.out.println("What is the current status of the movie?");
		status = sc.nextLine();
		JSONParser parser = new JSONParser();
	    JSONObject jsonObject = (JSONObject) parser.parse(new FileReader("src/movies.json"));
	    JSONArray jsonArray = (JSONArray) jsonObject.get(status);
	    JSONArray temp = new JSONArray();
	    JSONObject finalObject = new JSONObject();
	    if(status == "Current") {
	    	status = "Upcoming";
	    }else {
	    	status = "Current";
	    }
	    finalObject.put(status, jsonObject.get(status));
	    if(status == "Current") {
	    	status = "Upcoming";
	    }else {
	    	status = "Current";
	    }
	    Iterator currentIterator = jsonArray.iterator();
		while(currentIterator.hasNext()) {
			JSONObject movies = (JSONObject) currentIterator.next();
			String movie = (String) movies.get("title");
			if(movie.equals(title)) {
				continue;
			}else {
				temp.add(movies);
			}
		}
		finalObject.put(status, temp);
		FileWriter fileToWrite = new FileWriter("src/movies.json", false);
		try {
			fileToWrite.write(finalObject.toJSONString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		fileToWrite.flush();
		fileToWrite.close();
		System.out.println("Movie removed from catalog");
	}
}