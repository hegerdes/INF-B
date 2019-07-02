package Blatt09.sizeWatcher;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Timer;

/**
 * A small tool to watch Filezie of a File
 */
public class SizeWatcher {

    private static String fileName;
    public static long difference;
    public static long start;

    public static void main(String[] args) {

        /**
         * Read in commandline argumentes
         */
        if(args.length != 1){
            printUsage();
        }else fileName = args[0];

        if(fileName==null){
            System.exit(0);
        }


        File f =new File(fileName);
        if(!f.exists()){
            printUsage();
            System.out.println("Das eingegebene Verzeichnis wurde nicht gefunden.");
            System.exit(0);
        }

        // Hocked Thread if main is killed
        Thread shut = new WatchEnd();
        Runtime.getRuntime().addShutdownHook(shut);

        // Two ways to calc File size
        Timer timeKeeper1 = new Timer();
        Timer timeKeeper2 = new Timer();

        difference = 0;
        start = System.nanoTime();
        //Using Filevisitor
        try {
            timeKeeper1.schedule(new MyTimerTaskVisitor(f),0,1000);
        } catch (FileNotFoundException e) {
            printUsage();
        }

        //Using Interator
        try {
            timeKeeper2.schedule(new MyTimerTaskInterator(f),0,1000);
        } catch (FileNotFoundException e) {
            printUsage();
        }
    }

    /**
     * Info MSG if Error in Input
     */
    private static void printUsage() {
        System.out.println("Die Eingabe ist nicht gueltig. \n" +
                "Bitte nur ein Verzeichnis/Dateiüfad eingeben");
    }
}
