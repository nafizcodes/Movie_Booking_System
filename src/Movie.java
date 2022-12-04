import java.util.ArrayList;

public abstract class Movie {

	protected String title;
	protected String status; // current or upcoming
	protected ArrayList<String> showtimes;
	protected ArrayList<String> theaters;
	protected String numberOfSeats;
	protected String synopsis;
	protected String runtime;
	protected String prices;
	protected ArrayList<String> reviews;
	protected ArrayList<String> castInfo;

	// Constructor
	public Movie(String title, String status, ArrayList<String> showtimes, ArrayList<String> theaters,
			String numberOfSeats, String synopsis, String runtime, String prices, ArrayList<String> reviews,
			ArrayList<String> castInfo) {
		this.title = title;
		this.status = status;
		this.showtimes = showtimes;
		this.theaters = theaters;
		this.numberOfSeats = numberOfSeats;
		this.synopsis = synopsis;
		this.runtime = runtime;
		this.prices = prices;
		this.reviews = reviews;
		this.castInfo = castInfo;
	}

	// Getters & Setters
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ArrayList<String> getShowtimes() {
		return this.showtimes;
	}

	public void setShowtime(ArrayList<String> showtimes) {
		this.showtimes = showtimes;
	}

	public ArrayList<String> getTheaters() {
		return this.theaters;
	}

	public void setTheaters(ArrayList<String> theaters) {
		this.theaters = theaters;
	}

	public String getNumberOfSeats() {
		return this.numberOfSeats;
	}

	public void setNumberOfSeats(String numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public String getSynopsis() {
		return this.synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public String getRuntime() {
		return this.runtime;
	}

	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}

	public String getPrices() {
		return this.prices;
	}

	public void setPrices(String prices) {
		this.prices = prices;
	}

	public ArrayList<String> getReviews() {
		return this.reviews;
	}

	public void setReviews(ArrayList<String> reviews) {
		this.reviews = reviews;
	}

	public ArrayList<String> getCastInfo() {
		return this.castInfo;
	}

	public void setCastInfo(ArrayList<String> castInfo) {
		this.castInfo = castInfo;
	}

	@Override
	public String toString() {
		return "\nTitle: " + title +
				"\nStatus:" + status +
				"\nShowtimes: " + showtimes +
				"\nTheaters: " + theaters +
				"\nNumber of seats: " + numberOfSeats +
				"\nSynopsis: " + synopsis +
				"\nRuntime: " + runtime +
				"\nPrices: " + prices +
				"\nReviews: " + reviews +
				"\nMovie cast: " + castInfo;
	}

}