package numbers;

import java.util.Scanner;

public class MathOperations {

    public static void main(String[] args) {
        String problem = "3 / 8 + 7 / (8 - 2) = ?";
        double result = 3 / 8.0 + 7.0 / (8 - 2);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Round your answer to four decimal places.");
        System.out.println("Solve: " + problem);
        System.out.print("? = ");
        double input = scanner.nextDouble();

        if (Math.abs(result - input) < 0.0001) {
            System.out.println("Correct Answer");
        } else {
            System.out.println("Incorrect Answer");
        }
    }

}
