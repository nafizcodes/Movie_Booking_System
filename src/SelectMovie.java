import java.io.*;
import java.util.*;
import org.json.simple.*;
import org.json.simple.parser.*;

public class SelectMovie {
    public void selectMovie() {
    	boolean flag = true;
        System.out.println("\nPlease Enter the movie key you would like to see: ");
        Scanner sc = new Scanner(System.in);
        String input_movie = sc.nextLine();

        Random rand = new Random();
        boolean found = false;
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("src/movies.json"));
            JSONObject jsonObject = (JSONObject) obj;

            JSONArray current = (JSONArray) jsonObject.get("Current");
            Iterator currentIterator = current.iterator();

            while (currentIterator.hasNext()) {

                JSONObject movie = (JSONObject) currentIterator.next();
                String title = (String) movie.get("title");

                if (input_movie.equals(title)) {
                    // print title
                    System.out.println("\nTitle: " + title);
                    found = true;
                    // print showtimes
                    JSONArray showtimes = (JSONArray) movie.get("showtimes");
                    System.out.println("\nShowtimes:");
                    Iterator showtimesIterator = showtimes.iterator();
                    while (showtimesIterator.hasNext()) {
                        System.out.println("- " + showtimesIterator.next());
                    }

                    // print prices
                    String prices = (String) movie.get("prices");
                    System.out.println("\nPrice: " + prices);
                    //Take theaterLocation as input
                    System.out.println("Please enter the theater location");
                    String theaterLocation = sc.nextLine();
                    // ask user to select showtime of the movie
                    System.out.println("Please select your showtime");
                    String input_showtime = sc.nextLine();

                    // ask user to select showtime of the movie
                    int tickets = 0;
                    while(flag) {
	                    System.out.println("Please select the number of tickets you would like to purchase (Max 10):");
	                    tickets = sc.nextInt();
	                    if(tickets > 10) {
	                    	System.out.println("Maximum tickets is 10. Please try again.");
	                    }else {
	                    	flag = false;
	                    }
                    }
                    System.out.println("\t\t\t\t\t\t\t Payment Processing....");
                    
                    int price = Integer.parseInt(prices);
                    System.out.println("You have purchased " + tickets + " tickets for $" + (tickets * price) + " at the " + theaterLocation + " location.");

                    // generate random ticket number
                    
                    int n = 0;
                    System.out.println("Your ticket numbers are:");
                    while (n < tickets) {
                    	int randomTicketNumber = rand.nextInt(100);
                    	System.out.println("#"+ (n+1) +" ticket number is " +  randomTicketNumber);
                    n += 1;
                    }break;
                }
            }
            
            
           if (found == false) {
        	   System.out.println("Movie not found");
           }
        } catch (Exception e) {
            throw new IllegalArgumentException("Problem on reading JSON: ", e);
        }
    }
}