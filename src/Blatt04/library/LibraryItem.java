package Blatt04.library;

/**
 * Repesents a Item in a Library
 * @author Henrik
 * @version 11.05.2018
 *
 */
public abstract class LibraryItem {
	
	private boolean isBorrowed;
	
	/**
	 * Constructor
	 */
	public LibraryItem() {
		isBorrowed = false;
	}
	

	/**
	 * Getter for status
	 * @return true if item is not available else false
	 */
	  public boolean isBorrowed() {
		return isBorrowed;
	}


	  /**
	   * Setter for status
	   * @param isBorrowed
	   */
	public void setBorrowed(boolean isBorrowed) {
		this.isBorrowed = isBorrowed;
	}

	/**
	 * abstrakte Methode
	 */
	  public abstract String getDescription();
	
	

}
