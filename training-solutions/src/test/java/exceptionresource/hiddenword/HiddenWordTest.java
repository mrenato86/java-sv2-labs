package exceptionresource.hiddenword;

import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class HiddenWordTest {

    HiddenWord hiddenWord = new HiddenWord();

    @Test
    void testGetHiddenWord() {
        assertEquals("ALMA KÖRTE", hiddenWord.getHiddenWord(Paths.get("src/test/resources/exceptionresource/hiddenword/hiddenword.txt")));
    }

    @Test
    void testGetHiddenWordWithNotExistingFile() {
        Exception ex = assertThrows(IllegalStateException.class,
                () -> hiddenWord.getHiddenWord(Paths.get("src/test/resources/exceptionresource/hiddenword/xyz.txt")));
        assertEquals("File reading error!", ex.getMessage());
    }

}