package Blatt03;
/**
 * Represents a Rectangle in a two dimensional space
 * @author Henrik
 *
 */
public class Rectangle extends Volume {
	
	/**
	 * Default Constructor using super Constructor
	 * @param p1 Two dimensional Point 1
	 * @param p2 Two dimensional Point 2
	 * @return Rectangle
	 */
	public Rectangle(Point2D p1, Point2D p2) {
		super(p1,p2);
	}
	
	/**
	 * Creates a new minimal Geometry which includes this and the other Geometry
	 * Uses method of super class and a Cast to Rectangle
	 * @param other The other Geometry which should be included in the new Geometry
	 * @return Null if dimensions of this and other don't match else a new minimal Geometry including this and other
	 */
	public Geometry encapsulate(Geometry other) {
		if(other instanceof Point2D) {
			double[][] minmax = Point.getMinMax(this.getPoint1(),this.getPoint2(),(Point)other);
			return new Rectangle(new Point2D(minmax[0][0],minmax[0][1]),new Point2D(minmax[1][0],minmax[1][1]));
		}
		if(other instanceof Rectangle) {
			double[][] minmax = Point.getMinMax(this.getPoint1(),this.getPoint2(),((Rectangle)other).getPoint1(),((Rectangle)other).getPoint2());
			return new Rectangle(new Point2D(minmax[0][0],minmax[0][1]),new Point2D(minmax[1][0],minmax[1][1]));
		}
		return null;
	}

}
