package Blatt02;
/**
 * 
 * @author Henrik
 * @
 */
public class FibonacciPrint {

	public static void main(String[] args) {
		
		int fibNum = 0;		
		String s = args[0];
		if(s.matches("\\d*")) {
			fibNum= Integer.parseInt(s);
			Fibonacci fib1 = new Fibonacci();
			fib1.Print(fibNum);
		}else {
			System.err.println("Bitte eine Zahl >0 eingeben");
		}

	}

}
