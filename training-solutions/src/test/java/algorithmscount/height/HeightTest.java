package algorithmscount.height;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HeightTest {

    @Test
    void testCountChildrenWithHeightGreaterThan() {
        List<Integer> heights = List.of(100, 110, 160, 140, 99, 80);
        assertEquals(3, new Height().countChildrenWithHeightGreaterThan(heights, 100));
    }
}