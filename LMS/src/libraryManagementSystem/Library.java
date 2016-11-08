package libraryManagementSystem;

import java.util.ArrayList;

import libraryManagementSystem.Book;
import libraryManagementSystem.DataImporter;


public class Library
{
	private ArrayList<Book> bookList;
	private DataImporter dataImporter;

    public Library() {
		super();
		this.bookList = new ArrayList<Book>();
		this.dataImporter = new DataImporter();
		this.initialise();
	}

	private void initialise() {
		this.bookList = DataImporter.creatingData();
	}

	/**
	 * @return bookList
	 */
	public ArrayList<Book> getBookList() {
		return bookList;
	}

	/**
	 * @param bookList
	 */
	public void setBookList(ArrayList<Book> bookList) {
		this.bookList = bookList;
	}

	/**
	 * @return dataImporter
	 */
	public DataImporter getDataImporter() {
		return dataImporter;
	}

	/**
	 * @param dataImporter
	 */
	public void setDataImporter(DataImporter dataImporter) {
		this.dataImporter = dataImporter;
	}

	/**
	 * @brief simple search according to title
	 * @param titleName
	 * @return resultBookList
	 */
	public ArrayList<Book> simpleSearch(String titleName)
    {
        if (titleName.isEmpty())
        {
            return null;
        }
        ArrayList<Book> resultBookList = new ArrayList<>();

        for (int i = 0; i < bookList.size(); i++)
        {
            if (bookList.get(i).getTitle().toLowerCase().contains(titleName.toLowerCase()))
            {
                resultBookList.add(bookList.get(i));
            }
        }
        return resultBookList;
    }
	
	/**
	 * @brief simple search according to year
	 * @param searchedyear
	 * @return resultBookList
	 */
	public ArrayList<Book> searchAccordingToYear(int searchedYear)
	{
		ArrayList<Book> resultBookList = new ArrayList<>();
		
		for (int i = 0; i < bookList.size(); i++)
		{
			if (bookList.get(i).getYear() == searchedYear)
			{
				resultBookList.add(bookList.get(i));
			}
		}
		return resultBookList;
		
	}
	
	/**
	 * @brief simple search according to author
	 * @param authorName
	 * @return resultBookList
	 */
	public ArrayList<Book> searchedAccordingToAuthor(String authorName)
	{
		if (authorName.isEmpty())
		{
			return null;
		}
		
		ArrayList<Book> resultBookList = new ArrayList<>();
		
		for (int i = 0; i < bookList.size(); i++)
		{
			if (bookList.get(i).getAuthor().toLowerCase().contains(authorName.toLowerCase()))
			{
				resultBookList.add(bookList.get(i));
			}
		}
		return resultBookList;
	}
	
	/**
	 * @brief simple search according to title, author, year, publisher
	 * @param titleName, authorName, year, publisherName
	 * @return resultBookList
	 */
	public ArrayList<Book> advancedSearch(String titleName, String authorName, int year, String publisherName)
	{
		if (titleName.isEmpty() || authorName.isEmpty() || year == 0)
		{
			return null;
		}
		
		ArrayList<Book> resultBookList = new ArrayList<>();
		
		for (int i = 0; i < bookList.size(); i++)
		{
			if (bookList.get(i).getTitle().toLowerCase().contains(titleName.toLowerCase()) && 
				bookList.get(i).getAuthor().toLowerCase().contains(authorName.toLowerCase()) &&
				bookList.get(i).getPublishing_house().toLowerCase().contains(publisherName.toLowerCase()) &&
				bookList.get(i).getYear() == year)
			{
				resultBookList.add(bookList.get(i));
			}
		}
		return resultBookList;
		
	}
}