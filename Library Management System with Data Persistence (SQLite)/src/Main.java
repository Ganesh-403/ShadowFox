<<<<<<< HEAD
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Renamed var1 → scanner
        DatabaseHelper.createTables(); // Ensure DatabaseHelper is correctly linked

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Update Book");
            System.out.println("4. Delete Book");
            System.out.println("5. Register User");
            System.out.println("6. Login User");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice;
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear invalid input
                continue;
            }

            switch (choice) {
                case 1:
                System.out.print("Enter Book Title: ");
                String title = scanner.nextLine();
                System.out.print("Enter Author: ");
                String author = scanner.nextLine();
                System.out.print("Enter Genre: ");
                String genre = scanner.nextLine();  // Take genre input
                DatabaseHelper.addBook(title, author, genre);  // Now passing all 3 arguments
                break;
            

                case 2:
                    DatabaseHelper.displayBooks();
                    break;

                case 3:
                    System.out.print("Enter Book ID to Update: ");
                    if (scanner.hasNextInt()) {
                        int bookId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter New Title: ");
                        String newTitle = scanner.nextLine();
                        System.out.print("Enter New Author: ");
                        String newAuthor = scanner.nextLine();
                        DatabaseHelper.updateBook(bookId, newTitle, newAuthor);
                    } else {
                        System.out.println("Invalid ID. Please enter a number.");
                        scanner.nextLine(); // Clear invalid input
                    }
                    break;

                case 4:
                    System.out.print("Enter Book ID to Delete: ");
                    if (scanner.hasNextInt()) {
                        int deleteId = scanner.nextInt();
                        DatabaseHelper.deleteBook(deleteId);
                    } else {
                        System.out.println("Invalid ID. Please enter a number.");
                        scanner.nextLine();
                    }
                    break;

                case 5:
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter Password: ");
                    String password = scanner.nextLine();
                    DatabaseHelper.registerUser(name, email, password);
                    break;

                case 6:
                    System.out.print("Enter Email: ");
                    String loginEmail = scanner.nextLine();
                    System.out.print("Enter Password: ");
                    String loginPassword = scanner.nextLine();
                    DatabaseHelper.loginUser(loginEmail, loginPassword);
                    break;

                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
=======
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Renamed var1 → scanner
        DatabaseHelper.createTables(); // Ensure DatabaseHelper is correctly linked

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Update Book");
            System.out.println("4. Delete Book");
            System.out.println("5. Register User");
            System.out.println("6. Login User");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice;
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear invalid input
                continue;
            }

            switch (choice) {
                case 1:
                System.out.print("Enter Book Title: ");
                String title = scanner.nextLine();
                System.out.print("Enter Author: ");
                String author = scanner.nextLine();
                System.out.print("Enter Genre: ");
                String genre = scanner.nextLine();  // Take genre input
                DatabaseHelper.addBook(title, author, genre);  // Now passing all 3 arguments
                break;
            

                case 2:
                    DatabaseHelper.displayBooks();
                    break;

                case 3:
                    System.out.print("Enter Book ID to Update: ");
                    if (scanner.hasNextInt()) {
                        int bookId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter New Title: ");
                        String newTitle = scanner.nextLine();
                        System.out.print("Enter New Author: ");
                        String newAuthor = scanner.nextLine();
                        DatabaseHelper.updateBook(bookId, newTitle, newAuthor);
                    } else {
                        System.out.println("Invalid ID. Please enter a number.");
                        scanner.nextLine(); // Clear invalid input
                    }
                    break;

                case 4:
                    System.out.print("Enter Book ID to Delete: ");
                    if (scanner.hasNextInt()) {
                        int deleteId = scanner.nextInt();
                        DatabaseHelper.deleteBook(deleteId);
                    } else {
                        System.out.println("Invalid ID. Please enter a number.");
                        scanner.nextLine();
                    }
                    break;

                case 5:
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter Password: ");
                    String password = scanner.nextLine();
                    DatabaseHelper.registerUser(name, email, password);
                    break;

                case 6:
                    System.out.print("Enter Email: ");
                    String loginEmail = scanner.nextLine();
                    System.out.print("Enter Password: ");
                    String loginPassword = scanner.nextLine();
                    DatabaseHelper.loginUser(loginEmail, loginPassword);
                    break;

                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
>>>>>>> 1a94b891536753ea4de59780a52a8e03760e0801
