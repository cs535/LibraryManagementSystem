package libraryManagementSystem;

import java.util.ArrayList;

import libraryManagementSystem.Book;
import libraryManagementSystem.DataImporter;

/*
 * Class Library
 * */
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
	 * @param searchedString
	 * @return resultBookList
	 */
	public ArrayList<Book> search(String searchedString)
    {
        if (searchedString.isEmpty())
        {
            return null;
        }
        ArrayList<Book> bookList = new ArrayList<>(DataImporter.creatingData()); //booklist library e eklendiği zaman kaldırılacak library'nin booklisti kullanılacak.
        ArrayList<Book> resultBookList = new ArrayList<>();

        for (int i = 0; i < bookList.size(); i++)
        {
            if (bookList.get(i).getTitle().toLowerCase().contains(searchedString.toLowerCase()))
            {
                resultBookList.add(bookList.get(i));
            }
        }
        return resultBookList;
    }
}