package Blatt09.io;

import java.io.IOException;
import java.io.LineNumberReader;
import java.io.Reader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * Extends the LineNumberReader by searching for matches with a given regular
 * expression and numOfMatchesing them while reading.
 * 
 * @author Henrik Gerdes
 * 
 */
public class SearchLineReader extends LineNumberReader {

   /**
    * {@code Pattern} to search matches for
    */
   private final Pattern p;

   /**
    * total amount of currently found matches with {@code pattern}
    */
   private int numOfMatches;
   /**
    * number of the line where currently found matches with {@code pattern}
    */
   private int numOfLines;

   /**
    * 
    * @param in
    *           {@code Reader} to be wrapped by this {@code SearchLineReader}
    * @param search
    *           regular expression to search for
    */
   public SearchLineReader(Reader in, Pattern search) {
      super(in);
      if(search == null) {
         throw new IllegalArgumentException("Kein Suchbegriff");
      }
      if(in == null){
         throw new NullPointerException("Kein Input gegeben");
      }
      this.p = search;
      this.numOfLines = 0;
      this.numOfMatches = 0;
   }

   /**
    * 
    * @param in
    *           {@code Reader} to be wrapped by this {@code SearchLineReader}
    * @param search
    *           regular expression to search for
    * @throws PatternSyntaxException
    *            if {@code search} is not a valid regular expression.
    */
   public SearchLineReader(Reader in, String search) {
      super(in);
      if(search == null) {
         throw new IllegalArgumentException("Kein Suchbegriff");
      }
      if(in == null){
         throw new NullPointerException("Kein Input gegeben");
      }
      this.p = Pattern.compile(search);
      this.numOfLines = 0;
      this.numOfMatches = 0;;
   }

   @Override
   public String readLine() throws IOException {
      numOfMatches=0;
      String line = super.readLine();

      if(line != null){
         Matcher m = p.matcher(line);
         while (m.find()){
            numOfMatches++;
         }
         numOfLines++;
      }
      return line;
   }

   /**
    * Get the number of matches with the given regular expression in the latest
    * read line via {@link #readLine()}.
    * 
    * @return number of already found matches in the last call of
    *         {@link #readLine()} with the given regular expression of this
    *         {@code SearchLineReader}
    */
   public int getAmountOfMatches() {
      return this.numOfMatches;
   }

   /**
    * Gives the Number of the last read line
    * @return Number of last read line
    */
   public int getLineNumber(){
      return numOfLines;
   }
}
