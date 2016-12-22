package libraryManagementSystem;

public class Rating {

	private String userId; 
	private int ratingP;
	private Book book;
	
	/**
	 * @param userId
	 * @param ratingP
	 * @param book
	 */
	
	//constructor
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
	
	/**
	 * @return userId
	 */
	public String getUserId() {
		return userId;
	}  
	
	/**
	 * @return ratingP
	 */
	public int getRating() {
		return ratingP;
	} 
	
	/**
	 * @return book
	 */
	public Book getBook()
	{
		return this.book;
	}
	
	public String toString()
	{
		return "bookISBN : " + book.getIsbn() + "\n" + 
				"ratingP : " + ratingP + "\n"+
				"userId : " + userId + "\n";
	}
	
}
