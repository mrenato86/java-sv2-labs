package collectionsmap;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassTrip {

    private Map<String, Integer> payments = new HashMap<>();

    public Map<String, Integer> getPayments() {
        return new HashMap<>(payments);
    }

    public void loadInPayments(Path path) {
        for (String line : readFile(path)) {
            String[] parts = line.split(": ");
            payments.put(parts[0], Integer.parseInt(parts[1]));
        }
    }

    private List<String> readFile(Path path) {
        try {
            return Files.readAllLines(path);
        } catch (IOException ioe) {
            throw new IllegalStateException("File reading error!", ioe);
        }
    }

}
