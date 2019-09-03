package Blatt04.library;

/**
 * Implements a BluRay
 * @author Henrik
 * @version 11.05.2018
 *
 */

public class BluRay extends LibraryItem{
	
	private String title;
	private String director;
	
	/**
	 * Constructor for BluRay
	 * @param title The title of the movie
	 * @param director The director of the movie
	 * @throws If title or author are empty
	 */
	public BluRay(String title, String director) {
		super();
		if(title.isEmpty() || director.isEmpty()) {
			throw new RuntimeException("Der Film hat keinen Namen oder Director");
		}
		this.title = title;
		this.director = director;
	}
	
	/**
	 * Getter for Title
	 * @return String with title of movie
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * Getter for Director
	 * @return String with director of the book
	 */
	public String getDirector() {
		return director;
	}

	/**
	 * Gets Description of the Book
	 * Implements abstract LibraryItems method
	 */
	@Override
	public String getDescription() {
		return this.getTitle()+ " von " + this.getDirector();
	}
	
	

}
