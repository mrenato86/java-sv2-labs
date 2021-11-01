package stringbasic.characters;

import java.util.Arrays;
import java.util.Scanner;

public class Words {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Word to spell: ");
        String word = scanner.nextLine();
        System.out.println();

        System.out.println("Spell the following word by one letter a time: " + word);

        char[] chars = new char[word.length()];

        for (int i = 0; i < word.length(); i++) {
            chars[i] = scanner.nextLine().charAt(0);
        }

        System.out.println("Received characters: " + Arrays.toString(chars));
        String result = new String(chars);
        System.out.println("Received word: " + result);

        if (result.equals(word)) {
            System.out.println("Correct Answer!");
        } else {
            System.out.println("Incorrect Answer!");
        }
    }

}
