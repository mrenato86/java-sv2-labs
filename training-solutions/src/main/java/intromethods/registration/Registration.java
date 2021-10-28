package intromethods.registration;

import java.time.LocalDate;
import java.util.Scanner;

public class Registration {

    public String createFullName(String firstname, String lastname) {
        return firstname + " " + lastname;
    }

    public LocalDate createBirthDate(int year, int month, int day) {
        return LocalDate.of(year, month, day);
    }

    public static void main(String[] args) {
        Registration reg = new Registration();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Firstname: ");
        String firstname = scanner.nextLine();
        System.out.print("Lastname: ");
        String lastname = scanner.nextLine();

        System.out.print("Year of Birth: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Month of birth: ");
        int month = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Day of birth: ");
        int day = scanner.nextInt();
        scanner.nextLine();

        System.out.print("E-mail address: ");
        String email = scanner.nextLine();

        Person person = new Person(reg.createFullName(firstname, lastname), reg.createBirthDate(year, month, day), email);

        System.out.println("Person registered: " + person);

    }

}
