package inheritancemethods.cars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class JeepTest {

    Jeep jeep = new Jeep(10.0, 30.0, 50.0, 40.0, 20.0);

    @Test
    void testCreate() {
        Jeep jeep = new Jeep(10.0, 30.0, 50.0, 40.0, 20.0);

        assertEquals(10.0, jeep.getFuelRate());
        assertEquals(30.0, jeep.getFuel());
        assertEquals(50.0, jeep.getTankCapacity());
        assertEquals(40.0, jeep.getExtraCapacity());
        assertEquals(20.0, jeep.getExtraFuel());
    }

    @Test
    void testCreateIncorrectParameter() throws IllegalArgumentException {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> new Jeep(10.0, 60.0, 50.0, 40.0, 20.0));
        assertEquals("Tank capacity is less than fuel!", iae.getMessage());
    }

    @Test
    void testCalculateRefillAmount() {
        assertEquals(40.0, jeep.calculateRefillAmount());
    }

    @Test
    void testDrive() {
        jeep.drive(300);

        assertEquals(0.0, jeep.getExtraFuel());
        assertEquals(20.0, jeep.getFuel());
    }

    @Test
    void testDriveNotEnoughFuel() throws RuntimeException {
        RuntimeException re = assertThrows(RuntimeException.class, () -> jeep.drive(600));
        assertEquals("Not enough fuel available!", re.getMessage());
    }

}