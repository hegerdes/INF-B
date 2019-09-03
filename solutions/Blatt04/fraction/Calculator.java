/**
 * 
 */
package Blatt04.fraction;

/**
 * @author Henrik
 *
 */
public class Calculator {
	
	/**
	 * Operator and Number formats
	 */
	
	static final String REGEX = "-?\\d+/\\d*[1-9]\\d*";
	static final String FLOAT = "-?\\d+\\.?\\d*";
	static final String SUB = "-";
	static final String ADD = "+";
	static final String MULTI= "//*";
	static final String DIV = "/";

	/**
	 * Main
	 * @param args
	 */
	public static void main(String[] args) {
		
		if(args.length != 3) {
			System.out.println("Es wurden zu viele Argumente Uebergeben. Erwartet: 3 \n"
					+ "Bekommen: " + args.length);
			benutzung();
		}else {
			Calculator r = new Calculator();
			String ausgabe = r.calculate(args[0], args[1], args[2]);
			System.out.println("= " + ausgabe);
			
		}

	}
	
	/**
	 * Calculate a Numer form strings
	 * @param s1 Number 1
	 * @param operator Operator
	 * @param s2 Number 2
	 * @return String with result
	 */
	private String calculate(String s1, String operator, String s2) {
		//System.out.println("Bin in String calc");
		Number num1 = prase(s1);
		Number num2 = prase(s2);
		
		return calculate(num1, operator, num2).toString();
	}
	
	/**
	 * Calcs new Nuber if Num 1 and Num 2 are not Fractions
	 * @param num1 Number 1
	 * @param operator Operator
	 * @param num2 Numer 2
	 * @return Number with result
	 */
	private Number calculate(Number num1, String operator, Number num2) {
		//System.out.println("Bin in Number calc");
		if(num1 instanceof Fraction && num2 instanceof Fraction) {
			return calculate((Fraction)num1, operator, (Fraction)num2);
		}
		Number ausgabe = null;
		
		switch(operator) {
		
		case ADD:
			ausgabe=num1.doubleValue()+num2.doubleValue();break;
		case SUB:
			ausgabe=num1.doubleValue()-num2.doubleValue();break;
		case MULTI:
			ausgabe=num1.doubleValue()*num2.doubleValue();break;
		case DIV:
			ausgabe=num1.doubleValue()/num2.doubleValue();break;
		default:
			System.err.println("Kein g�ltiger Operator");
			benutzung();break;
		}
		return ausgabe;
	}
	
	/**
	 * Calcs the result of two Fractions
	 * @param f1 Fraction 1
	 * @param operator Operator
	 * @param f2 Fraction 2
	 * @return Fraction with result
	 */
	private Fraction calculate(Fraction f1, String operator, Fraction f2) {
		System.out.println("Bin in Frac calc");

		Fraction ausgabe = null;
		
		switch(operator) {
		
		case ADD:
			ausgabe=f1.add(f2);break;
		case SUB:
			ausgabe=f1.subtract(f2);break;
		case MULTI:
			ausgabe=f1.multiply(f2);break;
		case DIV:
			ausgabe=f1.divide(f2);break;
		default:
			System.err.println("Kein g�ltiger Operator");
			benutzung();break;
		}
		return ausgabe;
	}
	
	/**
	 * Prases String in Number
	 * @param s String
	 * @return Number
	 */
	private Number prase(String s) {
		if(s.contains("/")) {
			return praseFraction(s);
		}
		if(s.matches(FLOAT)) {
			return Double.parseDouble(s);
		}
		System.err.println("Die eingabe ist Weder ein Bruch, noch eine Kommazahl");
		benutzung();
		return null;
	}
	
	/**
	 * Prase Fraction form String
	 * @param frac String with potential Fraction
	 * @return Fraction 
	 */
	private Fraction praseFraction(String frac) {
		if( frac.matches(REGEX)) {
			return Fraction.parseFraction(frac);
		}else {
			System.err.println("Die Eingabe war ein g�ltiger Bruch");
			benutzung();
			return null;
		}
		
	}
	
	/**
	 * Prints how to use the Class
	 */
	private static void benutzung() {
		System.err.println("Die Eingabe ist ungueltig.\n"
				+ "Benutzung: \n"
    	  		+ "Stelle 1: Natuerliche Zahl, Fliesskommazahl oder Bruch.         z.B. 3.1415 \n"
    	  		+ "Stelle 2: Operator. Gueltig sind:                              +, -, /, \"*\" \n"
    	  		+ "Stelle 3: Bruch. Gueltiges Format:                             -4/9");
	}

}
