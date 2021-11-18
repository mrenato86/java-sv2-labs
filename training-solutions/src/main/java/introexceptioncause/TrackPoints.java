package introexceptioncause;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TrackPoints {

    public List<String> readCoordinates(String filename) {
        try {
            return Files.readAllLines(Paths.get(filename));
        } catch (IOException ioe) {
            throw new IllegalStateException("File reading error!", ioe);
        }
    }

    public List<Integer> getHeights(List<String> coordinates) {
        List<Integer> heights = new ArrayList<>(coordinates.size());
        for (String line : coordinates) {
            heights.add(Integer.parseInt(line.split(";")[2]));
        }
        return heights;
    }

    public void printHeightDiff(List<Integer> heights) {
        for (int i = 1; i < heights.size(); i++) {
            System.out.println(heights.get(i) - heights.get(i - 1));
        }
    }
}
