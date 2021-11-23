package algorithmssum.sales;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SalesAmountSumCalculatorTest {

    @Test
    void testSumSalesAmount() {
        SalesAmountSumCalculator calculator = new SalesAmountSumCalculator();
        List<Salesperson> salespersons = List.of(
                new Salesperson("John Doe", 214),
                new Salesperson("Jane Doe", 114),
                new Salesperson("Jack Doe", 14),
                new Salesperson("Jill Doe", 94)
        );
        assertEquals(436, calculator.sumSalesAmount(salespersons));
    }
}