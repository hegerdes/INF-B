package Blatt07.io;

import java.io.File;

public class List {

    public static void main(String[] args) {

        //Check all sub directory's?
        boolean recursive = false;

        //The directory to repesent
        String dir;

        if(args.length>2){
            throw new RuntimeException("Zu viele argumente");
        }

        if(args.length == 0){
            dir = ".";
        }else {
            if (args[0].matches("-r")) {
                recursive = true;
                if (args.length == 2) {
                    dir = args[1];
                } else dir = ".";
            } else {
                dir = args[0];
            }
        }

       // Output of all wanted Files
        System.out.println("Listing " + dir);
        File f = new File(dir);
        if (!f.exists()) {
            System.out.println("...does not exist");
        } else {
            new FileSystem(f).accept(new DoList(f, recursive));
        }
    }


}
