package introdate;

import java.util.Scanner;

public class EmployeeTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Year of birth: ");
        int year = scanner.nextInt();
        System.out.print("Month of birth: ");
        int month = scanner.nextInt();
        System.out.print("Day of birth: ");
        int day = scanner.nextInt();

        Employee employee = new Employee(year, month, day, name);
        employee.setName("Dr. " + employee.getName());
        System.out.println(employee.getName() + "(" + employee.getDateOfBirth() + ")" + " employed since: " + employee.getBeginEmployment());
    }

}
