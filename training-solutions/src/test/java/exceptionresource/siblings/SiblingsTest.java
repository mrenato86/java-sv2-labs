package exceptionresource.siblings;

import org.junit.jupiter.api.Test;

import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SiblingsTest {

    Siblings siblings = new Siblings();

    @Test
    void testGetFullNames() {
        List<String> expected = List.of("Szabó Emese", "Szabó Ferenc");

        assertEquals(expected, siblings.getFullNames("Szabó", Paths.get("src/test/resources/exceptionresource/siblings/siblings.txt")));
    }

    @Test
    void testGetFullNamesWithNotExistingFile() {
        Exception ex = assertThrows(IllegalStateException.class,
                () -> siblings.getFullNames("Szabó", Paths.get("src/test/resources/exceptionresource/siblings/xyz.txt")));
        assertEquals("File reading error!", ex.getMessage());
    }

}