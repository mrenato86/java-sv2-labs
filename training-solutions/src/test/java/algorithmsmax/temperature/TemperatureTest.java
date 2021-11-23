package algorithmsmax.temperature;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TemperatureTest {

    @Test
    void testGetMin() {
        List<Integer> temperatures = List.of(22, 11, 30, 4, -3, 0);
        assertEquals(-3, new Temperature().getMin(temperatures));
    }
}