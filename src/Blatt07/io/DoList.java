package Blatt07.io;

import java.io.File;

/**
 * Repesents a File holding the Filestructor
 * Implemets FileVisitor
 * @see Blatt07.io.FileVisitor
 */
public class DoList implements FileVisitor {
    private StringBuffer indent = new StringBuffer();

    private boolean recursive;
    private File root;

    DoList(File root, boolean recursive) {
        this.recursive = recursive;
        this.root = root;
    }

    @Override
    public FileVisitResult postVisitDirectory(File dir) {
        // Removes the last Entry
        indent = indent.delete(indent.length() - 2, indent.length());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(File dir) {
        System.out.println(indent + "+ " + dir.getName());
        // Print all sub directory if recursive or if not recursive and dir is root
        if (recursive || this.root.equals(dir)) {
            // Builds the Tree Structure
            indent.append("| ");
            return FileVisitResult.CONTINUE;
        } else {
            return FileVisitResult.SKIP_SUBTREE;
        }
    }

    @Override
    public FileVisitResult visitFailed(File file) {
        // If visit fails
        System.out.print(indent);
        System.out.println(file.getName() + " (unreadable) ");
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(File file) {
        // Output of the actual Element
        System.out.print(indent);

        System.out.println(file.getName());

        return FileVisitResult.CONTINUE;
    }
}