package library;

import java.sql.SQLException;
import java.util.Scanner;

public class LibrarySystem {
    public static void main(String[] args) throws java.sql.SQLException, SQLException {
        try {
            Scanner scanner = new Scanner(System.in);
            BookManager bookManager = new BookManager();
            MemberManager memberManager = new MemberManager();
            LoanManager loanManager = new LoanManager();

            while (true) {
                System.out.println("Library Management System");
                System.out.println("1. Add a  Book");
                System.out.println("2. Update Book ");
                System.out.println("3. Delete a Book");
                System.out.println("4. Search for Books");
                System.out.println("5. Add a New Member");
                System.out.println("6. Loan a Book");
                System.out.println("7. Return a Book");
                System.out.println("8. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); 

                switch (choice) {
                    case 1:
                        bookManager.addBook();
                        break;
                    case 2:
                        bookManager.updateBook();
                        break;
                    case 3:
                        bookManager.deleteBook();
                        break;
                    case 4:
                        bookManager.searchBooks();
                        break;
                    case 5:
                        memberManager.addMember();
                        break;
                    case 6:
                        loanManager.loanBook();
                        break;
                    case 7:
                        loanManager.returnBook();
                        break;
                    case 8:
                        System.out.println("Exiting the system...");
                        return;
                    default:
                        System.out.println("Invalid choice");
                }
            }
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }
}

