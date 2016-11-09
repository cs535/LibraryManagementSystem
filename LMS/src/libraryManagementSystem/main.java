package libraryManagementSystem;

public class main {
	
	public static void main(String[] args) {
		Library myLibrary = new Library();
		
		
		//DataImporter is working or not ?
		System.out.println("Library's first book's title is: " + myLibrary.getBookList().get(0).getTitle() + " author's name is : " + myLibrary.getBookList().get(0).getAuthor() + 
				" publication year is : " + myLibrary.getBookList().get(0).getYear() + " publication house is : " + myLibrary.getBookList().get(0).getPublishing_house());
		
		//simple search test.
		//System.out.println(myLibrary.simpleSearch("e g"));
		//System.out.println(myLibrary.simpleSearch(""));
		
		//search according to year test.
		//System.out.println(myLibrary.searchAccordingToYear("2004"));
		//System.out.println(myLibrary.searchAccordingToYear(""));
		
		//search according to author name test.
		//System.out.println(myLibrary.searchAccordingToAuthor("ll"));
		//System.out.println(myLibrary.searchAccordingToYear(""));
		
		//advanced search test. year string oldugu icin contains kullandım fakat "20" ile search edince "20" geçenleri return ediyor. biraz tuahf oldu. gg.
		//System.out.println(myLibrary.advancedSearch("e g", "ll", "2002", ""));
		//System.out.println(myLibrary.advancedSearch("ck", "ig", "2004", "c"));

		
	}

}
