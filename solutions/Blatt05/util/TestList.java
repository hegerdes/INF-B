package Blatt05.util;

public class TestList {

    public static void main(String[] args){

    MyList<String> lst = new MyList<>();

    lst.add("Das ist ");
    lst.add("ein ");
    lst.add("Test");


    MyList<String>clonelst;
    clonelst = lst.clone();

    // Make sure the cloned is the same object
        Assert.assertEquals(true,lst.getClass()==clonelst.getClass());

    // Testing if clone is not empty
        Assert.assertEquals(false, clonelst.empty());
    // Test equal of MyList
        lst.reset();
        clonelst.reset();
        Assert.assertEquals(true, lst.equals(clonelst));

    clonelst.reset();
    lst.reset();
    // Testing clone content
    while(!lst.endpos()||!clonelst.endpos()){
        Assert.assertEquals(lst.elem(),clonelst.elem());
        lst.advance();
        clonelst.advance();
    }

    clonelst.reset();
    lst.reset();
    lst.advance();
    // Testing independence
    Assert.assertEquals(false,lst.elem()==clonelst.elem());

    clonelst.add("!");

    // Testing reference behavior
    lst.reset();
    clonelst.reset();
    clonelst.advance();
    clonelst.delete();
    clonelst.reset();
    Assert.assertEquals(false,clonelst.elem()==lst.elem());



    /* while(!clonelst.endpos()){
        System.out.println(lst.elem());
        System.out.println(clonelst.elem());
        lst.advance();
        clonelst.advance();
    }*/
    //System.out.println(lst.hashCode() + " " +clonelst.hashCode());
    System.out.println("Test Abgeschlossen...");


    }
}
