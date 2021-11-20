package introexceptionwritefiletestjunit5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BookTest {

    Book book = new Book();

    @TempDir
    File temporaryFolder;

    @Test
    void testWriteBooks() throws IOException {
        Path source = Paths.get("src/test/resources/introexceptionwritefiletestjunit5/books.txt");
        Path tempFile = temporaryFolder.toPath().resolve("readable.txt");

        book.writeBooks(source, tempFile);

        List<String> expected = List.of("Gárdonyi Géza: Egri csillagok", "Molnár Ferenc: Pál utcai fiúk",
                "Fekete István: Tüskevár", "Jókai Mór: Kőszívű ember fiai");
        assertEquals(expected, Files.readAllLines(tempFile));
    }

    @Test
    void testWriteBooksException() {
        Path source = Paths.get("src/test/resources/introexceptionwritefiletestjunit5/NoBooks.txt");
        Path tempFile = temporaryFolder.toPath().resolve("readable.txt");
        IllegalStateException ise = assertThrows(IllegalStateException.class, () -> book.writeBooks(source, tempFile));
        assertEquals("File reading error!", ise.getMessage());
    }
}