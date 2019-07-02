package Blatt07;

import java.util.Collection;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * Vergleicht die Geschwindigkeit der Methoden add, contains und remove bei verschiedenen Collections
 *
 * @author Josephine
 */
public class Geschwindigkeit {

    /**
     * @param i case, bestimmt, welche Collection untersucht wird
     * @param method Methode, die untersucht wird
     * @return gibt die im Durchschnitt benoetigte Zeit zum Durchfuehren der entsprechenden Methode zurueck
     * @throws IllegalArgumentException wenn ein falscher case uebergeben wurde
     */
    public static long time(int i, String method){
         switch (i) {
            case 0:
                ArrayList arr = new ArrayList();
                return operation(arr,method);
            case 1:
                LinkedList list = new LinkedList();
                return operation(list,method);
            case 2:
                HashSet hash = new HashSet();
                return operation(hash,method);
            default:
                throw new IllegalArgumentException("Falscher Case");
        }



    }

    /**
     *  ruft die naechste Methode auf, welche add, contains, remove vielfach auffuehrt
     * @param set die uebergebene Collection
     * @param method die zu testende Methode
     * @return Zeit, die im Schnitt fuer die entsprechende Methode benoetigt wird
     */
    private static long operation(Collection set, String method){
        if(method == "add") {
            return add(set);
        }else if(method == ("contains")) {
            return contains(set);
        } else if(method == "remove"){
            return remove(set);
        }
        throw new IllegalArgumentException("Falsche Methode");
    }


    /**
     * prueft die durchschnittlich benoetigte Zeit fuer die Operation add bei der uebergebenen Collection
     * @param set die uebergebene Collection
     * @return durchschnittlich benoetigte Zeit fuer add bei der uebergebenen Collection
     */
    private static long add(Collection set){
        long time = System.nanoTime();
        for (int j = 500000; j>0; j--) {
            set.add(j);
        }
        return (System.nanoTime() - time) / 500000;
    }

    /**
     * prueft die durchschnittlich benoetigte Zeit fuer die Operation contains bei der uebergebenen Collection
     * @param set die uebergebene Collection
     * @return durchschnittlich benoetigte Zeit fuer contains bei der uebergebenen Collection
     */
    private static long contains(Collection set){
        long time = System.nanoTime();
        for (int j = 0; j <500000; j++) {
            set.contains(j);
        }
        return (System.nanoTime() - time) / 500000;
    }


    /**
     * prueft die durchschnittlich benoetigte Zeit fuer die Operation remove bei der uebergebenen Collection
     * @param set die uebergebene Collection
     * @return durchschnittlich benoetigte Zeit fuer remove bei der uebergebenen Collection
     */
    private static long remove(Collection set){
        long time = System.nanoTime();
        for (int j = 500000; j>0; j--) {
            set.remove(j);
        }
        return (System.nanoTime() - time) / 500000;
    }




    public static void main(String[] args) {
        //0 for ArrayList, 1 for LinkedList, 2 for HashSet
        long arrayAdd = time(0, "add");
        long arrayCon = time(0, "contains");
        long arrayRem = time(0, "remove");
        long linkedAdd = time(1, "add");
        long linkedCon = time(1, "contains");
        long linkedRem = time(1, "remove");
        long hashAdd = time(2, "add");
        long hashCon = time(2, "contains");
        long hashRem = time(2, "remove");



        System.out.println("          |  HashSet   | ArrayList | LinkedList ");
        System.out.println("----------+------------+-----------+------------");
        System.out.print("add()     | ");
        //schnelles Einfuegen von Elementen (Skript), hier am langsamsten. Einfuegen hier auch langsamer als contains und add
        System.out.printf("%11f",(double)hashAdd);
        System.out.print ("|");
        //hier schellstes add
        System.out.printf("%11f",(double)arrayAdd);
        System.out.print ("|");
        //schnelles Einfuegen, erfolgt direkt. Hier im Mittelfeld
        System.out.printf("%11f",(double)linkedAdd);
        System.out.println();
        System.out.println("----------+------------+-----------+------------");
        //
        System.out.print("contains()| ");
        //
        System.out.printf("%11f",(double)hashCon);
        System.out.print ("|");
        //schneller Zugriff. Hier Mittel
        System.out.printf("%11f",(double)arrayCon);
        //
        System.out.print ("|");
        //langsamer Zugriff auf Elemente (muss durchlaufen werden). Hier am schnellsten
        System.out.printf("%11f",(double)linkedCon);
        System.out.println();
        System.out.println("----------+------------+-----------+------------");
        System.out.print("remove()  | ");
        //
        System.out.printf("%11f",(double)hashRem);
        System.out.print ("|");
        //
        System.out.printf("%11f",(double)arrayRem);
        System.out.print ("|");
        //am langsamsten wegen sequentiellem Suchen (zu loeschendes Object muss erst gefunden werden)
        System.out.printf("%11f",(double)linkedRem);
        System.out.println();






    }
}
