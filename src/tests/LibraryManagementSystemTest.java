package tests;

import static org.junit.Assert.*;
import org.junit.Test;

public class LibraryManagementSystemTest {

    @Test
    public void testAddBook() {
        LibraryManagementSystem lms = new LibraryManagementSystem();
        Book book = new Book(1, "The Chronicles of Narnia", "C.S. lewis");
        lms.addBook(book);
        assertEquals(1, lms.listAllBooks().size());
    }
    //Testing add book function

    @Test
    public void testRemoveBookByBarcode() {
        LibraryManagementSystem lms = new LibraryManagementSystem();
        Book book = new Book(1, "The Chronicles of Narnia", "C.S. lewis");
        lms.addBook(book);
        assertTrue(lms.removeBookByBarcode(1));
        assertEquals(0, lms.listAllBooks().size());
    }
    //Testing remove book function

    @Test
    public void testRemoveBookByTitle() {
        LibraryManagementSystem lms = new LibraryManagementSystem();
        Book book = new Book(1, "The Chronicles of Narnia", "C.S. lewis");
        lms.addBook(book);
        assertTrue(lms.removeBookByTitle("The Chronicles of Narnia"));
        assertEquals(0, lms.listAllBooks().size());
    }
    //Testing remove book by title/name function

    @Test
    public void testCheckOutBook() {
        LibraryManagementSystem lms = new LibraryManagementSystem();
        Book book = new Book(1, "The Chronicles of Narnia", "C.S. lewis");
        lms.addBook(book);
        assertTrue(lms.checkOutBook(1));
        assertNotNull(lms.findBookByBarcode(1).getDueDate());
    }
    //Testing check-out book function
    @Test
    public void testCheckInBook() {
        LibraryManagementSystem lms = new LibraryManagementSystem();
        Book book = new Book(1, "The Chronicles of Narnia", "C.S. lewis");
        lms.addBook(book);
        lms.checkOutBook(1);
        assertTrue(lms.checkInBook(1));
        assertNull(lms.findBookByBarcode(1).getDueDate());
    }
}
    //Testing check-in book function