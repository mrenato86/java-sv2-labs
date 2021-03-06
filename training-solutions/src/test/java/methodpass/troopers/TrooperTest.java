package methodpass.troopers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrooperTest {

    Trooper trooper = new Trooper("John Doe");
    Position target = new Position(3, 4);

    @Test
    void testCreate() {
        Trooper trooper = new Trooper("New Trooper");

        assertEquals("New Trooper", trooper.getName());
        assertEquals(0, trooper.getPosition().getPosX(), 0);
        assertEquals(0, trooper.getPosition().getPosY(), 0);
    }

    @Test
    void testCreateWithEmptyName() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> new Trooper(""));
        assertEquals("Name cannot be empty", iae.getMessage());
    }

    @Test
    void testChangePosition() {
        trooper.changePosition(target);

        assertEquals(3, trooper.getPosition().getPosX(), 0.000001);
        assertEquals(4, trooper.getPosition().getPosY(), 0.000001);
    }

    @Test
    void testChangePositionToNowhere() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> trooper.changePosition(null));

        assertEquals("The new position cannot be null", ex.getMessage());
    }

    @Test
    void testDistanceFrom() {
        assertEquals(5, trooper.distanceFrom(target), 0.000001);
    }

}