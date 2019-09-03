package Blatt09.stringSearcher;

import Blatt09.io.FileSystem;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class ParallelSearcher {

    public static void main(String[] args) {
        /*
         * options and arguments
         */
        boolean recursive = false;
        Pattern regex = null;
        String search = new String();
        String path = new String();
        File f;

        /*
         * determine whether all arguments are read or not
         */
        boolean argumentsRead = false;

        if(args.length==0){
            System.exit(1);
        }

        int i = 0;
        while (!argumentsRead && i < args.length) {

            /*
             * read out the arguments
             */
            switch (args[i]) {
                case "-r":
                    recursive = true;
                    i++;
                    break;
                default:
                    /*
                     * arguments must be set at the beginning. Every String which isn't
                     * an argument, must be a path
                     */
                    argumentsRead = true;
                    break;
            }
        }
        /*
         * next argument must be search string
         */
        if (i >= args.length) {
            printUse("Fehler: " + "No expression to search for found");
        } else {
            search = args[i++];
        }



        /*
         * next argument must be the file or directory to search in
         */
        if (i >= args.length) {
            f = new File(".");
        } else {
            path =args[i];
            f = new File(args[i++]);
        }

        if (!f.exists()) {
            printUse("Fehler: " + f + " does not exist");
        }


//        //HardCode
//        recursive=true;
//        search = "Thread";
//        f = new File("src/Blatt09");

        try {
            regex = Pattern.compile(search);
        } catch (PatternSyntaxException e) {
            printUse("invalid regular expression: " + e.getDescription());
        }

        Thread.UncaughtExceptionHandler exceptionHandler = new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                printUse(e.getMessage());
            }
        };

        DoParallelSearch searcher = new DoParallelSearch(f, recursive, regex, exceptionHandler);

        try{
            new FileSystem(f).accept(searcher);
        }catch (Exception e){
            System.out.println("Es ist ein Fehler aufgetreten");
            System.exit(1);
        }

        for(Thread t :searcher.getThreads()){
            try {
                t.join();
            } catch (InterruptedException e) {
                System.out.println("Es ist ein Fehler aufgetreten");
                e.printStackTrace();
            }
        }


        ConcurrentHashMap<File, List<SearchLineResult>> result = searcher.getResults();
        printResult(result,path,regex.toString());



    }

    private static void printResult(ConcurrentHashMap<File, List<SearchLineResult>> result,String path, String searchterm){
        if(result.size()==0){
            System.out.println("Es wurden keine Ergebnisse für " + searchterm + " gefunden.");
        }else {
            int i = 0;
            System.out.println("\nIm Verzeichnis " + path + " wurden " + result.size() + " Dateien gefunden, in denen \""
                    + searchterm + "\" vorkommt. \n");
            System.out.println("Dateien, in denen der Suchbegiff gefunden wurde:\n");

            //Overview of all Found Files with searchtearm
            for (Map.Entry<File, List<SearchLineResult>> e : result.entrySet()) {
                i++;
                if (i % 2 != 0) {
                    System.out.printf("|%3d: %-25s", i, e.getKey().getName());
                } else {
                    System.out.printf("|%3d: %s", i, e.getKey().getName());
                    System.out.println();
                }
            }
            System.out.println();
            for (Map.Entry<File, List<SearchLineResult>> e : result.entrySet()) {
                System.out.println();
                System.out.println("In Datei " + e.getKey().getName() + ":");
                System.out.println("Zeile:   |Treffer: | Absatz:");
                System.out.println("---------+---------+-----------------------------");
                for (SearchLineResult sr : e.getValue()) {
                    System.out.printf("|%8d| %8d| %20s ", sr.getLineNumber(), sr.getAmountOfMatches(), sr.getLine());
                    System.out.println();
                }
            }
        }
    }

    private static void printUse(String s){
        System.out.println("Die Suche war nicht möglich");
        System.out.println("Bitte geben Sie ihren Suchbegiff und den Pfad an \n");
        System.out.println("Beispiel:   -r Test src\n");
        System.out.println("Beim Suchen von mehr als einem Wort bitte \"\" benutzen.\n");
        if(s!=null){
            System.out.println(s);
        }
    }
}
