package constructoroverloading.bus;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleTimeTest {

    @Test
    void testCreateTwoParameters() {
        SimpleTime time = new SimpleTime(15, 16);
        assertEquals(15, time.getHours());
        assertEquals(16, time.getMinutes());
    }

    @Test
    void testCreateOneParameter() {
        SimpleTime time = new SimpleTime(15);
        assertEquals(15, time.getHours());
        assertEquals(0, time.getMinutes());
    }

    @Test
    void testCreateSimpleTimeParameter() {
        SimpleTime time = new SimpleTime(new SimpleTime(15, 16));
        assertEquals(15, time.getHours());
        assertEquals(16, time.getMinutes());
    }

    @Test
    void testGetDifferenceAfter() {
        SimpleTime time = new SimpleTime(new SimpleTime(15, 16));
        SimpleTime anotherTime = new SimpleTime(new SimpleTime(14, 10));
        assertEquals(66, time.getDifference(anotherTime));
    }

    @Test
    void testGetDifferenceBefore() {
        SimpleTime time = new SimpleTime(new SimpleTime(15, 16));
        SimpleTime anotherTime = new SimpleTime(new SimpleTime(17, 26));
        assertEquals(-130, time.getDifference(anotherTime));
    }

    @Test
    void testToString() {
        SimpleTime time = new SimpleTime(new SimpleTime(15, 16));
        assertEquals("15:16", time.toString());
    }

}