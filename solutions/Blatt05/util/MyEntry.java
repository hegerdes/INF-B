package Blatt05.util;

/**
 * An Entry holds an Object <code>o</code> and a reference <code>next</code> to
 * the next Entry such that a linked List of Entry elements is generated. Type safe implemetation
 *
 * @author Henrik Gerdes
 */

public class MyEntry<T> implements Cloneable {

    MyEntry<T> next;
    T o;

    MyEntry() {
        this(null, null);
    }

    MyEntry(T o) {
        this(o, null);
    }

    MyEntry(T o, MyEntry<T> e) {
        this.o = o;
        this.next = e;

    }

    /**
     * Clones this Entry. Will return a new copy of the reference of this Entry.
     * NOTE: Its not a deep copy. The cloned Entry still can be modified by other program's
     * @return A new Entry
     * @throws InternalError if Clone is not supported
     */
    @Override
    public MyEntry<T> clone(){
        MyEntry<T> clone;
        try {
            clone = (MyEntry<T>)super.clone();
            if(next != null){
                clone.next=next.clone();
            }
            return clone;
        }catch (CloneNotSupportedException e){
            throw new InternalError(e);
        }
    }
    /**
     * Compares the Entry with another given Object
     * Uses Rules of Object equals
     * @param obj Object to compare with
     * @return true if List is equals else false
     */
    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
      //  System.out.println("Stelle 1");
        if(this==null) return false;
      //  System.out.println("Stelle 2");
        if(this.getClass() != obj.getClass()) return false;
      //  System.out.println("Stelle 3");
        MyEntry other = (MyEntry) obj;
        if(next==null) {
            if (other.next != null) return false;
       //     System.out.println("Stelle 4");
        }else if(!next.equals(other.next)) return false;
       // System.out.println("Stelle 5");
        if(o == null) {
            if (other.o != null) return false;
       //     System.out.println("Stelle 6");
        }else if(!o.equals(other.o)) return false;
       // System.out.println("Stelle 7");

        return true;
    }
    /**
     *  Returns a hash code value for the object.
     *  Uses super method
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
