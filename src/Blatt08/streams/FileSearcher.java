package Blatt08.streams;

import java.io.IOException;
import java.io.InputStreamReader;

public class FileSearcher {
    // To Do
    // Prüfe ob Inputstream leer ist
    //System.exit(1);

    public static void main(String[] args) {

        if (args.length != 1) {
            printUsage();
        }else search(args[0]);
        if(System.in == null){
            printUsage();
        }


    }

    private static void printUsage(){
        System.out.println("Kein Suchbegriff eingegeben");
    }

    private static void search(String searchTerm){
        try (SearchLine lineIn = new SearchLine(new InputStreamReader(System.in), searchTerm)) {
            int teffer = 0;

            String outLine = lineIn.readLine();
            System.out.println("Ergebnisse der Suche für \"" + searchTerm + "\"");
            System.out.println("Zeile:   |Treffer: | Absatz:");
            System.out.println("---------+---------+-----------------------------");


            while(outLine != null){
                if(lineIn.getAmountOfMatches()>0){
                    String partLine;
                    teffer+=lineIn.getAmountOfMatches();
                    try {
                        partLine = "... " + outLine.substring(outLine.indexOf(searchTerm) - 10, outLine.indexOf(searchTerm) + 10) +" ...";
                    }catch (StringIndexOutOfBoundsException e){
                        partLine = "..." + outLine.substring(outLine.indexOf(searchTerm), outLine.indexOf(searchTerm) + searchTerm.length())+"...";
                    }
                    System.out.printf("|%8d| %8d| %20s", lineIn.getLineNumber(),lineIn.getAmountOfMatches(),partLine);
                    System.out.println();

                }
                outLine = lineIn.readLine();

            }
            System.out.println();
            System.out.println("Es  wurden insgesamt " + teffer + " Treffer für \""+searchTerm + "\" gefunden.");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
