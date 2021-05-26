package ua.ithillel.task1;

import java.io.File;

public class TaskDir {

    public static void main(String[] args) {
        if (args.length == 0) {
            listDirectories(new File("."));
        } else {
            listDirectories(new File(args[0]));
        }
    }

    public static void listDirectories(File directory) {
        if (directory.isDirectory() && directory.exists()) {
            String[] directories = directory.list();
            assert directories != null; //идея сказала так сделать:)
            for (String dir : directories) {
                System.out.println(dir);
            }
        } else {
            System.out.println("There is no such directory");
        }
    }
}
