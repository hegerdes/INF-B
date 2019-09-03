package Blatt01;

import Blatt02.Assert;

public class StringStackTest {

   /**
    * @param args
    */
   public static void main(String[] args) {
      String[] strings = {"1", "2", "3", "4", "5", "6"};

      System.out.println("Create first StringStack on Array");
      StringStack original = fill(strings);
      Assert.assertEquals(new String[]{"1", "2", "3", "4", "5", "6"},
            arrayOf(original));

      System.out.println("Copy StringStack");
      original = fill(strings);
      StringStack copy = new StringStack(original);
      Assert.assertEquals(new String[]{"1", "2", "3", "4", "5", "6"}, arrayOf(copy));

      System.out.println("Delete first 3 elements from copied Stack - " +
            "original should not change");
      original = fill(strings);
      copy = new StringStack(original);
      for (int i = 0; i < 3; i++) {
         copy.pop();
      }
      Assert.assertEquals(new String[]{"1", "2", "3", "4", "5", "6"},
            arrayOf(original));

      System.out.println("Copy again and push 2 elements to copied Stack - " +
            "original should not change");
      original = fill(strings);
      copy = new StringStack(original);
      for (int i = 7; i < 9; i++) {
         copy.push("" + i);
      }
      Assert.assertEquals(new String[]{"1", "2", "3", "4", "5", "6"},
            arrayOf(original));

   }

   private static StringStack fill(String[] strings) {
      StringStack stack = new StringStack();
      for (String s : strings) {
         stack.push(s);
      }
      return stack;
   }


   private static String[] arrayOf(StringStack s) {

      StringStack tmp = new StringStack();
      int size = 0;
      while (!s.empty()) {
         size++;
         tmp.push(s.pop());
      }

      String[] ret = new String[size];
      int i = 0;
      while (!tmp.empty()) {
         ret[i++] = tmp.peek();
         s.push(tmp.pop());
      }
      return ret;

   }

}
