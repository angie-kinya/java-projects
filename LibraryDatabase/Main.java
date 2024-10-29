package LibraryDatabase;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("\nLibrary Menu:");
            System.out.println("1. Display all books.");
            System.out.println("2. Borrow a book.");
            System.out.println("3. Return a book.");
            System.out.println("4. Exit");

            System.out.println("Choose an option: ");
            String choicestr = scanner.nextLine();

            try {
                int choice = Integer.parseInt(choicestr);
                switch (choice) {
                    case 1:
                        library.displayBooks();
                        break;
                    case 2:
                        System.out.println("Enter the serial number of the book to borrow: ");
                        int borrowSerial = Integer.parseInt(scanner.nextLine());
                        library.borrowBook(borrowSerial);
                        break;
                    case 3:
                        System.out.println("Enter the serial number of the book to return: ");
                        int returnSerial = Integer.parseInt(scanner.nextLine());
                        library.returnBook(returnSerial);
                        break;
                    case 4:
                        running = false;
                        library.close();
                        System.out.println("Exiting library system. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. PLease enter a number between 1 and 4.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice!. Please enter a valid option number.");
            }
        }

        scanner.close();
    }
}
