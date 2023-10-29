import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * By: Calvin Chaparro (Tutors Elvis F., Nicholas L., BROS_ETT)
 * Course: CEN-3024C
 * Professor: Mary Walauskis
 * Date: 10/29/2023
 *
 * This class represents the GUI for the "Library Management System (LMS)".
 * This works directly with the LibraryManagementSystem,and allow for the
 * previous console based system to be shown in a much nicer and approachable
 * GUI. It functions nearly identical to the previous console version but
 * with buttons for each action instead of numerical inputs. If the user
 * enters an incorrect response (wrong integer or alphabetical character)
 * the proper error handling will be used, and they will be thrown an appropriate
 * message indicating an incorrect input was used.
 */

public class LibraryManagementSystemGUI extends JFrame {
    private final LibraryManagementSystem lms;
    private final JTextArea outputTextArea;

    public LibraryManagementSystemGUI() {
        lms = new LibraryManagementSystem();
        setTitle("Library Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Adds components to show menu options in a presentable and clear way
        JButton addBooksButton = new JButton("Add Books");
        JButton removeBooksButton = new JButton("Remove Books");
        JButton checkOutButton = new JButton("Check Out Book");
        JButton checkInButton = new JButton("Check In Book");
        outputTextArea = new JTextArea();
        outputTextArea.setEditable(false);

        // These action listeners respond to user inputs depending on the option selected
        addBooksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String filePath = JOptionPane.showInputDialog("Enter the path to the .txt file:");
                    if (filePath != null && !filePath.isEmpty()) {
                        if (lms.addBooksFromFile(filePath)) {
                            JOptionPane.showMessageDialog(null, "Books added successfully.");
                            updateOutput();
                        } else {
                            JOptionPane.showMessageDialog(null, "No file found under the given name.");
                        }
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid file path.");
                }
            }
        });

        removeBooksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String input = JOptionPane.showInputDialog("Enter barcode of book to remove:");
                    if (input != null) {
                        int barcode = Integer.parseInt(input);
                        boolean removed = lms.removeBookByBarcode(barcode);
                        if (removed) {
                            JOptionPane.showMessageDialog(null, "Book removed successfully.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Book not found.");
                        }
                        updateOutput();
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid Barcode.");
                }
            }
        });

        checkOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
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
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid Barcode.");
                }
            }
        });

        checkInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
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
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid Barcode.");
                }
            }
        });

        // Creation of button panels
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 4));
        buttonPanel.add(addBooksButton);
        buttonPanel.add(removeBooksButton);
        buttonPanel.add(checkOutButton);
        buttonPanel.add(checkInButton);


        add(buttonPanel, BorderLayout.NORTH);
        add(new JScrollPane(outputTextArea), BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }

    private void updateOutput() {
        outputTextArea.setText("");
        for (Book book : lms.listAllBooks()) {
            outputTextArea.append("Barcode: " + book.getBarcode() + ", Title: " +
                    book.getTitle() + ", Author: " + book.getAuthor() +
                    ", Checked Out: " + (book.isCheckedOut() ? "Yes" : "No") + "\n");
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
