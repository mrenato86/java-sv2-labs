package exceptions.measurement;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Measurement {

    public List<String> readFromFile(Path path) {
        try {
            return Files.readAllLines(path);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file.", ioe);
        }
    }

    public List<String> validate(List<String> data) {
        List<String> result = new ArrayList<>(data.size());
        for (String line : data) {
            if (!isValidLine(line)) {
                result.add(line);
            }
        }
        return result;
    }

    private boolean isValidLine(String line) {
        String[] parts = line.split(",");
        if (parts.length == 3) {
            return isValidId(parts[0]) && isValidMeasurement(parts[1]) && isValidName(parts[2]);
        }
        return false;
    }

    private boolean isValidId(String lineNumber) {
        try {
            Integer.parseInt(lineNumber);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    private boolean isValidMeasurement(String measurement) {
        try {
            Double.parseDouble(measurement);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    private boolean isValidName(String name) {
        int space = name.indexOf(' ');
        return 0 < space && space < name.length() - 1;
    }

}
