/**
 * By: Calvin Chaparro (Tutors Elvis F., Nicholas L., BROS_ETT)
 * Course: CEN-3024C
 * Professor: Mary Walauskis
 * Date: 09/10/2023
 *
 * This is the "book" class for part(2) of the SDLC Assignment.
 * This is the area that is essential for getting the book barcode,
 * titles and authors, as well as handling the function for checking
 * in and out books from the collection.
 */

class Book {
    private int barcode;
    private String title;
    private String author;
    private boolean checkedOut;

    public Book(int barcode, String title, String author) {
        this.barcode = barcode;
        this.title = title;
        this.author = author;
        this.checkedOut = false;
    }

    public int getBarcode() {
        return barcode;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
    //Expanded functionality for module 6
    public boolean isCheckedOut() {
        return checkedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }
}