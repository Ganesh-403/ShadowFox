import java.util.Scanner;

public class calculator {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n*** Enhanced Calculator ***");
            System.out.println("1. Arithmetic Operations");
            System.out.println("2. Scientific Calculations");
            System.out.println("3. Temperature Conversion");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            switch (scanner.nextInt()) {
                case 1 -> arithmeticOperations();
                case 2 -> scientificOperations();
                case 3 -> temperatureConversion();
                case 4 -> {
                    System.out.println("Exiting Calculator...");
                    return;
                }
                default -> System.out.println("Invalid option! Try again.");
            }
        }
    }

    private static void arithmeticOperations() {
        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();
        System.out.print("Enter operator (+, -, *, /): ");
        char op = scanner.next().charAt(0);
        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();

        double result = switch (op) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            case '/' -> num2 != 0 ? num1 / num2 : Double.NaN;
            default -> Double.NaN;
        };
        System.out.println("Result: " + result);
    }

    private static void scientificOperations() {
        System.out.println("1. Square Root  2. Square  3. Exponent (e^x)  4. Logarithm");
        System.out.print("Choose operation: ");
        int choice = scanner.nextInt();
        System.out.print("Enter number: ");
        double num = scanner.nextDouble();

        double result = switch (choice) {
            case 1 -> Math.sqrt(num);
            case 2 -> Math.pow(num, 2);
            case 3 -> Math.exp(num);
            case 4 -> Math.log(num);
            default -> Double.NaN;
        };
        System.out.println("Result: " + result);
    }

    private static void temperatureConversion() {
        System.out.println("1. Fahrenheit to Celsius  2. Celsius to Fahrenheit");
        System.out.print("Choose conversion: ");
        int option = scanner.nextInt();
        System.out.print("Enter temperature: ");
        double temp = scanner.nextDouble();

        double converted = (option == 1) ? (temp - 32) * 5 / 9 : (temp * 9 / 5) + 32;
        System.out.println("Converted Temperature: " + converted);
    }
}
