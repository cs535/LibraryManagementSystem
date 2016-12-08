package libraryManagementSystem;

import java.util.ArrayList;
import libraryManagementSystem.Book;
import libraryManagementSystem.DataImporter;


public class Library
{
	private ArrayList<Book> bookList;
	private DataImporter dataImporter;

    public Library() 
    {
		super();
		this.bookList = new ArrayList<Book>();
		this.dataImporter = new DataImporter();
		this.initialise();
	}
    
    public Library(ArrayList<Book> bookList)
    {
    	this.bookList = bookList;
    }

	private void initialise() 
	{
		String fileName = "BXBooks.csv";
		this.bookList = DataImporter.creatingData(fileName);
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
}