package introexceptionreadfile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Holiday {

    public static void main(String[] args) {
        try {
            List<String> holidayList = Files.readAllLines(Paths.get("src/main/resources/introexceptionreadfile/holiday.txt"));
            System.out.println(holidayList);
        } catch (IOException ioe) {
            System.out.println("File reading error: " + ioe.getMessage());
        }
    }

}
