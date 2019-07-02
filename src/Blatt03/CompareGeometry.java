package Blatt03;
public abstract class CompareGeometry extends Geometry implements Comparable{

	public CompareGeometry(int dim) {
		super(dim);
		
	}
	/**
	 * Compares two Objects of Geometry by volume
	 * @param o The Object to compare with
	 * @return Value <0, if other is bigger, 0 if other and this are the same, >0 if this is bigger
	 * @throws If o is not a Geometry
	 */	
	@Override
	 public int compareTo(Object o) {
	      if (o instanceof Geometry) {
	    	  if(this.dimensions()==((Geometry) o).dimensions()) {
	    		  return (int) ((this.volume() - ((Geometry) o).volume()));
	    	  }
	    	  throw new RuntimeException("Die Dimensionen der Objekte sind unterschiedlich");
	      } else {
	         throw new RuntimeException(o.getClass() + "is not a Geometry");
	      }
	   }
	

}
