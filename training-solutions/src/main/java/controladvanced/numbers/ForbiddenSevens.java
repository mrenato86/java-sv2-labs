package controladvanced.numbers;

import java.util.Scanner;

public class ForbiddenSevens {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Positive integer to start from: ");
        int number = scanner.nextInt();
        if (number < 0) {
            return;
        }

        for (int i = number; i > 0; i++) {
            if (i % 7 == 0) {
                System.out.println("X");
                continue;
            }
            if (String.valueOf(i).contains("7")) {
                break;
            }
            System.out.println(i);
        }
    }

}
