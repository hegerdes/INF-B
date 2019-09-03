package Blatt05.util;

import java.util.NoSuchElementException;

/**
 * A simple linked list. One may go through this list by {@link #advance()} until
 * the last position ({@link #endpos()}) is reached. One also may
 * {@link #delete()} and {@link #add(Object)} elements. After advancing it is
 * possible to go back to the beginning by {@link #reset()}.
 *
 * @author Mathias Menninghaus (mathias.menninghaus@uos.de)
 *
 */

public class MyList<T> implements Cloneable {

    private MyEntry<T> begin;

    private MyEntry<T> pos;

    public MyList(){
        pos = begin = new MyEntry<T>();
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
    public  T elem(){
        if(endpos()){
            throw new NoSuchElementException("Already at the and of this List");
        }
        return pos.next.o;
    }

    /**
     * Inserts <code>o</code> in this List. It will be placed before the actual
     * element. After insertion the inserted element will become the actual
     * element.
     *
     * @param x
     *           the element to be inserted
     */
    public void add(T x) {
        MyEntry<T> newone = new MyEntry<T>(x, pos.next);

        pos.next = newone;
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
        pos.next = pos.next.next;
    }

    /**
     * Clones this List. Will return a new copy of this List.
     * Important: The Entry's will not be cloned. So its NOT a deep copy
     * @return New <code>MyList</code>
     * @throws InternalError If Clone of Object fails
     */
    public MyList<T> clone(){
        try{
            MyList<T> clone = (MyList<T>) super.clone();
            clone.begin = this.begin.clone();
            clone.pos = clone.begin;
            return clone;
        } catch (CloneNotSupportedException e){
            throw new InternalError(e);
        }

    }

    /**
     * Compares the List with another given Object
     * Uses Rules of Object equals
     * @param obj Object to compare with
     * @return true if List is equals else false
     */
    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null) return false;
        if(this.getClass() != obj.getClass()) return false;

        MyList<T> other = (MyList<T>) obj;
        if(!begin.equals(other.begin)) return false;
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
