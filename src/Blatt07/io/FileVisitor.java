package Blatt07.io;

import java.io.File;

public interface FileVisitor {


    public FileVisitResult visitFile(File file);

    public FileVisitResult visitFailed(File dir);

    public FileVisitResult preVisitDirectory(File dir);

    public FileVisitResult postVisitDirectory(File dir);
}
