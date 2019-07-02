package Blatt06.math;

public class FractionTest {


    public static void main(String[] args) {

        Fraction a = Fraction.instanceOfFraction(1, 2);
        Fraction b = Fraction.instanceOfFraction(3, 4);
        Fraction c = Fraction.instanceOfFraction(1);
        Fraction d = Fraction.instanceOfFraction(5, 10);

        assertEquals(a==d,true);
        assertEquals(a==b, false);



        assertEquals("1/4",b.substract(a));
        assertEquals("5/4",a.add(b));
        assertEquals("0/1", Fraction.instanceOfFraction(0, 23));
        assertEquals("3/4", Fraction.instanceOfFraction(-3, -4));
        assertEquals("-3/4", Fraction.instanceOfFraction(-3, 4));
        assertEquals("1/2", a);
        assertEquals("3/4", b);
        assertEquals("1/1", c);
        assertEquals("1/1", a.multiply(2));
        assertEquals("3/8", b.multiply(a));
        assertEquals("3/8", a.multiply(b));
        assertEquals("3/2", b.divide(a));
        assertEquals("2/3", a.divide(b));
        assertEquals("3/8", a.multiply(b, c));
        System.out.println("...tests finished");

    }

    private static void assertEquals(String expected, Fraction actual) {
        assertEquals(expected, actual.toString());
    }

    private static void assertEquals(boolean expected, boolean actual) {
        if((expected != actual)){
            System.out.println("FAIL [expectded: " + expected + " but was "
                    + actual + "]");
        }

    }

    private static void assertEquals(String expected, String actual) {
        if (!expected.equals(actual)) {
            System.out.println("FAIL [expectded: " + expected + " but was "
                    + actual + "]");
        }
    }


}
