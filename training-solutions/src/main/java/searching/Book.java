package searching;

public class Book implements Comparable<Book> {

    private int id;
    private String author;
    private String title;

    public Book(int id, String author, String title) {
        this(author, title);
        this.id = id;
    }

    public Book(String author, String title) {
        this.author = author;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public int compareTo(Book o) {
        if (author.compareTo(o.author) != 0) {
            return author.compareTo(o.author);
        }
        return title.compareTo(o.title);
    }

    @Override
    public String toString() {
        return String.format("%d %s %s", id, author, title);
    }
}
