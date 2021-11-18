package introexceptioncause;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Poem {

    public static void main(String[] args) {
        List<String> poem = new Poem().readFile("src/main/resources/introexceptioncause/poem.txt");
        for (String line : poem) {
            System.out.print(line.charAt(0));
        }
    }

    public List<String> readFile(String filename) {
        try {
            return Files.readAllLines(Paths.get(filename));
        } catch (IOException ioe) {
            throw new IllegalStateException("File reading error!", ioe);
        }
    }
}
