package Blatt06.util;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A simple linked list. One may go through this list by {@link #advance()}
 * until the last position ({@link #endpos()}) is reached. One also may
 * {@link #delete()} and {@link #add(Object)} elements. After advancing it is
 * possible to go back to the beginning by {@link #reset()}.
 * 
 * @author Mathias Menninghaus (mathias.menninghaus@uos.de)
 * 
 */
public class MyList<E> implements Cloneable, Iterable<E> {

   /**
    * Reference on the first Entry of this List
    * Counter of Modfifications
    */
   private MyEntry<E> begin;
   private int numberOfEntrys;
   private int modCount;
   /**
    * References before the actual Entry of this List
    */
   private MyEntry<E> pos;

   /**
    * Create a new empty List.
    */
   public MyList() {
      modCount =0;
      numberOfEntrys = 0;
      pos = begin = new MyEntry<E>();
   }

   /**
    * Determines if this List is empty or not.
    * 
    * @return <code>true</code>, if there are no elements in this List
    */
   public boolean empty() {
      return begin.next == null;
   }

   /**
    * Determines if it is possible to {@link #advance()} in this List. Returns
    * <code>true</code> if the last position of this List has been reached. An
    * {@link #empty()} List will alway deliver <code>true</code>
    * 
    * @return <code>true</code> if the last Entry in this List already has been
    *         reached.
    */
   public boolean endpos() { // true, wenn am Ende
      return pos.next == null;
   }

   /**
    * Returns to the beginning of this List.
    */
   public void reset() {
      pos = begin;
   }

   /**
    * Advances one step in this List.
    * 
    * @throws NoSuchElementException
    *            if the last Entry of this List already has been reached.
    */
   public void advance() {
      if (endpos()) {
         throw new NoSuchElementException("Already at the end of this List");
      }
      pos = pos.next;
   }

   /**
    * Returns the actual element of this List.
    * 
    * @return the actual element
    * 
    * @throws RuntimeException
    *            if the last Entry of this List already has been reached.
    */
   public E elem() {
      if (endpos()) {
         throw new NoSuchElementException("Already at the end of this List");
      }
      return pos.next.o;
   }

   /**
    * Inserts <code>o</code> in this List. It will be placed before the actual
    * element. After insertion the inserted element will become the actual
    * element. Increases Modcount
    * 
    * @param x
    *           the element to be inserted
    */
   public void add(E x) {
      MyEntry<E> newone = new MyEntry<E>(x, pos.next);

      numberOfEntrys++;
      pos.next = newone;
      modCount++;
   }

   /**
    * Deletes the actual element of this List. The element after the actual
    * element will become the new actual element.
    * 
    * @throws NoSuchElementException
    *            if the last Entry of this List already has been reached.
    */
   public void delete() {
      if (endpos()) {
         throw new NoSuchElementException("Already at the end of this List");
      }
      numberOfEntrys--;
      modCount++;
      pos.next = pos.next.next;
   }

   /**
    * Clones this MyList. Will create a new independent MyList which actual
    * position lies at the beginning of this MyList. This clone operation also
    * fulfills the optional requirements defined by the {@link Object#clone()}
    * operation. NOTE: Inserted elements will not be cloned, due to the fact,
    * that the {@link Object#clone()} is <code>protected</code>.
    * 
    * @see Object#clone()
    */
   public MyList<E> clone(){
      try {

         MyList<E> clone = (MyList<E>) super.clone();
         clone.begin = this.begin.clone();
         clone.pos = clone.begin;

         return clone;
      } catch (CloneNotSupportedException e) {
         throw new InternalError();
      }
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((begin == null) ? 0 : begin.hashCode());
      return result;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      MyList other = (MyList) obj;
      if (!begin.equals(other.begin))
         return false;
      return true;
   }


   /**
    * Returns an iterator over elements of type {@code T}.
    *
    * @return an Iterator.
    */
   @Override
   public Iterator<E> iterator() {
      return new ListIterator();

   }


   private class ListIterator implements Iterator<E>{

      private int expecktedModC;

      private MyEntry<E> last;

      private MyEntry<E> next;

      private MyEntry<E> prevLast;

      private ListIterator(){
         this.next = begin.next;
         this.last = begin;
         this.expecktedModC = MyList.this.modCount;
         this.prevLast = null;
      }

      /**
       * Returns {@code true} if the iteration has more elements.
       * (In other words, returns {@code true} if {@link #next} would
       * return an element rather than throwing an exception.)
       *
       * @return {@code true} if the iteration has more elements
       */
      @Override
      public boolean hasNext() {
         return next != null;
      }

      /**
       * Returns the next element in the iteration.
       *
       * @return the next element in the iteration
       * @throws NoSuchElementException if the iteration has no more elements
       */
      @Override
      public E next() {
         if(expecktedModC != MyList.this.modCount){
            throw new ConcurrentModificationException();
         }
         if(next==null){
            throw new NoSuchElementException();
         }
         prevLast = last;
         last = next;
         next = next.next;
         return last.o;
      }

      @Override
      public void remove() {
         if(expecktedModC != MyList.this.modCount){
            throw new ConcurrentModificationException();
         }
         if(prevLast == null){
            throw new IllegalStateException();
         }
         expecktedModC++;
         MyList.this.modCount++;
         prevLast.next =next;
         prevLast=null;

      }

//   public E[] toArray(){
//      Object[] array = new Object[numberOfEntrys];
//      this.reset();
//      for(int i = 0; !this.endpos();i++){
//         array[i] = elem();
//         this.advance();
//      }
//
//      return (E[])array;
//   }
   }
}
