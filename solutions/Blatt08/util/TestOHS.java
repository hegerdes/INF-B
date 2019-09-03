package Blatt08.util;

import Blatt08.test.Assert;

import java.io.*;

public class TestOHS {

    public static void main(String[] args) {

        OpenHashSet<Integer> hSetOut = new OpenHashSet<>();
        OpenHashSet<Integer> hSetIn = null;

        Integer[] ints = {-72,98,1,82,19};

        for (Integer i: ints){
            hSetOut.insert(i);
        }


        File serialH = new File("OpenHashSet.ser");
        try{
            if(!serialH.exists()){
                serialH.createNewFile();
            }
        } catch (IOException e) {
            System.out.println("Unable to create File");
            e.printStackTrace();
        }

        try(FileOutputStream fileOut = new FileOutputStream(serialH);
            ObjectOutputStream o = new ObjectOutputStream(fileOut);) {

            o.writeObject(hSetOut);
            o.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Can not serialise OpenHashSet");
            e.printStackTrace();
        }

        try (FileInputStream fileIn = new FileInputStream(serialH);
            ObjectInputStream i = new ObjectInputStream(fileIn)){

            hSetIn = (OpenHashSet<Integer>) i.readObject();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        Assert.assertEquals(hSetOut.toString(),hSetIn.toString());
        //Assert.assertEquals(hSetOut,hSetIn);


        System.out.println("Test abgeschlossen");
    }
}
