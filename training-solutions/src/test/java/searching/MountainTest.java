package searching;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MountainTest {

    @Test
    void testSearchPike() {
        int[] heights = new int[]{1234, 2345, 2634, 2670, 2790, 3200};

        assertTrue(new Mountain(heights).searchPike(new Pike("Lomnici-csúcs", 2634)));
    }

    @Test
    void testSearchPikeNotFound() {
        int[] heights = new int[]{1234, 2345, 2634, 2670, 2790, 3200};

        assertFalse(new Mountain(heights).searchPike(new Pike("Gerlachfalvi-csúcs", 2655)));
    }

}