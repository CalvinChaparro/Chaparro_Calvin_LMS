import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * By: Calvin Chaparro (Tutors Elvis F., Nicholas L., BROS_ETT)
 * Course: CEN-3024C
 * Professor: Mary Walauskis
 * Date: 09/10/2023
 *
 * This class represents the "Library Management System (LMS)" for
 * part(2) of the SDLC Assignment. The goal of this system is for users
 * to add or remove books to and from the collection as well
 * as listing all the books of the collection.
 */
class LibraryManagementSystem {
    private List<Book> collection = new ArrayList<>();   //lists book from collection

    public void addBooksFromFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] bookInfo = line.split(",");
                if (bookInfo.length == 3) {
                    int id = Integer.parseInt(bookInfo[0].trim());
                    String title = bookInfo[1].trim();
                    String author = bookInfo[2].trim();
                    Book book = new Book(id, title, author);
                    //coded this way to meet the format for the collection
                    //book ID code, the title of the book and lastly the author
                    collection.add(book);
                } else {
                    System.out.println("Invalid line skipped: " + line);
                    //If format of file is not entered properly it is skipped into the next line
                }
            }
            //
            System.out.println("Books successfully added to collection.");
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Please check path or name");
        } catch (IOException e) {
            System.out.println("Error reading the selected file.");
        }

        //If path or file name is wrong or file type is not correct throw following response
    }

    public boolean removeBookById(int bookId) {          //removes book from collection
        Iterator<Book> iterator = collection.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getId() == bookId) {
                iterator.remove();
                System.out.println("Book successfully removed.");
                return true;
            }
        }
        System.out.println("Book not found.");
        //If book is not found throw the following response
        return false;
    }

    public List<Book> listAllBooks() {
        return collection;

        //listAllBooks used to return the entire collection of books

    }
}