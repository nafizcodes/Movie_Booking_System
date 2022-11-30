public class AdminControl {
	ManageMovies manageShows = new ManageMovies();
	ManageShowtimes manageShowtimes = new ManageShowtimes();
	public void addShows() {
		manageShows.addShows();
	}
	public void removeShows() {
		manageShows.removeShows();
	}
	private void addShowtimes() {
		manageShowtimes.addShowtimes();
	}
	private void removeShowtimes() {
		manageShowtimes.removeShowtimes();
	}
}
