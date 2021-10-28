package objects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ObjectsMain {

    public static void main(String[] args) {
        //1.
        new Book();
        //2.
        System.out.println(new Book());
        //3.
        Book emptyBook;
        //System.out.println(emptyBook);
        //4.
        emptyBook = null;
        System.out.println(emptyBook);
        //5.
        System.out.println(emptyBook == null);
        //6.
        Book book = new Book();
        System.out.println(book);
        //7.
        book = null;
        System.out.println(book);
        //8.
        book = new Book();
        System.out.println(book);
        //9.
        Book anotherBook = new Book();
        System.out.println(anotherBook);
        //10.
        System.out.println(book == anotherBook);
        //11.
        anotherBook = book;
        System.out.println(anotherBook);
        //12.
        System.out.println(book == anotherBook);

        //2/1.
        Book[] books = {new Book(),new Book(),new Book()};
        //2/2.
        List<Book> bookList = new ArrayList<>(Arrays.asList(new Book(),new Book(),new Book()));
        //2/3.
        List<Book> bookList2 = new ArrayList<>();
        bookList2.add(new Book());
        bookList2.add(new Book());
        bookList2.add(new Book());
        //2/4.
        System.out.println(Arrays.toString(books));
        System.out.println(bookList);
        System.out.println(bookList2);
    }

}
