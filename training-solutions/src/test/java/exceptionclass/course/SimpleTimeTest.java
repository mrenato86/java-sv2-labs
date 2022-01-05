package exceptionclass.course;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SimpleTimeTest {


    @Test
    void testCreateInteger() {
        int hour = 1;
        int minute = 2;
        SimpleTime simpleTime = new SimpleTime(hour, minute);

        assertEquals(1, simpleTime.getHour());
        assertEquals(2, simpleTime.getMinute());
    }

    @Test
    void testCreateString() {
        String timeStr = "01:12";
        SimpleTime simpleTime = new SimpleTime(timeStr);

        assertEquals(1, simpleTime.getHour());
        assertEquals(12, simpleTime.getMinute());
    }

    @Test
    void testCreateInvalidHourExceptions() {
        int hour = 24;
        int minute = 1;
        InvalidTimeException ite = assertThrows(InvalidTimeException.class, () -> new SimpleTime(hour, minute));
        assertEquals("Hour is invalid (0-23)", ite.getMessage());

        String timeString = "24:23";
        ite = assertThrows(InvalidTimeException.class, () -> new SimpleTime(timeString));
        assertEquals("Hour is invalid (0-23)", ite.getMessage());
    }

    @Test
    public void testCreateInvalidMinuteExceptions() {
        int hour = 1;
        int minute = 60;
        InvalidTimeException ite = assertThrows(InvalidTimeException.class, () -> new SimpleTime(hour, minute));
        assertEquals("Minute is invalid (0-59)", ite.getMessage());

        String timeString = "12:60";
        ite = assertThrows(InvalidTimeException.class, () -> new SimpleTime(timeString));
        assertEquals("Minute is invalid (0-59)", ite.getMessage());
    }

    @Test
    void testCreateNullParameterException() {
        InvalidTimeException ite = assertThrows(InvalidTimeException.class, () -> new SimpleTime(null));
        assertEquals("Time is null", ite.getMessage());
    }

    @Test
    void testCreateInvalidFormatExceptions() {
        String wrongLength = "aa";
        InvalidTimeException ite = assertThrows(InvalidTimeException.class, () -> new SimpleTime(wrongLength));
        assertEquals("Time is not hh:mm", ite.getMessage());

        String wrongDelimiter = "12,23";
        ite = assertThrows(InvalidTimeException.class, () -> new SimpleTime(wrongDelimiter));
        assertEquals("Time is not hh:mm", ite.getMessage());

        String wrongNumber = "a1:23";
        ite = assertThrows(InvalidTimeException.class, () -> new SimpleTime(wrongNumber));
        assertEquals("Time is not hh:mm", ite.getMessage());
    }

    @Test
    void testToString() {
        SimpleTime simpleTime = new SimpleTime(1, 12);
        assertEquals("01:12", simpleTime.toString());
    }

}