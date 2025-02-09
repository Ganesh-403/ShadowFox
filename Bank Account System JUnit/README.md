
# Bank Account System

This is a Java-based Bank Account System project that provides functionality to manage bank accounts. It includes features like depositing, withdrawing money, and viewing account details. The project also includes unit tests to verify the correctness of the implementation using JUnit 5.

---

# Features

- **Create and Manage Bank Accounts**: Create accounts with unique account numbers, account holder names, and initial balances.
- **Deposit Money**: Add funds to the account balance.
- **Withdraw Money**: Subtract funds from the account balance, with validation for insufficient funds.
- **Display Account Details**: View account information such as account number, holder name, and balance.

---

# Requirements

- **Java Development Kit (JDK)**: Version 8 or higher
- **JUnit 5**: For running unit tests
- **IDE/Text Editor**: Preferably Visual Studio Code, IntelliJ IDEA, or Eclipse

---

# How to Run the Project

1. **Clone the Repository**:
   ```
   git clone https://github.com/<your-username>/<repo-name>.git
   cd <repo-name>
   ```

2. **Compile the Code**:
   Use the following command to compile the source code:
   ```
   javac -cp ".;lib/*" src/*.java test/*.java
   ```

3. **Run the Application**:
   ```
   java -cp ".;lib/*" src.BankApp
   ```

4. **Run Unit Tests**:
   ```
   java -cp ".;lib/*" org.junit.platform.console.ConsoleLauncher --scan-class-path
   ```

---

# How to Extend the Project

- Add new features such as account types (savings, current), interest calculations, or transaction history.
- Integrate a database (e.g., MySQL, SQLite) to persist account data.
- Build a graphical user interface (GUI) using JavaFX or Swing for a better user experience.

---

# License

This project is open-source and available for educational purposes. Feel free to modify and use it as needed.

---

# Acknowledgements

- **JUnit**: For providing the testing framework used in this project.
- Online resources and tutorials for inspiration and guidance.


