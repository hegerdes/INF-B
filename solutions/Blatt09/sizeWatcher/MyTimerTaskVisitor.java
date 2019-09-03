package Blatt09.sizeWatcher;

import Blatt09.io.DoList;
import Blatt09.io.FileSystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.TimerTask;

/**
 * A TimeTask that walks with a FileVistor over the given File f and calc's the Filesize
 * If the size changes the new Filesize is printed.
 *
 */
public class MyTimerTaskVisitor extends TimerTask {

    private long size;
    private File file;

    /**
     * Default Constructor
     * @param f The File to walk over
     * @throws FileNotFoundException If the given File dose not exist
     */
    public MyTimerTaskVisitor(File f) throws FileNotFoundException {
        file = f;
        size=0;
        if(!f.exists()){
            throw new FileNotFoundException(f.getName() + " nicht gefunden");
        }
    }

    double start;
    /**
     * The action to be performed by this timer task.
     * Walks over the given File
     */
    @Override
    public void run() {
        start = System.nanoTime();
        //FileVisitor
        new FileSystem(file).accept(new DoList(file, true));
        //System.out.println("Zeit von Visitor: " + (start - System.nanoTime()));

        //Compare size
        if(DoList.getSize()!=size){
            size=DoList.getSize();
            String filetype = new String();
            if(file.isFile()){
                filetype = "Die Datei ";
            }else filetype = "Das Verzeichnis ";
            System.out.println(filetype + file.getName() + " ist " + size +" byte groß     -Über Visitor berechnet");
        }
    }
}

