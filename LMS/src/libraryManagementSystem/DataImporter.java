package libraryManagementSystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import libraryManagementSystem.Book;

public class DataImporter {

	public static ArrayList<Book> creatingData(String fileName) {
		
		File fileFromDataReading = new File(fileName);
		
		FileReader fr = null;
		
		if(!fileFromDataReading.exists()){
			
			System.out.println("FAILED: " + fileName + " FILE does not exist");
			return null;	
		}
		
		try {		
			fr = new FileReader(fileFromDataReading);	
		} 
		
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		BufferedReader br = new BufferedReader(fr);
			 
		ArrayList<Book> bookList = new ArrayList<>();
		
 	    try {
 	    	String str = null;
		    while((str = br.readLine()) != null)
		    {	
			    Book b = new Book();
			    str = str.replace('"', ':');
			    String[] arr = str.split(":;:");			    
			    b.setIsbn(String.valueOf(arr[0]).replace(':', ' '));
			    b.setTitle(String.valueOf(arr[1]));
			    b.setAuthor(String.valueOf(arr[2]));
			    b.setYear(String.valueOf(arr[3]));
			    b.setPublishing_house(String.valueOf(arr[4]));
			    b.setImage(String.valueOf(arr[6]));
			    bookList.add(b);
	    	}
	    } 	
    	catch (IOException e) {
	    	e.printStackTrace();
	    }

		
		 try {
		     br.close();
			 fr.close();
		 } 
		 
		 catch (IOException e) {
			e.printStackTrace();
		 }
		 
		return bookList;
	}
}
