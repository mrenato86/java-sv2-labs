package defaultconstructor.date;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SimpleDateTest {

    SimpleDate simpleDate = new SimpleDate();

    @Test
    void testSetDate() {
        simpleDate.setDate(2016, 2, 29);

        assertEquals(2016, simpleDate.getYear());
        assertEquals(2, simpleDate.getMonth());
        assertEquals(29, simpleDate.getDay());
    }

    @Test
    void testSetDateNotLeapYear() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> simpleDate.setDate(1914, 2, 29)
        );
        assertEquals("Invalid parameter(s) in: 1914 2 29", iae.getMessage());
    }

    @Test
    void testSetDateWrongDay() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> simpleDate.setDate(2000, 4, 31)
        );
        assertEquals("Invalid parameter(s) in: 2000 4 31", iae.getMessage());
    }

    @Test
    void testSetDateWrongYear() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> simpleDate.setDate(1848, 3, 15)
        );
        assertEquals("Invalid parameter(s) in: 1848 3 15", iae.getMessage());
    }

    @Test
    void testSetDateWrongMonth() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> simpleDate.setDate(2014, 13, 15)
        );
        assertEquals("Invalid parameter(s) in: 2014 13 15", iae.getMessage());
    }

}