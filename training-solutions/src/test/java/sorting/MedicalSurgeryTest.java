package sorting;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MedicalSurgeryTest {

    List<Patient> patients = List.of(
            new Patient("Kiss József", "1234", LocalDateTime.of(2021, 12, 15, 12, 30)),
            new Patient("Nagy Béla", "2345", LocalDateTime.of(2021, 12, 15, 9, 15)),
            new Patient("Szép Virág", "3456", LocalDateTime.of(2021, 12, 15, 11, 45)),
            new Patient("Németh György", "4567", LocalDateTime.of(2021, 12, 15, 10, 0)),
            new Patient("Szabó Gergely", "5678", LocalDateTime.of(2021, 12, 15, 10, 30)),
            new Patient("Fodor Diána", "6789", LocalDateTime.of(2021, 12, 15, 11, 15)));
    MedicalSurgery surgery = new MedicalSurgery(patients);

    @Test
    void testGetPatientsInTimeOrder() {
        List<Patient> result = surgery.getPatientsInTimeOrder();

        assertEquals("Nagy Béla", result.get(0).getName());
        assertEquals("Szabó Gergely", result.get(2).getName());
        assertEquals("Szép Virág", result.get(4).getName());
        assertEquals(patients, surgery.getPatients());
    }

}