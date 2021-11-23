package algorithmssum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TwoDigitEvensTest {

    @Test
    void testGetSum() {
        assertEquals(1980, new TwoDigitEvens().getSum());
    }
}