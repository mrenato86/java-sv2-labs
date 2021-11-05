package controlselection.month;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DayInMonthTest {

    DayInMonth dayInMonth = new DayInMonth();

    @Test
    void testNumberOfDays() {
        assertEquals(31, dayInMonth.numberOfDays(2021, "May"));
        assertEquals(30, dayInMonth.numberOfDays(2021, "june"));
        assertEquals(28, dayInMonth.numberOfDays(2021, "february"));
        assertEquals(28, dayInMonth.numberOfDays(1900, "february"));
    }

    @Test
    void testLeapYear() {
        assertEquals(29, dayInMonth.numberOfDays(2012, "february"));
        assertEquals(29, dayInMonth.numberOfDays(2020, "february"));
        assertEquals(29, dayInMonth.numberOfDays(2000, "february"));
    }

    @Test
    void testIllegalMonth() {
        assertEquals(0, dayInMonth.numberOfDays(4211, "not a Month"));
    }

}