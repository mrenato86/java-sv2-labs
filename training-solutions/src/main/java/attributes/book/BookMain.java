package attributes.book;

public class BookMain {

    public static void main(String[] args) {
        Book book = new Book("Hyperion");
        System.out.println(book.getTitle());

        book.setTitle("Endymion");
        System.out.println(book.getTitle());
    }
}
