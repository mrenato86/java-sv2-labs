package methodoverloading;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimeTest {

    Time time = new Time(14, 20, 44);

    @Test
    void testCreate() {
        Time time = new Time(14, 20, 44);
        assertEquals(14, time.getHours());
        assertEquals(20, time.getMinutes());
        assertEquals(44, time.getSeconds());
    }

    @Test
    void testIsEqualWithInt() {
        assertTrue(time.isEqual(14, 20, 44));
        assertFalse(time.isEqual(15, 10, 20));
    }

    @Test
    void testIsEqualWithTime() {
        assertTrue(time.isEqual(new Time(14, 20, 44)));
        assertFalse(time.isEqual(new Time(15, 10, 20)));
    }

    @Test
    void testIsEarlierWithInt() {
        assertFalse(time.isEarlier(14, 20, 44));
        assertTrue(time.isEarlier(15, 10, 20));
        assertFalse(time.isEarlier(10, 10, 10));
    }

    @Test
    void testIsEarlierWithTimeParameter() {
        assertFalse(time.isEarlier(new Time(14, 20, 44)));
        assertTrue(time.isEarlier(new Time(15, 10, 20)));
        assertFalse(time.isEarlier(new Time(10, 10, 10)));
    }
}