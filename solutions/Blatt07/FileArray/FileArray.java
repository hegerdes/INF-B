package Blatt07.FileArray;

import java.io.*;

public class FileArray implements AutoCloseable{

    private static final short BYTE_SIZE = 4;
    private static RandomAccessFile file;


    /**
     * Creates a new File or writs in a existing one
     * Writes all Integers of <code>ints</code> in the file.
     * Note! If file already exsists it will be overridden
     * @param ints Array of Integers
     * @param name Name of the file
     */
    public FileArray(Integer[] ints, String name) throws IOException{
        File f = new File(name);
        if(!f.exists()){
            f.createNewFile();
        }
        file = new RandomAccessFile(f,"rws");
        for( Integer i: ints){
            file.writeInt(i);
        }
    }

    /**
     * New FileArray form a existing array
     * Look for the file and throws IOException if its non exsisting
     * @param name Name of the file
     * @throws IOException
     */
    public FileArray(String name) throws IOException{
        File f = new File(name);
        if(!f.exists()){
            throw new FileNotFoundException(name + "gibt es nicht");
        }
        file = new RandomAccessFile(f, "rws");
    }

    /**
     * Gets a specific Integer of the Filearray
     * @param i Indexpoint must be between 0 and array.length
     * @return Integer in Index i
     * @throws IOException If Reed or seek error
     */
    public Integer get(int i)throws IOException{
        if(i<0 || i> length()){
            throw new ArrayIndexOutOfBoundsException();
        }
        file.seek(i*BYTE_SIZE);
        return file.readInt();
    }

    /**
     * Sets one specific Integer at Index i
     * @param i Index position for the new Integer
     * @param elem The new Integer that will be written
     * @throws IOException If write or seef Fails
     */
    public void set(int i, Integer elem) throws IOException{
        if(i<0 || i> length()){
            throw new ArrayIndexOutOfBoundsException();
        }
        file.seek(i*BYTE_SIZE);
        file.writeInt(elem);
    }


    /**
     * Returns the length of a FileArray
     * @return Number of Elements
     * @throws IOException If Error
     */
    public int length()throws IOException{
        return (int)file.length()/BYTE_SIZE;
    }


    /**
     * Closes this resource, relinquishing any underlying resources.
     * This method is invoked automatically on objects managed by the
     * {@code try}-with-resources statement.
     *
     * <p><em>Implementers of this interface are also strongly advised
     * to not have the {@code close} method throw {@link
     * InterruptedException}.</em>
     * <p>
     * However, implementers of this interface are strongly encouraged
     * to make their {@code close} methods idempotent.
     *
     * @throws Exception if this resource cannot be closed
     */
    @Override
    public void close() throws IOException {
        this.file.close();
    }
}
