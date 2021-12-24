package isahasa.fleet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LinerTest {

    Liner liner = new Liner(100);

    @Test
    void testLoad() {
        assertEquals(0, liner.loadPassenger(56));
        assertEquals(56, liner.getPassengers());
    }

    @Test
    void testLoadTooMuch() {
        assertEquals(11, liner.loadPassenger(111));
        assertEquals(100, liner.getPassengers());
    }

}