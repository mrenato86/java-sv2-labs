package templatemethod.bank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class YieldProductTest {

    @Test
    public void testRound() {
        YieldProduct yieldProduct = new YieldProduct(123);

        assertEquals(125, yieldProduct.round(125.5));
    }

}