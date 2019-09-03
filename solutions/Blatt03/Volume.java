package Blatt03;
/**
 * Representing a Volume. Build by two Points
 * @author Henrik
 *
 *
 */
public class Volume extends CompareGeometry{
	
	private Point p1;
	private Point p2;
	private double[] edge;
	
	/**
	 * Default Constructor	
	 * @param po1 Point1 with n Dimension
	 * @param po2 Point2 with n Dimension
	 * @return A Volume
	 * @throws if po1 and po2 unmatched dimensions
	 */
	public Volume(Point po1, Point po2) {
		super(po1.dimensions());
		
		if (po1.dimensions() != po2.dimensions()) {
			throw new RuntimeException("Die Punkte müssen die gleiche Dimension haben!");
	    }
		this.p1 = po1;
		this.p2 = po2;
	}
	
	/**
	 * Gets the Volume of an Volume
	 * @return The volume
	 */
	public double volume() {
		createEdges();
		double vol = edge[0];
		for(int i = 1; i < edge.length; i++) {
			vol *=edge[i];
		}
		return vol;
	}
	
	/**
	 * Creates a new minimal Geometry which includes this and the other Geometry
	 * @param other The other Geometry which should be included in the new Geometry
	 * @return Null if dimensions of this and other don't match else a new minimal Geometry including this and other
	 * @throws if Dimensions don't match
	 */
	public Geometry encapsulate(Geometry other) {
		if(this.dimensions()!=other.dimensions()) {
			return null;
		}
		
		if(other instanceof Point) {
			if(other.dimensions()!=p1.dimensions()) {
				throw new RuntimeException("Die Geometrys haben unterschiedliche Dimensionen");
			}
			double[][] minmax = Point.getMinMax((Point)other,this.getPoint1(),this.getPoint2());
			return new Volume(new Point(minmax[0]),new Point(minmax[1]));
		}
		
		if(other instanceof Volume) {
			double[][] minmax = Point.getMinMax(((Volume) other).getPoint1(),((Volume) other).getPoint2(),this.getPoint1(),this.getPoint2());
			return new Volume(new Point(minmax[0]),new Point(minmax[1]));
		}
		
		return null;
	}
	
	
	/**
	 * Creates the Edge's of an Volume and saves the length of every edge in an array
	 * Numbers of edges = number of dimensions
	 */
	private void createEdges() {
		this.edge = new double[p1.dimensions()];
		for(int i = 0; i<p1.dimensions();i++ ) {
			edge[i]=Math.abs(p1.getValueByDimensions(i)-p2.getValueByDimensions(i));
		}
	}
	
	/**
	 * Getter for Point 1
	 * @return Point 1
	 */
	public Point getPoint1() {
		return this.p1;
	}

	/**
	 * Getter for Point 1
	 * @return Point 1
	 */
	public Point getPoint2() {
		return this.p2;
	}
	
	/**
	 * Creates a String representig a Volume
	 * @return String for Volume
	 */
	public String toString() {
		return "Punkt 1: " + p1.toString() + " Punkt 2: " + p2.toString();
	}
	
	
	

}
