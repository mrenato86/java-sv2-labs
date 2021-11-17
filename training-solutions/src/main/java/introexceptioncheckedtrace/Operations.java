package introexceptioncheckedtrace;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

public class Operations {

    public String getDailySchedule(List<String> undergroundNumbers) {
        StringBuilder sb = new StringBuilder(LocalDate.now().toString());
        sb.append(",");
        for (String line : undergroundNumbers) {
            if (line.startsWith("2")) {
                sb.append(" ").append(line);
            }
        }
        return sb.toString();
    }

    public List<String> readFile(String path) throws IOException {
        return Files.readAllLines(Paths.get(path));
    }
}
