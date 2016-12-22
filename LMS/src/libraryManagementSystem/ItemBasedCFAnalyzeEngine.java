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

		// Iterate for every point for a book
		for (int currentRatingPoint=MIN_RATING; currentRatingPoint<=MAX_RATING; currentRatingPoint++)
		{
			ArrayList<String> userIdsWhoRatedSamePointForABook = new ArrayList<String>();
			System.out.println("Book ratings count : " + queryBook.getRatings().size());
			for (Rating currentRatingObj : queryBook.getRatings())
			{
				if (currentRatingObj.getRating() == currentRatingPoint) // only currently iterating ratingPoint
				{
					userIdsWhoRatedSamePointForABook.add(currentRatingObj.getUserId());
				}
			}

			//System.out.println(currentRatingPoint + " - userIdsWhoRatedSamePointForABook : " + userIdsWhoRatedSamePointForABook.size() );
			
			for (String tempUserId : userIdsWhoRatedSamePointForABook)
			{ 
				// Get the other books which are rated same point by these users
				ArrayList<Book> tempList = getTheOtherBooksWhichAreRatedSamePointByUser(queryBook, tempUserId, currentRatingPoint);
				if (tempList != null && tempList.size() != 0)
				{
					recommendationCandidates.addAll(tempList);
				}
			} 
		} 
		
		ArrayList<Book> topRecommendedBooks = getTopRecommendedBooks(recommendationCandidates, requestedBookCount);

		return topRecommendedBooks;
	}  
	
	private ArrayList<Book> getTopRecommendedBooks(ArrayList<Book> recommendationCandidates, int requestedBookCount)
	{
		Map<String, Integer> occurrencehash = constructOccurencesHash(recommendationCandidates);
		
		ArrayList<Book> recommendedBooks = new ArrayList<Book>();

		System.out.println("=====================================================");
		System.out.println("Recommended book: ");
		
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
				System.out.println("(" + occurrencehash.get(maxBook.getIsbn()) + ") " + maxBook.getTitle());
				
				occurrencehash.put(maxBook.getIsbn(), 0);
				recommendedBooks.add(maxBook);
			}
		}  
		System.out.println("=====================================================");	
		
		return recommendedBooks;
	}
	
	private Map<String, Integer> constructOccurencesHash(ArrayList<Book> recommendationCandidates)
	{
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
		
		return occurrencehash;
	}
	
	private ArrayList<Book> getTheOtherBooksWhichAreRatedSamePointByUser(Book bookToExclude, String userId, int rating)
	{ 
		 ArrayList<Book> bookList = new ArrayList<Book>(); 
		 ArrayList<Rating> rList = library.getRatingList(); 
		 
		 for (int i=0; i<rList.size(); i++)
		 { 
			 if (rList.get(i).getUserId().equals(userId))
			 {  
				 if (rList.get(i).getRating() == rating)
				 { 
					 if (!bookToExclude.getIsbn().equals(rList.get(i).getBook().getIsbn()))
					 { 
						 bookList.add(rList.get(i).getBook());
					 }
				 } 
			 } 
		 }
		 
		 return bookList;
	}
}
