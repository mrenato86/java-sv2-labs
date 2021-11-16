package introexceptionthrowjunit5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StudentTest {

    Student student = new Student();

    @Test
    void testAddNote() {
        student.addNote(2);
        student.addNote(5);
        student.addNote(3);

        assertEquals(3, student.getGrades().size());
        assertEquals(2, student.getGrades().get(0).intValue());
        assertEquals(5, student.getGrades().get(1).intValue());
        assertEquals(3, student.getGrades().get(2).intValue());
    }

    @Test
    void testAddNoteException() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> student.addNote(6));
        assertEquals("Note must be between 1 and 5!", iae.getMessage());

    }
}