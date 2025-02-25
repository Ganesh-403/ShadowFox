<<<<<<< HEAD
import java.util.Scanner;

public class LibraryApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n📖 Library Management System");
            System.out.println("1. Add a Book");
            System.out.println("2. View Books");
            System.out.println("3. Borrow a Book");
            System.out.println("4. Return a Book");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> Library.addBook();
                case 2 -> Library.viewBooks();
                case 3 -> Library.borrowBook();
                case 4 -> Library.returnBook();
                case 5 -> {
                    System.out.println("📚 Exiting Library System...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("❌ Invalid choice! Try again.");
            }
        }
    }
}
=======
import java.util.Scanner;

public class LibraryApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n📖 Library Management System");
            System.out.println("1. Add a Book");
            System.out.println("2. View Books");
            System.out.println("3. Borrow a Book");
            System.out.println("4. Return a Book");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> Library.addBook();
                case 2 -> Library.viewBooks();
                case 3 -> Library.borrowBook();
                case 4 -> Library.returnBook();
                case 5 -> {
                    System.out.println("📚 Exiting Library System...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("❌ Invalid choice! Try again.");
            }
        }
    }
}
>>>>>>> 1a94b891536753ea4de59780a52a8e03760e0801
