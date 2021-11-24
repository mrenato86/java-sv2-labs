package algorithmstransformation.letters;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TwoLettersTest {

    @Test
    void testGetFirstTwoLetters() {
        List<String> words = List.of("alma", "körte", "barack", "eper", "szilva");
        List<String> expected = List.of("al", "kö", "ba", "ep", "sz");
        List<String> result = new TwoLetters().getFirstTwoLetters(words);

        assertEquals(result, expected);
    }
}