package collectionsclass;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExamTest {

    List<ExamResult> testResults = List.of(
            new ExamResult("Kiss József", 56),
            new ExamResult("Nagy Béla", 34),
            new ExamResult("Szép Virág", 78),
            new ExamResult("Szabó Gergely", 67),
            new ExamResult("Fodor Károly", 76),
            new ExamResult("Horvát Lajos", 59),
            new ExamResult("Kékes Kinga", 92),
            new ExamResult("Fehér Klára", 62)
    );
    Exam exam = new Exam(testResults);

    @Test
    void testGetNamesOfSucceededPeople() {
        List<String> result = exam.getNamesOfSucceededPeople(4);

        assertEquals(4, result.size());
        assertEquals("Kékes Kinga", result.get(0));
        assertEquals("Fodor Károly", result.get(2));
    }

    @Test
    void testGetNamesOfSucceededPeopleMorePlaces() {
        List<String> result = exam.getNamesOfSucceededPeople(10);

        assertEquals(8, result.size());
    }

}