package introexceptionwritefiletestjunit5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Book {

    public void writeBooks(Path fromFilePath, Path toFilePath) {
        List<String> books = readBooks(fromFilePath);
        List<String> readableBooks = new ArrayList<>();
        for (String book : books) {
            String[] catalogData = book.split(";");
            readableBooks.add(catalogData[2] + ": " + catalogData[1]);
        }
        writeReadableBooks(toFilePath, readableBooks);
    }

    private List<String> readBooks(Path fromFilePath) {
        try {
            return Files.readAllLines(fromFilePath);
        } catch (IOException ioe) {
            throw new IllegalStateException("File reading error!", ioe);
        }
    }

    private void writeReadableBooks(Path toFilePath, List<String> readableBookList) {
        try {
            Files.write(toFilePath, readableBookList);
        } catch (IOException ioe) {
            throw new IllegalStateException("File writing error!", ioe);
        }
    }

}
