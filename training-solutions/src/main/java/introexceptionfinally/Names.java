package introexceptionfinally;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Names {

    public static void main(String[] args) {
        Names names = new Names();

        List<String> nameListDr = names.readNames(Paths.get("src/main/resources/introexceptionfinally/names.txt"));
        System.out.println("Result: " + names.getFirstPrefixName("DR", nameListDr));

        List<String> nameListNoDr = names.readNames(Paths.get("src/main/resources/introexceptionfinally/noDrNames.txt"));
        System.out.println("Result: " + names.getFirstPrefixName("DR", nameListNoDr));

        List<String> noNameList = names.readNames(Paths.get("src/main/resources/introexceptionfinally/noNames.txt"));
        System.out.println("Result: " + names.getFirstPrefixName("DR", noNameList));
    }

    private List<String> readNames(Path path) {
        try {
            return Files.readAllLines(path);
        } catch (IOException ioe) {
            throw new IllegalStateException("File reading error!", ioe);
        } finally {
            System.out.println("End of reading.");
        }
    }

    private String getFirstPrefixName(String prefix, List<String> names) {
        prefix = prefix.toLowerCase();
        for (String name : names) {
            if (name.toLowerCase().startsWith(prefix)) {
                return name;
            }
        }
        return "";
    }

}
