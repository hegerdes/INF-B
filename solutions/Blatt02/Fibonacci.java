package Blatt02;
import java.util.*;
/**
 * 
 * @author Henrik
 * Implements a Object representing the Fibonacci numbers, using a Int ArrayList 
 */
public class Fibonacci {
	
	/**
	 * Class attributes
	 */
	private List<Integer> folge = new ArrayList<Integer>();
	private int pos;
	
	/**
	 * Default constructor
	 * Adding the first two necessary fib numbers
	 */
	public Fibonacci() {
		folge.add(0);
		folge.add(1);
		pos=1;
	}
	
	/**
	 * Calculates the next fib number and adds it to the list
	 * @return the new fib number
	 * @throws If fib number is bigger then int-space
	 */
	public int next() {
		folge.add(folge.get(pos-1)+folge.get(pos));
		pos++;
		if(folge.get(pos)<0) {
			throw new RuntimeException("Wertebereich f�r Int-Daten �berschritten");
		}
		return folge.get(pos);
	}
	
	/**
	 * Gets The Fib-number of Index i
	 * @param i Index number of fib
	 * @return The Fib number for i
	 * @throws If i<0 Fibonacci is only defined for i>0
	 */
	public int get(int i) {
		if(i<0) {
			throw new RuntimeException("Die Fibonaccifolge hat keinen Wert f�r negative Indezes");
		}
		if(i>pos) {
			for(int j=i;pos<j;j++) {
				this.next();
			}
		}
		return folge.get(i);
	}
	
	/**
	 * Prints a formated list of all Fib-numbers till index i to commandline
	 * @param n Amount and index of the printed Fib-numbers 
	 * @throws If i<0 Fibonacci is only defined for i>0
	 */
	public void Print(int n) {
		if(n<0) {
			throw new RuntimeException("Die Fibonaccifolge hat keinen Wert f�r negative Indezes");
		}
		System.out.println("|  n  |   f(n)   |");
		System.out.println("+-----+----------+");
		for(int i=0;i<=n;i++) {
			this.next();
			System.out.printf("|%5d|%10d|%n",i,this.get(i));
		}
		System.out.println("+-----+----------+");
	}

}
