package algorithmsmax.sales;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SalespersonTest {

    @Test
    void testCreate() {
        Salesperson person = new Salesperson("John", 1000, 200);

        assertEquals("John", person.getName());
        assertEquals(1000, person.getAmount());
        assertEquals(200, person.getTarget());
        assertEquals(800, person.getDiffFromTarget());
    }

}