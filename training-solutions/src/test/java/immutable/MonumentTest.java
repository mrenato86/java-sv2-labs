package immutable;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MonumentTest {

    @Test
    void testCreate() {
        Monument monument = new Monument("Big Pyramid", "Egypt, Pyramid square",
                LocalDate.of(2019, 9, 9), "BPY-1234");

        assertEquals("Big Pyramid", monument.getName());
        assertEquals("Egypt, Pyramid square", monument.getAddress());
        assertEquals(LocalDate.of(2019, 9, 9), monument.getDateOfRegistry());
        assertEquals("BPY-1234", monument.getRegistryNumber());
    }

    @Test
    void testCreateWithWrongName() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> new Monument(null, "Egypt, Pyramid square",
                        LocalDate.of(2019, 9, 9), "BPY-1234"));
        assertEquals("Name, address or registry number cannot be empty!", iae.getMessage());

        iae = assertThrows(IllegalArgumentException.class,
                () -> new Monument("    ", "Egypt, Pyramid square",
                        LocalDate.of(2019, 9, 9), "BPY-1234"));
        assertEquals("Name, address or registry number cannot be empty!", iae.getMessage());
    }

    @Test
    void testCreateWithWrongAddress() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> new Monument("Big Pyramid", null,
                        LocalDate.of(2019, 9, 9), "BPY-1234"));
        assertEquals("Name, address or registry number cannot be empty!", iae.getMessage());

        iae = assertThrows(IllegalArgumentException.class,
                () -> new Monument("Big Pyramid", "   ",
                        LocalDate.of(2019, 9, 9), "BPY-1234"));
        assertEquals("Name, address or registry number cannot be empty!", iae.getMessage());
    }

    @Test
    void testCreateWithWrongRegistryNumber() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> new Monument("Big Pyramid", "Egypt, Pyramid square",
                        LocalDate.of(2019, 9, 9), null));
        assertEquals("Name, address or registry number cannot be empty!", iae.getMessage());

        iae = assertThrows(IllegalArgumentException.class,
                () -> new Monument("Big Pyramid", "Egypt, Pyramid square",
                        LocalDate.of(2019, 9, 9), "    "));
        assertEquals("Name, address or registry number cannot be empty!", iae.getMessage());
    }
}