package templatemethod.bank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BankProductTest {

    @Test
    public void testIncreaseWhenLoanProduct() {
        GeneralProduct product = new LoanProduct(100);
        product.increase(15);

        assertEquals(115, product.getPrice());
    }

    @Test
    public void testIncreaseWhenYieldProduct() {
        GeneralProduct product = new YieldProduct(100);
        product.increase(15);

        assertEquals(115, product.getPrice());
    }

}