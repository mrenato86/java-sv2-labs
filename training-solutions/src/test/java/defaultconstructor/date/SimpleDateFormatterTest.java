package defaultconstructor.date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleDateFormatterTest {

    SimpleDate simpleDate;

    @BeforeEach
    void init() {
        simpleDate = new SimpleDate();
        simpleDate.setDate(2021, 11, 27);
    }

    @Test
    void testFormatDateStringByCountryCode() {
        assertEquals("2021-11-27", new SimpleDateFormatter().formatDateStringByCountryCode(CountryCode.HU, simpleDate));
        assertEquals("11-27-2021", new SimpleDateFormatter().formatDateStringByCountryCode(CountryCode.US, simpleDate));
        assertEquals("27-11-2021", new SimpleDateFormatter().formatDateStringByCountryCode(CountryCode.EN, simpleDate));
    }

    @Test
    void testFormatDateString() {
        assertEquals("2021-11-27", new SimpleDateFormatter().formatDateString(simpleDate));
    }

}