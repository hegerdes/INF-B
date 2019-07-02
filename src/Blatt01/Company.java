package Blatt01;
/**
 * 
 * @author Henrik
 * Implementiert die Datenstrucktur Company
 * @param name		Der Name der Firma
 * @param st_price	Aktienpreis der Firma
 */
public class Company {
	
	private String name;
	private double st_price;
	
	/**
	 * Constructor for name and price
	 * @param name
	 * @param price
	 */
	public Company(String name,double price ) {
		this.name=name;
		this.st_price=price;
	}
	
	/**
	 * Constructor for name and default price
	 * @param name
	 */
	public Company(String name) {
		this(name, 1.0);
	}
	/**
	 * Default Constructor with default Data
	 */
	public Company() {
		this("Firma XY", 1.0);
	}
	
	/**
	 * Changes the Stock Price and prints it to Console
	 * @param d
	 */
	public void changeStockPrice(double d) {
		this.st_price = d;
		Ticker.getInstance().print(name + " " + st_price);
	}
	/**
	 * Prints Company failed and
	 * Sets Data to Null for GC
	 */
	protected void finalize() {
		Ticker.getInstance().print(name + " ist insolvent");
		this.name = null;
		this.st_price = (Double) null;
		}
	

}
