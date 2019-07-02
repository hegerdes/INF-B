package Blatt01;
/**
 * Test Class for Ticker and Company class
 * @author Henrik
 *
 */
public class TickerCompanyTest {

	public static void main(String[] args) {
		
		//Ticker Test
		Ticker.getInstance().print("Wichtige Nachrichten: \n Hallo World");
		
		// Generate two new Company's
		Company com1 = new Company("Beste Firma der Welt", 2.0);
		Company com2 = new Company("Schlechteste Firma der Welt", 1.5);
		
		// Change Stock price
		com1.changeStockPrice(50.2);
		com2.changeStockPrice(1.1);
		
		//Ticker massage
		Ticker.getInstance().print("Weitere wichtige Nachichten um den Platz zu f�llen");
		//Destrucktor for Company
		com2.finalize();
		System.gc();
		// Test call after GC
		com2.changeStockPrice(2.3);
		
	}
	

}
