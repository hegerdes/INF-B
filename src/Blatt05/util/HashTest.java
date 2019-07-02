package Blatt05.util;

import java.util.LinkedList;

public class HashTest {

    public static void main(String[] args) {

        //Constructor Test
        HashArray<MyString> table =new HashArray<>(20);
        HashArray<Double> tables =new HashArray<>();


        MyString a = new MyString("Inf A");
        MyString b = new MyString("Inf B");
        MyString c = new MyString("KI");
        MyString d = new MyString("Mutig und freundlich, so tapfer und gläubig fröhlich und frech kämpfen " +
                "sie auch für dich. Leben im Wald unter Bäumen und Steinen, in ihren Höhlen da sind sie zu Haus. " +
                "Gummibären hüpfen hier und dort und überall. \n");

        Integer z = 50;

        //Testing HashArray Methods

        //Insert
        Assert.assertEquals(true, table.insert(a));
        // Contains
        Assert.assertEquals(true, table.contains(a));
        //Insert of two identical Objects
        Assert.assertEquals(false, table.insert(a));

        Assert.assertEquals(true, table.insert(b));
        Assert.assertEquals(true, table.insert(c));
        Assert.assertEquals(true, table.insert(d));

        // Delete
        Assert.assertEquals(true, table.delete(a));
        Assert.assertEquals(false, table.contains(a));
        Assert.assertEquals(false, table.delete(a));

        //Typsicher
        //Assert.assertEquals(false,table.insert(z));

        //Check if HashSortig is working
        //Assert.assertEquals("KI", ((MyString)table.array[2].elem()).toString());



        // HashFunktion of MyString
        Assert.assertEquals(5,a.hashCode(a));

        // Insert of other Type
        Assert.assertEquals(true, tables.insert((Double)8.2));
        // HashFunktion of Object
        Assert.assertEquals(642121728,((Double)8.2).hashCode());


        System.out.println("Test Abgeschlossen...");






    }
}
