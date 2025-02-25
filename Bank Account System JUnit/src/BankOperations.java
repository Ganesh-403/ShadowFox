<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;

public class BankOperations {
    private BankAccount account;
    private List<String> transactionHistory;

    public BankOperations(BankAccount account) {
        this.account = account;
        this.transactionHistory = new ArrayList<>();
    }

    public void deposit(double amount) {
        account.deposit(amount);
        transactionHistory.add("Deposited: $" + amount);
    }

    public void withdraw(double amount) {
        try {
            account.withdraw(amount);
            transactionHistory.add("Withdrew: $" + amount);
        } catch (IllegalArgumentException e) {
            transactionHistory.add("Failed Withdrawal: " + e.getMessage());
        }
    }

    public double checkBalance() {
        return account.getBalance();
    }

    public List<String> getTransactionHistory() {
        return transactionHistory;
    }
}
=======
import java.util.ArrayList;
import java.util.List;

public class BankOperations {
    private BankAccount account;
    private List<String> transactionHistory;

    public BankOperations(BankAccount account) {
        this.account = account;
        this.transactionHistory = new ArrayList<>();
    }

    public void deposit(double amount) {
        account.deposit(amount);
        transactionHistory.add("Deposited: $" + amount);
    }

    public void withdraw(double amount) {
        try {
            account.withdraw(amount);
            transactionHistory.add("Withdrew: $" + amount);
        } catch (IllegalArgumentException e) {
            transactionHistory.add("Failed Withdrawal: " + e.getMessage());
        }
    }

    public double checkBalance() {
        return account.getBalance();
    }

    public List<String> getTransactionHistory() {
        return transactionHistory;
    }
}
>>>>>>> 1a94b891536753ea4de59780a52a8e03760e0801
