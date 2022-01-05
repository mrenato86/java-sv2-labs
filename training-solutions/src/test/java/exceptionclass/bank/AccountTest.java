package exceptionclass.bank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AccountTest {

    Account account = new Account("11112", 100);

    @Test
    void testCreate() {
        Account account = new Account("11112", 150.3);

        assertEquals("11112", account.getAccountNumber());
        assertEquals(150.3, account.getBalance());
        assertEquals(100000, account.getMaxSubtract());
    }

    @Test
    void testCreateNullAccountNumberException() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> new Account(null, 0));
        assertEquals("Account number should not be null!", iae.getMessage());
    }

    @Test
    void testSetMaxSubtract() {
        account.setMaxSubtract(120000);
        assertEquals(120000, account.getMaxSubtract());
    }

    @Test
    void testSetMaxSubtractException() {
        InvalidAmountBankOperationException iaboe = assertThrows(InvalidAmountBankOperationException.class,
                () -> account.setMaxSubtract(-10));
        assertEquals("Invalid amount!", iaboe.getMessage());
    }

    @Test
    void testSubtract() {
        account.subtract(50);
        assertEquals(50, account.getBalance());
    }

    @Test
    void testSubtractInvalidAmountException() {
        InvalidAmountBankOperationException iaboe = assertThrows(InvalidAmountBankOperationException.class,
                () -> account.subtract(-10));
        assertEquals("Invalid amount!", iaboe.getMessage());
    }

    @Test
    void testSubtractLowBalanceException() {
        LowBalanceBankOperationException lbboe = assertThrows(LowBalanceBankOperationException.class,
                () -> account.subtract(200));
        assertEquals("Low balance!", lbboe.getMessage());
    }

    @Test
    void testDeposit() {
        account.deposit(300);
        assertEquals(400, account.getBalance());
    }

    @Test
    void testDepositInvalidAmountException() {
        InvalidAmountBankOperationException iaboe = assertThrows(InvalidAmountBankOperationException.class,
                () -> account.deposit(-10));
        assertEquals("Invalid amount!", iaboe.getMessage());
    }

}