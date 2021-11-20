package introexceptionwritefiletestjunit5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ElectricityTest {

    Electricity electricity = new Electricity();

    @TempDir
    File temporaryFolder;

    @Test
    void testWriteStreets() throws IOException {
        Path tempPath = temporaryFolder.toPath().resolve("streets.txt");
        System.out.println(tempPath);

        electricity.writeStreets(tempPath);

        List<String> expected = List.of(LocalDate.now().toString(), "Long street", "Short street",
                "Nice street", "Big street", "Empty street");
        assertEquals(expected, Files.readAllLines(tempPath));
    }
}