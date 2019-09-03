package Blatt01;
/**
 * A Stack that holds Strings. Works after the LIFO (Last in first out)
 * principle.
 * 
 * @author Mathias Menninghaus (mathias.menninghaus@uos.de)
 * 
 */
public class StringStack {

   public StringStack() {
      this.first = null;
   }

   /**
    * Creates a new StringStack as a copy of <code>s</code>.
    * 
    * @param s
    *           The StringStack to be copied.
    */
   public StringStack(StringStack s) {
      // simple variant, behaviour of deep copy
       this.first = s.first;
      // complex variant, real deep copy
      if (!s.empty()) {
         this.first = new StringStackEntry(s.first);
      }
   }

   private StringStackEntry first;

   /**
    * Tests, whether this StringStack is empty or not.
    * 
    * @return true if this StringStack is empty, else false
    */
   public boolean empty() {
      return this.first == null;
   }

   /**
    * Returns the first element in the stack. Throws Exception when stack is
    * empty
    * 
    * @return First element or null if stack is empty
    * @throws RuntimeException
    *            if stack is empty.
    */
   public String peek() {
      if (!this.empty()) {
         return first.getString();
      } else {
         throw new RuntimeException("Stack is empty");
      }
   }

   /**
    * Deletes the first elment in the stack and returns it. Throws Exception
    * when stack is empty
    * 
    * @return first element in the stack
    * @throws RuntimeException
    *            if stack is empty.
    */
   public String pop() {
      if (!this.empty()) {
         String ret = first.getString();
         this.first = this.first.getNext();
         return ret;
      } else {
         throw new RuntimeException("Stack is empty");
      }
   }

   /**
    * Puts the String s on the stack.
    * 
    * @param s
    *           String to be added.
    */
   public void push(String s) {
      if (this.empty()) {
         first = new StringStackEntry(s, null);
      } else {
         first = new StringStackEntry(s, first);
      }
   }

}
