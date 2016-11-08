package libraryManagementSystem;

/**
 * class Book
 * */
public class Book {

	private String isbn;
	private String title;
	private String author;
	private String year;
	private String publishing_house;
	private String image;
	
	//constructor
	public Book(){}
	
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getPublishing_house() {
		return publishing_house;
	}

	public void setPublishing_house(String publishing_house) {
		this.publishing_house = publishing_house;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}	
	
	@Override
	public String toString() {
		return "ISBN: " + isbn + "\n" +
			   "Book Title: " + title + "\n" +
			   "Book Author: " + author + "\n" +
			   "Year of Publication: " + year + "\n" +
			   "Publisher: " + publishing_house + "\n" +
			   "Image URL: " + image;
	}
}
