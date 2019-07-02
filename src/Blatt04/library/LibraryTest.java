package Blatt04.library;

import Blatt06.util.Assert;

/**
 * @author Henrik
 * 
 * Test Class for Library
 *
 */
public class LibraryTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Library uos = new Library();
		
		Book b1 = new Book("Illuminati", "Dan Brown");
		Book b2 = new Book("Sakrileg", "Dan Brown");
		Book b3 = new Book("Das verlorene Symbol", "Dan Brown");
		
		Book b4 = new Book("Ragdoll", "Daniel Cole");
		Book b5 = new Book("Ich bin die Nacht", "Ethan Cross");
		Book b6 = new Book("Ich bin die Angst", "Ethan Cross");
		
		BluRay m1 = new BluRay("Illuminati", "Ron Howard");
		BluRay m2 = new BluRay("Fight Club", "David Fincher");
		BluRay m3 = new BluRay("The Imitation Game � Ein streng geheimes Leben", "Morten Tyldum");
		BluRay m4 = new BluRay("Matrix", "Lana Wachowski");
		BluRay m5 = new BluRay("7 Psychos", "Martin McDonagh");
		BluRay m6 = new BluRay("Prestige � Die Meister der Magie", "Christopher Nolan");
		
		uos.addItem(b1);
		uos.addItem(b2);
		uos.addItem(b3);
		uos.addItem(b4);
		uos.addItem(b5);
		uos.addItem(b6);
		uos.addItem(b1);
		
		uos.addItem(m1);
		uos.addItem(m2);
		uos.addItem(m3);
		uos.addItem(m4);
		uos.addItem(m5);
		uos.addItem(m6);
		
		m1.setBorrowed(true);
		Assert.assertEquals(b1.getAuthor(), "Dan Brown");
		Assert.assertEquals(b1.getTitle(), "Illuminati");
		Assert.assertEquals(m1.getTitle(), "Illuminati");
		Assert.assertEquals(m1.getDirector(), "Ron Howard");
		Assert.assertEquals(m1.isBorrowed(), true);
		
		Assert.assertEquals(Library.toString(uos.search("Matrix")), "Ergebniss 1:  Matrix von Lana Wachowski \n");
		uos.deleteItem(m4);
		Assert.assertEquals(Library.toString(uos.search("Matrix")), "");
		Assert.assertEquals(Library.toString(uos.search("Brown")), "Ergebniss 1:  Illuminati von Dan Brown \n" + 
				"Ergebniss 2:  Sakrileg von Dan Brown \n" + 
				"Ergebniss 3:  Das verlorene Symbol von Dan Brown \n" + 
				"Ergebniss 4:  Illuminati von Dan Brown \n");
		
		System.out.println("Test abgeschlossen...");
		
		
		
		
		

	}

}
