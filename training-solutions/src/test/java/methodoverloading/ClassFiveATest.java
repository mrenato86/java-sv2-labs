package methodoverloading;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClassFiveATest {

    ClassFiveA classFiveA = new ClassFiveA("Gárdos Helga", "Joó Lilla", "Kiss József", "Nagy Béla",
            "Németh Dóra", "Pongrácz Imola", "Rendes Richárd", "Szabó Nóra", "Takács Júlia", "Vígh Elemér");

    @Test
    void testGetTodayReferringStudentByInt() {
        assertEquals("Kiss József", classFiveA.getTodayReferringStudent(3));
    }

    @Test
    void testGetTodayReferringStudentByEnum() {
        assertEquals("Kiss József", classFiveA.getTodayReferringStudent(Number.THREE));
    }

    @Test
    void testGetTodayReferringStudentByEnumName() {
        assertEquals("Kiss József", classFiveA.getTodayReferringStudent("three"));
    }
}