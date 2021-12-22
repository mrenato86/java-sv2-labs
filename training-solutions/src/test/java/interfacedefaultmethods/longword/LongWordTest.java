package interfacedefaultmethods.longword;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LongWordTest {

    @Test
    void testLongWord() {
        Path path = Path.of("src/test/resources/interfacedefaultmethods/longword/longword.txt");

        assertEquals("LONGWORD", new LongWord(path).getLongWord());
    }

    @Test
    void testLongWordFileIsNotExisting() {
        Path wrongPath = Path.of("src/test/resources/interfacedefaultmethods/longword/nofile.txt");

        IllegalStateException ise = assertThrows(IllegalStateException.class,
                () -> new LongWord(wrongPath).getLongWord());
        assertEquals("File reading error!", ise.getMessage());
    }

}