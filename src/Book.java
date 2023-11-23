
public class Book {
    private int barcode;
    private String title;
    private String author;
    private String genre;
    private String status;
    private String dueDate;

    public Book(int barcode, String title, String author, String genre, String status, String dueDate) {
        this.barcode = barcode;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.status = status;
        this.dueDate = dueDate;
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

    public String getGenre() {
        return genre;
    }

    public String getStatus() {
        return status;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

}
