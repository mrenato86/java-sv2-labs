package methodparam.marriage;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MarriageTest {

    @Test
    void getMarried() {
        Woman woman = new Woman("Eod Jane", new ArrayList<>(List.of(
                new RegisterDate("birth date", LocalDate.of(1987, 8, 15))
        )));
        Man man = new Man("Doe John", new ArrayList<>(List.of(
                new RegisterDate("birth date", LocalDate.of(1986, 8, 15)),
                new RegisterDate("marriage date", LocalDate.of(2000, 4, 1)),
                new RegisterDate("divorce date", LocalDate.of(2010, 4, 1))
        )));
        new Marriage().getMarried(woman, man);

        assertEquals("Doe-Eod Jane", woman.getName());
        assertEquals(4, man.getRegisterDates().size());
        assertEquals(LocalDate.now(), woman.getRegisterDates().get(1).getDate());
    }
}