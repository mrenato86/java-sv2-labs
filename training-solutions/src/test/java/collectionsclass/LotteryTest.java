package collectionsclass;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LotteryTest {

    @Test
    void testSelectWinningNumbers() {
        List<Integer> winningNumbers = new Lottery().selectWinningNumbers(5, 90);
        assertEquals(5, winningNumbers.size());
    }

    @Test
    void testSelectWinningNumbersWrongParameters() {
        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> new Lottery().selectWinningNumbers(10, 10));
        assertEquals("Ball count must be bigger than drawn numbers!", ex.getMessage());
    }

}