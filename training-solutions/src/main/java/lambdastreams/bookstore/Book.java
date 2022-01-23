package lambdastreams.bookstore;

public class Book {

    private String title;
    private int releaseYear;
    private int price;
    private int pieces;

    public Book(String title, int releaseYear, int price, int pieces) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.price = price;
        this.pieces = pieces;
    }

    public String getTitle() {
        return title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public int getPrice() {
        return price;
    }

    public int getPieces() {
        return pieces;
    }
}
