package objectclass;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleBagTest {

    SimpleBag bag = new SimpleBag();

    @Test
    void testCreate() {
        SimpleBag bag = new SimpleBag();

        assertTrue(bag.isEmpty());
        assertEquals(0, bag.size());
    }

    @Test
    void testPutItem() {
        bag.putItem("alma");
        bag.putItem(12);
        bag.putItem(new Book("Rejtő Jenő", "Az ellopott cirkáló"));
        bag.putItem(new Beer("Borsodi", 239));

        assertFalse(bag.isEmpty());
        assertEquals(4, bag.size());
    }

    @Test
    void testIteration() {
        bag.putItem(new Beer("Heineken", 250));
        bag.putItem(new Book("Rejtő Jenő", "Az ellopott cirkáló"));
        bag.putItem(new Beer("Borsodi", 239));
        while (bag.hasNext()) {
            bag.next();
        }

        assertEquals(2, bag.getCursor());
    }

    @Test
    void testContains() {
        bag.putItem(new Beer("Borsodi", 239));
        bag.putItem(new Book("Rejtő Jenő", "Az ellopott cirkáló"));

        assertTrue(bag.contains(new Beer("Borsodi", 239)));
        assertTrue(bag.contains(new Book("Rejtő Jenő", "Az ellopott cirkáló")));
        assertFalse(bag.contains(new Book("Rejtő Jenő", "A megkerült cirkáló")));
    }

}