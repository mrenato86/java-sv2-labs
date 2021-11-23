package algorithmscount.transactions;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TransactionCounterTest {

    @Test
    void testCountEntryLessThan() {
        List<Transaction> transactions = List.of(
                new Transaction("1234-5678", TransactionType.CREDIT, 1000),
                new Transaction("1234-5678", TransactionType.CREDIT, 2000),
                new Transaction("1234-5678", TransactionType.CREDIT, 3000),
                new Transaction("1234-5678", TransactionType.CREDIT, 4000),
                new Transaction("1234-5678", TransactionType.DEBIT, 5000)
        );
        TransactionCounter tc = new TransactionCounter();
        assertEquals(1, tc.countEntryLessThan(transactions, 2000));
        assertEquals(0, tc.countEntryLessThan(transactions, 1000));
        assertEquals(4, tc.countEntryLessThan(transactions, 10000));
    }
}