package Blatt01;
/**
 * Every instance of <code>Fraction</code> represents a fraction with numerator
 * and denominator.
 *
 * @author Mathias Menninghaus (mathias.menninghaus@uos.de)
 */
public class Fraction {

   /**
    * Creates greatest common divisor for a and b.
    *
    * @param a
    * @param b
    * @return the greatest common divisor for a and b.
    */
   public static int gcd(int a, int b) {
      return b == 0 ? a : gcd(b, a % b);
   }
   
   /**
    * Parases a Fraction out of a String
    * @param s a string to be converted to Fraction
    * @throws a invalide input
    * @return Fraction with numarator and denumerator or null 
    */
   public static Fraction paraseFraction(String s) {
	if(s.matches("-?\\\\d+/[1-9]\\\\d*")) {
		String[] split = s.split("\\p{Punct}");
		return new Fraction(Integer.parseInt(split[0]),Integer.parseInt(split[1]));
	}
	else System.err.println("Die Eingabe ist kein g�ltiger Bruch. \n Bitte einen Bruch in diesem Format: Zahl/Zahl");
	   return null;
   }

   private final int numerator;

   private final int denominator;

   /**
    * Creates a Fraction object with numerator and denominator 1, cancels the
    * fraction with creation.
    *
    * @param numerator
    */
   public Fraction(int numerator) {
      this(numerator, 1);
   }

   /**
    * Creates a Fraction object with numerator and denominator, cancels the
    * fraction by creation. Denominator == 0 is not allowed.
    *
    * @param numerator   the numerator
    * @param denominator the denominator, must not be 0.
    * @throws RuntimeException if <code>denominator</code> is 0
    */
   public Fraction(int numerator, int denominator) {
      if (denominator == 0) {
         throw new RuntimeException("denominator == 0 is not possible");
      }

      /*
       * creates greatest common divisior.
       */
      int gcd = Fraction.gcd(numerator, denominator);
      /*
       * check sign, make denominator positive
       */
      if (denominator / gcd < 0) {
         gcd *= -1;
      }

      this.numerator = numerator / gcd;

      this.denominator = denominator / gcd;
   }
   
   /**
    * Adds one Fraction to another Fraction
    * @param addend another Fraction that will be added
    * @return new Fraction with result of two added Fractions 
    */
   public Fraction add(Fraction addend) {
	   if(addend.getDenominator()==this.getDenominator()) {
		   return new Fraction(addend.getNumerator()+this.getNumerator(), this.getDenominator());
	   }
	   return new Fraction((this.getNumerator()*addend.getDenominator()+this.getDenominator()*addend.getNumerator()),this.getDenominator()*addend.getDenominator());
   }
   
   /**
    * Subtracts one Fraction of another Fraction
    * @param subtrahend Fraction that will be subtracted
    * @return new Fraction with difference of both Fractions
    */
   public Fraction subtract(Fraction subtrahend) {
	   if(subtrahend.getDenominator()==this.getDenominator()) {
		   return new Fraction(subtrahend.getNumerator()-this.getNumerator(), this.getDenominator());
	   }
	   return new Fraction((this.getNumerator()*subtrahend.getDenominator()-this.getDenominator()*subtrahend.getNumerator()),this.getDenominator()*subtrahend.getDenominator());
   }

   /**
    * Divides this Fraction with another Fraction
    *
    * @param another Fraction to divide this Fraction by
    * @return quotient as a new Fraction
    * @throws RuntimeException if <code>numerator</code> of <code>another</code> is 0
    */
   public Fraction divide(Fraction another) {
      return new Fraction(this.numerator * another.denominator,
            this.denominator * another.numerator);
   }

   public int getDenominator() {
      return this.denominator;
   }

   public int getNumerator() {
      return this.numerator;
   }

   /**
    * Multiplies this Fraction with another Fraction
    *
    * @param factor Fraction to multiply this Fraction with
    * @return product as a new Fraction
    */
   public Fraction multiply(Fraction factor) {
      return new Fraction(this.numerator * factor.numerator, this.denominator
            * factor.denominator);
   }

   /**
    * Multiplies this Fraction with all other Fraction instances given by
    * factors
    *
    * @param factors Fraction instances to multiply this Fraction with
    * @return product as a new Fraction
    */
   public Fraction multiply(Fraction... factors) {
      Fraction result = this;
      for (int i = 0; i < factors.length; i++) {
         result = result.multiply(factors[i]);
      }
      return result;
   }

   /**
    * Multiplies this Fraction with int n.
    *
    * @param n factor to multiply with
    * @return product as a new Fraction
    */
   public Fraction multiply(int n) {
      return new Fraction(this.numerator * n, this.denominator);
   }

   /**
    * Returns a string representation of this Fraction such as
    * numerator/denominator.
    *
    * @return This Fraction as a String
    */
   public String toString() {
      return numerator + "/" + denominator;
   }
}
