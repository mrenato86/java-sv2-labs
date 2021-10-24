package aslist;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Favourites {

    public static void main(String[] args) {
        List<String> favouriteThings = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Favorite book: ");
        favouriteThings.add(scanner.nextLine());
        System.out.print("Favorite movie: ");
        favouriteThings.add(scanner.nextLine());
        System.out.print("Favorite animal: ");
        favouriteThings.add(scanner.nextLine());
        System.out.print("Favorite color: ");
        favouriteThings.add(scanner.nextLine());

        System.out.println("The " + favouriteThings.size() + " favorite things are:");
        System.out.println(favouriteThings);

    }

}
