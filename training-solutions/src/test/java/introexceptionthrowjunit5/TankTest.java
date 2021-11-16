package introexceptionthrowjunit5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TankTest {
    Tank tank = new Tank();

    @Test
    void testModifyAngle() {
        tank.modifyAngle(2090);
        assertEquals(290, tank.getAngle());

        tank.modifyAngle(-2020);
        assertEquals(70, tank.getAngle());
    }

    @Test
    void testModifyAngleException() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> tank.modifyAngle(2000));
        assertEquals("Turret can't be in a position between 80° and 280°!", iae.getMessage());
    }

}