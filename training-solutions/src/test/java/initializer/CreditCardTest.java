package initializer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreditCardTest {

    CreditCard testCard = new CreditCard(100_000);

    @Test
    void testCreateWithTwoParameters() {
        CreditCard card = new CreditCard(1000, Currency.EUR);

        assertEquals(308_230L, card.getBalance());
    }

    @Test
    void testCreateWithOneParameter() {
        CreditCard card = new CreditCard(100_000);

        assertEquals(100_000L, card.getBalance());
    }

    @Test
    void testPaymentSuccessCases() {
        assertTrue(testCard.payment(100, Currency.EUR));
        assertEquals(69177L, testCard.getBalance());

        assertTrue(testCard.payment(10_000));
        assertEquals(59177L, testCard.getBalance());
    }

    @Test
    void testPaymentFailCases() {
        assertFalse(testCard.payment(1000, Currency.EUR));
        assertEquals(100_000L, testCard.getBalance());

        assertFalse(testCard.payment(150_000));
        assertEquals(100_000L, testCard.getBalance());
    }

}