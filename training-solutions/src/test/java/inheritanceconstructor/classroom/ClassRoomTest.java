package inheritanceconstructor.classroom;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClassRoomTest {

    ClassRoom classroom = new ClassRoom("122", 20, Facility.COMPUTERS);

    @Test
    void testCreate() {
        ClassRoom classroom = new ClassRoom("122", 20, Facility.CHALKBOARD);

        assertEquals("122", classroom.getLocation());
        assertEquals(20, classroom.getCapacity());
        assertEquals(Facility.CHALKBOARD, classroom.getFacility());
    }

    @Test
    void testIsSuitableSuccess() {
        Course course = new Course(15, Facility.COMPUTERS);

        assertTrue(classroom.isSuitable(course));
    }

    @Test
    void tesIsSuitableFail() {
        Course course = new Course(15, Facility.CHALKBOARD);

        assertFalse(classroom.isSuitable(course));
    }

}