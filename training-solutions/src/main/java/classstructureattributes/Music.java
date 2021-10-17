package classstructureattributes;

import java.util.Scanner;

public class Music {

    public static void main(String[] args) {
        Song song = new Song();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Band name: ");
        song.band= scanner.nextLine();
        System.out.print("Title: ");
        song.title = scanner.nextLine();
        System.out.print("Length: ");
        song.length = scanner.nextInt();

        System.out.println("\n" + song);
    }
}
