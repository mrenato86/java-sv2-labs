package methodparam.sums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SumsTest {

    @Test
    void testCreate() {
        Sums sums = new Sums(62.3, -12.3);

        assertEquals(62.3, sums.getSumOfPositives(), 0.00001);
        assertEquals(-12.3, sums.getSumOfNegatives(), 0.00001);
    }

}