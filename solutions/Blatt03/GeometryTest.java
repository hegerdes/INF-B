package Blatt03;
/**
 * Test Class for Geometry
 * @author Henrik
 *
 */
public class GeometryTest {

	public static void main(String[] args) {
		
		Point p1 = new Point(6,5,4);
		Point p2 = new Point(1,9,2);
		Point p3 = new Point(20,3,-5);
		Point p4 = new Point(-15,80,3);
		
		Volume vol1 = new Volume(p1,p2);
		Volume vol2 = new Volume(p3,p4);
		Volume vol3 = (Volume)p1.encapsulate(p2);
		Volume vol4 = (Volume)p1.encapsulate(vol2);
		Volume vol5 = (Volume)vol2.encapsulate(p1);
		Volume vol6 = (Volume)vol2.encapsulate(vol1);
		Volume vol7 = (Volume)vol2.encapsulate(vol2);
		
		Point2D p2d1= new Point2D(6,7);
		Point2D p2d2= new Point2D(1,8);
		Point2D p2d3= new Point2D(53,4);
		
		Rectangle r1= new Rectangle(p2d1,p2d2);
		Rectangle r2= new Rectangle(p2d1,p2d3);
		Rectangle r3= (Rectangle)p2d1.encapsulate(p2d2);
		Rectangle r4= (Rectangle)p2d1.encapsulate(r2);
		Rectangle r5= (Rectangle)r2.encapsulate(p2d1);
		Rectangle r6= (Rectangle)r2.encapsulate(r1);
		
		vol4.volume();
		
		
		// Dim and Capsel-Test
		Assert.assertEquals(p1.dimensions(),3);
		Assert.assertEquals(p2.dimensions(),3);
		Assert.assertEquals(vol1.dimensions(),3);
		Assert.assertEquals(vol2.dimensions(),3);
		Assert.assertEquals(p2d1.dimensions(),2);
		Assert.assertEquals(p2d2.dimensions(),2);
		Assert.assertEquals(r1.dimensions(),2);
		Assert.assertEquals(r2.dimensions(),2);
		Assert.assertEquals(p1.volume(),(double)0);
		Assert.assertEquals(p1.volume(),p2.volume());
		Assert.assertEquals(r1.volume(),(double)5);
		Assert.assertEquals(r2.volume(),(double)141);
		Assert.assertEquals(r3.volume(),r1.volume());
		Assert.assertEquals(r4.volume(),(double)141);
		Assert.assertEquals(r4.volume(),r5.volume());
		Assert.assertEquals(r6.volume(),(double)208);
		Assert.assertEquals(vol1.volume(),(double)40);
		Assert.assertEquals(vol2.volume(),(double)21560);
		Assert.assertEquals(vol1.volume(),vol3.volume());
		Assert.assertEquals(vol4.volume(),(double)24255);
		Assert.assertEquals(vol4.volume(),vol5.volume());
		Assert.assertEquals(vol6.volume(),(double)24255);
		Assert.assertEquals(vol2.volume(),vol7.volume());
		
		//Equals Test
		Assert.assertEquals(p2.compareTo(p1),0);
		Assert.assertEquals(p3.compareTo(p1),0);
		Assert.assertEquals(p3.compareTo(p4),0);
	
		Assert.assertEquals(vol1.compareTo(vol2),-21520);
		Assert.assertEquals(vol7.compareTo(vol2),0);
		
		Assert.assertEquals(r2.compareTo(r1),136);
		Assert.assertEquals(r5.compareTo(r4),0);
		
		
		System.out.println("Test Abgeschlossen ...");
		

	}

}
