package junit5fixture;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class WordsTest {

    Words words;

    @BeforeEach
    void init() {
        words = new Words();
        words.addWord("chinchilla");
        words.addWord("bighorn");
        words.addWord("cheetah");
        words.addWord("kitten");
        words.addWord("springbok");
        words.addWord("big-hog");
        words.addWord("ferret");
        words.addWord("big-buffalo");
        words.addWord("horse");
    }

    @Test
    void testGetWordsStartWith() {
        List<String> expectedList = new ArrayList<>(List.of("bighorn", "big-hog", "big-buffalo"));
        words.getWordsStartWith("big");
        assertEquals(expectedList, words.getWords());
    }

    @Test
    void testGetWordsWithLength() {
        List<String> expectedList = new ArrayList<>(List.of("bighorn", "cheetah", "big-hog"));
        words.getWordsWithLength(7);
        assertEquals(expectedList, words.getWords());
    }

}
