package methodparam.sums;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class SeparatedSum {

    public String readFirstLine(Path path) {
        try {
            return Files.readAllLines(path).get(0);
        } catch (IOException ioe) {
            throw new IllegalStateException("File reading error!", ioe);
        }
    }

    public Sums sum(String floatingNumbers) {
        String[] rawNumbers = floatingNumbers.replace(',', '.').split(";" );
        double sumPositive = 0;
        double sumNegative = 0;
        for (String rawNumber : rawNumbers) {
            double number = Double.parseDouble(rawNumber);
            if (number > 0) {
                sumPositive += number;
            } else {
                sumNegative += number;
            }
        }
        return new Sums(sumPositive, sumNegative);
    }
}
