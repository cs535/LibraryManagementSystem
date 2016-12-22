package libraryManagementSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import libraryManagementSystem.Book;
import libraryManagementSystem.DataImporter;


public class Library
{
	private ArrayList<Book> bookList;
	private DataImporter dataImporter;
	private ArrayList<Rating> ratingList;
	private HashMap<String, Book> bookMap;
	private ItemBasedCFAnalyzeEngine recommendationEngine;

    public Library(String filename) 
    {
		super();
		this.bookList = new ArrayList<Book>();
		this.dataImporter = new DataImporter();
		this.bookMap = new HashMap<String, Book>(); 
		this.recommendationEngine = new ItemBasedCFAnalyzeEngine(this);
		this.initialise(filename);
	}
    
    public Library(ArrayList<Book> bookList)
    {
    	this.bookList = bookList;
    }

	private void initialise(String fileName) 
	{
//		fileName = "/home/songulab/workspace/Books3.csv";
		//String fileName = "BXBooks_Complete.csv";
		this.bookList = DataImporter.creatingData(fileName);
		
		for (int i=0; i<this.bookList.size(); i++)
		{
			this.bookMap.put(this.bookList.get(i).getIsbn(), this.bookList.get(i));
		}

		this.ratingList = RatingImporter.readRatingData(this);
	}

	public ArrayList<Rating> getRatingList()
	{
		return this.ratingList;
	}
	
	/**
	 * @return bookList
	 */
	public ArrayList<Book> getBookList() 
	{
		return bookList;
	}

	/**
	 * @param bookList
	 */
	public void setBookList(ArrayList<Book> bookList) 
	{
		this.bookList = bookList;
	}
	
	
	public Book getBookByID(String bookID)
	{ 
		return this.bookMap.get(bookID);
	}

	/**
	 * @return dataImporter
	 */
	public DataImporter getDataImporter()
	{
		return dataImporter;
	}

	/**
	 * @param dataImporter
	 */
	public void setDataImporter(DataImporter dataImporter) 
	{
		this.dataImporter = dataImporter;
	}
	
	/**
	 * @brief simple search according to title, author, year, publisher
	 * @param titleName, authorName, year, publisherName
	 * @return resultBookList
	 */
	public ArrayList<Book> advancedSearch(String titleName, String authorName, String year, String publisherName, String isbnNumber)
	{
		if (titleName.isEmpty() && authorName.isEmpty() && publisherName.isEmpty() && year.isEmpty())
		{
			return bookList;
		}
		
		ArrayList<Book> resultBookList = new ArrayList<>();
		
		for (int i = 0; i < bookList.size(); i++)
		{
			if (bookList.get(i).getTitle().toLowerCase().contains(titleName.toLowerCase()) && 
					bookList.get(i).getAuthor().toLowerCase().contains(authorName.toLowerCase()) &&
					bookList.get(i).getPublishing_house().toLowerCase().contains(publisherName.toLowerCase()) &&
					bookList.get(i).getYear().toLowerCase().contains(year.toLowerCase()))
				{
				resultBookList.add(bookList.get(i));
			}
		}
		return resultBookList;
	}
	
	/**
	 * @brief returns library's booklist's size
	 * @return size
	 */
	public int getSize()
	{
		return bookList.size();
	}
	
	public ArrayList<Book> getRecommendedBooksFor(Book queryBook)
	{
		return this.recommendationEngine.getRecommendedBooksFor(queryBook, 5);
	}
}