package statements;

import java.util.Scanner;

public class DivByThree {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Number: ");
        int i = scanner.nextInt();
        System.out.println(i + " " + ((i % 3) == 0 ? "is dividable by 3" : "is not dividable by 3"));
    }
}
