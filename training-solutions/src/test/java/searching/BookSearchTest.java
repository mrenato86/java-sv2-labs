package searching;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BookSearchTest {

    List<Book> books = new ArrayList<>();
    BookSearch search;

    @BeforeEach
    void setUp() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("src/test/resources/searching/books.csv"));
        for (String s : lines) {
            String[] lineParts = s.split(";");
            books.add(new Book(Integer.parseInt(lineParts[0]), lineParts[1], lineParts[2]));
        }
        Collections.sort(books);
        search = new BookSearch(books);
    }

    @Test
    void testFindBookByAuthorTitleEmptyException() {
        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> search.findBookByAuthorTitle("", ""));
        assertEquals("Author or Title must not be empty!", ex.getMessage());
    }

    @Test
    void testFindBookByAuthorTitleNullException() {
        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> search.findBookByAuthorTitle(null, null));
        assertEquals("Author or Title must not be empty!", ex.getMessage());
    }

    @Test
    void testFindBookByAuthorTitleNotFoundException() {
        String author = "Homérosz";
        String title = "Iliász";

        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> search.findBookByAuthorTitle(author, title));
        assertEquals("No book found by " + author + " with title " + title, ex.getMessage());
    }

    @Test
    void testFindBookByAuthorTitle() {
        Book book = search.findBookByAuthorTitle("Fazekas Anna", "Mackó, mókus, malacka");

        assertEquals(1010, book.getId());
        assertEquals("Fazekas Anna", book.getAuthor());
        assertEquals("Mackó, mókus, malacka", book.getTitle());
        assertEquals("1010 Fazekas Anna Mackó, mókus, malacka", book.toString());
    }

}