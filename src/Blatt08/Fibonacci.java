package Blatt08;

import java.io.*;
import java.util.HashMap;

/**
 * Class to calculate the Fibonacci number. Uses a HashMap to reduce the
 * calculation cost.
 *
 * @author Mathias Menninghaus (mathias.menninghaus@uos.de)
 */
public class Fibonacci<S>{

   private static HashMap<Integer, Long> fibonacciHash;
   private static final String filename = "FibonacciHash.map";
   private static int umberOfValues;
   /**
    * Fill HashMap with initial key-value-pairs.
    */

   /**
    * Calculates the fibonacci value of n.
    *
    * @param n a natural number >= 0 to calculate the fibonacci value of
    * @return fibonacci value of n
    */
   public static long fibonacci(int n) throws IOException {
      if (n < 0) {
         throw new IllegalArgumentException("n = " + n);
      }
      if(fibonacciHash==null){
         File f = new File(filename);
         if(!f.exists()){
            fibonacciHash = new HashMap<Integer,Long>();
            fibonacciHash.put(0,0L);
            fibonacciHash.put(1,1L);
         }else{
            ObjectInputStream inStream = null;
            try {
               inStream = new ObjectInputStream(new FileInputStream(f));
               //noinspection unchecked
               fibonacciHash = (HashMap<Integer, Long>) inStream.readObject();
            } catch (ClassNotFoundException e) {
               e.printStackTrace();
            }catch (IOException e) {
               e.printStackTrace();
            }finally
             {
               inStream.close();
            }

         }
      }

      int startSize = fibonacciHash.size();

      long fibNum = getFibonacci(n);

      if(startSize != fibonacciHash.size()){
         ObjectOutputStream outStream = null;

         File f = new File(filename);
         if(!f.exists()){
            f.createNewFile();
         }
         try {
            outStream = new ObjectOutputStream(new FileOutputStream(f));
            outStream.writeObject(fibonacciHash);
            outStream.flush();
            outStream.close();
         }catch (IOException e){
            e.printStackTrace();
         }finally {
            outStream.close();
         }
      }
      //printHashMap();
      return fibNum;
   }

   private static long getFibonacci(int n) {
      if (fibonacciHash.containsKey(n)) {
         return fibonacciHash.get(n);
      } else {
         long nMinus1 = getFibonacci(n - 1);
         long nMinus2 = getFibonacci(n - 2);
         long fibonacci = nMinus1 + nMinus2;

         fibonacciHash.put(n, fibonacci);
         return fibonacci;
      }
   }

   private static void printHashMap(){
      for(int i = 0; i<fibonacciHash.size();i++){
         System.out.println(fibonacciHash.get(i));
      }
   }

   public static void main(String[] args) {
      if (args.length != 1) {
         printUsage();
      } else {
         try {
            System.out.println(fibonacci(Integer.parseInt(args[0])));

         } catch (IllegalArgumentException ex) {
            printUsage();
         } catch (IOException e) {
            e.printStackTrace();
         }
      }
   }

   private static void printUsage() {
      System.out.println("java calc/Fiboncci n");
      System.out.println("n must be a natural number >= 0");
   }



}
