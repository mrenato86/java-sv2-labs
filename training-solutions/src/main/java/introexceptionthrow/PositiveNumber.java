package introexceptionthrow;

import java.util.Scanner;

public class PositiveNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Positive number: ");
        int number;
        if (!scanner.hasNextInt() || (number = scanner.nextInt()) < 0) {
            throw new IllegalArgumentException("Not a positive number!");
        }
        System.out.println(number);
    }

}
