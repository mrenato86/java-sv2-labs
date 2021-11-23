package algorithmsdecision.towns;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TownTest {

    @Test
    void testContainsFewerHabitants() {
        Town town = new Town();
        List<Integer> residents = List.of(2871, 65423, 120140, 9834, 561, 19623);

        assertTrue(town.containsFewerHabitants(residents, 1000));
        assertFalse(town.containsFewerHabitants(residents, 100));
    }
}