package Blatt09.stringSearcher;

import Blatt09.io.SearchLineReader;

import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;
import java.util.regex.Pattern;

/**
 * Starts a new SearchFileLine activity and saves the result in a HashMap of Lists
 */
public class SearchThread implements Runnable {

    private File file;
    private Pattern regx;
    private ConcurrentHashMap<File,List<SearchLineResult>> results;

    public SearchThread(File f, Pattern p, ConcurrentHashMap<File,List<SearchLineResult>> result){
        this.file = f;
        this.regx = p;
        this.results = result;
    }



    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() throws RuntimeException {
        List resultsList = null;

        try(FileReader fileReader = new FileReader(file);
            SearchLineReader readerIn = new SearchLineReader(fileReader,regx)){

            //Holds the read String of the Stream
            String lineIn = readerIn.readLine();
            while (lineIn!=null){
                String partLine;
                // Check if any Match was found
                if(readerIn.getAmountOfMatches()>0){
                    //Save just save a part of the String
                    try {
                        partLine = "... " + lineIn.substring(lineIn.indexOf(regx.toString()) - 10,
                                lineIn.indexOf(regx.toString()) + 10) +" ...";
                    }catch (StringIndexOutOfBoundsException e){
                        partLine = "..." + lineIn.substring(lineIn.indexOf(regx.toString()),
                                lineIn.indexOf(regx.toString()) + regx.toString().length())+"...";
                    }
                    // A other Thread may have searched in the File before
                    // Snc the results
                    if(resultsList==null){
                        if(results.containsKey(file)){
                            resultsList = results.get(file);
                        }else{
                            resultsList = new LinkedList();
                            results.put(file,resultsList);
                        }
                    }
                    // Change the Value of the HashMap
                    resultsList.add(new SearchLineResult(partLine, readerIn.getLineNumber(), readerIn.getAmountOfMatches(), file));
                }
                // Next Line from Stream
                lineIn = readerIn.readLine();
            }

        }catch (Exception e){
            throw new RuntimeException(e);

        }
    }
}
