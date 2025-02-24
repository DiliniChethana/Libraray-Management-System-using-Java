package library;

import java.sql.*;
import java.util.Scanner;

class LoanManager {
    private Connection conn;

    public LoanManager() throws SQLException {
        conn = Jdbc.getConnection();
    }

    public void loanBook() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter book ID to loan:");
        int bookId = scanner.nextInt();
        System.out.println("Enter member ID:");
        int memberId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter loan date:");
        String loanDate = scanner.nextLine();
        System.out.println("Enter due date:");
        String dueDate = scanner.nextLine();

        String query = "INSERT INTO loans (book_id, member_id, loan_date, due_date) VALUES (?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setInt(1, bookId);
        pstmt.setInt(2, memberId);
        pstmt.setDate(3, Date.valueOf(loanDate));
        pstmt.setDate(4, Date.valueOf(dueDate));
        pstmt.executeUpdate();
        System.out.println("loaned successfully!");
    }

    public void returnBook() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter loan ID :");
        int loanId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter return date:");
        String returnDate = scanner.nextLine();

        String query = "UPDATE loans SET return_date = ? WHERE loan_id = ?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setDate(1, Date.valueOf(returnDate));
        pstmt.setInt(2, loanId);
        pstmt.executeUpdate();
        System.out.println("Book returned successfully");
    }
}

