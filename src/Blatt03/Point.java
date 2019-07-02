package Blatt03;
/**
 * Represents an n dimensional Point
 * extends Geometry
 * @author Henrik
 *
 */
public class Point extends CompareGeometry{

	private double[] points;
	
	/**
	 * Default Constructor
	 * Puts Value per dimension in an array
	 * @param punkte
	 */
	public Point(double ... punkte) {
		super(punkte.length);
		this.points = new double[punkte.length];
		for(int i = 0; i<punkte.length; i++) {
			points[i]=punkte[i];
		}
	}
	
	/**
	 * Gets the Volume of a Point
	 * @return 0 Since points have no volume
	 */
	public double volume() {
		return 0;
	}

	/**
	 * Creates a new minimal Geometry which includes this and the other Geometry
	 * @param other The other Geometry which should be included in the new Geometry
	 * @return Null if dimensions of this and other don't match else a new minimal Geometry including this and other
	 * @throws if dimensions don't match
	 */
	public Geometry encapsulate(Geometry other) {
		if(this.dimensions() != other.dimensions()) {
			return null;
		}
	    if (!(other instanceof Geometry)) {
	        throw new RuntimeException("Nur mit Geometry moeglich!");
	     }
		
		if(other instanceof Point) {
			return new Volume(this,(Point)other);
		}
		// Calls encapsulate of Volume
		if(other instanceof Volume) {
			if(((Volume) other).getPoint1().dimensions() != this.dimensions()) {
				throw new RuntimeException("Die Geometrys haben unterschiedliche Dimensionen");
			}
			return ((Volume) other).encapsulate(this);
		}
		return null;
		
	}
	
	/**
	 * Gets the coordinate per dimension
	 * @param index The wanted dimension
	 * @return Value of the given dimension
	 * @throws if Value for Dimension <0 or n+1 is wanted
	 */
	public double getValueByDimensions(int index) {
		if(index < 0 || index>points.length) {
			throw new RuntimeException("Kein Wert f�r Dimension <0");
		}
		return points[index];
	}
	
	/**
	 * Generates the smallest and biggest possible point for the given points
	 * @param dots Array of unlimited Number of Points
	 * @return Array of two Points. In first place the min Point, second the max Point
	 * @throws if dimensions don't match
	 */
	public static double[][] getMinMax(Point ... dots) {
		int dim = dots[1].dimensions();
		
		// Generate a limited Array for all min per dimension
		double[] mindots = new double[dim];
		// Generate a limited Array for all max per dimension
		double[] maxdots = new double[dim];
		// Go through all dimensions
		for(int i = 0; i<dim;i++) {
			// Sets random Value for min/max
			double min = dots[i].getValueByDimensions(i);
			double max = dots[i].getValueByDimensions(i);
			// Go through all Points
			for(int j=0;j<dots.length;j++) {
				// Dimension Check
				if(dots[i].dimensions() != dim) {
					throw new RuntimeException("Die �bergebenen Ponkte haben unterschiedliche "
							+ "Dimensionen");
				}
				//Assign new min
				if(dots[j].getValueByDimensions(i)<min) {
					min = dots[j].getValueByDimensions(i);
				}
				//Assign new max
				if(dots[j].getValueByDimensions(i)>max) {
					max = dots[j].getValueByDimensions(i);
				}
			}
			// Puts it in array
			mindots[i]=min;
			maxdots[i]=max;
		}
		// One array to return
		double[][] minmax= new double[2][];
		minmax[0] = mindots;
		minmax[1] = maxdots;

		return minmax;
	}


	/**
	 * Creates a String representation of a Point
	 * @return String for Point
	 */
	public String toString() {
		String s =new String();
		for(int i = 0;i<points.length;i++) {
			s = s + points[i]+ " ";
		}
		return s;
	}
}
