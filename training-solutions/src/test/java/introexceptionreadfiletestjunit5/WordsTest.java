package introexceptionreadfiletestjunit5;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WordsTest {

    Words words = new Words();

    @Test
    void testGetFirstWordWithAValid() {
        Path validFile = Paths.get("src/test/resources/introexceptionreadfiletestjunit5/words.txt");
        assertEquals("Anna", words.getFirstWordWithA(validFile));
    }

    @Test
    void testGetFirstWordWithAInvalid() {
        Path invalidFile = Paths.get("src/test/resources/introexceptionreadfiletestjunit5/wordsNoA.txt");
        assertEquals("A", words.getFirstWordWithA(invalidFile));
    }

    @Test
    void testGetFirstWordWithANoFile() {
        Path noFile = Paths.get("src/test/resources/introexceptionreadfiletestjunit5/NoWords.txt");
        IllegalStateException ise = assertThrows(IllegalStateException.class, () -> words.getFirstWordWithA(noFile));
        assertEquals("File reading error!", ise.getMessage());
    }
}