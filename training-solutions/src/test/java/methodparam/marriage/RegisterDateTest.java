package methodparam.marriage;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RegisterDateTest {

    @Test
    void testCreate() {
        RegisterDate registerDate = new RegisterDate("birth date", LocalDate.of(1999, 10, 2));

        assertEquals("birth date", registerDate.getDescription());
        assertEquals(LocalDate.of(1999, 10, 2), registerDate.getDate());
    }

}