package libraryManagementSystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class RatingImporter {
	
	public static ArrayList<Rating> readRatingData(Library library) 
	{
		String fileName = "BXBookRatings.csv";
		//String fileName = "BXBookRatings_Complete.csv";
		
		File fileFromDataReading = new File(fileName);
		
		FileReader fr = null;
		
		if(!fileFromDataReading.exists())
		{
			System.out.println("FAILED: " + fileName + " FILE does not exist");
			return null;	
		}
		
		try
		{		
			fr = new FileReader(fileFromDataReading);	
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		BufferedReader br = new BufferedReader(fr);

		ArrayList<Rating> ratingList = new ArrayList<>();
			
 	    try 
 	    {
 	    	int foundCount = 0;
 	    	int notFoundCount = 0;
 	    	
 	    	String str = null;
		    while((str = br.readLine()) != null)
		    {	
			    str = str.replace('"', ' ');
			    String[] arr = str.split(";");		
 
			    Book currentBook = library.getBookByID(String.valueOf(arr[1].trim()));
			    

			    
			    
			    if (currentBook == null)
			    {
			    	notFoundCount++;
			    	continue;
			    } 
			    else
			    {
			    	foundCount++;
			    }

			    String userId = String.valueOf(arr[0]).replace(':', ' ').trim();
			    int rating = Integer.valueOf(arr[2].trim());
			    
			    Rating ratingObj = new Rating(userId, rating, currentBook);
			    
			    currentBook.addRating(ratingObj);
			    
			    
			    
			    
			    ratingList.add(ratingObj);
	    	}

		    System.out.println("+++ Found book count : " + foundCount);
		    System.out.println("--- Not Found book count : " + notFoundCount);
		    
	    }
    	catch (IOException e)
 	    {
	    	e.printStackTrace();
	    }
 	    
 	    try
 	    {
 	    	br.close();
			fr.close();
		}
 	    catch (IOException e) 
 	    {
 	    	e.printStackTrace();
		}
		
		return ratingList;
	}
 

}
