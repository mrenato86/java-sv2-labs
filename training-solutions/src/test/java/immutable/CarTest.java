package immutable;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarTest {

    @Test
    void testCreate() {
        Car car = new Car("Ford", "Focus", 2019);

        assertEquals("Ford", car.getBrand());
        assertEquals("Focus", car.getModel());
        assertEquals(2019, car.getYearOfProduction());
    }

    @Test
    void testCreateWithNullName() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> new Car(null, "Focus", 3000));
        assertEquals("Brand name cannot be empty!", iae.getMessage());
    }

    @Test
    void testCreateWithEmptyName() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> new Car("", "Focus", 3000));
        assertEquals("Brand name cannot be empty!", iae.getMessage());
    }

    @Test
    void testCreateWithYearInTheFuture() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> new Car("Ford", "Focus", 3000));
        assertEquals("Year of production cannot be in the future!", iae.getMessage());
    }

}