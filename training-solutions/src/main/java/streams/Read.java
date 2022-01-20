package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Read {

    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getBooks() {
        return new ArrayList<>(books);
    }

    public List<String> listBookTitlesShorterThanGiven(int maxNumberOfPages) {
        return books.stream()
                .filter(book -> book.getNumberOfPages() < maxNumberOfPages)
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    public List<String> listBookTitlesWithGivenAuthor(String author) {
        return books.stream()
                .filter(book -> book.getAuthor().equals(author))
                .map(Book::getTitle)
                .sorted()
                .collect(Collectors.toList());
    }

    public List<String> listAuthors() {
        return books.stream()
                .map(Book::getAuthor)
                .distinct()
                .collect(Collectors.toList());
    }
}
