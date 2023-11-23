import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class LibraryManagementSystemGUI extends JFrame {
    private final LibraryManagementSystem lms;
    private final JTextArea outputTextArea;

    public LibraryManagementSystemGUI() {
        lms = new LibraryManagementSystem();
        setTitle("Library Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JButton listBooksButton = new JButton("List All Books");
        JButton checkOutButton = new JButton("Check Out Book");
        JButton checkInButton = new JButton("Check In Book");
        outputTextArea = new JTextArea();
        outputTextArea.setEditable(false);

        listBooksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateOutput();
            }
        });

        checkOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("Enter Barcode of book to check out:");
                if (input != null) {
                    int barcode = Integer.parseInt(input);
                    boolean checkedOut = lms.checkOutBookByBarcode(barcode);
                    if (checkedOut) {
                        JOptionPane.showMessageDialog(null, "Book checked out successfully.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Book not found or already checked out.");
                    }
                    updateOutput();
                }
            }
        });

        checkInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("Enter Barcode of book to check in:");
                if (input != null) {
                    int barcode = Integer.parseInt(input);
                    boolean checkedIn = lms.checkInBookByBarcode(barcode);
                    if (checkedIn) {
                        JOptionPane.showMessageDialog(null, "Book checked in successfully.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Book not found or not checked out.");
                    }
                    updateOutput();
                }
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 3));
        buttonPanel.add(listBooksButton);
        buttonPanel.add(checkOutButton);
        buttonPanel.add(checkInButton);

        add(buttonPanel, BorderLayout.NORTH);
        add(new JScrollPane(outputTextArea), BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }

    private void updateOutput() {
        outputTextArea.setText("");
        List<Book> books = lms.listAllBooks();
        if (books.isEmpty()) {
            outputTextArea.append("No books in the collection.");
        } else {
            for (Book book : books) {
                outputTextArea.append("Barcode: " + book.getBarcode() + "\n" +
                        "Title: " + book.getTitle() + "\n" +
                        "Author: " + book.getAuthor() + "\n" +
                        "Genre: " + book.getGenre() + "\n" +
                        "Status: " + book.getStatus() + "\n" +
                        "Due Date: " + (book.getDueDate() != null ? book.getDueDate() : "N/A") + "\n\n");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                LibraryManagementSystemGUI gui = new LibraryManagementSystemGUI();
                gui.setVisible(true);
            }
        });
    }
}
