package classstructureio;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("First Number: ");
        int first = scanner.nextInt();
        System.out.print("Second Number: ");
        int second = scanner.nextInt();
        System.out.println(first + " + "+second + " ="+"\n"+(first+second));
    }
}
