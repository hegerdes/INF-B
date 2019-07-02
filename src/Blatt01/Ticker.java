package Blatt01;
/**
 * Implements a Ticker
 * Prints out the given String, removes /n and adds +++ betwen Strings
 * @author Henrik
 *
 */
public class Ticker {
	
	private static Ticker ticker;
	private Ticker(){};
	
	/**
	 * Constructor of Ticker in Sington-Structure 
	 * @return Ticker
	 */
	public static Ticker getInstance() {
		if(ticker==null) {
			ticker = new Ticker();
		}
		return ticker;
	}
	
	/**
	 * Prints the given String
	 * @param text
	 */
	public void print(String text) {
		text = text.replace("\n", "");
		System.out.print("+++ ");
		System.out.print(text);
		System.out.print(" ");
		}
	}
