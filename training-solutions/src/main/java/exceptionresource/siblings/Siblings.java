package exceptionresource.siblings;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Siblings {

    public List<String> getFullNames(String lastName, Path path) {
        List<String> fullNames = new ArrayList<>();
        try (Scanner scanner = new Scanner(path)) {
            while (scanner.hasNextLine()) {
                String firstName = scanner.nextLine();
                fullNames.add(lastName + " " + firstName);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("File reading error!", ioe);
        }
        return fullNames;
    }
}
