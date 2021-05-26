package task2;

import java.io.*;

public class TaskFile {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.out.println("You haven't entered anything");
        } else {
            readFile(args[0]);
        }
    }


    public static void readFile(String directory) throws IOException {
        File file = new File(directory);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("There is no such file");
        }
    }
}

