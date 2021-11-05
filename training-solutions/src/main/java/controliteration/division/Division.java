package controliteration.division;

import java.util.Scanner;

public class Division {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a positive integer. The program will print smaller numbers.");
        int number = scanner.nextInt();
        System.out.print("First Divisor: ");
        int divisorFor = scanner.nextInt();
        System.out.print("Second Divisor: ");
        int divisorWhile = scanner.nextInt();

        System.out.println("For: " + divisorFor);
        for (int i = 1; i <= number; i++) {
            if (i % divisorFor == 0) {
                System.out.print(i + ", ");
            }
        }
        System.out.println("\nWhile: " + divisorWhile);
        int actual = 1;
        while (actual <= number) {
            if (actual % divisorWhile == 0) {
                System.out.print(actual + ", ");
            }
            actual++;
        }
    }

}
