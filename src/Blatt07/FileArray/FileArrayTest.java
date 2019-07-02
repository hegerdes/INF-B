package Blatt07.FileArray;

import Blatt06.util.Assert;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileArrayTest {

    public static void main(String[] args) {

        Integer[] ints = {35, 4, -90, 9, 65, 110};
        // Wertebereich AutoBoxing[-127,127]. Beim Tutor sicher gehen. Wie kann man das am einfachsten umgehen?

        // Testing Creation
        try (FileArray fArray = new FileArray(ints, "Test.txt")) {
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("Test");
        }

        //Testing Length
        try (FileArray fArray = new FileArray(ints, "Test.txt")) {
            Assert.assertEquals(ints.length, fArray.length());
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Testing get
        Integer[] fileOut = new Integer[ints.length];
        try (FileArray fArray = new FileArray(ints, "Test.txt")) {
            for(int i = 0; i<fArray.length();i++){
                fileOut[i]=fArray.get(i);
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        Assert.assertEquals(ints, fileOut);

        //Testing set und get
        try (FileArray fArray = new FileArray(ints, "Test.txt")) {
            fArray.set(1, 42);
            Assert.assertEquals(42,fArray.get(1));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (FileArray fArray = new FileArray(ints, "Test.txt")) {
            int i = fArray.get(-1);
        } catch (ArrayIndexOutOfBoundsException e) {
            Assert.assertEquals(true, e != null);
        }
        catch (IOException e){
            e.printStackTrace();
        }

        // Testing New FileArry that doesn't exsist
        try (FileArray fArray = new FileArray("Test.data")) {
        } catch (IOException e) {
            Assert.assertEquals(true, e != null);
        }

        System.out.println("Test abgeschlossen...");


    }
}
