package movie;

// Import the Scanner class to read text files
import java.util.*;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors

public class MovieDatabase {
	private ArrayList<Movie> movieList;
	private ArrayList<Actor> actorList;
	
	//constructor with empty values
	public MovieDatabase() {
		movieList = new ArrayList<>();
		actorList = new ArrayList<>();
	}
	/**
	 * @return the movieList
	 */
	public ArrayList<Movie> getMovieList() {
		return this.movieList;
	}

	/**
	 * @return the actorList
	 */
	public ArrayList<Actor> getActorList() {
		return this.actorList;
	}

	
	public void addMovie(String name, String[] actors) {
		Movie m = new Movie(name);
		if(movieList.contains(m)) {
			System.out.println("the movie exists in the database. no action needed.");
		}
		else {
			movieList.add(m);
			for(String actor:actors) {
				Actor a = new Actor(actor);
				if(actorList.contains(a)) {
					a = actorList.get(actorList.indexOf(a));
				}
				else {
					actorList.add(a);
				}
				
				m.getActorList().add(a);
				a.getMovieList().add(m);
				
				
			}
		}
	}
	
	public void addRating(String name, double rating) {
		Movie m = new Movie(name);
		if (movieList.indexOf(m)!=-1) {
			movieList.get(movieList.indexOf(m)).setRating(rating);
		}
	}
	
	public void updateRating(String name, double newRating) {
		Movie m = new Movie(name);
		movieList.get(movieList.indexOf(m)).setRating(newRating);
	}
	
	public String getBestActor() {
		Collections.sort(actorList);
		return actorList.get(actorList.size()-1).getActorName();
	}
	
	public String getBestMovie() {
		Collections.sort(movieList);
		return movieList.get(movieList.size()-1).getMovieName();
	}
	
	public static void main(String[] args) throws FileNotFoundException {  
		MovieDatabase mdb = new MovieDatabase();
		
		//File moviefile = new File("/Users/oh_jason_zhang/eclipse-workspace/movieDatabase/src/movie/movies.txt");
		Map<String, List<String>> movies = new HashMap<>();
		Scanner sc = new Scanner(new File("movies.txt"));
        while(sc.hasNextLine()) {
        	String[] actors = sc.nextLine().split(", ");
        	for (int i = 1; i < actors.length; i++) {
        		if (!movies.containsKey(actors[i])) {
        			movies.put(actors[i], new ArrayList<String>());
        		}
        		movies.get(actors[i]).add(actors[0]);
        	}
        }
        for (String movie : movies.keySet()) {
        	List<String> actors = movies.get(movie);
        	mdb.addMovie(movie, actors.toArray(new String[actors.size()]));
        }

        
        /*
		 * Read ratings
		 */
        sc = new Scanner(new File("ratings.txt"));
        sc.nextLine(); // skip header
        while(sc.hasNextLine()){
        	String[] ratings = sc.nextLine().split("\t");
        	mdb.addRating(ratings[0], Double.parseDouble(ratings[1]));
        }

//		mdb.printDatabase();
		System.out.println("Best movie: " + mdb.getBestMovie());
		System.out.println("Best actor: " + mdb.getBestActor());
	}
}
