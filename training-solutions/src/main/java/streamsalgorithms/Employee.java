package streamsalgorithms;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Employee {

    private String name;
    private int yearOfBirth;

    public Employee(String name, int yearOfBirth) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
    }

    public String getName() {
        return name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    @Override
    public String toString() {
        return name + "(" + yearOfBirth + ")";
    }

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>(List.of(
                new Employee("John", 1990),
                new Employee("Jack", 1988),
                new Employee("Jane", 1976),
                new Employee("Mark", 2001),
                new Employee("Peter", 1998),
                new Employee("Mary", 1986)
        ));

        //1.
        int sumOfYearOfBirth = employees.stream()
                .mapToInt(Employee::getYearOfBirth)
                .sum();
        System.out.println(sumOfYearOfBirth);

        //2.
        int sumOfAges = employees.stream()
                .mapToInt(Employee::getYearOfBirth)
                .map(year -> LocalDate.now().getYear() - year)
                .sum();
        System.out.println(sumOfAges);

        //3.
        long numOfEmployees = employees.stream()
                .count();
        System.out.println(numOfEmployees);

        //4.
        long numOfBornBefore1990 = employees.stream()
                .filter(employee -> employee.getYearOfBirth() < 1990)
                .count();
        System.out.println(numOfBornBefore1990);

        //5.
        int oldest = employees.stream()
                .mapToInt(Employee::getYearOfBirth)
                .min()
                .orElse(-1);
        System.out.println(oldest);

        //6.
        String oldestName = employees.stream()
                .sorted(Comparator.comparing(Employee::getYearOfBirth))
                .map(Employee::getName)
                .findFirst()
                .orElse("Not Found");
        System.out.println(oldestName);

        //7.
        boolean allBornBefore1980 = employees.stream()
                .allMatch(e -> e.getYearOfBirth() < 1980);
        System.out.println(allBornBefore1980);

        //8.
        List<Employee> bornBefore1990 = employees.stream()
                .filter(e -> e.getYearOfBirth() < 1990)
                .collect(Collectors.toList());
        System.out.println(bornBefore1990);

        //9.
        List<String> names = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
        System.out.println(names);

        //10.
        List<String> namesOfBornBefore1990 = employees.stream()
                .filter(e -> e.getYearOfBirth() < 1990)
                .map(Employee::getName)
                .collect(Collectors.toList());
        System.out.println(namesOfBornBefore1990);

    }
}
