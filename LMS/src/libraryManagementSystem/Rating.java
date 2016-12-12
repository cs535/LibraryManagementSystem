package libraryManagementSystem;

public class Rating {

	private String userId;
	private String movieId;
	private int rating;
	
	public Rating(){}
	
	public String getUserId() {
		return userId;
	}

	public String getMovieId() {
		return movieId;
	}

	public int getRating() {
		return rating;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
}
