package tests;

import libraryManagementSystem.Book;
import org.junit.Test;
import junit.framework.TestCase;

public class BookTest extends TestCase {
	
	private Book book;
	
	public BookTest() {
		super();
		book = new Book("isbn", "title", "author", "year", "publishing_house", "image");
	}

	@Test
	public void testGetIsbn() {
		String result = book.getIsbn();
		assertEquals("isbn",result);
	}

	@Test
	public void testSetIsbn(String isbn) {
		book.setIsbn("isbn1");
		String result = book.getIsbn();
		assertEquals("isbn1",result);
	}
	
	@Test
	public void testGetTitle() {
		String result = book.getTitle();
		assertEquals("title",result);
	}

	@Test
	public void testsettitle(String title) {
		book.setTitle("title1");
		String result = book.getTitle();
		assertEquals("title1",result);
	}

	@Test
	public void testGetAuthor() {
		String result = book.getAuthor();
		assertEquals("author",result);
	}

	@Test
	public void testSetAuthor(String author) {
		book.setAuthor("author1");
		String result = book.getAuthor();
		assertEquals("author1",result);
	}

	@Test
	public void testGetYear() {
		String result = book.getYear();
		assertEquals("year",result);
	}

	@Test
	public void testSetYear(String year) {
		book.setYear("year1");
		String result = book.getYear();
		assertEquals("year1",result);
	}

	@Test
	public void testGetPublishing_house() {
		String result = book.getPublishing_house();
		assertEquals("publishing_house",result);
	}

	@Test
	public void testSetPublishing_house(String publishing_house) {
		book.setPublishing_house("publishing_house1");
		String result = book.getPublishing_house();
		assertEquals("publishing_house1",result);
	}

	@Test
	public void testGetImage() {
		String result = book.getImage();
		assertEquals("image",result);
	}

	@Test
	public void testSetImage(String image) {
		book.setImage("image1");
		String result = book.getImage();
		assertEquals("image1",result);
	}
	
	@Test
	public void testToString() {
		
		String result = book.toString();
		assertEquals("ISBN: " + "isbn" + "\n" +
				   "Book Title: " + "title" + "\n" +
				   "Book Author: " + "author" + "\n" +
				   "Year of Publication: " + "year" + "\n" +
				   "Publisher: " + "publishing_house" + "\n" +
				   "Image URL: " + "image",result);
	}

}
