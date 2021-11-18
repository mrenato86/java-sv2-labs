package introexceptioncause;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class PaulStreetBoys {

    public static void main(String[] args) {
        PaulStreetBoys psb = new PaulStreetBoys();
        psb.printList(psb.readNames("src/main/resources/introexceptioncause/palutcaifiuk.txt"));
    }

    public List<String> readNames(String filename) {
        try {
            return Files.readAllLines(Paths.get(filename));
        } catch (IOException ioe) {
            throw new IllegalStateException("File reading error!", ioe);
        }
    }

    public void printList(List<String> names) {
        for (String line : names) {
            if ("Nemecsek Ernő".equals(line)) {
                line = line.toLowerCase();
            }
            System.out.println(line);
        }
    }

}
