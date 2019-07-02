package Blatt06.math;

import java.util.HashMap;

/**
 * Every instance of Fraction represents a fraction with numerator and
 * denominator.
 * 
 * @author Mathias Menninghaus (mathias.menninghaus@uos.de)
 * 
 */
public class Fraction extends Number implements HashFunction<Fraction> {

    public static HashMap<Integer,Fraction> fracs = new HashMap(10,2);
    private int key;

   /**
    * The regular expression that defines the String representation of a
    * Fraction.
    */
   public static final String REGEX = "-?\\d+/[1-9]\\d*";

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
    * Parses a Fraction from a String by using REGEX. Throws RuntimeException if
    * String s does not contain valid Fraction.
    * 
    * @param s
    *           String to be parsed
    * @return parsed String as Fraction
    * @throws RuntimeException
    *            if String s is not a valid Fraction
    */
   public static Fraction parseFraction(String s) {
      if (!s.matches(REGEX)) {
         throw new RuntimeException("Parsing error");
      }
      String[] splitted = s.split("/");

      return Fraction.instanceOfFraction(Integer.parseInt(splitted[0]),
              Integer.parseInt(splitted[1]));
   }

   /**
    * Calls <code>instanceOfFraction</code> withe a default Denumerator of 1
    * @param num Numerator
    * @return a new Fraction
    */
   public static Fraction instanceOfFraction(int num){
      return  Fraction.instanceOfFraction(num,1);
   }

   /**
    * public method to create a new Fraction
    * If the same Fraction is already created it returns the existing Fraction
    * @param num Numerator
    * @param denum Denominator
    * @return New Fraction
    */
   public static Fraction instanceOfFraction(int num, int denum){
      int key;
      Fraction instFrac = new Fraction(num,denum);

      key=instFrac.hashCode(instFrac);
      if(fracs.isEmpty()){
         fracs.put(key,instFrac);
      }

      if (fracs.containsKey(key)){
         instFrac = null;
         return fracs.get(key);
      }else{
         fracs.put(key,instFrac);
      }

      return instFrac;
   }

   private int numerator;

   private int denominator;

   /**
    * Creates a Fraction object with numerator and denominator, cancels the
    * fraction by creation. Denominator == 0 is not allowed.
    * 
    * @param numerator
    * @param denominator
    */
   private Fraction(int numerator, int denominator) {
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
    * Adds addend to this Fraction and return the result as a new Fraction.
    * 
    * @param addend
    *           Fraction to be added
    * @return the sum as a new Fraction
    */
   public Fraction add(Fraction addend) {
      return new Fraction(this.numerator * addend.denominator
            + this.denominator * addend.numerator, this.denominator
            * addend.denominator);
   }

   /**
    * Divides this Fraction with another Fraction
    * 
    * @param another
    *           Fraction to divide this Fraction by
    * @return quotient as a new Fraction
    */
   public Fraction divide(Fraction another) {
      return new Fraction(this.numerator * another.denominator,
            this.denominator * another.numerator);
   }

   /**
    * 
    * @return denominator of this Fraction
    */
   public int getDenominator() {
      return this.denominator;
   }

   /**
    * 
    * @return numerator of this Fraction
    */
   public int getNumerator() {
      return this.numerator;
   }

   /**
    * Multiplies this Fraction with another Fraction
    * 
    * @param another
    *           Fraction to multiply this Fraction with
    * @return product as a new Fraction
    */
   public Fraction multiply(Fraction another) {
      return new Fraction(this.numerator * another.numerator, this.denominator
            * another.denominator);
   }

   /**
    * Multiplies this Fraction with n.
    * 
    * @param n
    *           factor to multiply with
    * @return product as a new Fraction
    */
   public Fraction multiply(int n) {
      return new Fraction(this.numerator * n, this.denominator);
   }

   /**
    * Multiplies this Fraction with all other Fraction instances given by
    * factors
    * 
    * @param factors
    *           Fraction instances to multiply this Fraction with
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
    * Subtracts subtrahend from this Fraction an returns the result as a new
    * Fraction.
    * 
    * @param subtrahend
    *           to be substracted Fraction
    * @return the difference as a new Fraction
    */
   public Fraction substract(Fraction subtrahend) {
      return new Fraction(this.numerator * subtrahend.denominator
            - this.denominator * subtrahend.numerator, this.denominator
            * subtrahend.denominator);
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

   @Override
   public int intValue() {
      return (int) (doubleValue() + 0.5);
   }

   @Override
   public long longValue() {
      return (long) (doubleValue() + 0.5);
   }

   @Override
   public float floatValue() {
      return (float) doubleValue();
   }

   @Override
   public double doubleValue() {
      return (double) this.getNumerator() / (double) this.getDenominator();
   }

   /**
    * Defines the equality of two objects as defined by {@link Object#equals(Object)}
    * but in relation to the {@link HashFunction#hashCode(Object)} method in this
    * <code>HashFunction</code>.
    *
    * @param o1
    * @param o2
    */
   @Override
   public boolean equals(Fraction o1, Fraction o2) {
      if(o1.getDenominator() == o2.getDenominator() && o1.getNumerator() == o2.getNumerator()){
         return true;
      } else return false;
   }

   /**
    * Defines the hash code of an object as defined by {@link Object#hashCode()}
    * but in relation to the {@link HashFunction#equals(Object, Object)} method in
    * this <code>HashFunctions</code>.
    *
    * @param o
    */
   @Override
   public int hashCode(Fraction o) {
      final int prime = 31;
      int result = 1;
      result = prime * result + denominator;
      result = prime * result + numerator;
      return result;
   }
}
