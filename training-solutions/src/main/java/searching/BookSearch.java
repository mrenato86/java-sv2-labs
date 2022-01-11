package searching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookSearch {

    private List<Book> books;

    public BookSearch(List<Book> books) {
        this.books = books;
    }

    public List<Book> getBooks() {
        return new ArrayList<>(books);
    }

    public Book findBookByAuthorTitle(String author, String title) {
        if (isEmpty(author) || isEmpty(title)) {
            throw new IllegalArgumentException("Author or Title must not be empty!");
        }
        int foundIndex = Collections.binarySearch(books, new Book(author, title));
        if (foundIndex < 0) {
            throw new IllegalArgumentException("No book found by " + author + " with title " + title);
        }
        return books.get(foundIndex);
    }

    private boolean isEmpty(String value) {
        return value == null || value.isBlank();
    }
}
