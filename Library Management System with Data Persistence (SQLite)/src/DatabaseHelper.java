<<<<<<< HEAD
import java.sql.*;

public class DatabaseHelper {
    private static final String DB_URL = "jdbc:sqlite:library.db";

    // Connect to SQLite database
    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL);
            System.out.println("Connected to the database!");
        } catch (SQLException e) {
            System.out.println("Database connection error: " + e.getMessage());
        }
        return conn;
    }

    // Create Tables (Users & Books)
    public static void createTables() {
        String createUsersTable = "CREATE TABLE IF NOT EXISTS users (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT NOT NULL, " +
                "email TEXT UNIQUE NOT NULL, " +
                "password TEXT NOT NULL)"; // ✅ "password" column is now included from the start

        String createBooksTable = "CREATE TABLE IF NOT EXISTS books (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "title TEXT NOT NULL, " +
                "author TEXT NOT NULL);";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(createUsersTable);
            stmt.execute(createBooksTable);
            System.out.println("Tables created successfully!");

            // ✅ Ensure 'password' column exists (only add if missing)
            ensurePasswordColumn(conn);
        } catch (SQLException e) {
            System.out.println("Error creating tables: " + e.getMessage());
        }
    }

    // ✅ Ensure 'password' column exists in the 'users' table
    private static void ensurePasswordColumn(Connection conn) {
        String checkColumnExists = "PRAGMA table_info(users)";
        boolean columnExists = false;

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(checkColumnExists)) {
            while (rs.next()) {
                String columnName = rs.getString("name");
                if ("password".equals(columnName)) {
                    columnExists = true;
                    break;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error checking 'password' column: " + e.getMessage());
        }

        if (!columnExists) {
            System.out.println("Adding missing 'password' column...");
            String alterTableSQL = "ALTER TABLE users ADD COLUMN password TEXT NOT NULL DEFAULT 'default_password'";
            try (Statement stmt = conn.createStatement()) {
                stmt.execute(alterTableSQL);
                System.out.println("Column 'password' added successfully.");
            } catch (SQLException e) {
                System.out.println("Error adding 'password' column: " + e.getMessage());
            }
        }
    }

    // Add a new book
    // Add a new book
    // Add a new book
public static void addBook(String title, String author, String genre) {
    String sql = "INSERT INTO books (title, author, genre) VALUES (?, ?, ?)";
    try (Connection conn = connect();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, title);
        pstmt.setString(2, author);
        pstmt.setString(3, genre);  // Add genre input
        pstmt.executeUpdate();
        System.out.println("Book added successfully!");
    } catch (SQLException e) {
        System.out.println("Error adding book: " + e.getMessage());
    }
}


    // Display all books
    public static void displayBooks() {
        String sql = "SELECT * FROM books";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("ID | Title | Author");
            System.out.println("----------------------");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " | " +
                        rs.getString("title") + " | " +
                        rs.getString("author"));
            }
        } catch (SQLException e) {
            System.out.println("Error displaying books: " + e.getMessage());
        }
    }

    // Update a book's details
    public static void updateBook(int bookId, String newTitle, String newAuthor) {
        String sql = "UPDATE books SET title = ?, author = ? WHERE id = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newTitle);
            pstmt.setString(2, newAuthor);
            pstmt.setInt(3, bookId);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Book updated successfully!");
            } else {
                System.out.println("Book ID not found.");
            }
        } catch (SQLException e) {
            System.out.println("Error updating book: " + e.getMessage());
        }
    }

    // Delete a book
    public static void deleteBook(int bookId) {
        String sql = "DELETE FROM books WHERE id = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, bookId);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Book deleted successfully!");
            } else {
                System.out.println("Book ID not found.");
            }
        } catch (SQLException e) {
            System.out.println("Error deleting book: " + e.getMessage());
        }
    }

    // User Registration
    public static void registerUser(String name, String email, String password) {
        String sql = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, password);
            pstmt.executeUpdate();
            System.out.println("User registered successfully!");
        } catch (SQLException e) {
            System.out.println("Error registering user: " + e.getMessage());
        }
    }

    // User Login
    public static boolean loginUser(String email, String password) {
        String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                System.out.println("Login successful! Welcome, " + rs.getString("name"));
                return true;
            } else {
                System.out.println("Invalid email or password.");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error logging in: " + e.getMessage());
            return false;
        }
    }
}
=======
import java.sql.*;

