package exceptionresource.hiddenword;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class HiddenWord {

    public String getHiddenWord(Path path) {
        try (Scanner scanner = new Scanner(path)) {
            return getWord(scanner);
        } catch (IOException ioe) {
            throw new IllegalStateException("File reading error!", ioe);
        }
    }

    private String getWord(Scanner scanner) {
        StringBuilder sb = new StringBuilder();
        while (scanner.hasNextLine()) {
            sb.append(getLetterFromLine(scanner.nextLine()));
        }
        return sb.toString();
    }

    private char getLetterFromLine(String line) {
        for (int i = 0; i < line.length(); i++) {
            char actual = line.charAt(i);
            if (Character.isAlphabetic(actual)) {
                return actual;
            }
        }
        return ' ';
    }
}
