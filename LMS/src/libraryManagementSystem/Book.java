package libraryManagementSystem;

public class Book {

	private String title;
	private String author;
	private int year;
	private String publishing_house;
	private String image;
	
	//constructor
	public Book(String title, String author, int year, String publishing_house, String image)
	{
        title = this.title;
        author = this.author;
        year = this.year;
        publishing_house = this.publishing_house;
        image = this.image;
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

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
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
	
}
