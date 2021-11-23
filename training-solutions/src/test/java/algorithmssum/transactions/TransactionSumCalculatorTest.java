package algorithmssum.transactions;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TransactionSumCalculatorTest {

    @Test
    void testSumAmountOfCreditEntries() {
        List<Transaction> transactions = List.of(
                new Transaction("1234-4567-8910", TransactionOperation.CREDIT, 100000),
                new Transaction("1234-4567-8910", TransactionOperation.DEBIT, 500),
                new Transaction("1234-4567-8910", TransactionOperation.CREDIT, 0),
                new Transaction("1234-4567-8910", TransactionOperation.CREDIT, 1),
                new Transaction("1234-4567-8910", TransactionOperation.CREDIT, -200),
                new Transaction("1234-4567-8910", TransactionOperation.DEBIT, 100000)
        );
        assertEquals(99801, new TransactionSumCalculator().sumAmountOfCreditEntries(transactions));
    }
}