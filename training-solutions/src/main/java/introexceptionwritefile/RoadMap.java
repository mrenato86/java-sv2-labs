package introexceptionwritefile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class RoadMap {

    public static void main(String[] args) {
        List<String> roadmap = List.of("Debrecen", "Püspökladány", "Szajol", "Szolnok");
        Path path = Paths.get("src/main/resources/introexceptionwritefile/roadmap.txt");
        try {
            Files.write(path, roadmap);
        } catch (IOException ioe) {
            throw new IllegalStateException("File writing error!", ioe);
        }
    }

}
