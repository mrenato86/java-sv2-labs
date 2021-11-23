package algorithmssum.sales;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SalespersonTest {

    @Test
    void testCreate() {
        Salesperson salesperson = new Salesperson("John Doe", 214);
        assertEquals("John Doe", salesperson.getName());
        assertEquals(214, salesperson.getAmount());
    }
}