package templatemethod.bank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoanProductTest {

    @Test
    public void testRound() {
        LoanProduct loanProduct = new LoanProduct(123);

        assertEquals(129, loanProduct.round(128.5));
    }

}