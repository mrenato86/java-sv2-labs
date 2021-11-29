package inheritanceconstructor.classroom;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {

    @Test
    void testCreate() {
        Course course = new Course(20, Facility.COMPUTERS);

        assertEquals(20, course.getParticipants());
        assertEquals(Facility.COMPUTERS, course.getFacilityNeeded());
    }

}