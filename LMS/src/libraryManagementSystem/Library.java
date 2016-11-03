package libraryManagementSystem;

import java.util.ArrayList;

import libraryManagementSystem.Book;
import libraryManagementSystem.DataImporter;



public class Library
{

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