package algorithmsmax;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlaneTest {

    String map = "10000000111110000000000001111111111000010000010000100000111111110000101000000000111110000000000000000100000001000000000000111111000000000100000000000011";

    @Test
    void testGetLongestOcean() {
        assertEquals(16, new Plane().getLongestOcean(map));
    }

    @Test
    void testGetLongestOceanAlternative() {
        assertEquals(16, new Plane().getLongestOceanAlternative(map));
    }
}