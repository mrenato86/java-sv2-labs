package primitivetypes.primitivetypes.exam;

import java.time.LocalDate;
import java.util.Scanner;

public class ExamRegistration {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Exam registration");

        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Year of Birth: ");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.print("Month of Birth: ");
        int month = Integer.parseInt(scanner.nextLine());
        System.out.print("Day of Birth: ");
        int day = Integer.parseInt(scanner.nextLine());
        System.out.print("Zip Code: ");
        int zip = Integer.parseInt(scanner.nextLine());
        System.out.print("Average of course results: ");
        double avg = Double.parseDouble(scanner.nextLine().replace(',', '.'));

        Exam exam = new Exam();
        exam.addPerson(new Person(name, LocalDate.of(year, month, day), zip, avg));

        System.out.println(exam.getAttendees());

    }

}
