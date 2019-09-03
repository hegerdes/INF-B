package Blatt04.library;

import Blatt04.util.*;

/**
 * Repesents a Library
 * @author Henrik
 *
 */
public class Library {
	
	private List bestand;
	
	/**
	 * Constructor for a new Library
	 */
	public Library() {
		bestand = new List();
	}
	
	public void addItem(LibraryItem item) {
		if(item != null) {
			bestand.add(item);
		}else
		throw new RuntimeException("Kein g�ltiges LibraryItem �bergeben");
		
	}
	
	public void deleteItem(LibraryItem item) {
		if(item == null) {
			throw new RuntimeException("Es sind keine leeren Elemente in der Liste");
		}
		bestand.reset();
		while(!bestand.endpos() ){
			if(bestand.elem().equals(item)) {
				bestand.delete();
			}else
			bestand.advance();
		}
	}
	
	/**
	 * Searches for a match of content form text and every LibraryItem
	 * @param text String to search for
	 * @return List of matching LibraryItems
	 */
	public List search(String text) {
		bestand.reset();
		List result = new List();
		
		while(!bestand.endpos()) {
			if(((LibraryItem)(bestand.elem())).getDescription().contains(text)) {
				result.add(bestand.elem());	
			}
			bestand.advance();
		}
		
		if(!result.empty()) {
			result.reset();
			return result;
		}
		//System.err.println("Keine Ergebnisse gefunden");
		return null;
	}

	//public List getList() {return bestand;	}
	
	/**
	 * Parses a list of LibraryItems in a String
	 * @param liste List of LibraryItems
	 * @return String
	 */
	public static String toString(List liste) {
		if(liste != null) {
		
			StringBuilder a = new StringBuilder();
			int num = 1;
		
			while (!liste.endpos()) {
				if(liste.elem() instanceof LibraryItem) {
					a.append("Ergebniss " + num + ":  " + ((LibraryItem)liste.elem()).getDescription() + " \n");
					liste.advance();
					num++;
				}else throw new RuntimeException("Die Liste besteht nicht ausschlie�lich aus LibraryItems");
			}
			return a.toString();
		}else return "";
	}
	
}
