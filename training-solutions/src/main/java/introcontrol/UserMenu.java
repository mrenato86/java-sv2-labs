package introcontrol;

import java.util.Scanner;

public class UserMenu {

    public static void main(String[] args) {
        System.out.println("1. List Users");
        System.out.println("2. Add User");
        System.out.println("Other: Exit");

        Scanner scanner = new Scanner(System.in);
        int picked = scanner.nextInt();
        if (picked == 1) {
            System.out.println("List Users");
            return;
        }
        if (picked == 2) {
            System.out.println("Add User");
        }

    }
}
