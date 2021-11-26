package staticattrmeth;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankTransactionTest {

    @BeforeEach
    void init(){
        BankTransaction.initTheDay();
    }

    @Test
    void testZeroTransaction() {
        assertEquals(0L, BankTransaction.getCurrentMinValue());
        assertEquals(0L, BankTransaction.getCurrentMaxValue());
        assertEquals(0L, BankTransaction.getSumOfTransactions());
    }

    @Test
    void testOneTransaction() {
        BankTransaction bankTransaction = new BankTransaction(10_000);

        assertEquals(10_000L, bankTransaction.getTransactionValue());
        assertEquals(10_000L, BankTransaction.getCurrentMinValue());
        assertEquals(10_000L, BankTransaction.getCurrentMaxValue());
        assertEquals(10_000L, BankTransaction.getSumOfTransactions());
        assertEquals(10_000L, BankTransaction.getAverageOfTransaction());
    }

    @Test
    void testSeveralTransactions() {
        new BankTransaction(10_000);
        new BankTransaction(20_000);

        assertEquals(10_000L, BankTransaction.getCurrentMinValue());
        assertEquals(20_000L, BankTransaction.getCurrentMaxValue());
        assertEquals(30_000L, BankTransaction.getSumOfTransactions());
        assertEquals(15_000L, BankTransaction.getAverageOfTransaction());
    }

}