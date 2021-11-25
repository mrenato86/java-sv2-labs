package methodparam.marriage;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WomanTest {

    @Test
    void testCreate() {
        RegisterDate registerDate = new RegisterDate("birth date", LocalDate.of(1987, 8, 12));
        Woman woman = new Woman("Eod Jane", new ArrayList<>());
        woman.addRegisterDate(registerDate);

        assertEquals("Eod Jane", woman.getName());
        assertEquals(1, woman.getRegisterDates().size());
        assertEquals(LocalDate.of(1987, 8, 12), woman.getRegisterDates().get(0).getDate());
    }

}