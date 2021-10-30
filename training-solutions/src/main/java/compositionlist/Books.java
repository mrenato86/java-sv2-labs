package compositionlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Books {

    private List<String> titles = new ArrayList<>();

    public void addBook(String title) {
        titles.add(title);
    }

    public int findBookAndSetAuthor(String title, String author) {
        int indexOfTitle = titles.indexOf(title);
        if (indexOfTitle >= 0) {
            titles.set(indexOfTitle, author + ": " + title);
        }
        return indexOfTitle;
    }

    //Little upgrade
    public void findAllBookAndSetAuthor(String title, String author) {
        int indexOfTitle;
        do {
            indexOfTitle = findBookAndSetAuthor(title, author);
        } while (indexOfTitle >= 0);
    }

    public List<String> getTitles() {
        return titles;
    }

    public static void main(String[] args) {
        Books books = new Books();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Number of book titles: ");
        int numberOfBooks = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < numberOfBooks; i++) {
            System.out.print((i + 1) + ". title: ");
            books.addBook(scanner.nextLine());
        }
        System.out.println(books.getTitles());
        System.out.println();

        System.out.print("Title of book to update with author: ");
        String titleToUpdate = scanner.nextLine();
        System.out.print("Author: ");
        String author = scanner.nextLine();

        books.findAllBookAndSetAuthor(titleToUpdate, author);
        System.out.println(books.getTitles());

    }

}
