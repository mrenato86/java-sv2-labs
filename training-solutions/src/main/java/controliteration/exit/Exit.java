package controliteration.exit;

import java.util.Scanner;

public class Exit {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        do {
            System.out.println("The customer service menu is currently unavailable.\nTo exit press x!");
            input = scanner.nextLine();
        } while (!"x".equals(input));
        System.out.println("Bye");
    }

}
