package lambdastreams.bookstore;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class BookStore {

    private final List<Book> books;

    public BookStore(List<Book> books) {
        this.books = books;
    }

    public Integer getNumberOfBooks() {
        return books.stream().reduce(0, (n, b) -> n + b.getPieces(), Integer::sum);
    }

    public Optional<Book> findNewestBook() {
        return books.stream().max(Comparator.comparingInt(Book::getReleaseYear));
    }

    public Integer getTotalValue() {
        return books.stream().reduce(0, (n, b) -> n + b.getPieces() * b.getPrice(), Integer::sum);
    }

}
