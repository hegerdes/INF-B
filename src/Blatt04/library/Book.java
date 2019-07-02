package Blatt04.library;

/**
 * @author Henrik
 * @version 11.05.2018
 * 
 * Represents a Book, extending a LibraryItem
 */
public class Book extends LibraryItem{
	
	private String title;
	private String author;
	
	/**
	 * Constructor
	 * @param title The title of the Book
	 * @param author The author of the Book
	 * @throws If title or author are empty
	 */
	public Book(String title, String author) {
		super();
		if(title.isEmpty() || author.isEmpty()) {
			throw new RuntimeException("Der Film hat keinen Namen oder Autor");
		}
		this.title = title;
		this.author = author;
	}

	/**
	 * Getter for Title
	 * @return String with title of Book
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Getter for Author
	 * @return String with author of the book
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * Gets Description of the Book
	 * Implements abstract LibraryItems method
	 */
	@Override
	public String getDescription() {
		return this.getTitle() + " von " + this.getAuthor();
	}
	
	
	

}
