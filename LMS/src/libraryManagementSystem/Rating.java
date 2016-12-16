package libraryManagementSystem;

public class Rating {

	private String userId;
	private String bookId;
	private int rating;
	
	public Rating(){}
	
	public String getUserId() {
		return userId;
	}

	public String getMBookId() {
		return bookId;
	}

	public int getRating() {
		return rating;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
}
