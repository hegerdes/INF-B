package Blatt06.util;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * Frage: Kann man ein Generics Arry erstellen?
 */
public class IterateListTest {

    public static void main(String[] args) {

        // Test Data
        String[] teststingsIn = {"Das ", "ist ", "ein ", "Test ", "!"};

        // New List
        MyList<String> words = new MyList<>();

        //Filling the List
        for(int j = 0; j<teststingsIn.length; j++){
            words.add(teststingsIn[j]);
        }

        // Checking Elements
        int l= 1;
        for(String i: words){
            Assert.assertEquals(teststingsIn[teststingsIn.length-l], i);
            l++;
        }

        // IteratorTest
        Iterator<String> counter = words.iterator();

        //Remove-Fail Test Test
        boolean fehler = false;
        try{
            counter.remove();
        }catch (IllegalStateException e) {
            fehler = true;
        }
        Assert.assertEquals(true, fehler);

        // Real Remove Test
        counter.next();
        counter.remove();

        l= 2;
        for(String i: words){
            Assert.assertEquals(teststingsIn[teststingsIn.length-l], i);
            l++;
        }

        // ModTest
        fehler = false;
        try {
            words.add("'_'");
            counter.next();
        }catch (ConcurrentModificationException e){
            fehler=true;
        }
        Assert.assertEquals(true, fehler);

        // ModTest
        fehler=false;
        try{
            counter.remove();
        }catch (ConcurrentModificationException e){
            fehler=true;
        }
        Assert.assertEquals(true, fehler);

        // ModTest
        fehler=false;
        try {
            while (counter.hasNext()){
                counter.next();
            }
            counter.next();
        }catch (ConcurrentModificationException e){
            fehler=true;
        }
        Assert.assertEquals(true, fehler);


        System.out.println("Test abgeschlossen...");
    }
}
