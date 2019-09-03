package Blatt07.util;

public class VisitorTest {

    public static void main(String[] args) {

        //Test-data
        Integer[] ints = {-5,-82,6,91,71,42};

        MyList<Integer> intListIn = new MyList<>();

        // Fill the List
        for(Integer i : ints){
            intListIn.add(i);
        }

        MyList<Integer> intsCopy1 = new MyList<>();

        // New Visitor
        Visitor<Integer> visits1 = new Visitor<Integer>(){
            @Override
            public boolean visit(Integer o) {
                intsCopy1.add(o);
                intsCopy1.advance();
                return true;
            }
        };


        intListIn.accept(visits1);
        //Test If Lists are equal
        Assert.assertEquals(intListIn,intsCopy1);


        //Second Test
        MyList<Integer> intsCopy2 = new MyList<>();

        Visitor<Integer> visits2 = new Visitor<Integer>() {
            int i = 0;
            @Override
            // Put/Visit only the second and 4th element in List
            public boolean visit(Integer o) {
                    if (i==2 || i ==4){
                        intsCopy2.add(o);
                        intsCopy2.advance();
                    }
                    i++;
                    if(i>4){
                        return false;
                    }else return true;

            }
        };

        // Use Visit
        intListIn.accept(visits2);

        //Test the result
        Integer[] intsArrayAnPos2_4 = {-82,91};
        MyList<Integer> list2_4 = new MyList<>();
        for(Integer i: intsArrayAnPos2_4){
            list2_4.add(i);
        }

        //Compare intsCopy2 and list2_4
        Assert.assertEquals(list2_4,intsCopy2);

        System.out.println("Test abgeschlossen...");
    }


}
