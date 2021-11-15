package introexceptiontrycatch;

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("First number: ");
        int first = 0;
        try {
            first = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException nfe) {
            System.out.println("Not a number, default value will be 0");
        }

        System.out.print("Second number: ");
        int second = 0;
        try {
            second = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException nfe) {
            System.out.println("Not a number, default value will be 0");
        }

        System.out.print("Operation(+,-,*,/): ");
        String operation = scanner.nextLine();
        switch (operation) {
            case "+":
                System.out.printf("%d + %d = %d", first, second, first + second);
                break;
            case "-":
                System.out.printf("%d - %d = %d", first, second, first - second);
                break;
            case "*":
                System.out.printf("%d * %d = %d", first, second, first * second);
                break;
            case "/":
                try {
                    System.out.printf("%d / %d = %d", first, second, first / second);
                } catch (ArithmeticException ae) {
                    System.out.println("Error: " + ae.getMessage());
                }
                break;
            default:
                System.out.println("Wrong operation!");
        }
    }

}
