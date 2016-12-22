package libraryManagementSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ItemBasedCFAnalyzeEngine 
{
	private Library library;
	
	public static final int MAX_RATING = 2;
	public static final int MIN_RATING = 1;
	
	public ItemBasedCFAnalyzeEngine(Library library)
	{
		this.library = library;
	}
	
	
	public ArrayList<Book> getRecommendedBooksFor(Book queryBook, int requestedBookCount)
	{ 
		ArrayList<Book> recommendationCandidates = new ArrayList<Book>();
		
		System.out.println("Rating count : " + queryBook.getRatings().size());

		// Iterate for every point for a book
		for (int currentRatingPoint=MIN_RATING; currentRatingPoint<=MAX_RATING; currentRatingPoint++)
		{
			ArrayList<String> userIdsWhoRatedSamePointForABook = new ArrayList<String>();
			for (Rating currentRatingObj : queryBook.getRatings())
			{
				if (currentRatingObj.getRating() == currentRatingPoint) // only currently iterating ratingPoint
				{
					userIdsWhoRatedSamePointForABook.add(currentRatingObj.getUserId());
				}
			}

			System.out.println(currentRatingPoint + " - userIdsWhoRatedSamePointForABook : " + userIdsWhoRatedSamePointForABook.size() );
			
			int i=0;
			
			for (String tempUserId : userIdsWhoRatedSamePointForABook)
			{ 
				i++;
				
				if (i % 20 == 0)
				{
					System.out.println("Loop : " + i);
				    System.out.println( "recommendationCandidates : " + recommendationCandidates.size() );
				}
				// Get the other books which are rated same point by these users
				ArrayList<Book> tempList = getTheOtherBooksWhichAreRatedSamePointByUser(queryBook, tempUserId, currentRatingPoint);
				if (tempList != null && tempList.size() != 0)
				{
					recommendationCandidates.addAll(tempList);
				}
			} 
		}

		
		Map<String, Integer> occurrencehash = new HashMap<String, Integer>();
		
		for (Book tempBook : recommendationCandidates)
		{
			if (occurrencehash.get(tempBook.getIsbn()) == null)
			{
				occurrencehash.put(tempBook.getIsbn(), 1);
			}
			else
			{
				occurrencehash.put(tempBook.getIsbn(), occurrencehash.get(tempBook.getIsbn()) + 1);
			}
		}
		
		ArrayList<Book> recommendedBooks = new ArrayList<Book>();
		for (int i=0; i<requestedBookCount; i++)
		{
			int max = 0;
			Book maxBook = null;
			
			for (Book tempBook : recommendationCandidates)
			{
				if (occurrencehash.get(tempBook.getIsbn()) != null)
				{
					if (occurrencehash.get(tempBook.getIsbn()) > max)
					{
						max = occurrencehash.get(tempBook.getIsbn());
						maxBook = tempBook;
					} 
				} 
			}
			
			 
			if (maxBook != null)
			{
				occurrencehash.put(maxBook.getIsbn(), 0);
				recommendedBooks.add(maxBook);
			}
		} 
		
		System.out.println("Recommended Book count : " + recommendedBooks.size());
		
		return recommendedBooks;
	}
	
	
	private ArrayList<Book> getTheOtherBooksWhichAreRatedSamePointByUser(Book bookToExclude, String userId, int rating)
	{
		
		/*if (userId == "262407" && rating == 2)
		{
			System.out.println("trueeeee");
		}*/
		
		 ArrayList<Book> bookList = new ArrayList<Book>();
		 
		 for (Rating currentRating : library.getRatingList())
		 {
			 if (currentRating.getUserId() == userId )
			 {
				 //System.out.println("BookName " + currentRating.getBook().getTitle());
				 if (currentRating.getRating() == rating )
				 {
					 if (bookToExclude.getIsbn() != currentRating.getBook().getIsbn())
					 {
						 bookList.add(currentRating.getBook());
					 }
				 } 
			 }
			 
		 }
		 
		 return bookList;
	}
	
}
