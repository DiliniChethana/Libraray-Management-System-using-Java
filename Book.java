package library;

import java.sql.*;
import java.util.Scanner;

class BookManager {
    private Connection conn;

    public BookManager() throws SQLException {
        conn = Jdbc.getConnection();
    }

    public void addBook() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter title:");
        String title = scanner.nextLine();
        System.out.println("Enter author:");
        String author = scanner.nextLine();
        System.out.println("Enter publisher:");
        String publisher = scanner.nextLine();
        System.out.println("Enter year published:");
        int yearPublished = scanner.nextInt();

        String query = "INSERT INTO books (title, author, publisher, year_published) VALUES (?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, title);
        pstmt.setString(2, author);
        pstmt.setString(3, publisher);
        pstmt.setInt(4, yearPublished);
        pstmt.executeUpdate();
        System.out.println("Book added successfully");
    }

    public void updateBook() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter book ID to update:");
        int bookId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter new title:");
        String title = scanner.nextLine();
        System.out.println("Enter new author:");
        String author = scanner.nextLine();
        System.out.println("Enter new publisher:");
        String publisher = scanner.nextLine();
        System.out.println("Enter new year published:");
        int yearPublished = scanner.nextInt();

        String query = "UPDATE books SET title = ?, author = ?, publisher = ?, year_published = ? WHERE book_id = ?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, title);
        pstmt.setString(2, author);
        pstmt.setString(3, publisher);
        pstmt.setInt(4, yearPublished);
        pstmt.setInt(5, bookId);
        pstmt.executeUpdate();
        System.out.println("Book updated successfully!");
    }

    public void deleteBook() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter book ID to delete:");
        int bookId = scanner.nextInt();

        String query = "DELETE FROM books WHERE book_id = ?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setInt(1, bookId);
        pstmt.executeUpdate();
        System.out.println("Book deleted successfully!");
    }

    public void searchBooks() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter search term (title, author, or year published):");
        String searchTerm = scanner.nextLine();

        String query = "SELECT * FROM books WHERE title LIKE ? OR author LIKE ? OR year_published LIKE ?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, "%" + searchTerm + "%");
        pstmt.setString(2, "%" + searchTerm + "%");
        pstmt.setString(3, "%" + searchTerm + "%");
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            System.out.println("Book ID: " + rs.getInt("book_id"));
            System.out.println("Title: " + rs.getString("title"));
            System.out.println("Author: " + rs.getString("author"));
            System.out.println("Publisher: " + rs.getString("publisher"));
            System.out.println("Year Published: " + rs.getInt("year_published"));
            System.out.println("---------------");
        }
    }
}

