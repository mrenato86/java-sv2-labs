package algorithmscount.bankaccount;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BankAccountTest {

    @Test
    void testCreate() {
        BankAccount bankAccount = new BankAccount("John Doe", "1234-4567-8910", 200000);
        assertEquals("John Doe", bankAccount.getNameOfOwner());
        assertEquals("1234-4567-8910", bankAccount.getAccountNumber());
        assertEquals(200000, bankAccount.getBalance());
    }

}