package Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayStack<E> implements Iterable {

    private Object[] stack;
    private int top;

    public ArrayStack(int size){
        stack = new Object[size];
        top =-1;
    }

    public void push(E e){
        if(isFull()){
            throw new RuntimeException("Voll");
        }
        stack[++top] =e;
    }

    private boolean isFull() {
        return top==stack.length-1;
    }

    public E pop(){
        if(isEmpty()){
            throw new RuntimeException("Leer");
        }
        return (E)stack[top--];
    }

    public E top(){
        if(isEmpty()){
            throw new RuntimeException("Leer");
        }
        return (E)stack[top];
    }

    private boolean isEmpty() {
        return top==-1;
    }


    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator iterator() {
        return new StackIterator();
    }

    private class StackIterator<E> implements Iterator {

        private int zaeler;
        private int expecktetTop;

        private StackIterator(){
            zaeler =0;
            expecktetTop = top;
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
            if(expecktetTop != top){
                throw new ConcurrentModificationException("Änderung");
            }
            if(zaeler <= top){
                return true;
            }else return false;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public E next() {
            if(expecktetTop != top){
                throw new ConcurrentModificationException("Änderung");
            }
            return (E) stack[zaeler++];
        }
    }

    public static void main(String[] args) {
        ArrayStack<Integer> intStack = new ArrayStack<>(20);

        for(int i =0;i<10;i++){
           // System.out.println(i);
            intStack.push(i);
        }

        for(Object e : intStack){
            System.out.println((Integer)e);
        }
    }
}
