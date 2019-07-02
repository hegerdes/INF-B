package Blatt03;
/**
 * 
 * @author HenriK
 * Represents a two dimensional Point
 *
 */
public class Point2D extends Point{
	
	/**
	 * Default Constructor, uses super Constructor
	 * @param x x-Value of dimension 1
	 * @param y y-Value of dimension 2
	 */
	public Point2D(double x, double y) {
		super(x,y);
	}
	/**
	 * Creates a new minimal Geometry which includes this and the other Geometry
	 * Uses method of super class and a Cast to Rectangle
	 * @param other The other Geometry which should be included in the new Geometry
	 * @return Null if dimensions of this and other don't match else a new minimal Geometry including this and other
	 */
	public Geometry encapsulate(Geometry other) {
		if(other instanceof Point2D) {
			return new Rectangle(this,(Point2D)other);
		}
		if(other instanceof Rectangle) {
			return ((Rectangle) other).encapsulate(this);
		}
		return null;
	}


}
