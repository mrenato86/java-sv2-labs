package algorithmsdecision;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimeTest {

    @Test
    void testIsPrime() {
        Prime prime = new Prime();

        assertFalse(prime.isPrime(-1));
        assertFalse(prime.isPrime(0));
        assertFalse(prime.isPrime(1));
        assertTrue(prime.isPrime(2));
        assertFalse(prime.isPrime(27));
        assertTrue(prime.isPrime(29));
    }
}