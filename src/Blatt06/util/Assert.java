package Blatt06.util;
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
            if (!expected[i].equals(actual[actual.length-i])) {
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

   public static void assertEquals(Integer[] expected, Integer[] actual) {
      if (expected.length != actual.length) {
         System.out.println("FAIL [expected: " + expected.length + "laenge " + " but was " + actual.length + "laenge]");
      }
      for(int i = 0; i<actual.length; i++){
         if(actual[i] != expected[i]){
            System.out.println("FAIL [expected: " + expected[i] + " but was "
                    + actual[i] + "]");
         }
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
   
   public static void assertEquals(boolean expected, boolean actual) {
	      if (expected != actual) {
	         System.out.println("FAIL expected " + expected + " but was " + actual);
	      }
	   }

    public static <E> void assertEquals(MyList<E> expected, MyList<E> actual) {
       expected.reset();
       actual.reset();

       while (!expected.endpos() || !actual.endpos()){
           Assert.assertEquals((String)expected.elem(),(String)actual.elem());
           expected.advance();
           actual.advance();
       }
    }
}
