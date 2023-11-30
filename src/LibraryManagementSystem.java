import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The core class for the Library Management System.
 * Manages the library collection, database initialization, and book transactions.
 */
public class LibraryManagementSystem {
    private static final String DATABASE_URL = "jdbc:sqlite:library.db";
    private List<Book> collection = new ArrayList<>();

    /**
     * Constructs a new LibraryManagementSystem.
     * Initializes the database and loads books from the database on creation.
     */
    public LibraryManagementSystem() {

        initializeDatabase();

        loadBooksFromDatabase();
    }

    /**
     * Initializes the SQLite database by creating the books table if it does not exist.
     */
    private void initializeDatabase() {
        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS books (" +
                            "barcode INTEGER PRIMARY KEY," +
                            "title TEXT," +
                            "author TEXT," +
                            "genre TEXT," +
                            "status TEXT," +
                            "due_date TEXT)"
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Loads books from the database into the local collection.
     */
    private void loadBooksFromDatabase() {
        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM books");

            while (resultSet.next()) {
                int barcode = resultSet.getInt("barcode");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                String genre = resultSet.getString("genre");
                String status = resultSet.getString("status");
                String dueDate = resultSet.getString("due_date");

                Book book = new Book(barcode, title, author, genre, status, dueDate);
                collection.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Retrieves a list of all books in the collection.
     *
     * @return The list of books in the collection.
     */
    public List<Book> listAllBooks() {
        return collection;
    }

    /**
     * Checks out a book by updating its status and due date in the database and local collection.
     *
     * @param barcode The barcode of the book to check out.
     * @return True if the book is successfully checked out, false otherwise.
     */
    public boolean checkOutBookByBarcode(int barcode) {
        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "UPDATE books SET status = 'checked out', due_date = ? WHERE barcode = ?")) {

            String dueDate = "2023-12-31"; // Default due date

            preparedStatement.setString(1, dueDate);
            preparedStatement.setInt(2, barcode);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                // Update the local collection
                for (Book book : collection) {
                    if (book.getBarcode() == barcode) {
                        book.setStatus("checked out");
                        book.setDueDate(dueDate);
                        break;
                    }
                }
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Checks in a book by updating its status and due date in the database and local collection.
     *
     * @param barcode The barcode of the book to check in.
     * @return True if the book is successfully checked in, false otherwise.
     */
    public boolean checkInBookByBarcode(int barcode) {
        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "UPDATE books SET status = 'checked in', due_date = NULL WHERE barcode = ?")) {

            preparedStatement.setInt(1, barcode);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                // Update the local collection
                for (Book book : collection) {
                    if (book.getBarcode() == barcode) {
                        book.setStatus("checked in");
                        book.setDueDate(null);
                        break;
                    }
                }
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
