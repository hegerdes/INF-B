package Blatt04.fraction;

/**
 * Test the functionality of the Class Fraction.
 *
 * @author Henrik Gerdes
 */
public class FractionTest {
	
	static String REGEX = "-?\\d+/\\d*[1-9]\\d*";
	static String FLOAT = "-?\\d+\\.?\\d*";
	static String SUB = "(.*)-(.*)";
	static String ADD = "(.*)\\+(.*)";
	static String MULTI = "(.*)\\*(.*)";
	static String DIV = "(.*)/(.*)";
	
   public static void main(String[] args) {

      Fraction a = new Fraction(1, 2);
      Fraction b = new Fraction(3, 4);
      Fraction c = new Fraction(1);
      
      if(args.length != 0 || args.length >3) {
    	  
 /**   	  
    	  if(args[2].matches(REGEX)) {
    		  if(args[1].matches(SUB)) {
            	  if(args[0].matches(REGEX)) {
            		  System.out.println(Fraction.parseFraction(args[2]).subtract(Fraction.parseFraction(args[0])).toString());
            	  }
            	  if(args[0].matches(FLOAT)) {
            		  System.out.println(Fraction.parseFraction(args[2]).substract(Double.parseDouble(args[0])));
            	  }
            	
              }
    		  if(args[1].matches(ADD)) {
            	  if(args[0].matches(REGEX)) {
            		  System.out.println(Fraction.parseFraction(args[2]).add(Fraction.parseFraction(args[0])).toString());
            	  }
            	  if(args[0].matches(FLOAT)) {
            		  System.out.println(Fraction.parseFraction(args[2]).add(Double.parseDouble(args[0])));
            	  }
            	
              }  
    		  if(args[1].matches(MULTI)) {
            	  if(args[0].matches(REGEX)) {
            		  System.out.println(Fraction.parseFraction(args[2]).multiply(Fraction.parseFraction(args[0])).toString());
            	  }
            	  if(args[0].matches(FLOAT)) {
            		  System.out.println(Fraction.parseFraction(args[2]).multiply(Double.parseDouble(args[0])));
            	  }
            	
              }
    		  if(args[1].matches(DIV)) {
            	  if(args[0].matches(REGEX)) {
            		  System.out.println(Fraction.parseFraction(args[2]).divide(Fraction.parseFraction(args[0])).toString());
            	  }
            	  if(args[0].matches(FLOAT)) {
            		  System.out.println(Fraction.parseFraction(args[2]).divide(Double.parseDouble(args[0])));
            	  }
            	
              }
    		  
    	  }
    	  System.out.println("Benutzung: \n"
    	  		+ "Stelle 1: Nat�rliche Zahl, Flie�kommazahl oder Bruch.         z.B. 3.1415 \n"
    	  		+ "Stelle 2: Operator. G�ltig sind:                              +, -, /, \"*\" \n"
    	  		+ "Stelle 3: Bruch. G�ltiges Format:                             -4/9");
    	  */
    	  
    	  
      assertEquals("1/4",b.subtract(a));
      assertEquals("5/4",a.add(b));
      assertEquals("0/1", new Fraction(0, 23));
      assertEquals("3/4", new Fraction(-3, -4));
      assertEquals("-3/4", new Fraction(-3, 4));
      assertEquals("1/2", a);
      assertEquals("3/4", b);
      assertEquals("1/1", c);
      assertEquals("1/1", a.multiply(2));
      assertEquals("3/8", b.multiply(a));
      assertEquals("3/8", a.multiply(b));
      assertEquals("3/2", b.divide(a));
      assertEquals("2/3", a.divide(b));
      assertEquals("3/8", a.multiply(b, c));
      System.out.println("... intern test finished");
      }
   }

   private static void assertEquals(String expected, Fraction actual) {
      assertEquals(expected, actual.toString());
   }

   private static void assertEquals(String expected, String actual) {
      if (!expected.equals(actual)) {
         System.out.println("FAIL [expectded: " + expected + " but was "
               + actual + "]");
      }
   }
}
