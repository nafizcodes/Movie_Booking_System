import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
//import org.json.simple.*;
public class ManageShowtimes {
	String userInput, status;
	boolean flag = true;
	@SuppressWarnings("unchecked")
	public void addShowtimes() throws FileNotFoundException, IOException, ParseException {
		Scanner tempScan = new Scanner(System.in);
		String[] showtime = new String[10];
		System.out.println("What is the name of the movie for which you'd like to add showtimes");
		userInput = tempScan.nextLine();
		System.out.println("Is the movie current or upcoming?");
		status = tempScan.nextLine();
		int n = 0;
		while(flag) {
			System.out.println("Please enter the showtimes you'd like to create (type exit when finished)");
			userInput = tempScan.nextLine();
			switch(userInput) {
				case "exit":
					flag = false;
				default:
					showtime[n] = userInput;
					n++;
			}
		}
		JSONParser parser = new JSONParser();
	    JSONObject jsonObject = (JSONObject) parser.parse(new FileReader("Src/movies.json"));
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
			String movie = (String ) movies.get("title");
			String key = (String) movies.get("key");
			JSONArray showtimes = (JSONArray) movies.get("showtimes");
			JSONArray theaters = (JSONArray) movies.get("theaters");
			String  numberOfSeats = (String ) movies.get("numberOfSeats");
			String  synopsis = (String ) movies.get("synopsis");
			String  runtime = (String ) movies.get("runtime");
			String  price = (String ) movies.get("price");
			JSONArray review = (JSONArray) movies.get("reviews");
			JSONArray castInfo = (JSONArray) movies.get("castInfo");
			JSONObject tempFinal = new JSONObject();
			JSONArray showtimesTemp = new JSONArray();
			if(userInput.equals(movie)) {
				tempFinal.put("title", movie);
				tempFinal.put("key" , key);
				tempFinal.put("theaters", theaters);
				tempFinal.put("numberOfSeats", numberOfSeats);
				tempFinal.put("synopsis", synopsis);
				tempFinal.put("runtime", runtime);
				tempFinal.put("price", price);
				tempFinal.put("review", review);
				tempFinal.put("castInfo", castInfo);
				for(int j = 0; j < n; j++){
					showtimes.add(showtime[j]);
				}
				tempFinal.put("showtimes", showtimesTemp);
				temp.add(tempFinal);
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
		fileToWrite.close();
		System.out.println("Showtimes Added");  
		tempScan.close();
	}
	@SuppressWarnings("unchecked")
	public void removeShowtimes() throws FileNotFoundException, IOException, ParseException {
		Scanner tempScan = new Scanner(System.in);
		String[] showtime = new String[10];
		System.out.println("What is the name of the movie for which you'd like to remove showtimes");
		userInput = tempScan.nextLine();
		System.out.println("Is the movie current or upcoming?");
		status = tempScan.nextLine();
		int n = 0;
		while(flag) {
			System.out.println("Please enter the showtimes you'd like to remove (type exit when finished)");
			userInput = tempScan.nextLine();
			switch(userInput) {
				case "exit":
					flag = false;
				default:
					showtime[n] = userInput;
					n++;
			}
		}
		JSONParser parser = new JSONParser();
	    JSONObject jsonObject = (JSONObject) parser.parse(new FileReader("Src/movies.json"));
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
			String  movie = (String ) movies.get("title");
			String key = (String) movies.get("key");
			JSONArray showtimes = (JSONArray) movies.get("showtimes");
			JSONArray theaters = (JSONArray) movies.get("theaters");
			String  numberOfSeats = (String) movies.get("numberOfSeats");
			String  synopsis = (String) movies.get("synopsis");
			String  runtime = (String) movies.get("runtime");
			String  price = (String) movies.get("price");
			JSONArray review = (JSONArray) movies.get("reviews");
			JSONArray castInfo = (JSONArray) movies.get("castInfo");
			JSONObject tempFinal = new JSONObject();
			JSONArray showtimesTemp = new JSONArray();
			if(userInput.equals(movie)) {
				tempFinal.put("key" , key);
				tempFinal.put("title", movie);
				tempFinal.put("theaters", theaters);
				tempFinal.put("numberOfSeats", numberOfSeats);
				tempFinal.put("synopsis", synopsis);
				tempFinal.put("runtime", runtime);
				tempFinal.put("price", price);
				tempFinal.put("review", review);
				tempFinal.put("castInfo", castInfo);
				for(int j = 0; j < showtimes.size(); j++) {
					for(int m = 0; m < n; m++) {
						JSONObject tempShow = (JSONObject) showtimes.get(j);
						StringWriter outString = new StringWriter();
						tempShow.writeJSONString(outString);
						String showtimeRemove = outString.toString();
						if(showtimeRemove != showtime[m]) {
							showtimesTemp.add(showtimeRemove);
						}
					}
				}
				tempFinal.put("showtimes", showtimesTemp);
				temp.add(tempFinal);
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
		fileToWrite.close();
		System.out.println("Showtimes removed from database");
		tempScan.close();
	}
}
