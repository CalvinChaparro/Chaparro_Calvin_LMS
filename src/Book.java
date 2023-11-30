/**
 * Represents a book in the library with information such as barcode, title, author, genre, status, and due date.
 */
public class Book {
    private int barcode;
    private String title;
    private String author;
    private String genre;
    private String status;
    private String dueDate;

    /**
     * Constructs a new Book with the specified information.
     *
     * @param barcode The unique identifier for the book.
     * @param title   The title of the book.
     * @param author  The author of the book.
     * @param genre   The genre of the book.
     * @param status  The status of the book (example, checked in or checked out).
     * @param dueDate The due date for the book (null if the book is not checked out).
     */
    public Book(int barcode, String title, String author, String genre, String status, String dueDate) {
        this.barcode = barcode;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.status = status;
        this.dueDate = dueDate;
    }

    /**
     * Retrieves the barcode of the book.
     *
     * @return The barcode of the book.
     */
    public int getBarcode() {
        return barcode;
    }

    /**
     * Retrieves the title of the book.
     *
     * @return The title of the book.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Retrieves the author of the book.
     *
     * @return The author of the book.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Retrieves the genre of the book.
     *
     * @return The genre of the book.
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Retrieves the status of the book (example, checked in or checked out).
     *
     * @return The status of the book.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Retrieves the due date for the book.
     *
     * @return The due date for the book (null if the book is not checked out).
     */
    public String getDueDate() {
        return dueDate;
    }

    /**
     * Sets the status of the book.
     *
     * @param status The new status of the book.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Sets the due date for the book.
     *
     * @param dueDate The new due date for the book (null if the book is not checked out).
     */
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

}
