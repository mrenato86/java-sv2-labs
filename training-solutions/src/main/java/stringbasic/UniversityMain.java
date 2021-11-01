package stringbasic;

public class UniversityMain {

    public static void main(String[] args) {
        Person person = new Person("Best Student", "bestest@gmail.com", "123456789",
                "12345678-87654321-12345678", "+3630-1234567");
        Student student = new Student(person, "A1B2C3", "9876543210");

        Person samePerson = new Person("Best Copy", "copiest@gmail.com", "1010101010",
                "12345678-87654321-00000000", "+123-123-12345678");
        Student sameStudent = new Student(samePerson, "A1B2C3", "9876543210");

        Person anotherPerson = new Person("Different Student", "diffest@gmail.com", "123456788",
                "12345678-87654321-12345678", "+3670-1234567");
        Student anotherStudent = new Student(anotherPerson, "D4E5F6", "0123456789");

        University university = new University();
        student.setPassCardId("ID-CARD123");
        System.out.println(student.getPassCardId());

        System.out.println(university.areEqual(student, sameStudent));
        System.out.println(university.areEqual(student, anotherStudent));

        System.out.println(university.getStudents());
        university.addStudent(student);
        university.addStudent(anotherStudent);
        System.out.println(university.getStudents().size());

    }
}
