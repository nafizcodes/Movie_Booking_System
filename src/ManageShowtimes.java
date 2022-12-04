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
	Scanner sc = new Scanner(System.in);
	String userInput, status;
	boolean flag = true;
	@SuppressWarnings("unchecked")
	public void addShowtimes() throws FileNotFoundException, IOException, ParseException {
		String[] showtime = new String[10];
		System.out.println("What is the name of the movie for which you'd like to add showtimes");
		userInput = sc.nextLine();
		System.out.println("Is the movie current or upcoming?");
		status = sc.nextLine();
		int n = 0;
		while(flag) {
			System.out.println("Please enter the showtimes you'd like to create (type exit when finished)");
			userInput = sc.nextLine();
			if(userInput == "exit") {
				flag = false;
			}else {
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
		for(int i = 0; i < jsonArray.size(); i++) {
			JSONObject movies = (JSONObject) jsonArray.get(i);
			JSONObject movie = (JSONObject) movies.get("title");
			JSONArray showtimes = (JSONArray) movies.get("showtimes");
			JSONArray theaters = (JSONArray) movies.get("theaters");
			JSONObject numberOfSeats = (JSONObject) movies.get("numberOfSeats");
			JSONObject synopsis = (JSONObject) movies.get("synopsis");
			JSONObject runtime = (JSONObject) movies.get("runtime");
			JSONObject price = (JSONObject) movies.get("price");
			JSONArray review = (JSONArray) movies.get("reviews");
			JSONArray castInfo = (JSONArray) movies.get("castInfo");
			JSONObject tempFinal = new JSONObject();
			JSONArray showtimesTemp = new JSONArray();
			StringWriter out = new StringWriter();
			movie.writeJSONString(out);
			String movieTitle = out.toString();
			if(userInput.equals(movieTitle)) {
				tempFinal.put("title", movie);
				tempFinal.put("theaters", theaters);
				tempFinal.put("numberOfSeats", numberOfSeats);
				tempFinal.put("synopsis", synopsis);
				tempFinal.put("runtime", runtime);
				tempFinal.put("price", price);
				tempFinal.put("review", review);
				tempFinal.put("castInfo", castInfo);
				for(int j = 0; i < n; i++){
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
		System.out.println("Movie removed from catalog");
		sc.close();
	    
	}
	@SuppressWarnings("unchecked")
	public void removeShowtimes() throws FileNotFoundException, IOException, ParseException {
		String[] showtime = new String[10];
		System.out.println("What is the name of the movie for which you'd like to remove showtimes");
		userInput = sc.nextLine();
		System.out.println("Is the movie current or upcoming?");
		status = sc.nextLine();
		int n = 0;
		while(flag) {
			System.out.println("Please enter the showtimes you'd like to remove (type exit when finished)");
			userInput = sc.nextLine();
			if(userInput == "exit") {
				flag = false;
			}else {
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
		for(int i = 0; i < jsonArray.size(); i++) {
			JSONObject movies = (JSONObject) jsonArray.get(i);
			JSONObject movie = (JSONObject) movies.get("title");
			JSONArray showtimes = (JSONArray) movies.get("showtimes");
			JSONArray theaters = (JSONArray) movies.get("theaters");
			JSONObject numberOfSeats = (JSONObject) movies.get("numberOfSeats");
			JSONObject synopsis = (JSONObject) movies.get("synopsis");
			JSONObject runtime = (JSONObject) movies.get("runtime");
			JSONObject price = (JSONObject) movies.get("price");
			JSONArray review = (JSONArray) movies.get("reviews");
			JSONArray castInfo = (JSONArray) movies.get("castInfo");
			JSONObject tempFinal = new JSONObject();
			JSONArray showtimesTemp = new JSONArray();
			StringWriter out = new StringWriter();
			movie.writeJSONString(out);
			String movieTitle = out.toString();
			if(userInput.equals(movieTitle)) {
				tempFinal.put("title", movie);
				tempFinal.put("theaters", theaters);
				tempFinal.put("numberOfSeats", numberOfSeats);
				tempFinal.put("synopsis", synopsis);
				tempFinal.put("runtime", runtime);
				tempFinal.put("price", price);
				tempFinal.put("review", review);
				tempFinal.put("castInfo", castInfo);
				for(int j = 0; i < showtimes.size(); j++) {
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
		System.out.println("Movie removed from catalog");
		sc.close();
		
	}
}
