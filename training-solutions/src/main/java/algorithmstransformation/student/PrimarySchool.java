package algorithmstransformation.student;

import java.util.ArrayList;
import java.util.List;

public class PrimarySchool {

    private List<Person> personnel;

    public PrimarySchool(List<Person> personnel) {
        this.personnel = personnel;
    }

    public void addPerson(Person person) {
        personnel.add(person);
    }

    public List<Person> getPersonnel() {
        return personnel;
    }

    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        for (Person person : personnel) {
            if (person.getAge() >= 6 && person.getAge() <= 14) {
                students.add(new Student(person.getName(), person.getAddress()));
            }
        }
        return students;
    }
}
