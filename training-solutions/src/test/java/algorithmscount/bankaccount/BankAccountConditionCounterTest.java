package algorithmscount.bankaccount;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BankAccountConditionCounterTest {

    @Test
    void testCountWithBalanceGreaterThan() {
        List<BankAccount> accounts = List.of(
                new BankAccount("John Doe", "1234-4567-8910", 100000),
                new BankAccount("Jane Doe", "1234-4567-8190", 200000),
                new BankAccount("Joe Doe", "1324-4567-8910", 300000),
                new BankAccount("Jennifer Doe", "1234-4657-8910", 400000)
        );
        BankAccountConditionCounter bcc = new BankAccountConditionCounter();
        assertEquals(3, bcc.countWithBalanceGreaterThan(accounts, 100000));
        assertEquals(0, bcc.countWithBalanceGreaterThan(accounts, 400000));
    }
}