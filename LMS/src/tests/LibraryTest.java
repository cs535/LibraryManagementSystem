package tests;

import libraryManagementSystem.Book;
import java.lang.annotation.Target;
import java.util.ArrayList;

import org.junit.*;

import junit.framework.TestCase;

import libraryManagementSystem.Library;

public class LibraryTest extends TestCase {

	private Library library;

	public LibraryTest() {
		super();
		ArrayList<Book> bookList = new ArrayList<Book>();
		bookList.add(new Book("isbn1", "title1", "author1", "1", "house1", ""));
		bookList.add(new Book("isbn2", "title1", "author2", "2", "house3", ""));
		bookList.add(new Book("isbn2", "title1", "author3", "2", "house1", ""));
		bookList.add(new Book("isbn3", "title2", "author1", "1", "house1", ""));
		bookList.add(new Book("isbn4", "title3", "author1", "3", "house2", ""));
		bookList.add(new Book("isbn5", "title3", "author3", "3", "house4", ""));
		this.library = new Library(bookList);
	}
	
	public void testTitleSearch(){
		ArrayList<Book> resultList = library.advancedSearch("title1", "", "", "", "");
		assertEquals(resultList.size(), 3);
		for ( Book result : resultList)
		{
			assertEquals(result.getTitle(), "title1");
		}
		resultList = library.advancedSearch("title4", "", "", "", "");
		assertEquals(resultList.size(), 0);
	}
	
	public void testAuthorSearch(){
		ArrayList<Book> resultList = library.advancedSearch("", "author1", "", "", "");
		assertEquals(resultList.size(), 3);
		for ( Book result : resultList)
		{
			assertEquals(result.getAuthor(), "author1");
		}
		resultList = library.advancedSearch("", "author4", "", "", "");
		assertEquals(resultList.size(), 0);
		}
	
	public void testYearSearch(){
		ArrayList<Book> resultList = library.advancedSearch("", "", "3", "", "");
		assertEquals(resultList.size(), 2);
		for ( Book result : resultList)
		{
			assertEquals(result.getYear(), "3");
		}
		resultList = library.advancedSearch("", "", "4", "", "");
		assertEquals(resultList.size(), 0);
	}
	
	public void testPublishHouseSearch(){
		ArrayList<Book> resultList = library.advancedSearch("", "", "", "house3", "");
		assertEquals(resultList.size(), 1);
		for ( Book result : resultList)
		{
			assertEquals(result.getPublishing_house(), "house3");
		}
		resultList = library.advancedSearch("", "", "", "house5", "");
		assertEquals(resultList.size(), 0);
	}
	
	public void testTitleAndAuthorSearch(){
		ArrayList<Book> resultList = library.advancedSearch("title1", "author1", "", "", "");
		assertEquals(resultList.size(), 1);
		for ( Book result : resultList)
		{
			assertEquals(result.getTitle(), "title1");
			assertEquals(result.getAuthor(), "author1");
		}
		resultList = library.advancedSearch("title2", "author2", "", "", "");
		assertEquals(resultList.size(), 0);
	}
	
	public void testTitleAndYearSearch(){
		ArrayList<Book> resultList = library.advancedSearch("title1", "", "2", "", "");
		assertEquals(resultList.size(), 2);
		for ( Book result : resultList)
		{
			assertEquals(result.getTitle(), "title1");
			assertEquals(result.getYear(), "2");
		}
		resultList = library.advancedSearch("title1", "", "3", "", "");
		assertEquals(resultList.size(), 0);
	}
	
	public void testTitleAndHouseSearch(){
		ArrayList<Book> resultList = library.advancedSearch("title1", "", "", "house1", "");
		assertEquals(resultList.size(), 2);
		for ( Book result : resultList)
		{
			assertEquals(result.getTitle(), "title1");
			assertEquals(result.getPublishing_house(), "house1");
		}
		resultList = library.advancedSearch("title1", "", "", "house2", "");
		assertEquals(resultList.size(), 0);
	}
	
