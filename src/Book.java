/**
 * By: Calvin Chaparro (Tutors Elvis F., Nicholas L., BROS_ETT)
 * Course: CEN-3024C
 * Professor: Mary Walauskis
 * Date: 09/10/2023
 *
 * This is the "book" class for part(2) of the SDLC Assignment.
 * This is the area that is essential for getting the book ID,
 * titles and authors.
 */

class Book {
    private int id;
    private String title;
    private String author;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    //getter methods used to retrieve book ID, title and authors of books
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}