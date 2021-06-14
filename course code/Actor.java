package movie;

import java.util.*;


public class Actor implements Comparable<Actor>{
	private String actorName;
	private ArrayList<Movie> movieList;
	
	public Actor(String actorName) {
		this.actorName = actorName;
		movieList = new ArrayList<>();
	}
	
	public Actor() {
		this("");
	}
	
	public Actor(String actorName, ArrayList<Movie> movieList) {
		this.actorName = actorName;
		this.movieList = movieList;
	}

	/**
	 * @return the actorName
	 */
	public String getActorName() {
		return actorName;
	}

	/**
	 * @param actorName the actorName to set
	 */
	public void setActorName(String actorName) {
		this.actorName = actorName;
	}

	/**
	 * @return the movieList
	 */
	public ArrayList<Movie> getMovieList() {
		return movieList;
	}

	/**
	 * @param movieList the movieList to set
	 */
	public void setMovieList(ArrayList<Movie> movieList) {
		this.movieList = movieList;
	}
	
	public boolean equals(Object object) {
		return ((Actor) object).getActorName().equals(actorName);
	}
	
	public String toString() {
		return actorName + " average rating: " + getActorRating();
	}
	
	public double getActorRating() {
		double ratingSum = 0;
		for (Movie movie : movieList) {
			ratingSum += movie.getRating();
		}
		return ratingSum / movieList.size();
	}
	
	@Override
	public int compareTo(Actor o) {
		// TODO Auto-generated method stub
		Double rating = getActorRating();
		if (rating > o.getActorRating()) {
			return 1;
		} else if (rating < o.getActorRating()) {
			return -1;
		} else {
			return 0;
		}
	}
}
