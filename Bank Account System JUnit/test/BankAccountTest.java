import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    @Test
    void testDeposit() {
        BankAccount account = new BankAccount("12345", "John Doe", 500.0);
        account.deposit(200.0);
        assertEquals(700.0, account.getBalance());
    }

    @Test
    void testDepositNegativeAmount() {
        BankAccount account = new BankAccount("12345", "John Doe", 500.0);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(-100.0);
        });
        assertEquals("Deposit amount must be positive", exception.getMessage());
    }

    @Test
    void testWithdrawValidAmount() {
        BankAccount account = new BankAccount("12345", "John Doe", 500.0);
        account.withdraw(200.0);
        assertEquals(300.0, account.getBalance());
    }

    @Test
    void testWithdrawInvalidAmount() {
        BankAccount account = new BankAccount("12345", "John Doe", 500.0);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(600.0);
        });
        assertEquals("Insufficient balance or invalid amount", exception.getMessage());
    }

    @Test
    void testWithdrawExactBalance() {
        BankAccount account = new BankAccount("12345", "John Doe", 500.0);
        account.withdraw(500.0);
        assertEquals(0.0, account.getBalance(), 0.001);
    }

    @Test
    void testWithdrawZeroAmount() {
        BankAccount account = new BankAccount("12345", "John Doe", 500.0);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(0.0);
        });
        assertEquals("Insufficient balance or invalid amount", exception.getMessage());
    }
}