public class DatabaseHelper {
    private static final String DB_URL = "jdbc:sqlite:library.db";

    // Connect to SQLite database
    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL);
            System.out.println("Connected to the database!");
        } catch (SQLException e) {
            System.out.println("Database connection error: " + e.getMessage());
        }
        return conn;
    }

    // Create Tables (Users & Books)
    public static void createTables() {
        String createUsersTable = "CREATE TABLE IF NOT EXISTS users (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT NOT NULL, " +
                "email TEXT UNIQUE NOT NULL, " +
                "password TEXT NOT NULL)"; // ✅ "password" column is now included from the start

        String createBooksTable = "CREATE TABLE IF NOT EXISTS books (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "title TEXT NOT NULL, " +
                "author TEXT NOT NULL);";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(createUsersTable);
            stmt.execute(createBooksTable);
            System.out.println("Tables created successfully!");

            // ✅ Ensure 'password' column exists (only add if missing)
            ensurePasswordColumn(conn);
        } catch (SQLException e) {
            System.out.println("Error creating tables: " + e.getMessage());
        }
    }

    // ✅ Ensure 'password' column exists in the 'users' table
    private static void ensurePasswordColumn(Connection conn) {
        String checkColumnExists = "PRAGMA table_info(users)";
        boolean columnExists = false;

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(checkColumnExists)) {
            while (rs.next()) {
                String columnName = rs.getString("name");
                if ("password".equals(columnName)) {
                    columnExists = true;
                    break;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error checking 'password' column: " + e.getMessage());
        }

        if (!columnExists) {
            System.out.println("Adding missing 'password' column...");
            String alterTableSQL = "ALTER TABLE users ADD COLUMN password TEXT NOT NULL DEFAULT 'default_password'";
            try (Statement stmt = conn.createStatement()) {
                stmt.execute(alterTableSQL);
                System.out.println("Column 'password' added successfully.");
            } catch (SQLException e) {
                System.out.println("Error adding 'password' column: " + e.getMessage());
            }
        }
    }

    // Add a new book
    // Add a new book
    // Add a new book
public static void addBook(String title, String author, String genre) {
    String sql = "INSERT INTO books (title, author, genre) VALUES (?, ?, ?)";
    try (Connection conn = connect();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, title);
        pstmt.setString(2, author);
        pstmt.setString(3, genre);  // Add genre input
        pstmt.executeUpdate();
        System.out.println("Book added successfully!");
    } catch (SQLException e) {
        System.out.println("Error adding book: " + e.getMessage());
    }
}


    // Display all books
    public static void displayBooks() {
        String sql = "SELECT * FROM books";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("ID | Title | Author");
            System.out.println("----------------------");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " | " +
                        rs.getString("title") + " | " +
                        rs.getString("author"));
            }
        } catch (SQLException e) {
            System.out.println("Error displaying books: " + e.getMessage());
        }
    }

    // Update a book's details
    public static void updateBook(int bookId, String newTitle, String newAuthor) {
        String sql = "UPDATE books SET title = ?, author = ? WHERE id = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newTitle);
            pstmt.setString(2, newAuthor);
            pstmt.setInt(3, bookId);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Book updated successfully!");
            } else {
                System.out.println("Book ID not found.");
            }
        } catch (SQLException e) {
            System.out.println("Error updating book: " + e.getMessage());
        }
    }

    // Delete a book
    public static void deleteBook(int bookId) {
        String sql = "DELETE FROM books WHERE id = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, bookId);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Book deleted successfully!");
            } else {
                System.out.println("Book ID not found.");
            }
        } catch (SQLException e) {
            System.out.println("Error deleting book: " + e.getMessage());
        }
    }

    // User Registration
    public static void registerUser(String name, String email, String password) {
        String sql = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, password);
            pstmt.executeUpdate();
            System.out.println("User registered successfully!");
        } catch (SQLException e) {
            System.out.println("Error registering user: " + e.getMessage());
        }
    }

    // User Login
    public static boolean loginUser(String email, String password) {
        String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                System.out.println("Login successful! Welcome, " + rs.getString("name"));
                return true;
            } else {
                System.out.println("Invalid email or password.");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error logging in: " + e.getMessage());
            return false;
        }
    }
}
>>>>>>> 1a94b891536753ea4de59780a52a8e03760e0801
