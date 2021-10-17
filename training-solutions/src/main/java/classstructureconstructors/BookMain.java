package classstructureconstructors;


import java.util.Scanner;

public class BookMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Author: ");
        String author = scanner.nextLine();
        System.out.print("Title: ");
        String title = scanner.nextLine();

        Book book = new Book(author,title);
        book.register(author.substring(0,1) + (2*author.length()+12*title.length()));
        System.out.println("Author:" + book.getAuthor());
        System.out.println("Title:" + book.getTitle());
        System.out.println("Reg Number:" + book.getRegNumber());



    }
}
