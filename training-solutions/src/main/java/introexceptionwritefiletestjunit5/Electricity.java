package introexceptionwritefiletestjunit5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Electricity {

    public void writeStreets(Path path) {
        try {
            Files.write(path, getListOfStreets());
        } catch (IOException ioe) {
            throw new IllegalStateException("File writing error!", ioe);
        }
    }

    private List<String> getListOfStreets() {
        List<String> streets = new ArrayList<>();
        streets.add(LocalDate.now().toString());
        streets.add("Long street");
        streets.add("Short street");
        streets.add("Nice street");
        streets.add("Big street");
        streets.add("Empty street");
        return streets;
    }
}
