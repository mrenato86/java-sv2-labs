package algorithmsdecision.bankaccounts;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BankAccountDecisionMakerTest {

    List<BankAccount> accounts = List.of(
            new BankAccount("Joe", "123-456-789", 100),
            new BankAccount("Jack", "123-654-987", 200),
            new BankAccount("Jill", "321-456-987", 90)
    );

    @Test
    void testContainsBalanceGreaterThan() {
        BankAccountDecisionMaker decisionMaker = new BankAccountDecisionMaker();

        assertTrue(decisionMaker.containsBalanceGreaterThan(accounts, 150));
        assertFalse(decisionMaker.containsBalanceGreaterThan(accounts, 250));
        assertFalse(decisionMaker.containsBalanceGreaterThan(accounts, 200));
    }
}