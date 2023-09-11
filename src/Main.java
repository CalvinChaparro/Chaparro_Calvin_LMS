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
 * LibraryManagementSystem class.
 */

public class Main {
    public static void main(String[] args) {
        LibraryManagementSystem lms = new LibraryManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nWelcome to the Library Management System Menu:");
            System.out.println("1. Add Books from File");
            System.out.println("2. Remove a Book by ID");
            System.out.println("3. List All Books");
            System.out.println("4. Quit");

            System.out.print("Enter your choice from (1-4): ");


            if (scanner.hasNextInt()) {     // Check if the input is numerical
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter the path to the .txt file, if the file is in the directory enter filename.txt: ");
                        String filePath = scanner.nextLine();
                        lms.addBooksFromFile(filePath);
                    }
                    case 2 -> {
                        System.out.print("Enter the ID of the book to remove: ");
                        int bookId = scanner.nextInt();
                        lms.removeBookById(bookId);
                    }
                    case 3 -> {
                        System.out.println("List of Books:");
                        List<Book> books = lms.listAllBooks();
                        if (books.isEmpty()) {
                            System.out.println("No books in the collection.");
                        } else {
                            for (Book book : books) {
                                System.out.println("ID: " + book.getId() + ", Title: " + book.getTitle() + ", Author: " + book.getAuthor());
                            }
                        }
                    }
                    case 4 -> {
                        System.out.println("Quitting the Library Management System.");
                        scanner.close();
                        System.exit(0);
                    }
                    default -> System.out.println("Invalid choice. Please choose a valid option from (1-4).");
                }
            } else {
                // if the input is not numerical, returns with invalid input
                // prevents program from force ending/crashing
                System.out.println("Invalid choice. Please enter only a numerical choice from (1-4).");
                scanner.nextLine();
            }
        }
    }
}