package introexceptionthrow;

import java.util.Scanner;

public class ShortWord {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Word (less than 6 character long): ");
        String word = scanner.nextLine();
        if (word.length() > 5) {
            throw new IllegalArgumentException("The word " + word + " is too long!");
        }
        for (int i = 0; i < word.length(); i++) {
            if (!Character.isAlphabetic(word.charAt(i))) {
                throw new IllegalArgumentException("Illegal character '" + word.charAt(i) + "' in " + word);
            }
        }
        System.out.println("The word " + word + " has passed the test!");
    }
}
