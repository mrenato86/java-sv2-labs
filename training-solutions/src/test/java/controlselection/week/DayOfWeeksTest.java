package controlselection.week;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DayOfWeeksTest {

    @Test
    void dayOfWeekTest() {
        DayOfWeeks dayOfWeeks = new DayOfWeeks();

        assertEquals("Start of week", dayOfWeeks.dayOfWeek("Monday"));
        assertEquals("Midweek", dayOfWeeks.dayOfWeek("Wednesday"));
        assertEquals("Almost weekend", dayOfWeeks.dayOfWeek("friday"));
        assertEquals("Weekend", dayOfWeeks.dayOfWeek("sunday"));
        assertEquals("Unknown day", dayOfWeeks.dayOfWeek("funDay"));
    }

}