package Blatt09.stringSearcher;

import java.io.File;

/**
 * Class holding searchresults of a Stirng search
 * To store result's with simple getter function
 */
public class SearchLineResult {

    private String line;
    private int lineNumer;
    private int matchCounter;
    private File file;

    public SearchLineResult(String linein, int lineNumer, int matchCounter){
        this(linein,lineNumer,matchCounter,null);
    }


    public SearchLineResult(String linein, int lineNumer, int matchCounter, File f){
        this.line = linein;
        this.lineNumer = lineNumer;
        this.matchCounter = matchCounter;
        this.file = f;
    }

    public String getLine() {
        return line;
    }

    public int getLineNumber() {
        return lineNumer;
    }

    public int getAmountOfMatches() {
        return matchCounter;
    }

    public File getFile(){
        return file;
    }
}
