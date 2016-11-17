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
		if (isbn != null)
			this.isbn = isbn;
		else
			this.isbn = "";
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		if (title != null)
			this.title = title;
		else
			this.title = "";
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		if (author != null)
			this.author = author;
		else
			this.author = "";
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		if (year != null)
			this.year = year;
		else
			this.year = "";
	}

	public String getPublishing_house() {
		return publishing_house;
	}

	public void setPublishing_house(String publishing_house) {
		if (publishing_house != null)
			this.publishing_house = publishing_house;
		else
			this.publishing_house = "";
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		if (image != null)
			this.image = image;
		else
			this.image = "";
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
