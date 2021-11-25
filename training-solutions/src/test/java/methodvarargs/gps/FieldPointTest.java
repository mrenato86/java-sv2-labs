package methodvarargs.gps;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class FieldPointTest {

    @Test
    void testCreate() {
        FieldPoint fieldPoint = new FieldPoint(LocalDateTime.of(2021, 11, 25, 10, 11),
                47.205902, 17.555667);

        assertEquals(LocalDateTime.of(2021, 11, 25, 10, 11), fieldPoint.getTimeOfSetting());
        assertNull(fieldPoint.getTimeOfLogging());
        assertEquals(47.205902, fieldPoint.getLatitude(), 0.0001);
        assertEquals(17.555667, fieldPoint.getLongitude(), 0.0001);
    }

}