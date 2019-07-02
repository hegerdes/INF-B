package Blatt07;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class CollectionTestAlt {

    // Add the Testobjects
    static LinkedList<String> lList = new LinkedList<>();
    static ArrayList<String> aList = new ArrayList<>();
    static HashSet<String> hSet = new HashSet<>();

    // List of the variablen names and methods to test
    static String[] testSubject = {"lList", "aList", "hSet"};
    static String[] state = {"add", "remove", "contains"};

    static long numOfLoops = 10000;
    static String current = new String();
    static int numberOfTestObjects = testSubject.length;
    static int numberOfTestMethods = state.length;
    static long min = 999999999;
    static long[][] result = new long[numberOfTestObjects][numberOfTestMethods];
    static long[][] resultP = new long[numberOfTestObjects][numberOfTestMethods];


    public static void main(String[] args) {

        // For time Testing and Result Index
        long start = 0;
        long time = 0;
        long sum = 0;
        int index1 = 0;
        int index2 = 0;


        /**
         * For every <\code>testSubject</\code> and each methed of the testObject will be 10.000 calls
         * The time for every call is saved
         */
        for (String str : testSubject) {
            current = str;
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
                        default:
                            break;
                    }

                    time = System.nanoTime() - start;
                    sum = sum + time;
                }
                // Save the result
                result[index1][index2] = sum / numOfLoops;
                index2++;
                // Back to beginning state for time
                start = time = sum= 0;
                //System.out.println(str + " " + s + " "+ sum);
            }
            index2 = 0;
            index1++;
        }



        // Output of Test
        print(result);
        findMin(result);
        percent();
        System.out.println();
        System.out.println("Ergebnisse im vergleich zur kürzesten Zeit");
        print(resultP);

    }

    static boolean add(String s) {
        switch (current) {
            case "lList": {
                try {
                    lList.add(s);
                } catch (Exception e) {
                    fehler();
                    return false;
                }
                return true;
            }
            case "aList": {
                try {
                    aList.add(s);
                } catch (Exception e) {
                    fehler();
                    return false;
                }
            }
            case "hSet": {
                try {
                    hSet.add(s);
                } catch (Exception e) {
                    fehler();
                }

            }
            default:
                return true;
        }

    }

    static boolean remove(String s) {
        switch (current) {
            case "lList": {
                try {
                    lList.remove(s);
                } catch (Exception e) {
                    fehler();
                    return false;
                }
                return true;
            }
            case "aList": {
                try {
                    aList.remove(s);
                } catch (Exception e) {
                    fehler();
                    return false;
                }
            }
            case "hSet": {
                try {
                    hSet.remove(s);
                } catch (Exception e) {
                    fehler();
                }

            }
            default:
                return true;
        }
    }

    static boolean contains(String s) {
        switch (current) {
            case "lList": {
                try {
                    lList.contains(s);
                } catch (Exception e) {
                    fehler();
                    return false;
                }
                return true;
            }
            case "aList": {
                try {
                    aList.contains(s);
                } catch (Exception e) {
                    fehler();
                    return false;
                }
            }
            case "hSet": {
                try {
                    hSet.contains(s);
                } catch (Exception e) {
                    fehler();
                }

            }
            default:
                return true;
        }
    }

    // If testig throws an error Stop testing
    static void fehler() {
        throw new RuntimeException("Beim Test der Methoden ist ein Fehler aufgetreten.");
    }

    // Prints the Result List
    static void print(long[][] res) {
        System.out.print("       ");
        for (int j = 0; j < res.length; j++) {
            System.out.printf("%10s|", state[j]);
        }
        System.out.println();
        System.out.println("+----------------+----------+----------+");
        for (int i = 0; i < res.length; i++) {
            System.out.printf("|%5s|", testSubject[i]);
            for (int j = 0; j < res[i].length; j++) {
                System.out.printf("%10d|", res[i][j]);
            }
            System.out.println();
        }
    }

    // finds the min number in the given array
    static void findMin(long[][] res) {
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                if (res[i][j] < min) {
                    min = res[i][j];
                }
            }
        }
    }

    static void percent() {
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                resultP[i][j] = result[i][j] / min;
            }
        }
    }
}
