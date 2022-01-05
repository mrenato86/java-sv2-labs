package exceptionmulticatch.converter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnswerStatTest {

    AnswerStat answerStat = new AnswerStat(new BinaryStringConverter());

    @Test
    void testConvert() {
        String good = "1100010";
        boolean[] expected = {true, true, false, false, false, true, false};

        assertArrayEquals(expected, answerStat.convert(good));
    }

    @Test
    void testConvertNullException() {
        Exception ex = assertThrows(InvalidBinaryStringException.class, () -> answerStat.convert(null));
        assertEquals("Binary string is null.", ex.getCause().getMessage());
    }

    @Test
    void testConvertInvalidStringException() {
        Exception ex = assertThrows(InvalidBinaryStringException.class, () -> answerStat.convert("1133"));
        assertEquals("Binary string is not valid.", ex.getCause().getMessage());
    }

    @Test
    void testAnswerTruePercent() {
        assertEquals(50, answerStat.answerTruePercent("11000101"));
        assertEquals(80, answerStat.answerTruePercent("1111111100"));
    }

}