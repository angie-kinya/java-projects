package LibraryDatabase;

import java.sql.*;
import java.util.ArrayList;

public class Library {
    private Connection connection;

    public Library() {
        try {
            // Establish a connection to the database
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_db", "root", "Beomgyu@0313");
            System.out.println("Connected to the database successfully!");
        } catch (SQLException e) {
            System.out.println("Connection to the database failed!");
            e.printStackTrace();
        }
    }

    public void addBook(Book book) {
        String query = "INSERT INTO books (serialNumber, title, author, available) VALUES (?,?,?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, book.getSerialNumber());
            stmt.setString(2, book.getTitle());
            stmt.setString(3, book.getAuthor());
            stmt.setBoolean(4, book.available());
            System.out.println("Book added successfully!");
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void displayBooks() {
        String query = "SELECT * FROM books";
        try (Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query)) {
                while (rs.next()) {
                    int serialNumber = rs.getInt("serialNumber");
                    String title = rs.getString("title");
                    String author = rs.getString("author");
                    boolean available = rs.getBoolean("available");
                    System.out.println("Serial Number: " + serialNumber + ", Title: " + title + ", Author: " + author + ", Available: " + (available ? "Yes" : "No"));
                }
            } catch ( SQLException e) {
                e.printStackTrace();
            }
    }

    public void borrowBook(int serialNumber) {
        String query = "UPDATE books SET available = TRUE WHERE serialNumber = ? AND available = TRUE";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, serialNumber);
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Book borrowed with serial number: " + serialNumber);
            } else {
                System.out.println("Book already borrowed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void returnBook(int serialNumber) {
        String query = "UPDATE books SET available = FALSE WHERE serialNumber = ? AND available = TRUE";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, serialNumber);
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Book returned with serial number: " + serialNumber);
            } else {
                System.out.println("Book was not borrowed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //close the database connection
    public void close() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
