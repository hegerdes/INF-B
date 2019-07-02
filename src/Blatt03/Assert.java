package Blatt03;
/**
 * Assertion-methods which compare 2 arguments by optionally using several
 * additional help-arguments. If the correctness of the assertion is not given, a
 * failure will be printed on the standard system output. Else nothing happens.
 *
 * @author Mathias Menninghaus (mathias.mennighaus@uos.de)
 */
public class Assert {

   public static void assertEquals(String[] expected, String[] actual) {
      if (expected.length != actual.length) {
         System.out.println("FAIL expected length " + expected.length
               + " but was " + actual.length);
      } else {
         boolean fail = false;
         for (int i = 0; i < expected.length && !fail; i++) {
            if (!expected[i].equals(actual[i])) {
               System.out.println("FAIL at pos " + i + " expected "
                     + expected[i] + " but was " + actual[i]);
               fail = true;
            }
         }
      }
   }

   public static void assertEquals(String expected, String actual) {
      if (!expected.equals(actual)) {
         System.out.println("FAIL [expected: " + expected + " but was "
               + actual + "]");
      }
   }

   public static void assertEquals(double expected, double actual, double
         epsilon) {
      if (expected != actual && Math.abs(expected - actual) > epsilon) {
         System.out.println("FAIL expected " + expected + " but was " + actual);
      }
   }
   
   public static void assertEquals(double expected, double actual) {
	   if (expected != actual) {
	         System.out.println("FAIL expected " + expected + " but was " + actual);
	      }
	   }

   public static void assertEquals(int expected, int actual) {
      if (expected != actual) {
         System.out.println("FAIL expected " + expected + " but was " + actual);
      }
   }
}
