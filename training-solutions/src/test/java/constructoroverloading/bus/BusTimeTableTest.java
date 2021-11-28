package constructoroverloading.bus;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BusTimeTableTest {

    List<SimpleTime> timetableTest = List.of(
            new SimpleTime(9, 15),
            new SimpleTime(12, 45),
            new SimpleTime(14, 15),
            new SimpleTime(16, 15),
            new SimpleTime(18, 15)
    );
    BusTimeTable timetable = new BusTimeTable(timetableTest);

    @Test
    void testCreateFormList() {
        BusTimeTable timetable = new BusTimeTable(timetableTest);

        assertEquals(5, timetable.getTimeTable().size());
        assertEquals(9, timetable.getTimeTable().get(0).getHours());
        assertEquals(15, timetable.getTimeTable().get(4).getMinutes());
    }

    @Test
    void testCreateFormHours() {
        BusTimeTable timetable = new BusTimeTable(10, 16, 30);

        assertEquals(7, timetable.getTimeTable().size());
        assertEquals(10, timetable.getTimeTable().get(0).getHours());
        assertEquals(30, timetable.getTimeTable().get(0).getMinutes());
        assertEquals(16, timetable.getTimeTable().get(6).getHours());
    }

    @Test
    void testGetNextBus() {
        assertSame(timetableTest.get(2), timetable.getNextBus(new SimpleTime(13, 15)));
    }

    @Test
    void testGetNextBusNoNextBus() {
        IllegalStateException ise = assertThrows(IllegalStateException.class,
                () -> timetable.getNextBus(new SimpleTime(18, 16))
        );
        assertEquals("There's no more bus for today!", ise.getMessage());
    }

}