	public void testAuthorAndYearSearch(){
		ArrayList<Book> resultList = library.advancedSearch("", "author1", "1", "", "");
		assertEquals(resultList.size(), 2);
		for ( Book result : resultList)
		{
			assertEquals(result.getAuthor(), "author1");
			assertEquals(result.getYear(), "1");
		}
		resultList = library.advancedSearch("", "author1", "2", "", "");
		assertEquals(resultList.size(), 0);
		}
	
	public void testAuthorAndHouseSearch(){
		ArrayList<Book> resultList = library.advancedSearch("", "author1", "", "house1", "");
		assertEquals(resultList.size(), 2);
		for ( Book result : resultList)
		{
			assertEquals(result.getAuthor(), "author1");
			assertEquals(result.getPublishing_house(), "house1");
		}
		resultList = library.advancedSearch("", "author1", "", "house3", "");
		assertEquals(resultList.size(), 0);
		}
	
	public void testYearAndHouseSearch(){
		ArrayList<Book> resultList = library.advancedSearch("", "", "1", "house1", "");
		assertEquals(resultList.size(), 2);
		for ( Book result : resultList)
		{
			assertEquals(result.getYear(), "1");
			assertEquals(result.getPublishing_house(), "house1");
		}
		resultList = library.advancedSearch("", "", "1", "house3", "");
		assertEquals(resultList.size(), 0);
	}
	
	public void testTitleAndAuthorAndYearSearch(){
		ArrayList<Book> resultList = library.advancedSearch("title1", "author1", "1", "", "");
		assertEquals(resultList.size(), 1);
		for ( Book result : resultList)
		{
			assertEquals(result.getTitle(), "title1");
			assertEquals(result.getAuthor(), "author1");
			assertEquals(result.getYear(), "1");
		}
		resultList = library.advancedSearch("title1", "author1", "2", "", "");
		assertEquals(resultList.size(), 0);
	}
	
	public void testTitleAndAuthorAndHouseSearch(){
		ArrayList<Book> resultList = library.advancedSearch("title1", "author1", "", "house1", "");
		assertEquals(resultList.size(), 1);
		for ( Book result : resultList)
		{
			assertEquals(result.getTitle(), "title1");
			assertEquals(result.getAuthor(), "author1");
			assertEquals(result.getPublishing_house(), "house1");
		}
		resultList = library.advancedSearch("title1", "author1", "", "house2", "");
		assertEquals(resultList.size(), 0);
	}
	
	public void testTitleAndYearAndHouseSearch(){
		ArrayList<Book> resultList = library.advancedSearch("title1", "", "1", "house1", "");
		assertEquals(resultList.size(), 1);
		for ( Book result : resultList)
		{
			assertEquals(result.getTitle(), "title1");
			assertEquals(result.getPublishing_house(), "house1");
			assertEquals(result.getYear(), "1");
		}
		resultList = library.advancedSearch("title1", "author1", "", "house2", "");
		assertEquals(resultList.size(), 0);
	}
	
	public void testAuthorAndYearAndHouseSearch(){
		ArrayList<Book> resultList = library.advancedSearch("", "author1", "1", "house1", "");
		assertEquals(resultList.size(), 2);
		for ( Book result : resultList)
		{
			assertEquals(result.getAuthor(), "author1");
			assertEquals(result.getYear(), "1");
			assertEquals(result.getPublishing_house(), "house1");
		}
		resultList = library.advancedSearch("", "author1", "2", "house1", "");
		assertEquals(resultList.size(), 0);
		}
	
	public void testAllParameterSearch(){
		ArrayList<Book> resultList = library.advancedSearch("title1", "author1", "1", "house1", "");
		assertEquals(resultList.size(), 1);
		for ( Book result : resultList)
		{
			assertEquals(result.getTitle(), "title1");
			assertEquals(result.getPublishing_house(), "house1");
			assertEquals(result.getAuthor(), "author1");
			assertEquals(result.getYear(), "1");
		}
		resultList = library.advancedSearch("title1", "author2", "1", "house1", "");
		assertEquals(resultList.size(), 0);
	}

}
