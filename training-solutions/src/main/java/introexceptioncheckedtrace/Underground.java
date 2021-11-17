package introexceptioncheckedtrace;

import java.io.IOException;
import java.util.List;

public class Underground {

    public static void main(String[] args) {
        Operations operations = new Operations();
        List<String> undergroundNumbers;
        try {
            undergroundNumbers = operations.readFile("src/main/resources/introexceptioncheckedtrace/underground.txt");
        } catch (IOException ioe) {
            System.out.println("File reading error: " + ioe.getMessage());
            return;
        }
        System.out.println("Daily Schedule:");
        System.out.println(operations.getDailySchedule(undergroundNumbers));
    }

}
