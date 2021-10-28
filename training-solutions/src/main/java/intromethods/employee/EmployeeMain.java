package intromethods.employee;

public class EmployeeMain {

    public static void main(String[] args) {
        Employee employee = new Employee("John Doe", 2010, 300000);
        System.out.println(employee);

        employee.raiseSalary(30000);
        System.out.println(employee);

        employee.setName("Jack Doe");
        System.out.println("Name: " + employee.getName());
        System.out.println("Hiring year: " + employee.getHiringYear());
        System.out.println("Salary: " + employee.getSalary());
    }

}
