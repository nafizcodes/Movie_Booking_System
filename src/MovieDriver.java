import java.io.*;
import java.util.*;
import org.json.simple.*;
import org.json.simple.parser.*;

public class MovieDriver {

    Scanner sc = new Scanner(System.in);
    JSONParser parser = new JSONParser();

    public void browseUpcoming() {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("src/movies.json"));
            JSONObject jsonObject = (JSONObject) obj;

            JSONArray upcoming = (JSONArray) jsonObject.get("Upcoming");

            System.out.println("\n--------------------Upcoming Movies-----------------------");
            Iterator upcomingIterator = upcoming.iterator();

            while (upcomingIterator.hasNext()) {
                System.out.println();

                // use "movie" to get the objects from JSON file
                JSONObject movie = (JSONObject) upcomingIterator.next();

                System.out.println(
                        "***************************************************************************************");
                        
                // print movie #
                String key = (String) movie.get("key");
                System.out.println("Movie #" + key);

                // print title
                String title = (String) movie.get("title");
                System.out.println("\nTitle: " + title);

                // print status
                String status = (String) movie.get("status");
                System.out.println("\nStatus: " + status);

                // print showtimes
                JSONArray showtimes = (JSONArray) movie.get("showtimes");
                System.out.println("\nShowtimes:");
                Iterator showtimesIterator = showtimes.iterator();
                while (showtimesIterator.hasNext()) {
                    System.out.println("- " + showtimesIterator.next());
                }

                // print theaters
                JSONArray theater = (JSONArray) movie.get("theater");
                System.out.println("\nTheater:");
                Iterator theaterIterator = theater.iterator();
                while (theaterIterator.hasNext()) {
                    System.out.println("- " + theaterIterator.next());
                }

                // print number of seats
                String numberOfSeats = (String) movie.get("numberOfSeats");
                System.out.println("\nNumber of seats: " + numberOfSeats);

                // print synopsis
                String synopsis = (String) movie.get("synopsis");
                System.out.println("\nSynopsis: " + synopsis);

                // print runtime
                String runtime = (String) movie.get("runtime");
                System.out.println("\nRuntime: " + runtime);

                // print prices
                String prices = (String) movie.get("prices");
                System.out.println("\nPrice: " + prices);

                // print reviews
                JSONArray reviews = (JSONArray) movie.get("reviews");
                System.out.println("\nReviews:");
                Iterator reviewsIterator = reviews.iterator();
                while (reviewsIterator.hasNext()) {
                    System.out.println("- " + reviewsIterator.next());
                }

                // print cast info
                JSONArray castInfo = (JSONArray) movie.get("castInfo");
                System.out.println("\nCast info:");
                Iterator castInfoIterator = castInfo.iterator();
                while (castInfoIterator.hasNext()) {
                    System.out.println("- " + castInfoIterator.next());
                }
            }

        } catch (Exception e) {
            throw new IllegalArgumentException("Problem on reading JSON: " , e);
        }
    }

    public void browseCurrent() {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("src/movies.json"));
            JSONObject jsonObject = (JSONObject) obj;
            SelectMovie sm = new SelectMovie();
            JSONArray current = (JSONArray) jsonObject.get("Current");

            System.out.println("\n--------------------Current Movies-----------------------");
            Iterator currentIterator = current.iterator();

            while (currentIterator.hasNext()) {
                System.out.println();
                
                // use "movie" to get the objects from JSON file
                JSONObject movie = (JSONObject) currentIterator.next();

                System.out.println(
                        "***************************************************************************************");
                        
                // print movie #
                String key = (String) movie.get("key");
                System.out.println("Movie #" + key);

                // print title
                String title = (String) movie.get("title");
                System.out.println("\nTitle: " + title);

                // print status
                String status = (String) movie.get("status");
                System.out.println("\nStatus: " + status);

                // print showtimes
                JSONArray showtimes = (JSONArray) movie.get("showtimes");
                System.out.println("\nShowtimes:");
                Iterator showtimesIterator = showtimes.iterator();
                while (showtimesIterator.hasNext()) {
                    System.out.println("- " + showtimesIterator.next());
                }
                
                // print theaters
                JSONArray theater = (JSONArray) movie.get("theater");
                System.out.println("\nTheater:");
                Iterator theaterIterator = theater.iterator();
                while (theaterIterator.hasNext()) {
                    System.out.println("- " + theaterIterator.next());
                }

                // print number of seats
                String numberOfSeats = (String) movie.get("numberOfSeats");
                System.out.println("\nNumber of seats: " + numberOfSeats);

                // print synopsis
                String synopsis = (String) movie.get("synopsis");
                System.out.println("\nSynopsis: " + synopsis);

                // print runtime
                String runtime = (String) movie.get("runtime");
                System.out.println("\nRuntime: " + runtime);

                // print prices
                String prices = (String) movie.get("prices");
                System.out.println("\nPrice: " + prices);

                // print reviews
                JSONArray reviews = (JSONArray) movie.get("reviews");
                System.out.println("\nReviews:");
                Iterator reviewsIterator = reviews.iterator();
                while (reviewsIterator.hasNext()) {
                    System.out.println("- " + reviewsIterator.next());
                }

                // print cast info
                JSONArray castInfo = (JSONArray) movie.get("castInfo");
                System.out.println("\nCast info:");
                Iterator castInfoIterator = castInfo.iterator();
                while (castInfoIterator.hasNext()) {
                    System.out.println("- " + castInfoIterator.next());
                }
            }
            sm.selectMovie();
        } catch (Exception e) {
            throw new IllegalArgumentException("Problem on reading JSON: " , e);
        }
    }
}