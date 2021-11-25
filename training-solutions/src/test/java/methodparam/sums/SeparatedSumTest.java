package methodparam.sums;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SeparatedSumTest {


    @Test
    void testSum() {
        Path path = Paths.get("src/test/resources/methodparam/floatingnumbers.txt" );
        SeparatedSum separatedSum = new SeparatedSum();
        Sums sums = separatedSum.sum(separatedSum.readFirstLine(path));

        assertEquals(110.6, sums.getSumOfPositives(), 0.0001);
        assertEquals(-153.3, sums.getSumOfNegatives(), 0.0001);
    }
}