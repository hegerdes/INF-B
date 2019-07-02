package Blatt01;
/**
 * Class to test the functionality of the garbage collector and the method
 * {@link #finalize()}.
 *
 * @author Mathias Menninghaus
 */
public class StockExchange {

   /**
    * First argument defines 1/3 of the
    * instances of <code>Company</code> who will be created. Then 2/3 of the
    * newly created <code>Company</code> instances will be set to
    * <code>null</code> and the garbage collector explicitly called. After that,
    * the remaining 1/3 <code>Company</code> instances will be set to
    * <code>null</code>.
    *
    * @param args the command line arguments
    */
   public static void main(String[] args) {

      final int N = 1000;

      Company c[] = new Company[3 * N];

      for (int i = 0; i < c.length; i++) {
         c[i] = new Company("Toto_" + i);
      }

      for (int i = 0; i < 2 * N; i++) {
         c[i] = null;
      }

      System.gc();

      for (int i = 2 * N; i < 3 * N; i++) {
         c[i] = null;
      }

      while (true) ;
   }
}