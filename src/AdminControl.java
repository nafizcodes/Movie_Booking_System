import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

public class AdminControl {
	ManageMovies manageShows = new ManageMovies();
	ManageShowtimes manageShowtimes = new ManageShowtimes();
	public void addShows() throws FileNotFoundException, IOException, ParseException {
		manageShows.addShows();
	}
	public void removeShows() throws FileNotFoundException, IOException, ParseException {
		manageShows.removeShows();
	}
	private void addShowtimes() throws FileNotFoundException, IOException, ParseException {
		manageShowtimes.addShowtimes();
	}
	private void removeShowtimes() throws FileNotFoundException, IOException, ParseException {
		manageShowtimes.removeShowtimes();
	}
}
