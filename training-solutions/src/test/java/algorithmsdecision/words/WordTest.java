package algorithmsdecision.words;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WordTest {

    @Test
    void testContainsLongerWord() {
        Word word = new Word();
        List<String> words = List.of("apple", "grapefruit", "cocoa", "peanuts");

        assertTrue(word.containsLongerWord(words, "dog"));
        assertFalse(word.containsLongerWord(words, "starship enterprise"));
        assertFalse(word.containsLongerWord(words, "grapefruit"));
    }
}