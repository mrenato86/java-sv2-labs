package methodparam.marriage;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ManTest {

    @Test
    void testCreate() {
        RegisterDate registerDate = new RegisterDate("birth date", LocalDate.of(1986, 8, 15));
        Man man = new Man("Doe John", new ArrayList<>());
        man.addRegisterDate(registerDate);

        assertEquals("Doe John", man.getName());
        assertEquals(1, man.getRegisterDates().size());
        assertEquals(LocalDate.of(1986, 8, 15), man.getRegisterDates().get(0).getDate());
    }

}