import java.util.Scanner;
import java.util.List;

/**
 * By: Calvin Chaparro (Tutors Elvis F., Nicholas L., BROS_ETT)
 * Course: CEN-3024C
 * Professor: Mary Walauskis
 * Date: 09/10/2023
 *
 * This is the "main" class for part(2) of the SDLC Assignment.
 * This is the area that is essential to the sub menus of the LMS.
 * Ensures the correct prints are shown and displayed when entering
 * the requested information. The main pulls the methods from the
 * LibraryManagementSystem class. Added expanded functionality for
 * checking in and out books by barcode.
 */

public class Main {
    public static void main(String[] args) {
        LibraryManagementSystem lms = new LibraryManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nWelcome to the Library Management System Menu:");
            System.out.println("1. Add Books from File");
            System.out.println("2. Remove a Book by Barcode");
            System.out.println("3. List All Books");
            System.out.println("4. Check Out a Book by Barcode");
            System.out.println("5. Check In a Book by Barcode");
            System.out.println("6. Quit");
            //Expanded functionality for module 6, options 5 and 6 now allow users to check in and out books
            System.out.print("Enter your choice from (1-6): ");

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter the path to the .txt file, if the file is in the directory enter filename.txt: ");
                        String filePath = scanner.nextLine();
                        lms.addBooksFromFile(filePath);
                    }
                    case 2 -> {
                        System.out.print("Enter the Barcode of the book to remove: ");
                        if (scanner.hasNextInt()) {
                            int barcode = scanner.nextInt();
                            lms.removeBookByBarcode(barcode);
                        } else {
                            System.out.println("Invalid choice. Please enter a valid Barcode.");
                            scanner.next(); // Prevents an infinite loop
                        }
                    }
                    case 3 -> {
                        System.out.println("List of Books:");
                        List<Book> books = lms.listAllBooks();
                        if (books.isEmpty()) {
                            System.out.println("No books in the collection.");
                        } else {
                            for (Book book : books) {
                                System.out.println("Barcode: " + book.getBarcode() + ", Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", Checked Out: " + (book.isCheckedOut() ? "Yes" : "No"));
                            }
                        }
                    }
                    case 4 -> {
                        System.out.print("Enter the Barcode of the book to check out: ");
                        if (scanner.hasNextInt()) {
                            int barcode = scanner.nextInt();
                            lms.checkOutBookByBarcode(barcode);
                        } else {
                            System.out.println("Invalid choice. Please enter a valid Barcode.");
                            scanner.next(); //  Prevents infinite loop if user enters an integer or non integer
                        }
                    }
                    case 5 -> { //Expanded functionality for module 6, options 5 and 6 now allow users to check in and out books
                        System.out.print("Enter the Barcode of the book to check in: ");
                        if (scanner.hasNextInt()) {
                            int barcode = scanner.nextInt();
                            lms.checkInBookByBarcode(barcode);
                        } else {
                            System.out.println("Invalid choice. Please enter a valid Barcode.");
                            scanner.next(); // Prevents infinite loop if user enters an integer or non integer
                        }
                    }
                    case 6 -> {
                        System.out.println("Quitting the Library Management System.");
                        scanner.close();
                        System.exit(0);
                    }
                    default -> System.out.println("Invalid choice. Please choose a valid option from (1-6).");
                }
            } else {
                System.out.println("Invalid choice. Please enter only a numerical choice from (1-6).");
                scanner.next(); // Prevents an infinite loop
            }
        }
    }
}