package Blatt07;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;

@SuppressWarnings({"JavaDoc", "FieldCanBeLocal"})
public class CollectionTest {

    // Add the Testobjects
    private static LinkedList<String> lList = new LinkedList<>();
    private static ArrayList<String> aList = new ArrayList<>();
    private static HashSet<String> hSet = new HashSet<>();
    private static HashSet<String> hast2 = new HashSet<>();
    private static Collection[] subjects= {lList,aList,hSet, hast2};

    // List of the variablen names and methods to test
    private static String[] subjectNames = new String[subjects.length];
    private static String[] state = {"add", "contains", "remove"};

    private static int numOfLoops = 10000;
    private static Collection current;
    private static int numberOfTestObjects = subjects.length;
    private static int numberOfTestMethods = state.length;
    private static double min = 999999999;
    private static double[][] result = new double[numberOfTestObjects][numberOfTestMethods];
    private static double[][] percentResult = new double[numberOfTestObjects][numberOfTestMethods];


    public static void main(String[] args) {

        // For time Testing and Result Index
        double start;
        double time;
        double sum = 0;
        int index1 = 0;
        int index2 = 0;

        /**
         * For every <\code>testSubject</\code> and each methed of the testObject will be 10.000 calls
         * The time for every call is saved
         */
        for (Collection c : subjects) {
            current = c;
            for (String s : state) {
                for (int i = 0; i < numOfLoops; i++) {
                    start = System.nanoTime();
                    switch (s) {
                        case "add":
                            add("Test" + (i));
                            break;
                        case "remove":
                            remove("Test" + (i));
                            break;
                        case "contains":
                            contains("Test" +(i));
                            break;
                        default: throw new IllegalArgumentException("Diese Methode ist nicht testbar");
                    }

                    time = System.nanoTime() - start;
                    sum = sum + time;
                }
                // Save the result
                result[index1][index2] = sum / numOfLoops;
                index2++;
                // Back to beginning state for time
                sum= 0;
                //System.out.println(str + " " + s + " "+ sum);
            }
            index2 = 0;
            index1++;
        }

        // Output of Test
        buildSubjectNames();
        print(result);
        findMin(result);
        percent();
        System.out.println();
        System.out.println("Ergebnisse im vergleich zur kürzesten Zeit");
        print(percentResult);

    }

    /**
     * Testing add
     * @param s Sting to add the the Collection
     */
    private static void add(String s) {
                try {
                    current.add(s);
                } catch (Exception e) {
                    fehler();
                }
    }
    /**
     * Testing remove
     * @param s Sting to remove the the Collection
     */
    private static void remove(String s) {
        try {
            current.remove(s);
        } catch (Exception e) {
            fehler();
        }
    }
    /**
     * Testing contains
     * @param s Sting to be contained the the Collection
     */
    private static void contains(String s) {
        try {
            current.contains(s);
        } catch (Exception e) {
            fehler();
        }
    }

    // If testig throws an error Stop testing
    private static void fehler() {
        throw new RuntimeException("Beim Test der Methoden ist ein Fehler aufgetreten.");
    }

    /**
     * Prints the Result List
     * @param res
     */
    private static void print(double[][] res) {
        System.out.print("           |");
        for (int j = 0; j < res[0].length; j++) {
            System.out.printf("%10s|", state[j]);
        }
        System.out.println();
        System.out.println("+----------+----------+----------+----------+");
        for (int i = 0; i < res.length; i++) {
            System.out.printf("|%10s|", subjectNames[i]);
            for (int j = 0; j < res[i].length; j++) {
                System.out.printf("%10.2f|", res[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * finds the min number in the given array
     * @param res
     */
    private static void findMin(double[][] res) {
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                if (res[i][j] < min) {
                    min = res[i][j];
                }
            }
        }
    }

    /**
     * Calculates the results in %
     */
    private static void percent() {
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                percentResult[i][j] = result[i][j] / min;
            }
        }
    }

    /**
     * Builds a List of the Names of all Testsubjects
     */
    private static void buildSubjectNames(){
        StringBuilder[] stb = new StringBuilder[subjects.length];
        for(int i = 0;i<subjects.length;i++){
            stb[i] = new StringBuilder();
            stb[i].append(subjects[i].getClass().toString());
            stb[i].delete(0,16);
            subjectNames[i]=stb[i].toString();
        }
    }
}
