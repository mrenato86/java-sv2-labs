package algorithmssum.transactions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {

    @Test
    void testCreate() {
        Transaction transaction = new Transaction("1234-4567-8910", TransactionOperation.CREDIT, 100000);

        assertEquals("1234-4567-8910", transaction.getAccountNumber());
        assertTrue(transaction.isCredit());
        assertFalse(transaction.isDebit());
        assertEquals(100000, transaction.getAmount());

    }
}
