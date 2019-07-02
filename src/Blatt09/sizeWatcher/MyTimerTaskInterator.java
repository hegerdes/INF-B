package Blatt09.sizeWatcher;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.TimerTask;

/**
 * A TimeTask that walks with a Interator over the given File f and calc's the Filesize
 * If the size changes the new Filesize is printed.
 *
 */

public class MyTimerTaskInterator extends TimerTask {

    private long size;
    private long lastsize;
    private File file;

    /**
     * Default Constructor
     * @param f The given File
     * @throws FileNotFoundException if the File does not exist
     */
    public MyTimerTaskInterator(File f) throws FileNotFoundException {
        size = lastsize = 0;
        file = f;

        if(!file.exists()){
            throw new FileNotFoundException(file.getName() + " gibt es nicht");
        }
    }

    /**
     * Walks over all Files in the <code>file</code>
     * @param file The File to walk over
     * @return The size in byte
     */
    private long walker(File file){
        long tmp =0;
        try {
            for (File f : file.listFiles()) {
                if (f != null & f.isFile()) {
                    tmp += f.length();
                } else {
                    tmp += walker(f);
                }
            }
            return tmp;
        }catch (NullPointerException e){
            return tmp;
        }
    }
    double start;

    /**
     * The action to be performed by this timer task.
     * Calls walker and compares the old and new size
     * If it changes the new size ist printed
     */
    @Override
    public void run() {
        start = System.nanoTime();
        size=walker(file);
        //System.out.println("Zeit von Interator: " + (start - System.nanoTime()));

        if(lastsize !=size){
            if(lastsize!=0){
                SizeWatcher.difference += size-lastsize;
            }
            lastsize = size;
            String filetype = new String();
            if(file.isFile()){
                filetype = "Die Datei ";
            }else filetype = "Das Verzeichnis ";
            System.out.println(filetype + file.getName() + " ist " + size +" byte groß     -Über Interator berechnet");
        }



    }
}
