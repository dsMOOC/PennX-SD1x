package movie;

import java.util.*;

public class Movie implements Comparable<Movie> {
	private String movieName;
	private ArrayList<Actor> actorList;
	private double rating;
	
	public Movie(String movieName) {
		this.movieName = movieName;
		this.rating = 0.0;
		actorList = new ArrayList<>();
	}
	
	public Movie() {
		this("");
	}
	

	/**
	 * @return the movieName
	 */
	public String getMovieName() {
		return movieName;
	}

	/**
	 * @param movieName the movieName to set
	 */
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	/**
	 * @return the actorList
	 */
	public ArrayList<Actor> getActorList() {
		return actorList;
	}

	/**
	 * @param actorList the actorList to set
	 */
	public void setActorList(ArrayList<Actor> actorList) {
		this.actorList = actorList;
	}

	/**
	 * @return the rating
	 */
	public double getRating() {
		return rating;
	}

	/**
	 * @param rating the rating to set
	 */
	public void setRating(double rating) {
		this.rating = rating;
	}
	
	public boolean equals(Object object) {
		return ((Movie) object).getMovieName().equals(movieName);
	}
	
	public String toString() {
		return movieName + " Rating: " + rating;
	}
	
	@Override
	public int compareTo(Movie o) {
		if(rating>o.getRating()) {
			return 1;
		} else if (rating<o.getRating()) {
			return -1;
		} else {
			return 0;
		}
	}
}
