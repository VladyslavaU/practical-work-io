package task3;

import java.io.*;

public class TaskCopy {
    public static void main(String[] args) {
        copyFiles("C:\\java-new-homework\\practical-work-io\\fileToRead.txt", "C:\\java-new-homework\\practical-work-io\\fileToReadCopied.txt");
        replacementInFile("C:\\java-new-homework\\practical-work-io\\replace.txt");
    }

    public static void copyFiles(String oldFile, String newFile) {
        File fromFile = new File(oldFile);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fromFile)));
             BufferedWriter writer = new BufferedWriter(new FileWriter(newFile))
        ) {
            System.out.println("Copy file ...");
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line + "\n");
            }
            System.out.println("Copy ended");

        } catch (FileNotFoundException e) {
            System.out.println("There is no such file");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void replacementInFile(String directory) {
        File toReplace = new File(directory);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(toReplace)))
        ) {
            System.out.println("Replacing words ...");
            String line;
            StringBuilder replaced = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                line = line.replaceAll("public", "protected");
                replaced.append(line).append("\n");
            }
            System.out.println(replaced.toString());
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(toReplace))) {
                writer.write(replaced.toString());
                System.out.println("Words are replaced");
            }
        } catch (FileNotFoundException e) {
            System.out.println("There is no such file");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}






