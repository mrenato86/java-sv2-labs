package algorithmsdecision.bankaccounts;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BankAccountTest {

    BankAccount bankAccount = new BankAccount("John", "123-456-789", 100);

    @Test
    void testCreateBankAccount() {
        BankAccount bankAccount = new BankAccount("John", "123-456-789", 100);
        assertEquals("John", bankAccount.getNameOfOwner());
        assertEquals("123-456-789", bankAccount.getAccountNumber());
        assertEquals(100, bankAccount.getBalance());
    }

    @Test
    void testWithdraw() {
        bankAccount.withdraw(50);
        assertEquals(50, bankAccount.getBalance());
    }

    @Test
    void testDeposit() {
        bankAccount.deposit(100);
        assertEquals(200, bankAccount.getBalance());
    }
}