import java.io.*;
import java.util.*;
import org.json.simple.*;
import org.json.simple.parser.*;

public class ReviewMovie {
    public void createNewReview() {
        System.out.println("\nPlease Enter the movie key you would like to review: ");

        Scanner sc = new Scanner(System.in);
        String input_movie = sc.next();
        
        System.out.println("Please write your review below (click enter when done)");
        String userReview = sc.nextLine();

        JSONParser parser = new JSONParser();
        try {
    	    JSONObject jsonObject = (JSONObject) parser.parse(new FileReader("Src/movies.json"));
    	    JSONArray jsonArray = (JSONArray) jsonObject.get("Current");
    	    JSONArray temp = new JSONArray();
    	    JSONObject finalObject = new JSONObject();
    	    finalObject.put("Upcoming", jsonObject.get("Upcoming"));
    		for(int i = 0; i < jsonArray.size(); i++) {
    			JSONObject movies = (JSONObject) jsonArray.get(i);
    			JSONObject movie = (JSONObject) movies.get("title");
    			JSONObject key = (JSONObject) movies.get("key");
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
    			key.writeJSONString(out);
    			String movieTitle = out.toString();
    			if(input_movie.equals(key)) {
    				tempFinal.put("key" , key);
    				tempFinal.put("title", movie);
    				tempFinal.put("theaters", theaters);
    				tempFinal.put("numberOfSeats", numberOfSeats);
    				tempFinal.put("synopsis", synopsis);
    				tempFinal.put("runtime", runtime);
    				tempFinal.put("price", price);
    				review.add(userReview);
    				tempFinal.put("review", review);
    				tempFinal.put("castInfo", castInfo);
    				tempFinal.put("showtimes", showtimesTemp);
    				temp.add(tempFinal);
    				temp.add(movies);
    			}else {
    				temp.add(movies);
    			}
    		}
    		finalObject.put("Current", temp);
    		FileWriter fileToWrite = new FileWriter("src/movies.json", false);
    		try {
    			fileToWrite.write(finalObject.toJSONString());
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    		fileToWrite.close();
    		System.out.println("Review Added");
    		sc.close();
        } catch (Exception e) {
            throw new IllegalArgumentException("Problem on reading JSON: ", e);
        }
    }
}