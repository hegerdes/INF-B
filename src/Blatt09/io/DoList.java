package Blatt09.io;

import java.io.File;


public class DoList implements FileVisitor {

    public static long doSize;
    private StringBuffer indent = new StringBuffer();

    private boolean recursive;
    private File root;

    public DoList(File root, boolean recursive) {
        doSize=0;
        this.recursive = recursive;
        this.root = root;
    }

    @Override
    public FileVisitResult postVisitDirectory(File dir) {
        indent = indent.delete(indent.length() - 2, indent.length());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(File dir) {
        //System.out.println(indent + "+ " + dir.getName());

        if (recursive || this.root.equals(dir)) {
            indent.append("| ");
            return FileVisitResult.CONTINUE;
        } else {
            return FileVisitResult.SKIP_SUBTREE;
        }
    }

    @Override
    public FileVisitResult visitFailed(File file) {
        System.out.print(indent);
        System.out.println(file.getName() + " (unreadable) ");
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(File file) {

        //System.out.print(indent);
        doSize+=file.length();
        //System.out.println(file.getName());

        return FileVisitResult.CONTINUE;
    }

    public static long getSize() {
        return doSize;
    }
}
