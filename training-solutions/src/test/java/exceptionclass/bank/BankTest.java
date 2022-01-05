package exceptionclass.bank;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BankTest {

    double initialBalance = 100;
    List<Account> accounts = new ArrayList<>(List.of(
            new Account("acc1", initialBalance),
            new Account("acc2", initialBalance),
            new Account("acc3", initialBalance)
    ));
    Bank bank = new Bank(accounts);

    @Test
    void testCreateNullParameterException() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> new Bank(null));
        assertEquals("Account list should not be null!", iae.getMessage());
    }

    @Test
    void testCreateDuplicateAccountException() {
        accounts.add(new Account(accounts.get(2).getAccountNumber(), initialBalance));
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> new Bank(accounts));
        assertEquals("Duplicate account found!", iae.getMessage());
    }

    @Test
    void testWithdraw() {
        double amount = 10;
        bank.withdraw("acc2", amount);

        assertEquals(initialBalance - amount, accounts.get(1).getBalance());
        assertEquals(initialBalance, accounts.get(2).getBalance());
    }

    @Test
    void testWithdrawInvalidAccountException() {
        InvalidAccountNumberBankOperationException ianboe = assertThrows(InvalidAccountNumberBankOperationException.class,
                () -> bank.withdraw("wrongAccount", 10));
        assertEquals("Invalid account number!", ianboe.getMessage());
    }

    @Test
    void testDeposit() {
        double amount = 10;
        bank.deposit("acc2", amount);

        assertEquals(initialBalance + amount, accounts.get(1).getBalance());
        assertEquals(initialBalance, accounts.get(2).getBalance());
    }

    @Test
    void testDepositInvalidAccountException() {
        InvalidAccountNumberBankOperationException ianboe = assertThrows(InvalidAccountNumberBankOperationException.class,
                () -> bank.deposit("wrongAccount", 10));
        assertEquals("Invalid account number!", ianboe.getMessage());
    }

}