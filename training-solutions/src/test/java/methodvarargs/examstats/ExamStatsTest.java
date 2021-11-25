package methodvarargs.examstats;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExamStatsTest {

    ExamStats examStats = new ExamStats(100);

    @Test
    void testGetNumberOfTopGrades() {
        assertEquals(2, examStats.getNumberOfTopGrades(85, 50, 70, 49, 95, 87, 85));
        assertEquals(0, examStats.getNumberOfTopGrades(85, 50, 70, 49, 85));
    }

    @Test
    void testHasAnyFailed() {
        assertTrue(examStats.hasAnyFailed(50, 50, 70, 49, 95, 87, 85));
        assertFalse(examStats.hasAnyFailed(50, 50, 70, 95, 87, 85));
    }

    @Test
    void testGetNumberOfTopGradesWrongInput() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> examStats.getNumberOfTopGrades(85));
        assertEquals("Results cannot be empty!", iae.getMessage());

        iae = assertThrows(IllegalArgumentException.class, () -> examStats.getNumberOfTopGrades(85, null));
        assertEquals("Results cannot be empty!", iae.getMessage());
    }

    @Test
    void testHasAnyFailedWrongInput() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> examStats.hasAnyFailed(85));
        assertEquals("Results cannot be empty!", iae.getMessage());

        iae = assertThrows(IllegalArgumentException.class, () -> examStats.hasAnyFailed(85, null));
        assertEquals("Results cannot be empty!", iae.getMessage());
    }
}