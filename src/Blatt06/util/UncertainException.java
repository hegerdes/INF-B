public class UncertainException {

   private int i = 0;

   public static void uncertain(int number) {
      UncertainException uncertain = new UncertainException();
      int result = 0;

      try {
         System.out.println("uncertain" + number + "()");
         switch (number) {
            case 1:
               result = uncertain.uncertain1();
               break;
            case 2:
               result = uncertain.uncertain2();
               break;
            case 3:
               result = uncertain.uncertain3();
               break;
            case 4:
               result = uncertain.uncertain4();
               break;
            case 5:
               result = uncertain.uncertain5();
               break;
            case 6:
               result = uncertain.uncertain6();
               break;
            case 7:
               result = uncertain.uncertain7();
               break;
            case 8:
               result = uncertain.uncertain8();
               break;
            case 9:
               result = uncertain.uncertain9();
               break;
            case 10:
               result = uncertain.uncertain10();
               break;
         }
         System.out.println("result = " + result + ", i = " + uncertain.i);
      } catch (Exception e) {
         System.out.println("i = " + uncertain.i + " Exception (" + e.getClass()
               .getName() + ")");
      } finally {
      }
   }

   public static void main(String args[]) {
      for (int i = 1; i <= 10; ++i) {
         uncertain(i);
      }
   }

   // Geworfene Exception in try wird direkt in catch aufgefangen
   // i erhoeht (i = 1), ClassCastException
   // aber direkt finally: i erhoeht (i = 2)
   // ClassCastException unterbrochen, NumberFormatException geworfen
   public int uncertain1() {
      try {
         throw new RuntimeException();
      } catch (RuntimeException e) {
         i++;
         throw new ClassCastException();
      } finally {
         i++;
         throw new NumberFormatException();
      }
   }

   // for wird durch break in try unterbrochen
   // catch wird nicht erreicht, da gefangene Exception nicht geworfen
   // in finally wird i erhoeht (i = 1), RuntimeException geworfen
   public int uncertain2() {
      for (; ; ) {
         try {
            break;
         } catch (RuntimeException e) {
            i++;
         } finally {
            i++;
            throw new RuntimeException();
         }
      }
      // Compilerfehler:
      // Code wird nicht erreicht, "unreachable statement"
      // return i++;
   }

   // try wirft RuntimeExcetpion
   // in catch direkt aufgefangen, i erhoeht (i = 1), continue fuehrt eigtl. zum Ende von do-while-Schleife
   // finally trotzdem ausgefuehrt! i erhoeht (i = 2)
   // dann i zurueckgegeben (i = 2) und i erhoeht (i = 3)
   public int uncertain3() {
      do {
         try {
            throw new RuntimeException();
         } catch (RuntimeException e) {
            i++;
            continue;
         } finally {
            i++;
         }
      } while (false);
      return i++;
   }

   // return in try durch finally unterbrochen
   // catch wird nicht erreicht
   // finally erhoeht i (i = 1)
   // i erhoeht (i = 2) und zurueckgegeben
   public int uncertain4() {
      try {
         return i++;
      } catch (RuntimeException e) {
         i++;
      } finally {
         i++;
      }
      return i++;
   }

   // return in try durch finally unterbrochen
   // finally wirft RuntimeException, i nicht erhoeht
   public int uncertain5() {
      try {
         return i;
      } finally {
         throw new RuntimeException();
      }
   }

   // finally wird trotz geworfener Exception ausgefuehrt
   // in finally i erhoeht (i = 1) und zurueckgegeben
   public int uncertain6() {
      try {
         throw new RuntimeException();
      } finally {
         return ++i;
      }
   }

   // finally wird trotz geworfener Exception in try ausgefuehrt
   // catch wird nie erreicht
   // in finally i zurueckgegeben (i = 0) und dann erhoeht (i = 1)
   public int uncertain7() {
      try {
         throw new java.io.IOException();
      } catch (RuntimeException e) {
         i++;
      } finally {
         return i++;
      }
   }

   // in try wird NumberFormatException geworfen
   // in catch direkt aufgehoben, i erhoeht (i = 1) und RuntimeException geworfen
   // in finally i erhoeht (i = 2)
   public int uncertain8() {
      try {
         throw new NumberFormatException();
      } catch (RuntimeException e) {
         i++;
         throw new RuntimeException();
      } finally {
         i++;
      }
   }

   // in try wird ClassCastException geworfen
   // direkt in catch aufgefangen, i erhoeht (i = 1)
   // in finally i zurueckgegeben (i = 1) und erhoeht (i = 2)
   public int uncertain9() {
      try {
         throw new ClassCastException();
      } catch (RuntimeException e) {
         return i++;
      } finally {
         return i++;
      }
   }

   // catch wird nie erreicht
   // 1 wird zurueckgegeben
   public int uncertain10(){
      try {
         // Compiler-Fehler: Exception muss gefangen oder declared werden
         // throw new java.io.IOException();
      } catch (RuntimeException e) {
      }
      return 1;

   }
}
