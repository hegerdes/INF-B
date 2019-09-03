package Blatt09.stringSearcher;

import Blatt09.io.FileVisitResult;
import Blatt09.io.FileVisitorAdapter;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;
import java.util.regex.Pattern;

/**
 * Visitor to Visit a FileSystem
 * If not recursive skip the sub Directory's
 * Starts a new Thread for every Visit and Calls SearchThread
 * SearchThread calls a InputStreamReader that ready all Stings in the give File
 */

public class DoParallelSearch extends FileVisitorAdapter {

    /**
     * Needed variable's
     */
    private Thread.UncaughtExceptionHandler exHandler;
    private Pattern regex;
    private File file;
    private boolean recursive;
    private LinkedList<Thread> threads;
    private ConcurrentHashMap<File,List<SearchLineResult>> results;

    public DoParallelSearch(File f, boolean recursive, Pattern p, Thread.UncaughtExceptionHandler uncaughtExceptionHandler ){
        this.file = f;
        this.recursive = recursive;
        this.regex = p;
        this.exHandler = uncaughtExceptionHandler;
        this.results = new ConcurrentHashMap<>();
        this.threads = new LinkedList<>();
    }
    /**
     * Called by the visiting FileSystem if the visitation of a directory failed,
     * thus if the directory is not-readable. May return
     * {@link FileVisitResult#CONTINUE} if the visiting of files and directories
     * should continue or {@link FileVisitResult#TERMINATE} if not.
     * {@link FileVisitResult#SKIP_SUBTREE} will have the same effect as
     * {@link FileVisitResult#CONTINUE}.
     *
     *           the directory that could not be visited
     * @return if the visit should continue or not.
     */
    @Override
    public FileVisitResult preVisitDirectory(File f){
        if (recursive) {
            return FileVisitResult.CONTINUE;
        } else {
            return FileVisitResult.SKIP_SUBTREE;
        }
    }
    /**
     * Called by the visiting FileSystem to visit a file with this FileVisitor.
     * May return {@link FileVisitResult#CONTINUE} if the visiting of files and
     * directories should continue or {@link FileVisitResult#TERMINATE} if not.
     * {@link FileVisitResult#SKIP_SUBTREE} will have the same effect as
     * {@link FileVisitResult#CONTINUE}.
     *
     * @param file
     *           the file that is visited
     * @return if the visit should continue or not.
     */
    @Override
    public FileVisitResult visitFile(final File file) {
        Thread crawler = new Thread(new SearchThread(file,regex,results));
        crawler.setUncaughtExceptionHandler(this.exHandler);
        crawler.start();
        this.threads.add(crawler);
        return FileVisitResult.CONTINUE;
    }

    /**
     * Getter for Threads
     * @return List oth running Threads
     */
    public LinkedList<Thread> getThreads() {
        return threads;
    }

    /**
     * Getter for result
     * @return The HashMap of a List of SearchLineResult's
     */
    public ConcurrentHashMap<File,List<SearchLineResult>> getResults() {
        return results;
    }
}
