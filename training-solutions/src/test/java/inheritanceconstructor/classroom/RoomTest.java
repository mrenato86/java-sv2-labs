package inheritanceconstructor.classroom;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    @Test
    void testCreate() {
        Room room = new Room("I. em. 12.", 20);

        assertEquals("I. em. 12.", room.getLocation());
        assertEquals(20, room.getCapacity());
    }

}