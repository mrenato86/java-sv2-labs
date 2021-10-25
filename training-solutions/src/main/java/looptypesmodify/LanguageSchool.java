package looptypesmodify;

import java.util.ArrayList;
import java.util.List;

public class LanguageSchool {

    public static void main(String[] args) {
        List<Student> allStudents = new ArrayList<>();

        Student student1 = new Student("Little John");
        Student student2 = new Student("Tom Bombadil");
        Student student3 = new Student("Longboat Ragnar");
        Student student4 = new Student("Big Pete");
        Student student5 = new Student("John Doe");

        allStudents.add(student1);
        student1.setActive(false);
        allStudents.add(student2);
        allStudents.add(student3);
        student3.setActive(false);
        allStudents.add(student4);
        allStudents.add(student5);
        System.out.println("All " + allStudents.size() + " students:");
        System.out.println(allStudents);

        List<Student> studentsToRemove = new ArrayList<>();
        for (Student student : allStudents) {
            if (!student.isActive()) {
                studentsToRemove.add(student);
            }
        }
        allStudents.removeAll(studentsToRemove);
        System.out.println("\n" + studentsToRemove.size() + " inactive removed!");
        System.out.println("The remaining " + allStudents.size() + " active students:");
        System.out.println(allStudents);
    }

}
