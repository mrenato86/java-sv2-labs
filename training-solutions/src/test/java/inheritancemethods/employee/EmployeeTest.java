package inheritancemethods.employee;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmployeeTest {

    Employee employee = new Employee("John Doe", "1117 Budapest, Budafoki út 56.", 300_000);

    @Test
    void testCreateEmployee() {
        Employee employee = new Employee("John Doe", "1117 Budapest, Budafoki út 56.", 300_000);

        assertEquals("John Doe", employee.getName());
        assertEquals("1117 Budapest, Budafoki út 56.", employee.getAddress());
        assertEquals(300_000.0, employee.getSalary());
    }

    @Test
    void testMigrateEmployee() {
        employee.migrate("1117 Budapest, Budafoki út 100.");

        assertEquals("1117 Budapest, Budafoki út 100.", employee.getAddress());
    }

    @Test
    void testRaiseSalary() {
        employee.raiseSalary(10);

        assertEquals(330_000.0, employee.getSalary());
    }

}