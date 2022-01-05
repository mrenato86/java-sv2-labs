package exceptionclass.course;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CourseTest {

    @Test
    void testCreate() {
        String name = "courseName";
        SimpleTime begin = new SimpleTime(1, 1);
        Course course = new Course(name, begin);

        assertEquals(name, course.getName());
        assertEquals(begin, course.getBegin());
    }

    @Test
    void testCreateNullNameException() {
        SimpleTime begin = new SimpleTime(1, 1);

        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> new Course(null, begin));
        assertEquals("Name is null!", iae.getMessage());
    }

    @Test
    void testNullBeginException() {
        String name = "courseName";

        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> new Course(name, null));
        assertEquals("Begin is null!", iae.getMessage());
    }

    @Test
    void testToString() {
        Course course = new Course("courseName", new SimpleTime("12:05"));

        assertEquals("12:05: courseName", course.toString());
    }

}