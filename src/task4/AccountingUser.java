package task4;

import java.io.*;

public class AccountingUser {
    private RandomAccessFile file;

    public AccountingUser() throws FileNotFoundException {
        this.file = new RandomAccessFile("C:\\java-new-homework\\practical-work-io\\users.txt", "rw");
    }

    public void addUsers(String nameUser) throws IOException {
        String line = this.findString(nameUser.toLowerCase());
        if (line != null) {
            int number = Integer.parseInt(line.replaceAll("\\D", "")) + 1;
            long position = this.findUserPosition(nameUser.toLowerCase());
            this.file.seek(position - line.length() - 1);
            for (int i = 0; i < line.length(); i++) {
                this.file.writeBytes(" ");
            }
            this.file.seek(this.file.length());
            this.file.writeBytes(nameUser + " : " + number + "\n");
        } else {
            this.file.seek(this.file.length());
            this.file.writeBytes(nameUser + " : 1\n");
        }
        String deleted = deleteEmptyLines();
        this.file.seek(0);
        this.file.setLength(0);
        this.file.writeBytes(deleted);
    }

    private String deleteEmptyLines() throws IOException {
        this.file.seek(0);
        StringBuilder string = new StringBuilder();
        String line;
        while ((line = this.file.readLine()) != null) {
            if (line.contains(":")) {
                string.append(line).append("\n");
            }
        }
        return string.toString();
    }

    private long findUserPosition(String username) throws IOException {
        this.file.seek(0);
        long index;
        String line;
        while ((line = this.file.readLine()) != null) {
            index = file.getFilePointer();
            if (line.toLowerCase().contains(username)) {
                return index;
            }
        }
        return -1;
    }

    private String findString(String username) throws IOException {
        this.file.seek(0);
        String line;
        String finalLine = null;
        while ((line = this.file.readLine()) != null) {
            if (line.toLowerCase().contains(username)) {
                finalLine = line;
            }
        }
        return finalLine;
    }

    public void printFile() throws IOException {
        String line;
        this.file.seek(0);
        while ((line = this.file.readLine()) != null) {
            System.out.println(line);
        }
    }

    @Override
    public void finalize() throws IOException {
        this.file.close();
    }

}