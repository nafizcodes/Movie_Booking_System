import java.io.*;
import java.util.*;
import org.json.simple.*;
import org.json.simple.parser.*;

public class ReviewMovie {
    public void createNewReview() {
    	boolean flag = false;
        System.out.println("\nPlease Enter the movie key you would like to review: ");

        Scanner sc = new Scanner(System.in);
        String input_movie = sc.nextLine();
        
        System.out.println("Please write your review below (click enter when done)");
        String userReview = sc.nextLine();

        JSONParser parser = new JSONParser();
        try {
    	    JSONObject jsonObject = (JSONObject) parser.parse(new FileReader("Src/movies.json"));
    	    JSONArray jsonArray = (JSONArray) jsonObject.get("Current");
    	    JSONArray temp = new JSONArray();
    	    JSONObject finalObject = new JSONObject();
    	    finalObject.put("Upcoming", jsonObject.get("Upcoming"));
    	    Iterator currentIterator = jsonArray.iterator();
    		while(currentIterator.hasNext()) {
    			JSONObject movies = (JSONObject) currentIterator.next();
    			String movie = (String) movies.get("title");
    			String key = (String) movies.get("key");
    			JSONArray showtimes = (JSONArray) movies.get("showtimes");
    			JSONArray theaters = (JSONArray) movies.get("theaters");
    			String numberOfSeats = (String) movies.get("numberOfSeats");
    			String synopsis = (String) movies.get("synopsis");
    			String runtime = (String) movies.get("runtime");
    			String price = (String) movies.get("price");
    			JSONArray review = (JSONArray) movies.get("reviews");
    			JSONArray castInfo = (JSONArray) movies.get("castInfo");
    			JSONObject tempFinal = new JSONObject();
    			JSONArray showtimesTemp = new JSONArray();
    			if(input_movie.equals(key)) {
    				tempFinal.put("key" , key);
    				tempFinal.put("title", movie);
    				tempFinal.put("theaters", theaters);
    				tempFinal.put("numberOfSeats", numberOfSeats);
    				tempFinal.put("synopsis", synopsis);
    				tempFinal.put("runtime", runtime);
    				tempFinal.put("price", price);
    				tempFinal.put("showtimes", showtimes);
    				review.add(userReview);
    				tempFinal.put("review", review);
    				tempFinal.put("castInfo", castInfo);
    				tempFinal.put("showtimes", showtimesTemp);
    				temp.add(tempFinal);
    				temp.add(movies);
    				flag = true;
    			}else {
    				temp.add(movies);
    			}
    		}
    		finalObject.put("Current", temp);
    		StringWriter out = new StringWriter();
    		finalObject.writeJSONString(out);
    		String output = out.toString();
    		FileWriter fileToWrite = new FileWriter("src/movies.json", false);
    		try {
    			fileToWrite.write(finalObject.toJSONString());
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    		fileToWrite.flush();
    		fileToWrite.close();
    		if(flag == true) {
    			System.out.println("Review Added");
    		}else {
    			System.out.println("Movie key not found. Please try again");
    		}
        } catch (Exception e) {
            throw new IllegalArgumentException("Problem on reading JSON: ", e);
        }
    }
}