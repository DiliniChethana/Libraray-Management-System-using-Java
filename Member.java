package library;

import java.sql.*;
import java.util.Scanner;

class MemberManager {
    private Jdbc Jdbc = null;
    private java.sql.Connection conn;

    public MemberManager() throws SQLException {
        conn = Jdbc.getConnection();
    }

    public void addMember() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name:");
        String name = scanner.nextLine();
        System.out.println("Enter email:");
        String email = scanner.nextLine();
        System.out.println("Enter phone:");
        String phone = scanner.nextLine();

        String query = "INSERT INTO members (name, email, phone) VALUES (?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, name);
        pstmt.setString(2, email);
        pstmt.setString(3, phone);
        pstmt.executeUpdate();
        System.out.println("Member added successfully!");
    }
}

