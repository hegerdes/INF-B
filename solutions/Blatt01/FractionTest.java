package Blatt01;
/**
 * Test the functionality of the Class Fraction.
 *
 * @author Mathias Menninghaus (mathias.menninghaus@uos.de)
 */
public class FractionTest {

   public static void main(String[] args) {

      Fraction a = new Fraction(1, 2);
      Fraction b = new Fraction(3, 4);
      Fraction c = new Fraction(1);
      
      if(args.length != 0) {
      }

      if(args[1].matches("(.*)-(.*)")) {
    	  System.out.println("sub");
    	  System.out.println(Fraction.paraseFraction(args[2]).subtract(Fraction.paraseFraction(args[0])));
      }
      if(args[1].matches("(.*)\\+(.*)")) {
    	  System.out.println("add");
    	  System.out.println(Fraction.paraseFraction(args[2]).add(Fraction.paraseFraction(args[0])));
      }
      if(args[1].matches("(.*)\\*(.*)")) {
    	  System.out.println("multi");
    	  System.out.println(Fraction.paraseFraction(args[2]).multiply(Fraction.paraseFraction(args[0])));
      }
      if(args[1].matches("(.*)/(.*)")) { 
    	  System.out.println("div");
    	  System.out.println(Fraction.paraseFraction(args[2]).divide(Fraction.paraseFraction(args[0])));
      }
      
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
      System.out.println("...tests finished");

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
