package algorithmsfilter.prefix;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class PrefixTest {

    @Test
    void testGetWordsStartWith() {
        Prefix word = new Prefix();
        List<String> words = List.of("király", "királynő", "macska", "kislány", "kutya", "kilogramm");
        List<String> expected = List.of("király", "királynő", "kislány", "kilogramm");
        List<String> result = word.getWordsStartWith(words, "ki");

        assertEquals(expected, result);
        assertFalse(result.contains("macska"));
    }
}