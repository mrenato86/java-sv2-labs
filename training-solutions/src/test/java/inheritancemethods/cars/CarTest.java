package inheritancemethods.cars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarTest {

    Car car = new Car(5.0, 25.0, 40.0);

    @Test
    void testCreate() {
        Car car = new Car(5.0, 25.0, 40.0);

        assertEquals(5.0, car.getFuelRate());
        assertEquals(25.0, car.getFuel());
        assertEquals(40.0, car.getTankCapacity());
    }

    @Test
    void testCreateIncorrectParameter() throws IllegalArgumentException {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> new Car(5.0, 50.0, 40.0));
        assertEquals("Tank capacity is less than fuel!", iae.getMessage());
    }

    @Test
    void testModifyFuelAmount() {
        car.modifyFuelAmount(-10.0);

        assertEquals(15.0, car.getFuel());
    }

    @Test
    void testDrive() {
        car.drive(100);

        assertEquals(20.0, car.getFuel());
    }

    @Test
    void testDriveNotEnoughFuel() throws RuntimeException {
        RuntimeException re = assertThrows(RuntimeException.class, () -> car.drive(600));
        assertEquals("Not enough fuel available!", re.getMessage());
    }

    @Test
    void testCalculateRefillAmount() {
        assertEquals(15.0, car.calculateRefillAmount());
    }

}