package introexceptioncheckedtrace;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Neptun {

    public static void main(String[] args) {
        List<String> namesWithCodes;
        try {
            namesWithCodes = new Neptun().readFile("src/main/resources/introexceptioncheckedtrace/neptun.csv");
        } catch (IOException ioe) {
            System.out.println("File reading error: " + ioe.getMessage());
            return;
        }

        List<String> codes = new ArrayList<>();
        for (String line : namesWithCodes) {
            codes.add(line.split(",")[1]);
        }
        System.out.println(codes);
    }

    public List<String> readFile(String path) throws IOException {
        return Files.readAllLines(Paths.get(path));
    }

}
