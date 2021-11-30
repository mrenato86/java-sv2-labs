package inheritanceattributes.book;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShippedBookTest {

    ShippedBook book = new ShippedBook("The Lord of the Rings", 3000, 1200);

    @Test
    void testToString() {
        assertEquals("The Lord of the Rings: 3000 Ft, shipping cost: 1200 Ft", book.toString());
    }

    @Test
    void testOrder() {
        assertEquals(7200, book.order(2));
    }

    @Test
    void testPurchase() {
        assertEquals(6000, book.purchase(2));
    }

}