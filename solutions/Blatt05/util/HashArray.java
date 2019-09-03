package Blatt05.util;

/**
 * HashArry is a array of Generic MyList Objects
 * @author Henrik Gerdes
 * @param <T>
 */
public class HashArray<T> implements HashSet<T>{

    private MyList[] array;
    private Class type;

    /**
     * Default Constructor
     * If no length for array is given use default length 10
     */
    public HashArray(){
        this(10);
    }

    /**
     * Constructor
     * @param laenge length of the new HashArray
     */
    public HashArray(int laenge){
        array = new MyList[laenge];
        // Warum heir kein <T>? Tutor fragen

        for(int i=0; i<array.length; i++){
            array[i] = new MyList<T>();
        }
    }

    /**
     * Checks if <code>o</code> is in the <code>HashArray</code>
     * @param o the object that may be contained in this <code>HashSet</code>.
     * @return true if <code>o</code> is contained else false
     */
    @Override
    public boolean contains(T o) {
        if(o == null) return false;
        int hcode = hash(o);
        hcode %= array.length;

        if(array[hcode].empty()) return false;
        array[hcode].reset();
        while (!array[hcode].endpos()) {
            if (eqals(o, array[hcode].elem())) {
                return true;
            } else array[hcode].advance();
        }
        return false;
    }

    /**
     * Inserts a new Element in the <code>HashArray</code>
     * @param o inserts the given object into this <code>HashSet</code> if it is
     *          not already contained
     * @return false if <code>o</code> is null or already in the HashArray else true
     */
    @Override
    public boolean insert(T o) {
        // Makes sure only the same Object in in the Array
/*
        if(type == null){
            type = o.getClass();
        }
        if(type != o.getClass()) return false;
*/

        if(o == null) return false;
        if(contains(o)) return false;
        int hcode = hash(o);
        hcode %= array.length;
        array[hcode].add(o);
        return true;
    }

    /**
     *  Checks if <code>o</code> is in the HashArray and deletes it
     * @param o deletes the given object from this <code>HashSet</code> if it is contained
     * @return true if deletion is successful else false
     */
    @Override
    public boolean delete(T o) {
        if(o == null) return false;
        if(!contains(o)){
            return false;
        }else {
            int hcode = hash(o);
            hcode %= array.length;
            array[hcode].reset();
            while (!eqals(o, array[hcode].elem())) {
                array[hcode].advance();
            }
            array[hcode].delete();
            return true;
        }
    }

    /**
     * Compare to Objects
     * If <code>o</code> has a own equals method use equals of <code>o</code>
     * Else use equals of {@link Object#equals}
     * @param o The Object to delete, insert or look if its contained
     * @param l any Object that is in HashArray
     * @return true if equal is true else false
     */
    private boolean eqals(Object o, Object l){
        if (o instanceof HashFunction){
            return ((HashFunction) o).equals(o,l);
        }else return l.equals(o);
    }

    /**
     * Calculates the HashCode of an Object <code>o</code>
     * If <code>o</code> has a own HashCode method use equals of <code>o</code>
     * Else use HashCode of {@link Object#hashCode()}
     * @param o The Object which you want the HashCode from
     * @return int HashCode of <code>o</code>
     */
    private int hash (Object o){
        if(o instanceof HashFunction){
            return ((HashFunction) o).hashCode(o);
        }else return o.hashCode();
    }
}
