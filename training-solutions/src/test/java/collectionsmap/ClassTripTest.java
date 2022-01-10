package collectionsmap;

import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class ClassTripTest {

    ClassTrip classTrip = new ClassTrip();

    @Test
    void testLoadInPayments() {
        classTrip.loadInPayments(Paths.get("src/test/resources/collectionsmap/inpayments.txt"));

        assertEquals(3, classTrip.getPayments().entrySet().size());
        assertTrue(classTrip.getPayments().containsKey("Kiss József"));
        assertFalse(classTrip.getPayments().containsValue(20000));
        assertEquals(5000, classTrip.getPayments().get("Nagy Béla"));
    }

    @Test
    void testLoadInPaymentsFromNonExistingFile() {
        Exception ex = assertThrows(IllegalStateException.class, () -> classTrip.loadInPayments(Paths.get("xyz.txt")));
        assertEquals("File reading error!", ex.getMessage());
    }

}