package Blatt02;
/**
 * This class test the functions of Arena
 * @author Henrik
 *
 */
public class ArenaTest {

	public static void main(String[] args) {
		
	    Arena arena = new Arena (1.5);

	    Assert.assertEquals(-1, arena.getArea (2, 1));
	    
	    Assert.assertEquals(0, arena.getArea (0, 1));
	    Assert.assertEquals(6, arena.getArea (0, -1));
	    Assert.assertEquals(3, arena.getArea (1, 0));
	    Assert.assertEquals(9, arena.getArea (-1, 0));

	    Assert.assertEquals(-1, arena.getArea (1.6, 0.1));
	    Assert.assertEquals(1, arena.getArea (0.75, 0.75));
	    Assert.assertEquals(4, arena.getArea (0.75, -0.75));
	    Assert.assertEquals(7, arena.getArea (-0.75, -0.75));
	    Assert.assertEquals(10, arena.getArea (-0.75, 0.75));
	    Assert.assertEquals(13, arena.getArea (0, 0));
	    Assert.assertEquals(0, arena.getArea (0, 1));
	    Assert.assertEquals(8, arena.getArea (-1.49, -0.0001));
	    Assert.assertEquals(6, arena.getArea (0,-1));
	    Assert.assertEquals(6, arena.getArea (-0.3, -1.4));
	    Assert.assertEquals(3, arena.getArea (1, -0.4));
	    Assert.assertEquals(9, arena.getArea (-1.3, 0.3));
	    Assert.assertEquals(11, arena.getArea (-0.3, 1.3));

	    System.out.println("Tests abgeschlossen");
		

	}

}
