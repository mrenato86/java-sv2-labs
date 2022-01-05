package exceptionmulticatch.aid;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Aid {

    private int amount;

    public Aid(int amount) {
        this.amount = amount;
    }

    public List<String> countAmountsOfAid(Path path) {
        List<String> result = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(path);
            for (String line : lines) {
                String[] parts = line.split(" ");
                int amountForOnePerson = amount / Integer.parseInt(parts[1]);
                result.add(parts[0] + " " + amountForOnePerson);
            }
        } catch (NullPointerException | IOException | IndexOutOfBoundsException | NumberFormatException | ArithmeticException ex) {
            throw new IllegalStateException("Something went wrong while counting.", ex);
        }
        return result;
    }

    public int getAmount() {
        return amount;
    }
}
