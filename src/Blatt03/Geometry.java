package Blatt03;

/******************************  Geometry.java  *******************************/


/**
 * @version 14.05.14
 *
 * @author lbrenning
 * @author cbenz
 */

public abstract class Geometry {

    private static int dimension;
    /**
     * Konstruktor der Klasse Geometry
     */
    public Geometry(int dimension) {
        this.dimension = dimension;
        if(dimension<2)
            throw new RuntimeException("Zu wenig Dimensionen");
    }
    /**
     * Gibt die Anzahl der Dimensionen wieder
     * @return Anzahl der Dimensionen
     */
    public int dimensions(){
        return this.dimension;
    }
    /**
     * Abstrakte Klasse volume, die das Volumen ausgeben wird
     */
    public abstract double volume();

}

