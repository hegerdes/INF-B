package Blatt02;
/**
 * 
 * @author Henrik
 * Represents a Arena with 12 areas.
 * Sets the radius, can calculate if the given x,y is in the Arena and in witch area.
 *
 */
public class Arena {
	
	private double durchmesser;
	/**
	 * Constructor for a given radius times 2
	 * @param durchm given radius times 2
	 * @return Arena
	 */
	public Arena(double durchm) {
		durchmesser = durchm;
	}
	/**
	 * Default Constructor with default value
	 * @return Arena with r times 2 = 3
	 */
	public Arena() {
		this(3);
	}
	
	/**
	 * Checks if point is in Arena and gets the area {1 to 12} of a given point
	 * @param x X-Value of point
	 * @param y Y-Value of point
	 * @return the area witch the point is in
	 */
	public int getArea(double x, double y) {
		if(!imKreis(x,y)) {
			return -1;
		}else {
			if (x == 0 && y == 0) {
		      return 13;
			}
		}
		
		int area = (int)getAngle(x,y);
	      //second quarter
	      if (x > 0 && y <= 0) {
	        area = (90 - area)/30 + 3;
	        //first quarter
	      } else if (x >= 0 && y > 0) {
	        area = area/30;
	        //third quarter
	      } else if (x <=0  && y < 0) {
	        area = area/30 + 6;
	        //forth quarter
	      } else if (x < 0 && y>= 0 ) {
	        area = (90 - area)/30 + 9;
	      }
	    return area;
	}
	
	/**
	 * Calcs the angle of a given point !!Doesnt Work!!
	 * @param x X-Value of point
	 * @param y Y-Value of point
	 * @return the angle of the given point
	 */
	public double getAngle(double x, double y){
		
		return Math.toDegrees(Math.asin(Math.abs(x)/Math.hypot(Math.abs(x), Math.abs(y))));
	}
	
	/**
	 * Gets the Area {1 to 12} where the angle is in
	 * @param angle of give point
	 * @return Area of the angle/point
	 */
	public int getArea(double angle) {
		if(angle>360 || angle<0) {
			System.err.println("Falscher Winkel. Nicht im Spielfeld");
		}
		int bereich = 0;
		while(angle>0) {
			bereich++;
			angle= angle-30;
		}
		
		return bereich;
	}
	
	/**
	 * Checks if the given x,y is in the Arena by using pythagoras
	 * @param x X-Value of point
	 * @param y Y-Value of point
	 * @return true if point is in Arena else false
	 */
	public boolean imKreis(double x, double y) {
		if(Math.abs(x)>durchmesser || Math.abs(y)>(durchmesser)) {
			return false;
		}
		if(Math.sqrt(Math.pow(Math.abs(x), 2)+Math.pow(Math.abs(y), 2))>(durchmesser)) {
			return false;			
		}else return true;
	}
	

}
