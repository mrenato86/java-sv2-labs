package algorithmsmax.sales;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

class SalesTest {

    List<Salesperson> salespersons = List.of(
            new Salesperson("John", 600, 500),
            new Salesperson("Bill", 200, 300),
            new Salesperson("Kate", 700, 100),
            new Salesperson("Mary", 700, 300),
            new Salesperson("Karl", 200, 50),
            new Salesperson("Peter", 50, 100)
    );
    Sales sales = new Sales();

    @Test
    void testSelectSalesPersonWithMaxSalesAmount() {
        assertSame(salespersons.get(2), sales.selectSalesPersonWithMaxSalesAmount(salespersons));
        assertNull(sales.selectSalesPersonWithMaxSalesAmount(null));
    }

    @Test
    void testSelectSalesPersonWithFurthestAboveTarget() {
        assertSame(salespersons.get(2), sales.selectSalesPersonWithFurthestAboveTarget(salespersons));
        assertNull(sales.selectSalesPersonWithFurthestAboveTarget(null));
    }

    @Test
    void testSelectSalesPersonWithFurthestBelowTarget() {
        assertSame(salespersons.get(1), sales.selectSalesPersonWithFurthestBelowTarget(salespersons));
        assertNull(sales.selectSalesPersonWithFurthestBelowTarget(null));
    }
}