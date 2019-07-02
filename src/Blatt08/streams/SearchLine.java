package Blatt08.streams;

import java.io.IOException;
import java.io.LineNumberReader;
import java.io.Reader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchLine extends LineNumberReader {

    private Pattern p;
    private int numOfLines;
    private int numOfMatches;

    /**
     * Create a new line-numbering reader, using the default input-buffer
     * size.
     *
     * @param in A Reader object to provide the underlying stream
     */
    public SearchLine(Reader in, String search) throws IllegalArgumentException {
        super(in);
        if(search == null) {
           throw new IllegalArgumentException("Kein Suchbegriff");
        }
        if(in == null){
            throw new NullPointerException("Kein Input gegeben");
        }
        this.p = Pattern.compile(search);
        this.numOfLines = 0;
        this.numOfMatches = 0;
    }

    /**
     * Reads in a line by Char-Stream by using super
     * If the line matches <code>p</code> the number of Matches
     * @return
     * @throws IOException
     */
    public String readLine() throws IOException {
        numOfMatches=0;
        String line = super.readLine();

        if(line != null){
            Matcher m = p.matcher(line);
            while (m.find()){
                numOfMatches++;
            }
            numOfLines++;
            return line;
        }
        return null;
    }

    /**
     * Gives the number of matches for the given Pattern
     * @return
     */
    public int getAmountOfMatches(){
        return numOfMatches;
    }

    /**
     * Gives the Number of the last read line
     * @return Number of last read line
     */
    public int getLineNumber(){
        return numOfLines;
    }



}
