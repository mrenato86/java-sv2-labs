package introexceptionthrow;

import java.util.Scanner;

public class Registration {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Validation validation = new Validation();
        boolean validRegistration = true;
        System.out.println("Welcome!");

        System.out.print("Name: ");
        String name = scanner.nextLine();
        try {
            validation.validateName(name);
        } catch (IllegalArgumentException iae) {
            validRegistration = false;
            System.out.println(iae.getMessage());
        }

        System.out.print("Age: ");
        String age = scanner.nextLine();
        try {
            validation.validateAge(age);
        } catch (IllegalArgumentException iae) {
            validRegistration = false;
            System.out.println(iae.getMessage());
        }
        System.out.println("\nRegistration data:");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        if (validRegistration) {
            System.out.println("Registration successful!");
            return;
        }
        System.out.println("Registration unsuccessful!");
    }
}
