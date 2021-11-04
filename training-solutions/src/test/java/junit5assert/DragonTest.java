package junit5assert;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DragonTest {

    @Test
    void testName() {
        Dragon dragon = new Dragon("Seven-headed Dragon", 7, 10.1);

        assertEquals("Seven-headed Dragon", dragon.getName());
        assertNotEquals("Headless Dragon", dragon.getName());
    }

    @Test
    void testNumberOfHeads() {
        Dragon dragon = new Dragon("Seven-headed Dragon", 7, 10.1);

        assertEquals(7, dragon.getNumberOfHeads());
        assertTrue(dragon.getNumberOfHeads() == 7);
        assertFalse(dragon.getNumberOfHeads() == 0);
        assertEquals(true, dragon.getNumberOfHeads() == 7);
        assertEquals(false, dragon.getNumberOfHeads() == 0);
    }

    @Test
    void testHeight() {
        Dragon dragon = new Dragon("Seven-headed Dragon", 7, 10.1);

        assertEquals(10.1, dragon.getHeight(), 0.005);
    }

    @Test
    void testNull() {
        Dragon dragon = new Dragon("Seven-headed Dragon", 7, 10.1);
        Dragon nullDragon = null;

        assertNull(nullDragon);
        assertNotNull(dragon);
    }

    @Test
    void testSameObjects() {
        Dragon dragon = new Dragon("Seven-headed Dragon", 7, 10.1);
        Dragon copyDragon = dragon;

        assertSame(dragon, copyDragon);
    }

    @Test
    void testNotSameObjects() {
        Dragon dragon = new Dragon("Seven-headed Dragon", 7, 10.1);
        Dragon copyDragon = new Dragon("Seven-headed Dragon", 7, 10.1);

        assertNotSame(dragon, copyDragon);
    }

}
