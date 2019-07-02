package Blatt05.util;

/**
 * Test Class
 * Just an Object holding a String
 * Has an own HashFunktion
 */
public class MyString implements HashFunction {

    private String buffer;

    public MyString(){
        this("Ein String");
    }

    public MyString(String s){
        this.buffer = s;
    }


    @Override
    public boolean equals(Object o1, Object o2) {
        return o1.equals(o2);
    }

    @Override
    public int hashCode(Object o) {
        return buffer.length();
    }

    @Override
    public String toString() {
        return buffer;
    }
}
