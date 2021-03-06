package inheritanceattributes.book;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookTest {

    @Test
    void testCreate() {
        Book book = new Book("Hyperion", 3000);

        assertEquals("Hyperion", book.getTitle());
        assertEquals(3000, book.price);
    }

    @Test
    void testPurchase() {
        Book book = new Book("Hyperion", 3000);

        assertEquals(6000, book.purchase(2));
    }

}