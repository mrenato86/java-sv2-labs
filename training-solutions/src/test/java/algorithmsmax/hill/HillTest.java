package algorithmsmax.hill;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HillTest {

    @Test
    void testGetMax() {
        List<Integer> mountainHeights = List.of(2500, 1000, 780, 2700, 1210);
        assertEquals(2700, new Hill().getMax(mountainHeights));
    }
}