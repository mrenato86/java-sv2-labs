package algorithmssum.school;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SchoolTest {

    @Test
    void testGetNumberOfStudents() {
        School school = new School();
        List<Integer> headcounts = List.of(23, 31, 41, 19, 23);
        assertEquals(137, school.getNumberOfStudents(headcounts));
    }
}