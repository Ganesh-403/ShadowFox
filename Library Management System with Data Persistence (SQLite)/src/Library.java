<<<<<<< HEAD
import java.sql.*;
import java.util.Scanner;

public class Library {
    private static final Scanner scanner = new Scanner(System.in);

    // 📌 Connect to Database
    public static Connection connect() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:library.db");
    }

    // 📌 Add a Book
    public static void addBook() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter genre: ");
        String genre = scanner.nextLine();

        String sql = "INSERT INTO books (title, author, genre) VALUES (?, ?, ?)";

        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, title);
            pstmt.setString(2, author);
            pstmt.setString(3, genre);
            pstmt.executeUpdate();
            System.out.println("✅ Book added successfully!");
        } catch (SQLException e) {
            System.out.println("❌ Error adding book: " + e.getMessage());
        }
    }

    // 📌 View All Books
    public static void viewBooks() {
        String sql = "SELECT * FROM books";
        try (Connection conn = connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("\n📚 Library Books:");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + ". " + rs.getString("title") + " by " + rs.getString("author") +
                        " [" + (rs.getInt("available") == 1 ? "Available" : "Borrowed") + "]");
            }
        } catch (SQLException e) {
            System.out.println("❌ Error fetching books: " + e.getMessage());
        }
    }

    // 📌 Borrow a Book
    public static void borrowBook() {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        System.out.print("Enter book ID to borrow: ");
        int bookId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        String userSql = "INSERT INTO users (name, email) VALUES (?, ?) ON CONFLICT(email) DO NOTHING";
        String borrowSql = "INSERT INTO borrowed_books (user_id, book_id) VALUES ((SELECT id FROM users WHERE email = ?), ?)";
        String updateBookSql = "UPDATE books SET available = 0 WHERE id = ?";

        try (Connection conn = connect(); PreparedStatement userStmt = conn.prepareStatement(userSql);
             PreparedStatement borrowStmt = conn.prepareStatement(borrowSql);
             PreparedStatement updateStmt = conn.prepareStatement(updateBookSql)) {

            userStmt.setString(1, name);
            userStmt.setString(2, email);
            userStmt.executeUpdate();

            borrowStmt.setString(1, email);
            borrowStmt.setInt(2, bookId);
            int rows = borrowStmt.executeUpdate();

            if (rows > 0) {
                updateStmt.setInt(1, bookId);
                updateStmt.executeUpdate();
                System.out.println("✅ Book borrowed successfully!");
            } else {
                System.out.println("❌ Book not available or doesn't exist.");
            }

        } catch (SQLException e) {
            System.out.println("❌ Error borrowing book: " + e.getMessage());
        }
    }

    // 📌 Return a Book
    public static void returnBook() {
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        System.out.print("Enter book ID to return: ");
        int bookId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        String deleteSql = "DELETE FROM borrowed_books WHERE user_id = (SELECT id FROM users WHERE email = ?) AND book_id = ?";
        String updateSql = "UPDATE books SET available = 1 WHERE id = ?";

        try (Connection conn = connect(); PreparedStatement deleteStmt = conn.prepareStatement(deleteSql);
             PreparedStatement updateStmt = conn.prepareStatement(updateSql)) {

            deleteStmt.setString(1, email);
            deleteStmt.setInt(2, bookId);
            int rows = deleteStmt.executeUpdate();

            if (rows > 0) {
                updateStmt.setInt(1, bookId);
                updateStmt.executeUpdate();
                System.out.println("✅ Book returned successfully!");
            } else {
                System.out.println("❌ No record of you borrowing this book.");
            }

        } catch (SQLException e) {
            System.out.println("❌ Error returning book: " + e.getMessage());
        }
    }
}
=======
import java.sql.*;
import java.util.Scanner;

public class Library {
    private static final Scanner scanner = new Scanner(System.in);

    // 📌 Connect to Database
    public static Connection connect() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:library.db");
    }

    // 📌 Add a Book
    public static void addBook() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter genre: ");
        String genre = scanner.nextLine();

        String sql = "INSERT INTO books (title, author, genre) VALUES (?, ?, ?)";

        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, title);
            pstmt.setString(2, author);
            pstmt.setString(3, genre);
            pstmt.executeUpdate();
            System.out.println("✅ Book added successfully!");
        } catch (SQLException e) {
            System.out.println("❌ Error adding book: " + e.getMessage());
        }
    }

    // 📌 View All Books
    public static void viewBooks() {
        String sql = "SELECT * FROM books";
        try (Connection conn = connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("\n📚 Library Books:");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + ". " + rs.getString("title") + " by " + rs.getString("author") +
                        " [" + (rs.getInt("available") == 1 ? "Available" : "Borrowed") + "]");
            }
        } catch (SQLException e) {
            System.out.println("❌ Error fetching books: " + e.getMessage());
        }
    }

    // 📌 Borrow a Book
    public static void borrowBook() {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        System.out.print("Enter book ID to borrow: ");
        int bookId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        String userSql = "INSERT INTO users (name, email) VALUES (?, ?) ON CONFLICT(email) DO NOTHING";
        String borrowSql = "INSERT INTO borrowed_books (user_id, book_id) VALUES ((SELECT id FROM users WHERE email = ?), ?)";
        String updateBookSql = "UPDATE books SET available = 0 WHERE id = ?";

        try (Connection conn = connect(); PreparedStatement userStmt = conn.prepareStatement(userSql);
             PreparedStatement borrowStmt = conn.prepareStatement(borrowSql);
             PreparedStatement updateStmt = conn.prepareStatement(updateBookSql)) {

            userStmt.setString(1, name);
            userStmt.setString(2, email);
            userStmt.executeUpdate();

            borrowStmt.setString(1, email);
            borrowStmt.setInt(2, bookId);
            int rows = borrowStmt.executeUpdate();

            if (rows > 0) {
                updateStmt.setInt(1, bookId);
                updateStmt.executeUpdate();
                System.out.println("✅ Book borrowed successfully!");
            } else {
                System.out.println("❌ Book not available or doesn't exist.");
            }

        } catch (SQLException e) {
            System.out.println("❌ Error borrowing book: " + e.getMessage());
        }
    }

    // 📌 Return a Book
    public static void returnBook() {
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        System.out.print("Enter book ID to return: ");
        int bookId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        String deleteSql = "DELETE FROM borrowed_books WHERE user_id = (SELECT id FROM users WHERE email = ?) AND book_id = ?";
        String updateSql = "UPDATE books SET available = 1 WHERE id = ?";

        try (Connection conn = connect(); PreparedStatement deleteStmt = conn.prepareStatement(deleteSql);
             PreparedStatement updateStmt = conn.prepareStatement(updateSql)) {

            deleteStmt.setString(1, email);
            deleteStmt.setInt(2, bookId);
            int rows = deleteStmt.executeUpdate();

            if (rows > 0) {
                updateStmt.setInt(1, bookId);
                updateStmt.executeUpdate();
                System.out.println("✅ Book returned successfully!");
            } else {
                System.out.println("❌ No record of you borrowing this book.");
            }

        } catch (SQLException e) {
            System.out.println("❌ Error returning book: " + e.getMessage());
        }
    }
}
>>>>>>> 1a94b891536753ea4de59780a52a8e03760e0801
