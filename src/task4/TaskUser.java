package task4;

import java.io.IOException;
import java.util.Scanner;

public class TaskUser {
    public static void main(String[] args) throws IOException {
        AccountingUser users = new AccountingUser();
        System.out.println("The file is empty right now. Please, type a userName you want to add");
        typeUser(users);
    }

    public static void typeUser(AccountingUser users) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String userName = scanner.nextLine();
        System.out.println("Adding " + userName);
        users.addUsers(userName);
        System.out.println("Updated file: ");
        users.printFile();
        System.out.println("Would you like to add more users? Type YES to add more users.");
        if (scanner.nextLine().toUpperCase().equals("YES")) {
            System.out.println("Please, enter the name of the next user");

            typeUser(users);
        } else {
            users.finalize();
        }
    }
}

