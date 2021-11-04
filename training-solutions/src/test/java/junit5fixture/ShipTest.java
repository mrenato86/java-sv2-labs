package junit5fixture;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShipTest {

    Ship ship;

    @BeforeEach
    void init() {
        ship = new Ship("Queen Anne's Revenge", 1710, 31.4);
    }

    @Test
    void testName() {
        assertEquals("Queen Anne's Revenge", ship.getName());
        assertNotEquals("Santa Maria", ship.getName());
    }

    @Test
    void testYearOfConstruction() {
        assertEquals(1710, ship.getYearOfConstruction());
        assertTrue(ship.getYearOfConstruction() <= 1710);
        assertFalse(ship.getYearOfConstruction() <= 0);
    }

    @Test
    void testLength() {
        assertEquals(31.4, ship.getLength(), 0.005);
    }

    @Test
    void testNull() {
        Ship patrolShip = null;
        assertNull(patrolShip);
        assertNotNull(ship);
    }

    @Test
    void testSameObjects() {
        Ship pirateShip = ship;
        assertSame(ship, pirateShip);
    }

    @Test
    void testNotSameObjects() {
        Ship prateShip = new Ship("Queen Anne's Revenge", 1710, 31.4);
        assertNotSame(ship, prateShip);
    }
}
