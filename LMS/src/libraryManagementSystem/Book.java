package libraryManagementSystem;

import java.util.ArrayList;

public class Book 
{

	private String isbn;
	private String title;
	private String author;
	private String year;
	private String publishing_house;
	private String image;
	
	private ArrayList<Rating> ratings;
	
	//constructor
	public Book()
	{
		this.ratings = new ArrayList<Rating>();
	}
	
	/**
	 * @param isbn
	 * @param title
	 * @param author
	 * @param year
	 * @param publishing_house
	 * @param image
	 */
	public Book(String isbn, String title, String author, String year, String publishing_house, String image)
	{
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.year = year;
		this.publishing_house = publishing_house;
		this.image = image; 
		this.ratings = new ArrayList<Rating>();
	}

	public void addRating(Rating rating)
	{
		if (rating == null || this.ratings == null)
		{
			System.out.println("Error");
		}
		
		this.ratings.add(rating);
	}
	
	public ArrayList<Rating> getRatings()
	{
		return this.ratings;
	}

	/**
	 * @return isbn
	 */
	public String getIsbn() 
	{
		return isbn;
	}

	/**
	 * @param isbn
	 */
	public void setIsbn(String isbn)
	{
		if (isbn != null)
			this.isbn = isbn.trim();
		else
			this.isbn = "";
	}
	
	/**
	 * @return title
	 */
	public String getTitle()
	{
		return title;
	}

	/**
	 * @param title
	 */
	public void setTitle(String title)
	{
		if (title != null)
			this.title = title.trim();
		else
			this.title = "";
	}

	/**
	 * @return author
	 */
	public String getAuthor()
	{
		return author;
	}

	/**
	 * @param author
	 */
	public void setAuthor(String author) 
	{
		if (author != null)
			this.author = author.trim();
		else
			this.author = "";
	}

	/**
	 * @return year
	 */
	public String getYear()
	{
		return year;
	}

	/**
	 * @param year
	 */
	public void setYear(String year)
	{
		if (year != null)
			this.year = year.trim();
		else
			this.year = "";
	}

	/**
	 * @return publishing_house
	 */
	public String getPublishing_house()
	{
		return publishing_house;
	}

	/**
	 * @param publishing_house
	 */
	public void setPublishing_house(String publishing_house) 
	{
		if (publishing_house != null)
			this.publishing_house = publishing_house.trim();
		else
			this.publishing_house = "";
	}

	/**
	 * @return image
	 */
	public String getImage()
	{
		return image;
	}

	/**
	 * @param image
	 */
	public void setImage(String image) 
	{
		if (image != null)
			this.image = image.trim();
		else
			this.image = "";
	}	
	
	@Override
	public String toString() 
	{
		return "ISBN: " + isbn + "\n" +
			   "Book Title: " + title + "\n" +
			   "Book Author: " + author + "\n" +
			   "Year of Publication: " + year + "\n" +
			   "Publisher: " + publishing_house + "\n" +
			   "Image URL: " + image;
	}
}
