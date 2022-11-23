import java.util.ArrayList;

public abstract class Movie {
	
	protected String title;
	protected String synopsis;
	protected ArrayList<String> reviews;
	protected ArrayList<String> castinfo;
	
	public Movie(String tit, String synop, ArrayList<String> revs, ArrayList<String> cast) {
		title = tit;
		synopsis = synop;
		reviews = revs;
		castinfo = cast;
	}

}