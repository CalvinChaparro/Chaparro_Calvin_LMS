import java.util.List;
import java.util.Scanner;

/**
 * The main class for the Library Management System (LMS) application.
 * Allows users to interact with the LMS through a console menu.
 */

public class Main {
    /**
     * The entry point of the application.
     *
     * @param args The command-line arguments
     */
    public static void main(String[] args) {
        // Initialize the Library Management System
        LibraryManagementSystem lms = new LibraryManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nWelcome to the Library Management System Menu:");
            System.out.println("1. List All Books");
            System.out.println("2. Check Out a Book by Barcode");
            System.out.println("3. Check In a Book by Barcode");
            System.out.println("4. Quit");
            System.out.print("Enter your choice from (1-4): ");

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.println("List of Books:");
                        List<Book> books = lms.listAllBooks();
                        if (books.isEmpty()) {
                            System.out.println("No books in the collection.");
                        } else {
                            for (Book book : books) {
                                System.out.println("Barcode: " + book.getBarcode() + "\n" +
                                        "Title: " + book.getTitle() + "\n" +
                                        "Author: " + book.getAuthor() + "\n" +
                                        "Genre: " + book.getGenre() + "\n" +
                                        "Status: " + book.getStatus() + "\n" +
                                        "Due Date: " + (book.getDueDate() != null ? book.getDueDate() : "N/A") + "\n");
                            }
                        }
                        break;
                    case 2:
                        System.out.print("Enter the Barcode of the book to check out: ");
                        if (scanner.hasNextInt()) {
                            int barcode = scanner.nextInt();
                            lms.checkOutBookByBarcode(barcode);
                        } else {
                            System.out.println("Invalid choice. Please enter a valid Barcode.");
                            scanner.next(); // Prevents an infinite loop
                        }
                        break;
                    case 3:
                        System.out.print("Enter the Barcode of the book to check in: ");
                        if (scanner.hasNextInt()) {
                            int barcode = scanner.nextInt();
                            lms.checkInBookByBarcode(barcode);
                        } else {
                            System.out.println("Invalid choice. Please enter a valid Barcode.");
                            scanner.next(); // Prevents an infinite loop
                        }
                        break;
                    case 4:
                        System.out.println("Quitting the Library Management System.");
                        scanner.close();
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please choose a valid option from (1-4).");
                }
            } else {
                System.out.println("Invalid choice. Please enter only a numerical choice from (1-4).");
                scanner.next(); // Prevents an infinite loop
            }
        }
    }
}
