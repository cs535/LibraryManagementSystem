package libraryManagementSystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class RatingImporter {
	
	public static ArrayList<Rating> createRatingData() 
	{
		int i = 0;
		String fileName = "BXBookRatings.csv";
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
 	    	String str = null;
		    while((str = br.readLine()) != null)
		    {	
		    	Rating r = new Rating();
			    str = str.replace('"', ' ');
			    String[] arr = str.split(";");			    
			    r.setUserId(String.valueOf(arr[0]).replace(':', ' '));
			    r.setMovieId(String.valueOf(arr[1]));
			    r.setRating(Integer.valueOf(arr[2]));
			    ratingList.add(r);
			    i++;
	    	}
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
		
 	    createTestData(i);
		return ratingList;
	}
	
	public static ArrayList<Rating> createTestData(int n) 
	{
		int i = 0;
		String fileName = "BXBookRatings.csv";
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

		ArrayList<Rating> testList = new ArrayList<>();
			
 	    try 
 	    {
 	    	String str = null;
		    while((str = br.readLine()) != null && i <= n/5)
		    {	
		    	Rating r = new Rating();
			    str = str.replace('"', ' ');
			    String[] arr = str.split(";");			    
			    r.setUserId(String.valueOf(arr[0]).replace(':', ' '));
			    r.setMovieId(String.valueOf(arr[1]));
			    r.setRating(Integer.valueOf(arr[2]));
			    testList.add(r);
			    i++;
	    	}
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
		 
		return testList;
	}

}
