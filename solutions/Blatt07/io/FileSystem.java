package Blatt07.io;

import java.io.File;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Repesents a FileSystem withe a start directory.
 * It can hold a File or directory's
 * Can be visited withe a FileVisitor
 */
public class FileSystem {


    private final File root;

    /**
     * Constructor of the Filesystem
     * @param root The start File/directory
     * @throws if root does not exist or is null
     */
    public FileSystem(File root) {
        if(!root.exists() || root == null) {
          throw new IllegalArgumentException("Kein gültiges Strartverzeichnis uebergeben");
        }
        this.root = root;
    }

    /**
     * Connects the Filevisitor and the FileSystem
     * @param v A FileVisitor that visits all if accept is not returning false
     */
    public void accept(FileVisitor v){
        walkFile(root,v);
    }

    /**
     * Walks withe the FileVisitor over all Files
     * @param current The current File (Could be a recursiv call
     * @param v The FileVisitor
     * @return FileVisitResult Constants
     */
    private FileVisitResult walkFile(File current, FileVisitor v){

        // No read permission
        if(!current.canRead()){
            return v.visitFailed(current);
        }

        if (current.isDirectory()){
            FileVisitResult res = v.preVisitDirectory(current);

            switch (res){
                case CONTINUE:
                    File[] files = current.listFiles();
                    Arrays.sort(files);

                    for(File f : files){
                        if(walkFile(f, v)==FileVisitResult.TERMINATE){
                            return FileVisitResult.TERMINATE;
                        }
                    }
                    res = v.postVisitDirectory(current);
                case SKIP_SUBTREE:
                case TERMINATE:
                default: return res;
            }
        }
        else {
            return v.visitFile(current);

        }

    }

}
