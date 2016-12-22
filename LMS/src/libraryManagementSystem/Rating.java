package libraryManagementSystem;

public class Rating {

	private String userId; 
	private int ratingP;
	private Book book;
	
	public Rating(String userId, int rating, Book book)
	{
		this.userId = userId;
		
		if (rating < 5)
		{
			this.ratingP = 1;
		}
		else 
		{
			this.ratingP = 2;
		}
		
		
		
		this.book = book;	
	}
	
	public String getUserId() {
		return userId;
	}  
	
	public int getRating() {
		return ratingP;
	} 
	
	public Book getBook()
	{
		return this.book;
	}
}
